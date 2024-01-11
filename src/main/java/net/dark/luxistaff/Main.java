package net.dark.luxistaff;

import net.dark.luxistaff.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("ss").setExecutor(new SSTeleportCommand(this));
        getCommand("whois").setExecutor(new WhoisCommandExecutor());
        getCommand("alerts").setExecutor(new AlertsCommandExecutor());
        getCommand("cheatlog").setExecutor(new CheatLogCommandExecutor());
        getCommand("whoiscit").setExecutor(new WhoisCitCommandExecutor());
        getCommand("admingui").setExecutor(new AdminGuiCommandExecutor());
        getCommand("dupeip").setExecutor(new DupeIPCommandExecutor());
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getCommand("invsee").setExecutor(new InvseeCommand());
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
    }
}
