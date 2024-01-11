package net.dark.luxistaff.commands;

import net.dark.luxistaff.ColorUtil;
import net.dark.luxistaff.Main;
import net.dark.luxistaff.RGBUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VanishCommand implements CommandExecutor {

    private final Main plugin;
    private final List<UUID> vanished = new ArrayList<>();

    public VanishCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Solo i player possono utilizzare questo comando");
            return true;
        }
        String PREFIX = "&#084cfb&lL&#1054fb&lu&#175bfb&lx&#1f63fb&li&#266afb&lS&#2e72fb&lt&#357afc&la&#3d81fc&lf&#4489fc&lf &#4c90fc&l| &#5398fc&lb&#5ba0fc&ly &#62a7fc&l_&#6aaffc&lI&#71b6fc&lt&#79befc&ls&#80c5fc&l_&#88cdfd&lD&#8fd5fd&l4&#97dcfd&lr&#9ee4fd&lk&#a6ebfd&l_ &#adf3fd&l| ";

        Player player = (Player) sender;

        if (vanished.contains(player.getUniqueId())) {
            vanished.remove(player.getUniqueId());
            for (Player target : Bukkit.getOnlinePlayers()) {
                target.showPlayer(plugin, player);
            }
            player.sendMessage(ColorUtil.translate(RGBUtil.translateHexColorCodes(PREFIX + "non sei più in vanish")));
        } else {
            vanished.add(player.getUniqueId());
            for (Player target : Bukkit.getOnlinePlayers()) {
                target.hidePlayer(plugin, player);
            }
            player.sendMessage(ColorUtil.translate(RGBUtil.translateHexColorCodes(PREFIX + "Sei in vanish")));
        }
        return true;
    }
}
