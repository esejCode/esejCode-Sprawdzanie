package me.koiczek.check.listeners;

import me.koiczek.check.api.data.Config;
import me.koiczek.check.managers.CheckManager;
import me.koiczek.check.utils.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreProcessListener implements Listener{

    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent e)
    {
        final Player p = e.getPlayer();

        if (CheckManager.players.containsKey(p.getUniqueId())) {
            if (p.hasPermission("esej.check.bypass")) {
                return;
            }
            if (!e.getMessage().startsWith("/helpop")) {
                ChatUtil.sendMessage(p, Config.MESSAGE_ERROR);
                e.setCancelled(true);
            } else {
                return;
            }
            return;
        } else {
            return;
        }
    }
}
