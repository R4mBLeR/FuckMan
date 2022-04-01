package r4mblesplugins.fuckman;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import r4mblesplugins.fuckman.commands.nocommand;
import r4mblesplugins.fuckman.commands.sexCommand;
import r4mblesplugins.fuckman.commands.yescommand;

public final class FuckMan extends JavaPlugin {
    private static FuckMan instance;
    public static FileConfiguration config;
    public static boolean accept;

    @Override
    public void onEnable() {
        instance = this;
        config = getConfig();
        saveDefaultConfig();
        new sexCommand();
        new yescommand();
        new nocommand();

    }

    @Override
    public void onDisable() {
    }

    public static FuckMan GetInstance() {
        return instance;
    }
}
