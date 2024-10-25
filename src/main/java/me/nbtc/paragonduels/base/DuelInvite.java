package me.nbtc.paragonduels.base;

import lombok.Data;
import lombok.Value;

import java.util.UUID;

@Data
public class DuelInvite {
    private final UUID player, target;
    private long invitedAt = System.currentTimeMillis();
}
