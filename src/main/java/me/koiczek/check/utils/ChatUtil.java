package me.koiczek.check.utils;

import org.bukkit.entity.*;
import org.bukkit.*;

public class ChatUtil
{
    public static String fixColor(final String t) {
        return t.replace(">>", "»").replace("&", "§").replace("<<", "«");
    }

    public static void sendMessage(final Player p, final String t) {
        p.sendMessage(fixColor(t));
    }

    public static String locToString(final Location loc) {
        return loc.getX() + ":" + loc.getY() + ":" + loc.getZ() + ":" + loc.getYaw() + ":" + loc.getPitch();
    }

    public static Location locFromString(final String str) {
        final String[] str2loc = str.split(":");
        final Location loc = new Location((World)Bukkit.getWorlds().get(0), 0.0, 0.0, 0.0, 0.0f, 0.0f);
        loc.setX(Double.parseDouble(str2loc[0]));
        loc.setY(Double.parseDouble(str2loc[1]));
        loc.setZ(Double.parseDouble(str2loc[2]));
        loc.setYaw(Float.parseFloat(str2loc[3]));
        loc.setPitch(Float.parseFloat(str2loc[4]));
        return loc;
    }
}
