package me.stefanvl.lifeandafter.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class alHealth implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // /alhealth - checks player current healthpoints
        if (command.getName().equalsIgnoreCase("alhealth")) {

            if (sender instanceof Player) {
                Player pp = (Player) sender;
                if(pp.hasPermission("laa.alhealth")) {
                    Player player = (Player) sender;
                    if (args.length == 1) {
                        if (player.getServer().getPlayer(args[0]) != null) {
                            Player targetPlayer = player.getServer().getPlayer(args[0]);
                            targetPlayer.getHealth();
                            player.sendMessage(targetPlayer.getHealth() + " Hearts");
                        } else {
                            player.sendMessage("PLAYER NOT ONLINE");
                        }
                    }
                }else{
                    pp.sendMessage("You do not have permission to use this command!");
                }
            }
        }
        return true;
    }


}
