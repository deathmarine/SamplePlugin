
package com.dinnerbone.bukkit.sample;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Handle events for all Player related events
 * @author Dinnerbone
 */
public class SamplePlayerListener implements Listener {
    private final SamplePlugin plugin;

    public SamplePlayerListener(SamplePlugin instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerEvent event) {
        System.out.println(event.getPlayer().getName() + " joined the server! :D");
    }

    @EventHandler
    public void onPlayerQuit(PlayerEvent event) {
        System.out.println(event.getPlayer().getName() + " left the server! :'(");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (plugin.isDebugging(event.getPlayer())) {
            Location from = event.getFrom();
            Location to = event.getTo();

            System.out.println(String.format("From %.2f,%.2f,%.2f to %.2f,%.2f,%.2f", from.getX(), from.getY(), from.getZ(), to.getX(), to.getY(), to.getZ()));
        }
    }
}
