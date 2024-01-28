package org.example.r4mblesplugins.fuckman;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.r4mblesplugins.fuckman.commands.DenyCommand;
import org.example.r4mblesplugins.fuckman.commands.FuckCommand;

public final class FuckMan extends JavaPlugin {
    private static FuckMan instance;
    public static FileConfiguration config;
    public static boolean accept = false;

    @Override
    public void onEnable() {
        instance = this;
        config = getConfig();
        saveDefaultConfig();
        new FuckCommand();
        new DenyCommand();
    }

    @Override
    public void onDisable() {
    }

    public static FuckMan GetInstance() {
        return instance;
    }
}
