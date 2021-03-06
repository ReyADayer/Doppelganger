package neocraft.doppelganger.command;

import neocraft.doppelganger.util.NickNamerUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

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
            Bukkit.getOnlinePlayers().forEach(NickNamerUtil::clear);
        } else {
            NickNamerUtil.clear(targetPlayerName);
        }
        return true;
    }
}
