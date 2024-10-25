package me.nbtc.paragonduels.commands.admin;

import me.nbtc.paragonduels.Duels;
import me.nbtc.paragonduels.base.DuelArena;
import me.nbtc.paragonduels.manager.admin.DuelArenaProvider;
import me.nbtc.paragonduels.utils.TextUtil;
import org.bukkit.entity.Player;

public class DuelSetPosSubcommand {
    public DuelSetPosSubcommand(Player player, String[] args){
        if (args.length < 3) return;

        DuelArenaProvider provider = Duels.getInstance().getDuelArenaProvider();

        String name = args[1].toLowerCase();

        if (!provider.getArenas().containsKey(name)){
            TextUtil.msg(player, "&cArena doesn't exist! &8>> &7" + name);
            return;
        }

        DuelArena arena = provider.getArenas().get(name);
        String pos = args[2].toLowerCase();

        if (!provider.getNeededPositions().contains(pos)){
            TextUtil.msg(player, "&cNot a valid position to set &8>> &7" + name);
            return;
        }

        provider.setPos(arena, pos, player.getLocation());

        TextUtil.msg(player, "&aPos set successfully! &8>> &7" + name + " &8>> &7" + pos);
    }
}
