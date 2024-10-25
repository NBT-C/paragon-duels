package me.nbtc.paragonduels.commands.admin;

import me.nbtc.paragonduels.Duels;
import me.nbtc.paragonduels.base.DuelArenaState;
import me.nbtc.paragonduels.manager.admin.DuelArenaProvider;
import me.nbtc.paragonduels.utils.TextUtil;
import org.bukkit.entity.Player;

public class DuelStopSubcommand {
    public DuelStopSubcommand(Player player, String[] args){
        if (args.length < 2) return;

        DuelArenaProvider provider = Duels.getInstance().getDuelArenaProvider();

        String name = args[1].toLowerCase();
        if (!provider.getArenas().containsKey(name)){
            TextUtil.msg(player, "&cArena doesn't exist! &8>> &7" + name);
            return;
        }

        provider.getArenas().get(name).setState(DuelArenaState.NOT_SET);
        TextUtil.msg(player, "&aClosed successfully! (Not playable now) &8>> &7" + name);
    }
}
