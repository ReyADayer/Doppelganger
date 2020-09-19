package neocraft.doppelganger.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.inventivetalent.nicknamer.api.NickNamerAPI;
import org.jetbrains.annotations.Nullable;

public class NameListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        @Nullable String nickName = NickNamerAPI.getNickManager().getNick(player.getUniqueId());
        if (nickName != null) {
            event.setFormat("<" + nickName + "> %2$s");
        }
    }
}
