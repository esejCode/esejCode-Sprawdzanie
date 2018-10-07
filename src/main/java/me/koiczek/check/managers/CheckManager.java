package me.koiczek.check.managers;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CheckManager {

    public static Map<UUID, String> players;

    static {
        players = new ConcurrentHashMap<UUID, String>();
    }
}
