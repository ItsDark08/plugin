package net.dark.luxistaff.commands;

import net.dark.luxistaff.ColorUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Player targetPlayer = player.getServer().getPlayer(args[0]);
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "il comando puo essere eseguito solo da un giocatore");
            return true;
        }
        if (args.length != 1) {
            player.sendMessage(ColorUtil.translate("Utilizzo corretto: /mute <player>"));
            return true;
        }
        if (!player.hasPermission("luxistaff.staff")) {
            player.sendMessage(ColorUtil.translate("Non hai il permesso per usare questo comando!"));
            return true;
        }
        return true;
    }
}
