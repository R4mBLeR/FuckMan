package org.example.r4mblesplugins.fuckman.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.r4mblesplugins.fuckman.FuckMan;

public class DenyCommand extends AbstractCommand {
    public DenyCommand() {
        super("deny");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        if (FuckMan.accept) {
            FuckCommand.timer.cancel();
            FuckMan.accept = false;
            Player player1 = FuckCommand.p1;
            Player player2 = FuckCommand.p2;
            player1.sendMessage(FuckMan.config.getString("messages.fuck").replace("[player]", player2.getName()));
            player2.sendMessage(FuckMan.config.getString("messages.fuck2").replace("[player]", player1.getName()));
        }
    }
}
