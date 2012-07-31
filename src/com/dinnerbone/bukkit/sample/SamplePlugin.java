
package com.dinnerbone.bukkit.sample;

import java.util.HashSet;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

/**
 * Sample plugin for Bukkit
 *
 * @author Dinnerbone
 */
public class SamplePlugin extends JavaPlugin {
    private final SamplePlayerListener playerListener = new SamplePlayerListener(this);
    private final SampleBlockListener blockListener = new SampleBlockListener(this);
    private final HashSet<Player> debugees = new HashSet<Player>();

    // NOTE: There should be no need to define a constructor any more for more info on moving from
    // the old constructor see:
    // http://forums.bukkit.org/threads/too-long-constructor.5032/

    public void onDisable() {
        // TODO: Place any custom disable code here
    	debugees.clear();
        // NOTE: All registered events are automatically unregistered when a plugin is disabled
    	// MUSTDO: Clear all running events
    	this.getServer().getScheduler().cancelTasks(this);
        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        // this.getLogger().log(Level.INFO,"Goodbye world!");
        // Disable Logging is done automatically.
    }

    public void onEnable() {
        // TODO: Place any custom enable code here including the registration of any events

        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(playerListener, this);
        pm.registerEvents(blockListener, this);

        // Register our commands
        getCommand("pos").setExecutor(new SamplePosCommand(this));
        getCommand("debug").setExecutor(new SampleDebugCommand(this));

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        
        // this.getLogger().log(Level.INFO," is enabled!" );
        // Enabling Logging is done automatically.
    }

    public boolean isDebugging(final Player player) {
        if (debugees.contains(player)) {
            return true;
        } else {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) {
        if(value){
        	debugees.add(player);
        }else{
        	debugees.remove(player);
        }
    }
}
