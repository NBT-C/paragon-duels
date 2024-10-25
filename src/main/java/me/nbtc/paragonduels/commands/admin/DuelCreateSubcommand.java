package me.nbtc.paragonduels.commands.admin;

import me.nbtc.paragonduels.Duels;
import me.nbtc.paragonduels.manager.admin.DuelArenaProvider;
import me.nbtc.paragonduels.utils.TextUtil;
import org.bukkit.entity.Player;

public class DuelCreateSubcommand {
    public DuelCreateSubcommand(Player player, String[] args){
        if (args.length < 2) return;

        DuelArenaProvider provider = Duels.getInstance().getDuelArenaProvider();

        String name = args[1].toLowerCase();
        if (provider.getArenas().containsKey(name)){
            TextUtil.msg(player, "&cArena already exists! &8>> &7" + name);
            return;
        }

        provider.create(name);

        TextUtil.msg(player, "&aArena created! &8>> &7" + name);
    }
}
