package me.nbtc.paragonduels.base;

import lombok.Data;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

@Data
public class DuelArena {
    private final String name;
    private Map<String, Location> positions = new HashMap<>();
    private DuelArenaState state;

    public boolean isSetUp(){
        return positions.get("corner1") != null &&
                positions.get("corner2") != null &&
                positions.get("spawn1") != null &&
                positions.get("spawn2") != null;
    }
    public boolean isPlayable(){
        return state == DuelArenaState.FREE;
    }
}
