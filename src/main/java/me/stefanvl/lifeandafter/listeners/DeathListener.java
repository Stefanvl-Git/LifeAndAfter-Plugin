package me.stefanvl.lifeandafter.listeners;

import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.util.Vector;

public class DeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (((Player) e.getEntity()).getPlayer());
            p.setMaxHealth(Math.max(0, p.getMaxHealth() - 2));
            p.sendMessage("You lost a heart by dying!");
            p.spawnParticle(Particle.SOUL, p.getLocation(), 100);
        }
    }
}