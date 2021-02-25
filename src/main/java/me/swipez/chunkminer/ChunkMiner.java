package me.swipez.chunkminer;

import me.swipez.chunkminer.commands.GivePicksCommand;
import me.swipez.chunkminer.items.ItemManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import me.swipez.chunkminer.bstats.Metrics;

public final class ChunkMiner extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemManager.initRecipes(this);
        getServer().getPluginManager().registerEvents(new ChunkMine(), this);

        // Metrics
        new Metrics(this, 10433);

        // Commands
        registerCommandSafely("giveallpicks", new GivePicksCommand());
    }

    private void registerCommandSafely(String commandString, CommandExecutor executor) {
        PluginCommand command = getCommand(commandString);
        if (command == null) {
            return;
        }

        command.setExecutor(executor);

        if (executor instanceof TabCompleter) {
            command.setTabCompleter((TabCompleter) executor);
        }
    }

}
