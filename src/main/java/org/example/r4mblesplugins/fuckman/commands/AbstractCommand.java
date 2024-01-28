package org.example.r4mblesplugins.fuckman.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.example.r4mblesplugins.fuckman.FuckMan;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractCommand implements CommandExecutor {
    public AbstractCommand(String command) {
        PluginCommand PluginCommand = FuckMan.GetInstance().getCommand(command);
        if (PluginCommand != null) {
            PluginCommand.setExecutor(this);
        }

    }

    public abstract void execute(CommandSender sender, String label, String[] args);

    @Override
    public boolean onCommand(@Nullable CommandSender sender, @Nullable Command command, @Nullable String label, String[] args) {
        execute(sender, label, args);
        return true;
    }
}
