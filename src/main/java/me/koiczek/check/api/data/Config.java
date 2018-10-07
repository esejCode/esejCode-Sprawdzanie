package me.koiczek.check.api.data;

import me.koiczek.check.Check;
import org.bukkit.configuration.file.*;
import java.util.*;

public class Config
{
    static FileConfiguration config;
    public static List<String> MESSAGE_CHECK;
    public static List<String> MESSAGE_CLEAR;
    public static List<String> MESSAGE_CHEATER;
    public static List<String> MESSAGE_LOGOUT;
    public static String MESSAGE_ERROR;
    public static String SPAWN;

    static {
        Config.config = Check.getInst().getConfig();
        Config.MESSAGE_CHECK = config.getStringList("message.check");
        Config.MESSAGE_CLEAR = config.getStringList("message.clear");
        Config.MESSAGE_CHEATER = config.getStringList("message.cheater");
        Config.MESSAGE_LOGOUT = config.getStringList("message.logout");
        Config.MESSAGE_ERROR = config.getString("message.error");
        Config.SPAWN = config.getString("spawn");
    }
}
