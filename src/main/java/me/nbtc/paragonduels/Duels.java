package me.nbtc.paragonduels;

import lombok.Getter;
import me.nbtc.paragonduels.commands.admin.AdminDuelCommand;
import me.nbtc.paragonduels.commands.user.DuelAcceptCommand;
import me.nbtc.paragonduels.commands.user.DuelCommand;
import me.nbtc.paragonduels.manager.admin.DuelArenaManager;
import me.nbtc.paragonduels.manager.admin.DuelArenaProvider;
import me.nbtc.paragonduels.manager.user.game.DuelGameManager;
import me.nbtc.paragonduels.manager.user.game.DuelGameProvider;
import me.nbtc.paragonduels.manager.user.invite.DuelInviteManager;
import me.nbtc.paragonduels.manager.user.invite.DuelInviteProvider;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Duels extends JavaPlugin {
    private static @Getter Duels instance;

    private DuelArenaProvider duelArenaProvider;
    private DuelInviteProvider duelInviteProvider;
    private DuelGameProvider duelGameProvider;

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;
        duelArenaProvider = new DuelArenaManager();
        duelInviteProvider = new DuelInviteManager();
        duelGameProvider = new DuelGameManager();

        getCommand("adminduel").setExecutor(new AdminDuelCommand());
        getCommand("duel").setExecutor(new DuelCommand());
        getCommand("duelaccept").setExecutor(new DuelAcceptCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
