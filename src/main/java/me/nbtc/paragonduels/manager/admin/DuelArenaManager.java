package me.nbtc.paragonduels.manager.admin;

import me.nbtc.paragonduels.base.DuelArena;
import org.bukkit.Location;

import java.util.*;

public class DuelArenaManager implements DuelArenaProvider{
    private final Map<String, DuelArena> arenaMap = new HashMap<>();
    private final List<String> usedArenas = new ArrayList<>();

    @Override
    public void create(String name) {
        if (name.isEmpty() || arenaMap.containsKey(name)){
            return;
        }

        DuelArena duelArena = new DuelArena(name);
        arenaMap.put(name, duelArena);
    }

    @Override
    public void delete(String name) {
        arenaMap.remove(name.toLowerCase());
    }

    @Override
    public Map<String, DuelArena> getArenas() {
        return arenaMap;
    }

    @Override
    public void setPos(DuelArena arena, String pos, Location location) {
        arena.getPositions().put(pos, location);
    }

    @Override
    public List<String> getNeededPositions() {
        return List.of("corner1", "corner2", "spawn1", "spawn2");
    }

    @Override
    public DuelArena getPlayableArena() {
        for (DuelArena arena : arenaMap.values()){
            if (arena.isSetUp() && arena.isPlayable()){
                return arena;
            }
        }
        return null;
    }
}
