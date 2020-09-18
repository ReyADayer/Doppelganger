package neocraft.doppelganger;

import neocraft.doppelganger.command.ChangeCommand;
import neocraft.doppelganger.command.ClearCommand;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Doppelganger extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginCommand changeCommand = getCommand("dchange");
        if (changeCommand != null) {
            changeCommand.setExecutor(new ChangeCommand());
        }
        PluginCommand clearCommand = getCommand("dclear");
        if (clearCommand != null) {
            clearCommand.setExecutor(new ClearCommand());
        }
    }

    @Override
    public void onDisable() {
    }
}
