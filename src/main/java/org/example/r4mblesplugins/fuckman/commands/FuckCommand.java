package org.example.r4mblesplugins.fuckman.commands;

import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.r4mblesplugins.fuckman.FuckMan;

import java.util.Timer;

public class FuckCommand extends AbstractCommand {
    public FuckCommand() {
        super("fuck");
    }

    public static Player p1;
    public static Player p2;
    public static Timer timer;

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player1 = (Player) sender;
        if (!player1.hasPermission("fuck")) {
            player1.sendMessage(FuckMan.config.getString("messages.noperm"));
            return;
        }
        if (args.length == 0) {
            player1.sendMessage(FuckMan.config.getString("messages.no-name-error"));
            return;
        }

        if (!Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
            player1.sendMessage(FuckMan.config.getString("messages.error-name"));
            return;
        }
        Player player2 = Bukkit.getPlayer(args[0]);
        if(player1.getName().equals(player2.getName()))
        {player1.sendMessage(FuckMan.config.getString("messages.fuck-me")); return;}
        player2.sendMessage(FuckMan.config.getString("messages.fuck2-message").replace("[player]", player1.getName()));
        TextComponent component = new TextComponent(FuckMan.config.getString("messages.suggest"));
        String command = "/deny";
        player1.sendMessage(FuckMan.config.getString("messages.fuck-message").replace("[player]", player2.getName()));
        component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(FuckMan.config.getString("messages.click-message")).create()));
        p1 = player1;
        p2 = player2;
        timer = new Timer();
        mTimerTask timerTask = new mTimerTask();
        FuckMan.accept = true;
        player2.spigot().sendMessage(component);
        timer.schedule(timerTask, 30 * 1000);

    }
}

class mTimerTask extends java.util.TimerTask {
    @Override
    public void run() {
        if (FuckMan.accept) {
            FuckCommand.p1.sendMessage(FuckMan.config.getString("messages.no-fuck").replace("[player]", FuckCommand.p2.getName()));
            FuckCommand.p2.sendMessage(FuckMan.config.getString("messages.no-fuck2").replace("[player]", FuckCommand.p1.getName()));
            FuckMan.accept = false;
        }
    }
}
