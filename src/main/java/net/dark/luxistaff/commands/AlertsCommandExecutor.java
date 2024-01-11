package net.dark.luxistaff.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AlertsCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.performCommand("vulcan alerts");
            return true;
        } else {
            sender.sendMessage("Questo comando può essere eseguito solo da un giocatore.");
            return false;
        }
    }
}
