package net.dark.luxistaff;

import org.bukkit.ChatColor;

public class ColorUtil {
    public static String translate(String messaggio) {
        return ChatColor.translateAlternateColorCodes('&', messaggio);
    }
}
