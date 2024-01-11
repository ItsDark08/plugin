package net.dark.luxistaff.commands;

import net.dark.luxistaff.ColorUtil;
import net.dark.luxistaff.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;

public class SSTeleportCommand implements CommandExecutor {

    private final Main plugin;

    public SSTeleportCommand(Main plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String PREFIX = "&#084cfb&lL&#1054fb&lu&#175bfb&lx&#1f63fb&li&#266afb&lS&#2e72fb&lt&#357afc&la&#3d81fc&lf&#4489fc&lf &#4c90fc&l| &#5398fc&lb&#5ba0fc&ly &#62a7fc&l_&#6aaffc&lI&#71b6fc&lt&#79befc&ls&#80c5fc&l_&#88cdfd&lD&#8fd5fd&l4&#97dcfd&lr&#9ee4fd&lk&#a6ebfd&l_ &#adf3fd&l| ";
        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtil.translate(PREFIX + "Solo i giocatori possono usare questo comando!"));
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("luxistaff.ss")) {
            player.sendMessage(ColorUtil.translate(PREFIX + "Non hai il permesso per usare questo comando!"));
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(ColorUtil.translate(PREFIX + "Utilizzo corretto: /ss <player>"));
            return true;
        }

        Player targetPlayer = player.getServer().getPlayer(args[0]);

        if (targetPlayer == null || !targetPlayer.isOnline()) {
            player.sendMessage(ColorUtil.translate(PREFIX + "Il giocatore specificato non è online."));
            return true;
        }

        FileConfiguration config = plugin.getConfig();
        double x = config.getDouble("teleport_coordinates.x");
        double y = config.getDouble("teleport_coordinates.y");
        double z = config.getDouble("teleport_coordinates.z");
        String worldName = config.getString("teleport_coordinates.world", player.getWorld().getName());

        player.teleport(targetPlayer.getLocation());
        player.sendMessage(ColorUtil.translate(PREFIX + "Hai portato in ss il player " + targetPlayer.getName() + "."));

        targetPlayer.teleport(Objects.requireNonNull(Bukkit.getWorld(worldName)).getBlockAt((int)x, (int)y, (int)z).getLocation());
        targetPlayer.sendMessage(ColorUtil.translate(PREFIX + "Sei stato portato in ss da " + player.getDisplayName() + " installa anydesk: www.anydesk.com/download."));

        return true;
    }
}
