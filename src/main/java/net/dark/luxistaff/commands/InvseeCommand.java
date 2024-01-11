package net.dark.luxistaff.commands;

import net.dark.luxistaff.ColorUtil;
import net.dark.luxistaff.RGBUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Solo i giocatori possono usare questo comando!");
            return true;
        }

        Player player = (Player) sender;
        String PREFIX = "&#084cfb&lL&#1054fb&lu&#175bfb&lx&#1f63fb&li&#266afb&lS&#2e72fb&lt&#357afc&la&#3d81fc&lf&#4489fc&lf &#4c90fc&l| &#5398fc&lb&#5ba0fc&ly &#62a7fc&l_&#6aaffc&lI&#71b6fc&lt&#79befc&ls&#80c5fc&l_&#88cdfd&lD&#8fd5fd&l4&#97dcfd&lr&#9ee4fd&lk&#a6ebfd&l_ &#adf3fd&l| ";

        if (!player.hasPermission("luxistaff.invsee")) {
            player.sendMessage(ColorUtil.translate(RGBUtil.translateHexColorCodes(PREFIX + "Non hai il permesso per usare questo comando!")));
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(ColorUtil.translate(RGBUtil.translateHexColorCodes(PREFIX + "Utilizzo corretto: /invsee <player>")));
            return true;
        }

        Player targetPlayer = player.getServer().getPlayer(args[0]);

        if (targetPlayer == null) {
            player.sendMessage(ColorUtil.translate(RGBUtil.translateHexColorCodes(PREFIX + "Il giocatore specificato non è online.")));
            return true;
        }

        player.openInventory(targetPlayer.getInventory());

        return true;
    }
}
