package neocraft.doppelganger.command;

import neocraft.doppelganger.util.NickNamerUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SwapCommand implements CommandExecutor {
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

        NickNamerUtil.change(targetPlayerName, doppelgangerPlayerName);
        NickNamerUtil.change(doppelgangerPlayerName, targetPlayerName);
        return true;
    }
}