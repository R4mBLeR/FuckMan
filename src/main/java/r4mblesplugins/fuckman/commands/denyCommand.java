package r4mblesplugins.fuckman.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import r4mblesplugins.fuckman.FuckMan;

public class denyCommand extends AbstractCommand {
    public denyCommand() {
        super("deny");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        if (FuckMan.accept) {
            sexCommand.timer.cancel();
            FuckMan.accept = false;
            Player player1 = sexCommand.p1;
            Player player2 = sexCommand.p2;
            player1.sendMessage(FuckMan.config.getString("messages.fuck").replace("[player]", player2.getName()));
            player2.sendMessage(FuckMan.config.getString("messages.fuck2").replace("[player]", player1.getName()));
        }
    }
}
