package dev.bleepo.serversecure.events;

import dev.bleepo.serversecure.ServerSecure;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {
    private final ServerSecure plugin;

    public onJoin(ServerSecure plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e) {
        if(plugin.getConfig().getBoolean("creative.removecreative")) {
            if (!e.getPlayer().getGameMode().equals(GameMode.SURVIVAL) && !e.getPlayer().isOp()) {
                e.getPlayer().setGameMode(GameMode.SURVIVAL);
                String monke = plugin.getConfig().getString("creative.opmessage");
                for(Player player : Bukkit.getOnlinePlayers())
                    if(player.isOp()) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', monke.replace("{player}", e.getPlayer().getDisplayName())));

                    }
                String monke2 = plugin.getConfig().getString("creative.consolemessage");
                System.out.println(ChatColor.GREEN + "--------------------" + ChatColor.AQUA + "ServerSecure" + ChatColor.GREEN + "--------------------");
                System.out.println(ChatColor.translateAlternateColorCodes('&', monke2.replace("{player}", e.getPlayer().getDisplayName())));
                System.out.println(ChatColor.GREEN + "--------------------------------------------------");
                String monke3 = plugin.getConfig().getString("creative.playermessage");
                e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', monke3.replace("{player}", e.getPlayer().getDisplayName())));

            }
        }
    }
}
