package me.swipez.chunkminer.commands;

import me.swipez.chunkminer.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GivePicksCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            p.getInventory().addItem(ItemManager.SCpick);
            p.getInventory().addItem(ItemManager.SDCpick);
            p.getInventory().addItem(ItemManager.SPSCpick);
            p.getInventory().addItem(ItemManager.SDSPSpick);
        }
        return true;
    }
}
