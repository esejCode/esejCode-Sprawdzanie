package me.koiczek.check;

import me.koiczek.check.commands.CheaterCommand;
import me.koiczek.check.commands.CheckCommand;
import me.koiczek.check.commands.ClearCommand;
import me.koiczek.check.commands.SetSprCommand;
import me.koiczek.check.listeners.AsyncPlayerChatListener;
import me.koiczek.check.listeners.PlayerCommandPreProcessListener;
import me.koiczek.check.listeners.PlayerQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Check extends JavaPlugin {
    private static Check inst;
    static PluginManager pm = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        inst = this;
        saveDefaultConfig();
        this.getLogger().log(Level.INFO, "Uruchamianie pluginu...");
        registerCommands();
        registerEvents();
        this.getLogger().log(Level.INFO, "Uruchomiono plugin!");

    }

    public void registerCommands()
    {
        getCommand("sprawdz").setExecutor(new CheckCommand());
        getCommand("czysty").setExecutor(new ClearCommand());
        getCommand("cheater").setExecutor(new CheaterCommand());
        getCommand("setspr").setExecutor(new SetSprCommand());
    }

    public void registerEvents()
    {
        pm.registerEvents(new PlayerQuitListener(), this);
        pm.registerEvents(new AsyncPlayerChatListener(), this);
        pm.registerEvents(new PlayerCommandPreProcessListener(), this);
    }

    public static Check getInst()
    {
        return inst;
    }
}
