package dev.bleepo.serversecure.events;

import dev.bleepo.serversecure.ServerSecure;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onLeave implements Listener {
    private final ServerSecure plugin;

    public onLeave(ServerSecure plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerJoin(PlayerQuitEvent e) {
        if(plugin.getConfig().getBoolean("deop.removeop")) {
            if (e.getPlayer().isOp()) {
                e.getPlayer().setOp(false);
                String sexo = plugin.getConfig().getString("deop.opmessage");
                for(Player player : Bukkit.getOnlinePlayers())
                    if(player.isOp()) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', sexo.replace("{player}", e.getPlayer().getDisplayName())));

                    }
                String opMessage = plugin.getConfig().getString("deop.consolemessage");
                System.out.println(ChatColor.GREEN + "--------------------" + ChatColor.AQUA + "ServerSecure" + ChatColor.GREEN + "--------------------");
                System.out.println(ChatColor.translateAlternateColorCodes('&', opMessage.replace("{player}", e.getPlayer().getDisplayName())));
                System.out.println(ChatColor.GREEN + "--------------------------------------------------");

            }
        }
    }
}
