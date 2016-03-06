package me.raynorjames;

import me.raynorjames.commands.ArenaCommand;
import me.raynorjames.commands.ClanCommand;
import me.raynorjames.commands.RoyaleCommand;
import me.raynorjames.lib.Database;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by JamesRaynor on 3/5/16.
 */
public class CraftRoyale extends JavaPlugin {
    private Database database;

    public void onEnable() {

        /*this.establishSql();*/

        //Command registry
        this.getCommand("arena").setExecutor(new ArenaCommand());
        this.getCommand("royale").setExecutor(new RoyaleCommand());
        this.getCommand("clan").setExecutor(new ClanCommand());
        //Event registry

    }

    public void onDisable() {
        /*database.disconnect();*/
    }

    private void establishSql() {
        String name = this.getConfig().getString("database.name");
        String user = this.getConfig().getString("database.user");
        String pass = this.getConfig().getString("database.pass");
        String host = this.getConfig().getString("database.host");
        int port = this.getConfig().getInt("database.port");

        database = new Database(name, host, user, pass, port);
        database.connect();
    }

}
