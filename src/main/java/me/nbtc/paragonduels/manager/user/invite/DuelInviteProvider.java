package me.nbtc.paragonduels.manager.user.invite;

import org.bukkit.entity.Player;

import java.util.UUID;

public interface DuelInviteProvider {
    void createInvite(Player inviter, Player target);
    void acceptInvite(Player target, Player inviter);
}
