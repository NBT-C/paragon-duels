package me.nbtc.paragonduels.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class GameListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if (event.getItem().hasItemMeta() && event.getItem().getType() == Material.WOODEN_SWORD &&
                event.getItem().getItemMeta().getDisplayName().contains("Select a Kit")){

            event.getPlayer().sendMessage("test");
        }
    }

}
