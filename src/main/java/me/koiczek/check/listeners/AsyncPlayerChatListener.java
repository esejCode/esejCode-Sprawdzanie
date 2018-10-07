package me.koiczek.check.listeners;

import me.koiczek.check.api.data.Config;
import me.koiczek.check.managers.CheckManager;
import me.koiczek.check.utils.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener{

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
        final Player p = e.getPlayer();

        if (CheckManager.players.containsKey(p.getUniqueId())) {
            ChatUtil.sendMessage(p, Config.MESSAGE_ERROR);
            e.setCancelled(true);
            return;
        } else {
            return;
        }
    }
}
