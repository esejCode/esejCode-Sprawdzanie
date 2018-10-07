package me.koiczek.check.commands;

import me.koiczek.check.api.data.Config;
import me.koiczek.check.managers.CheckManager;
import me.koiczek.check.utils.ChatUtil;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

import java.util.List;

public class ClearCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        final Player p = (Player)sender;
        final String perm = "esej.check.clear";
        if (!p.hasPermission(perm)) {
            ChatUtil.sendMessage(p, "&c&lBlad: &7Nie posiadasz permisji! &8(&cesej.clear&8)");
            return false;
        }
        if (args.length != 1) {
            ChatUtil.sendMessage(p, "&c&lBlad: &7Poprawne uzycie: /czysty <gracz_online>");
            return false;
        }
        if (Bukkit.getPlayer(args[0]) == null) {
            ChatUtil.sendMessage(p, "&c&lBlad: &7Nie znaleziono takiego gracza!");
            return false;
        }
        Player spr = Bukkit.getPlayer(args[0]);
        if (!CheckManager.players.containsKey(spr.getUniqueId())) {
            ChatUtil.sendMessage(p, "&c&lBlad: &7Ten gracz nie jest podejrzany!");
            return false;
        }
        final List<String> clear = Config.MESSAGE_CLEAR;

        CheckManager.players.remove(spr.getUniqueId(),p.getName());
        ChatUtil.sendMessage(p, "&8[&2Sprawdzanie&8] &7Oczysciles z zarzutow gracza &6"+spr.getName()+"&7!");
        clear.forEach(c -> ChatUtil.sendMessage(spr, c));
        return true;
    }
}
