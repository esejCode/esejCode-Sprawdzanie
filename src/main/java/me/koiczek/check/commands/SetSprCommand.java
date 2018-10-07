package me.koiczek.check.commands;

import me.koiczek.check.Check;
import me.koiczek.check.api.data.Config;
import me.koiczek.check.managers.CheckManager;
import me.koiczek.check.utils.ChatUtil;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

import java.util.List;

public class SetSprCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        final Player p = (Player)sender;
        final String perm = "esej.check.setspr";
        if (!p.hasPermission(perm)) {
            ChatUtil.sendMessage(p, "&c&lBlad: &7Nie posiadasz permisji! &8(&cesej.setspr&8)");
            return false;
        }
        if (args.length != 0) {
            ChatUtil.sendMessage(p, "&c&lBlad: &7Poprawne uzycie: /setspr");
            return false;
        }

        Check.getInst().getConfig().set("spawn", ChatUtil.locToString(p.getLocation()));
        Check.getInst().saveConfig();
        ChatUtil.sendMessage(p, "&8[&2Sprawdzanie&8] &7Ustawiles nowy punkt spawnu!");
        return true;
    }
}
