package neocraft.doppelganger.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.inventivetalent.nicknamer.api.NickNamerAPI;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ChangeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            String[] args
    ) {
        if (args.length < 2) {
            return false;
        }
        String targetPlayerName = args[0];
        String doppelgangerPlayerName = args[1];
        if (targetPlayerName.equals("@a")) {
            Bukkit.getOnlinePlayers().forEach(player -> change(player, doppelgangerPlayerName));
        } else {
            UUID targetUUID = CommandUtil.getTargetUUID(targetPlayerName);
            if (targetUUID == null) {
                return false;
            }
            change(targetUUID, doppelgangerPlayerName);
        }
        return true;
    }

    private void change(@NotNull Player player, @NotNull String doppelgangerPlayerName) {
        change(player.getUniqueId(), doppelgangerPlayerName);
    }

    private void change(@NotNull UUID uuid, @NotNull String doppelgangerPlayerName) {
        NickNamerAPI.getNickManager().setSkin(uuid, doppelgangerPlayerName);
        NickNamerAPI.getNickManager().setNick(uuid, doppelgangerPlayerName);
    }
}