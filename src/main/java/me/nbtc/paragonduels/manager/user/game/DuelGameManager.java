package me.nbtc.paragonduels.manager.user.game;

import io.github.mqzen.menus.misc.itembuilder.ItemBuilder;
import me.nbtc.paragonduels.Duels;
import me.nbtc.paragonduels.base.DuelArena;
import me.nbtc.paragonduels.base.DuelArenaState;
import me.nbtc.paragonduels.base.DuelGame;
import me.nbtc.paragonduels.utils.TextUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DuelGameManager implements DuelGameProvider {
    private List<DuelGame> runningGames = new ArrayList<>();

    @Override
    public void startDuel(Player player1, Player player2) {
        DuelArena arena = Duels.getInstance().getDuelArenaProvider().getPlayableArena();
        DuelGame duelGame = new DuelGame(player1, player2, arena);
        arena.setState(DuelArenaState.PLAYING);

        runningGames.add(duelGame);
        duelGame.start();
    }

    @Override
    public void endDuel(Player player1, Player player2) {

    }

    @Override
    public void openKitMenu(Player player) {

    }
}
