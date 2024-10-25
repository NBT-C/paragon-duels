package me.nbtc.paragonduels.base;

import io.github.mqzen.menus.misc.itembuilder.ItemBuilder;
import lombok.Data;
import lombok.Value;
import me.nbtc.paragonduels.utils.TextUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

@Data @Value
public class DuelGame {
    Player player1, player2;
    DuelArena arena;

    public void start(){
        List<Player> players = List.of(player1,player2);

        if (arena == null){
            players.forEach(player -> TextUtil.msg(player, "&cDuel Cancelled, no free arena!"));
            return;
        }

        player1.teleport(arena.getPositions().get("spawn1"));
        player2.teleport(arena.getPositions().get("spawn2"));

        players.forEach(player -> {
            player.getInventory().clear();

            player.setHealth(20);
            player.setFoodLevel(20);

            player.setGameMode(player.getGameMode());
            player.setAllowFlight(false);
            player.setFlying(false);

            player.getInventory().setItem(0,
                    ItemBuilder.legacy(Material.WOODEN_SWORD).setDisplay("&eSelect a Kit").build());
        });
    }
}
