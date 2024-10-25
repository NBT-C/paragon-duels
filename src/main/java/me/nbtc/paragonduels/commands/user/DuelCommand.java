package me.nbtc.paragonduels.commands.user;

import me.nbtc.paragonduels.Duels;
import me.nbtc.paragonduels.utils.TextUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DuelCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player player)) return false;

        if (args.length == 0){
            TextUtil.msg(player, "&7- /duel <player> &c- &7Please choose a player");
            return false;
        }

        String playerS = args[0];
        Player target = Bukkit.getPlayer(playerS);
        if (target == null || !target.isOnline()) {
            TextUtil.msg(player, "&c- &7Player not found");
            return false;
        }

        if (Duels.getInstance().getDuelArenaProvider().getPlayableArena() == null){
            TextUtil.msg(player, "&c- &7No free arenas!");
            return false;
        }

        Duels.getInstance().getDuelInviteProvider().createInvite(player, target);
        return false;
    }
}
