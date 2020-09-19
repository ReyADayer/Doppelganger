package neocraft.doppelganger;

import neocraft.doppelganger.command.ChangeCommand;
import neocraft.doppelganger.command.ClearCommand;
import neocraft.doppelganger.command.SwapCommand;
import neocraft.doppelganger.listener.NameListener;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Doppelganger extends JavaPlugin {

    @Override
    public void onEnable() {
        initCommand("dchange", new ChangeCommand());
        initCommand("dclear", new ClearCommand());
        initCommand("dswap", new SwapCommand());
        registerListener(new NameListener());
    }

    @Override
    public void onDisable() {
    }

    public void initCommand(String name, CommandExecutor commandExecutor) {
        PluginCommand pluginCommand = getCommand(name);
        if (pluginCommand != null) {
            pluginCommand.setExecutor(commandExecutor);
        }
    }

    public void registerListener(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
