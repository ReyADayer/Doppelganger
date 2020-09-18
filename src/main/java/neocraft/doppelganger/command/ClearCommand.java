package neocraft.doppelganger.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.inventivetalent.nicknamer.api.NickNamerAPI;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ClearCommand implements CommandExecutor {
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            String[] args
    ) {
        if (args.length < 1) {
            return false;
        }
        String targetPlayerName = args[0];
        if (targetPlayerName.equals("@a")) {
            Bukkit.getOnlinePlayers().forEach(this::clear);
        } else {
            UUID targetUUID = CommandUtil.getTargetUUID(targetPlayerName);
            if (targetUUID == null) {
                return false;
            }
            clear(targetUUID);
        }
        return true;
    }

    private void clear(@NotNull Player player) {
        clear(player.getUniqueId());
    }

    private void clear(@NotNull UUID uuid) {
        NickNamerAPI.getNickManager().removeSkin(uuid);
        NickNamerAPI.getNickManager().removeNick(uuid);
    }
}
