package me.nbtc.paragonduels.manager.user.invite;

import me.nbtc.paragonduels.Duels;
import me.nbtc.paragonduels.base.DuelInvite;
import me.nbtc.paragonduels.utils.TextUtil;
import org.bukkit.entity.Player;

import java.util.*;

public class DuelInviteManager implements DuelInviteProvider{
    private final Map<UUID, List<DuelInvite>> invites = new HashMap<>();

    @Override
    public void createInvite(Player inviter, Player target) {
        DuelInvite invite = new DuelInvite(inviter.getUniqueId(), target.getUniqueId());

        invites.putIfAbsent(inviter.getUniqueId(), new ArrayList<>());
        invites.get(inviter.getUniqueId()).add(invite);

        TextUtil.msg(inviter, "&aInvite sent!");
        TextUtil.msg(target, "&aYou have received an invite from &c" + inviter.getDisplayName() + "&a!",
                "/duelaccept " + inviter.getName(), "&7Click here to accept!");
    }

    @Override
    public void acceptInvite(Player target, Player inviter) {
        if (invites.get(target.getUniqueId()).isEmpty()){
            TextUtil.msg(target, "&cYou have no invites buddy!");
            return;
        }

        List<DuelInvite> invites = this.invites.get(target.getUniqueId());
        for (DuelInvite invite : invites){
            if (invite.getPlayer().equals(inviter.getUniqueId())){
                this.invites.get(target.getUniqueId()).remove(invite);

                Player player = target.getServer().getPlayer(inviter.getUniqueId());
                if (player == null || !player.isOnline()){
                    TextUtil.msg(target, "&cInvite cancelled, player offline!");
                    return;
                }

                TextUtil.msg(target, "&aInvite accepted!");

                Duels.getInstance().getDuelGameProvider().startDuel(target, player);
                break;
            }
        }
    }
}
