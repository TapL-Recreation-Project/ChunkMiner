package me.swipez.chunkminer.commands;

import me.swipez.chunkminer.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class GivePicksCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players may run this command.");
            return true;
        }

        PlayerInventory inventory = ((Player) sender).getInventory();
        inventory.addItem(ItemManager.SUPER_PICKAXE);
        inventory.addItem(ItemManager.SUPER_DUPER_PICKAXE);
        inventory.addItem(ItemManager.SUPER_POOPER_SCOOPER_PICKAXE);
        inventory.addItem(ItemManager.SUPER_DUPER_SUPER_POOPER_SCOOPER_PICKAXE);

        return true;
    }
}
