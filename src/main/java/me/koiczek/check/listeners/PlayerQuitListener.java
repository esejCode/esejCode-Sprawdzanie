package me.koiczek.check.listeners;

import me.koiczek.check.api.data.Config;
import me.koiczek.check.managers.CheckManager;
import me.koiczek.check.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class PlayerQuitListener implements Listener{

    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
        final Player p = e.getPlayer();

        if (CheckManager.players.containsKey(p.getUniqueId())) {
            final String admin = CheckManager.players.get(p.getUniqueId());
            final Player a = Bukkit.getPlayer(admin);
            final List<String> msg = Config.MESSAGE_LOGOUT;
            msg.forEach(c -> ChatUtil.sendMessage(a, c.replace("{SPR-NAME}", p.getName())));
            CheckManager.players.remove(p.getUniqueId());
        }
    }
}
