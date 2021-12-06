package me.stefanvl.lifeandafter;

import me.stefanvl.lifeandafter.commands.alHealth;
import me.stefanvl.lifeandafter.commands.alReset;
import me.stefanvl.lifeandafter.listeners.DeathListener;
import me.stefanvl.lifeandafter.listeners.PKListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public final class LifeAndAfter extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin is starting!");
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new PKListener(), this);

        getCommand("alHealth").setExecutor(new alHealth());
        getCommand("alReset").setExecutor(new alReset());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Plugin is disabled!");
    }
}
