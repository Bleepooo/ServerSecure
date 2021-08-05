package dev.bleepo.serversecure;

import dev.bleepo.serversecure.events.onJoin;
import dev.bleepo.serversecure.events.onLeave;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerSecure extends JavaPlugin {

    @Override
    public void onEnable() {
        //Loaded
        getLogger().info(ChatColor.GREEN + "ServerSecure v1.4 is Loaded and Enabled!");

        //Load Events
        getServer().getPluginManager().registerEvents(new onJoin(this), this);
        getServer().getPluginManager().registerEvents(new onLeave(this), this);

        //Load Config
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onDisable() {
        //Goodbye!
        getLogger().info(ChatColor.GREEN + "ServerSecure v1.4 is Unloaded and Disabled!");
    }
}
