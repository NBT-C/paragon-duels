package me.nbtc.paragonduels.commands.admin;

import me.nbtc.paragonduels.utils.TextUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminDuelCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 0) return false;
        if (!(sender instanceof Player player)) return false;
        if (!player.hasPermission("duel.admin")) return false;

        String arg = args[0];
        switch (arg){
            case "help":{
                TextUtil.msg(player, "&7/duel create &e<arena> &7- Create an arena");
                TextUtil.msg(player, "&7/duel delete &e<arena> &7- Delete an arena");
                TextUtil.msg(player, "&7/duel setpos &e<arena> <pos> &7- (corner1, corner2, spawn1, spawn2)");
                TextUtil.msg(player, "&7/duel confirm &e<arena> &7- Make arena playable");
                TextUtil.msg(player, "&7/duel stop &e<arena> &7- Stop arena from being playable");
                break;
            }
            case "create":{
                new DuelCreateSubcommand(player, args);
                break;
            }
            case "delete":{
                new DuelRemoveSubcommand(player, args);
                break;
            }
            case "confirm":{
                new DuelConfirmSubcommand(player, args);
                break;
            }
            case "stop":{
                new DuelStopSubcommand(player, args);
                break;
            }
            case "setpos":{
                new DuelSetPosSubcommand(player, args);
                break;
            }
        }
        return false;
    }
}
