package me.stefanvl.lifeandafter.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class alReset implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // /alreset - Resets the current players health points to the default of 20.0 HP. (standard vanilla HP)
        if (command.getName().equalsIgnoreCase("alreset")) {

            if (sender instanceof Player) {
                Player pp = (Player) sender;
                if(pp.hasPermission("laa.alreset")) {
                    Player player = (Player) sender;
                    if (args.length == 1) {
                        if (player.getServer().getPlayer(args[0]) != null) {
                            Player targetPlayer = player.getServer().getPlayer(args[0]);
                            targetPlayer.setMaxHealth(20);
                            player.sendMessage("Players hearts got reset the the default of 20.0 HP");
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
