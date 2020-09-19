package neocraft.doppelganger.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class PlayerUtil {
    @Nullable
    public static UUID getTargetUUID(String playerName) {
        Player targetPlayer = Bukkit.getPlayer(playerName);
        if (targetPlayer == null) {
            return null;
        }
        return targetPlayer.getUniqueId();
    }
}
