package r4mblesplugins.fuckman.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.jetbrains.annotations.Nullable;
import r4mblesplugins.fuckman.FuckMan;

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
