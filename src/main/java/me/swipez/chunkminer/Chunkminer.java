package me.swipez.chunkminer;

import me.swipez.chunkminer.commands.GivePicksCommand;
import me.swipez.chunkminer.items.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.swipez.chunkminer.bstats.Metrics;

public final class Chunkminer extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ChunkMine(), this);
        ItemManager.init();
        getServer().getPluginManager().registerEvents(new CraftingListener(), this);
        new Metrics(this, 10433);
        getCommand("giveallpicks").setExecutor(new GivePicksCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
