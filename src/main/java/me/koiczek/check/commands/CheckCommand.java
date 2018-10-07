package me.koiczek.check.commands;

import me.koiczek.check.api.data.Config;
import me.koiczek.check.managers.CheckManager;
import me.koiczek.check.utils.ChatUtil;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

import java.util.List;

public class CheckCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        final Player p = (Player)sender;
        final String perm = "esej.check.check";
        if (!p.hasPermission(perm)) {
            ChatUtil.sendMessage(p, "&c&lBlad: &7Nie posiadasz permisji! &8(&cesej.check&8)");
            return false;
        }
        if (args.length != 1) {
            ChatUtil.sendMessage(p, "&c&lBlad: &7Poprawne uzycie: /sprawdz <gracz_online>");
            return false;
        }
        if (Bukkit.getPlayer(args[0]) == null) {
            ChatUtil.sendMessage(p, "&c&lBlad: &7Nie znaleziono takiego gracza!");
            return false;
        }
        Player spr = Bukkit.getPlayer(args[0]);
        if (CheckManager.players.containsKey(spr.getUniqueId())) {
            ChatUtil.sendMessage(p, "&c&lBlad: &7Ten gracz jest juz sprawdzany!");
            return false;
        }
        final List<String> check = Config.MESSAGE_CHECK;

        CheckManager.players.put(spr.getUniqueId(),p.getName());
        ChatUtil.sendMessage(p, "&8[&2Sprawdzanie&8] &7Rozpoczales check gracza &6"+spr.getName()+"&7...");
        spr.teleport(ChatUtil.locFromString(Config.SPAWN));
        check.forEach(c -> ChatUtil.sendMessage(spr, c));
        return true;
    }
}
