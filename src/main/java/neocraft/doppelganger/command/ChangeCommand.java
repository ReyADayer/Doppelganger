package neocraft.doppelganger.command;

import neocraft.doppelganger.util.NickNamerUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

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
            Bukkit.getOnlinePlayers().forEach(player -> NickNamerUtil.change(player, doppelgangerPlayerName));
        } else {
            NickNamerUtil.change(targetPlayerName, doppelgangerPlayerName);
        }
        return true;
    }
}