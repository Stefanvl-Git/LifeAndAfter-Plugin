package me.stefanvl.lifeandafter.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PKListener implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity killer = event.getEntity().getKiller();
        Entity deadEntity = event.getEntity();

        if(killer instanceof Player && deadEntity instanceof Player) {
            Player Pkiller = event.getEntity().getKiller();
            Player deadPlayer = (Player) event.getEntity();
            if(deadPlayer.getMaxHealth() > 2) {
                Pkiller.setMaxHealth(Math.max(0, Pkiller.getMaxHealth() + 2));
                Pkiller.sendMessage("You gained a heart by killing another player!");
            }else{
                Pkiller.sendMessage("This player does not have any more hearts!");
            }




        }
    }
}
