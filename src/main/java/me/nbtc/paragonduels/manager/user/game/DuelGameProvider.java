package me.nbtc.paragonduels.manager.user.game;

import org.bukkit.entity.Player;

public interface DuelGameProvider {
    void startDuel(Player player1, Player player2);
    void endDuel(Player player1, Player player2);
    void openKitMenu(Player player);
}
