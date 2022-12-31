package com.github.xKenKOfficial.Utils.Bungee.Commands;

import com.github.xKenKOfficial.Utils.Bungee.Basic.Main;
import com.github.xKenKOfficial.Utils.Utils.All.ChatUtil;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class xKenUtilsCommand extends Command
{
    private static final String NO_PERMISSION = Main.getPlugin().getConfiguration().getString("no_permission");
    private static final String WRONG_ARGS = Main.getPlugin().getConfiguration().getString("wrong_args");

    public xKenUtilsCommand(String name)
    {
        super(name);
    }

    @Override
    public void execute(final CommandSender Sender, final String[] args) {
        if(!Sender.hasPermission("xkenutils.admin.cmd.xkenutils")) {
            Sender.sendMessage(ChatUtil.fixColor(NO_PERMISSION));
            return;
        }
        if(args.length < 1) {
            Sender.sendMessage(ChatUtil.fixColor("&8&l===============[&3&l" + Main.getPlugin().getDescription().getName() + "&8&l]==============="));
            Sender.sendMessage(ChatUtil.fixColor(" "));
            Sender.sendMessage(ChatUtil.fixColor(" &7Plugin&8: &b" + Main.getPlugin().getDescription().getName()));
            Sender.sendMessage(ChatUtil.fixColor(" "));
            Sender.sendMessage(ChatUtil.fixColor(" &7Wersja&8: &b" + Main.getPlugin().getDescription().getVersion()));
            Sender.sendMessage(ChatUtil.fixColor(" "));
            Sender.sendMessage(ChatUtil.fixColor(" &7Ostatnia Aktualizacja&8: &b31.12.2022r. godz. 22:35"));
            Sender.sendMessage(ChatUtil.fixColor(" "));
            Sender.sendMessage(ChatUtil.fixColor("&8&l===============[&3&l" + Main.getPlugin().getDescription().getName() + "&8&l]==============="));
            return;
        } else {
            Sender.sendMessage(ChatUtil.fixColor(WRONG_ARGS));
        }
    }
}
