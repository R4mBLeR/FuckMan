package r4mblesplugins.fuckman;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import r4mblesplugins.fuckman.commands.denyCommand;
import r4mblesplugins.fuckman.commands.sexCommand;

public final class FuckMan extends JavaPlugin {
    private static FuckMan instance;
    public static FileConfiguration config;
    public static boolean accept = false;

    @Override
    public void onEnable() {
        instance = this;
        config = getConfig();
        saveDefaultConfig();
        new sexCommand();
        new denyCommand();
    }

    @Override
    public void onDisable() {
    }

    public static FuckMan GetInstance() {
        return instance;
    }
}
