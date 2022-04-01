package r4mblesplugins.fuckman.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import r4mblesplugins.fuckman.FuckMan;


public class sexCommand extends AbstractCommand{
    public sexCommand() {
        super("fuck");
    }
    @Override
    public void execute(CommandSender sender, String label, String[] args)
    {
        Player player1=(Player) sender;
        if(!player1.hasPermission("fuck"))
        {
            player1.sendMessage(FuckMan.config.getString("messages.noperm"));
            return;
        }
        if(args.length==0)
        {
            player1.sendMessage(FuckMan.config.getString("messages.no-name-error"));
            return;
        }

        if(!Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))){player1.sendMessage(FuckMan.config.getString("messages.error-name")); return;}
        Player player2=Bukkit.getPlayer(args[0]);
        player2.sendMessage(FuckMan.config.getString("messages.fuck2-message").replace("[player]",player1.getName())+"\n"+FuckMan.config.getString("messages.suggest-message"));
        TextComponent yes=new TextComponent(FuckMan.config.getString("messages.yes"));
        yes.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/yes"));
        yes.addExtra(StringUtils.repeat(" ",FuckMan.config.getInt("settings.spaces")));
        TextComponent no = new TextComponent(FuckMan.config.getString("messages.no"));
        no.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/no"));
        yes.addExtra(no);
        player2.spigot().sendMessage(yes);
        player1.sendMessage(FuckMan.config.getString("messages.fuck-message").replace("[player]",player2.getName()));
        if(FuckMan.accept)
        {
            player1.sendMessage(FuckMan.config.getString("messages.fuck"));
            player2.sendMessage(FuckMan.config.getString("messages.fuck2"));
        } else{
            player1.sendMessage(FuckMan.config.getString("messages.no-fuck"));
            player2.sendMessage(FuckMan.config.getString("messages.no-fuck2"));
        }
    }

}
