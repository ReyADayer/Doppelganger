package neocraft.doppelganger.util;

import org.bukkit.entity.Player;
import org.inventivetalent.nicknamer.api.NickManager;
import org.inventivetalent.nicknamer.api.NickNamerAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class NickNamerUtil {

    public static final NickManager nickManager = NickNamerAPI.getNickManager();

    public static void change(@NotNull String playerName, @NotNull String doppelgangerPlayerName) {
        @Nullable UUID uuid = PlayerUtil.getTargetUUID(playerName);
        if (uuid == null) {
            return;
        }
        change(uuid, doppelgangerPlayerName);
    }

    public static void change(@NotNull Player player, @NotNull String doppelgangerPlayerName) {
        change(player.getUniqueId(), doppelgangerPlayerName);
    }

    public static void change(@NotNull UUID uuid, @NotNull String doppelgangerPlayerName) {
        nickManager.setSkin(uuid, doppelgangerPlayerName);
        nickManager.setNick(uuid, doppelgangerPlayerName);
    }

    public static void clear(@NotNull String playerName) {
        @Nullable UUID uuid = PlayerUtil.getTargetUUID(playerName);
        if (uuid == null) {
            return;
        }
        clear(uuid);
    }

    public static void clear(@NotNull Player player) {
        clear(player.getUniqueId());
    }

    public static void clear(@NotNull UUID uuid) {
        nickManager.removeSkin(uuid);
        nickManager.removeNick(uuid);
    }
}
