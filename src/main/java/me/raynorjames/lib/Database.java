package me.raynorjames.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by JamesRaynor on 3/5/16.
 */
public class Database {

    private final String name;
    private final String host;
    private final String user;
    private final String pass;
    private final int port;

    private Connection connection;

    public Database(String name, String user, String pass) {
        this.name = name;
        this.user = user;
        this.pass = pass;
        this.host = "localhost";
        this.port = 3306;
    }

    public Database(String name, String host, String user, String pass) {
        this.name = name;
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.port = 3306;
    }

    public Database(String name, String host, String user, String pass, int port) {
        this.name = name;
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.port = port;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + name, user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
            connection = null;
        }
    }

    public void disconnect() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
