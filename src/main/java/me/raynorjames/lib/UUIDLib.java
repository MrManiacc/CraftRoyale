package me.raynorjames.lib;

/**
 * Created by River on 11/29/14.
 */

import com.google.common.collect.ImmutableList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.Callable;

//TODO return a list of previous names.

public class UUIDLib {

    private UUIDLib() {
    }

    public static UUID getID(String user) {
        UUIDFetcher fetcher = new UUIDFetcher(Arrays.asList(user));
        try {
            Map<String, UUID> stringUUIDMap = fetcher.call();
            return stringUUIDMap.get(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getName(UUID id) {
        NameFetcher fetcher = new NameFetcher(Arrays.asList(id));
        try {
            Map<UUID, String> uuidStringMap = fetcher.call();
            return uuidStringMap.get(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

class UUIDFetcher implements Callable<Map<String, UUID>> {
    private static final double PROFILES_PER_REQUEST = 100;
    private static final String PROFILE_URL = "https://api.mojang.com/profiles/minecraft";
    private final JSONParser jsonParser = new JSONParser();
    private final List<String> names;
    private final boolean rateLimiting;

    public UUIDFetcher(List<String> names, boolean rateLimiting) {
        this.names = ImmutableList.copyOf(names);
        this.rateLimiting = rateLimiting;
    }

    public UUIDFetcher(List<String> names) {
        this(names, true);
    }

    public Map<String, UUID> call() throws Exception {
        Map<String, UUID> uuidMap = new HashMap<>();
        int requests = (int) Math.ceil(names.size() / PROFILES_PER_REQUEST);
        for (int i = 0; i < requests; i++) {
            HttpURLConnection connection = createConnection();
            String body = JSONArray.toJSONString(names.subList(i * 100, Math.min((i + 1) * 100, names.size())));
            writeBody(connection, body);
            JSONArray array = (JSONArray) jsonParser.parse(new InputStreamReader(connection.getInputStream()));
            for (Object profile : array) {
                JSONObject jsonProfile = (JSONObject) profile;
                String id = (String) jsonProfile.get("id");
                String name = (String) jsonProfile.get("name");
                UUID uuid = UUIDFetcher.getUUID(id);
                uuidMap.put(name, uuid);
            }
            if (rateLimiting && i != requests - 1) {
                Thread.sleep(100L);
            }
        }
        return uuidMap;
    }

    private static void writeBody(HttpURLConnection connection, String body) throws Exception {
        OutputStream stream = connection.getOutputStream();
        stream.write(body.getBytes());
        stream.flush();
        stream.close();
    }

    private static HttpURLConnection createConnection() throws Exception {
        URL url = new URL(PROFILE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        return connection;
    }

    private static UUID getUUID(String id) {
        return UUID.fromString(id.substring(0, 8) + "-" + id.substring(8, 12) + "-" + id.substring(12, 16) + "-" + id.substring(16, 20) + "-" + id.substring(20, 32));
    }

    public static byte[] toBytes(UUID uuid) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        return byteBuffer.array();
    }

    public static UUID fromBytes(byte[] array) {
        if (array.length != 16) {
            throw new IllegalArgumentException("Illegal byte array length: " + array.length);
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap(array);
        long mostSignificant = byteBuffer.getLong();
        long leastSignificant = byteBuffer.getLong();
        return new UUID(mostSignificant, leastSignificant);
    }

    public static UUID getUUIDOf(String name) throws Exception {
        return new UUIDFetcher(Arrays.asList(name)).call().get(name);
    }
}

class NameFetcher implements Callable<Map<UUID, String>> {
    private static final String PROFILE_URL = "https://sessionserver.mojang.com/session/minecraft/profile/";
    private final JSONParser jsonParser = new JSONParser();
    private final List<UUID> uuids;

    public NameFetcher(List<UUID> uuids) {
        this.uuids = ImmutableList.copyOf(uuids);
    }

    @Override
    public Map<UUID, String> call() throws Exception {
        Map<UUID, String> uuidStringMap = new HashMap<>();
        for (UUID uuid : uuids) {
            HttpURLConnection connection = (HttpURLConnection) new URL(PROFILE_URL + uuid.toString().replace("-", "")).openConnection();
            JSONObject response = (JSONObject) jsonParser.parse(new InputStreamReader(connection.getInputStream()));
            String name = (String) response.get("name");
            if (name == null) {
                continue;
            }
            String cause = (String) response.get("cause");
            String errorMessage = (String) response.get("errorMessage");
            if (cause != null && cause.length() > 0) {
                throw new IllegalStateException(errorMessage);
            }
            uuidStringMap.put(uuid, name);
        }
        return uuidStringMap;
    }
}