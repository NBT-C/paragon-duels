package me.nbtc.paragonduels.manager.admin;

import me.nbtc.paragonduels.base.DuelArena;
import org.bukkit.Location;

import java.util.List;
import java.util.Map;

public interface DuelArenaProvider {
    void create(String name);
    void delete(String name);
    Map<String, DuelArena> getArenas();
    void setPos(DuelArena arena, String pos, Location location);
    List<String> getNeededPositions();

    DuelArena getPlayableArena();
}
