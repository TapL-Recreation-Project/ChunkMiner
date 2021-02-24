package me.swipez.chunkminer;

import me.swipez.chunkminer.items.ItemManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingListener implements Listener {
    @EventHandler
    public void onPlayerCraftsItem(PrepareItemCraftEvent e) {
        ItemStack vanillacobble = new ItemStack(Material.COBBLESTONE);

        int scobblecount = 0;
        int sdcobblecount = 0;
        int sdpcobblecount = 0;
        int sdpscobblecount = 0;
        int pickcount = 0;
        int pickcountstone = 0;
        int pickcountiron = 0;
        int pickcountdiamond = 0;
        int cobblecount = 0;
        if ( e.getInventory().getItem(0) != null && ((e.getInventory().getItem(0).getItemMeta().getDisplayName()).toLowerCase().contains("ultimate") || (e.getInventory().getItem(0).getItemMeta().getDisplayName()).toLowerCase().contains("super"))){
            if (e.getInventory().contains(ItemManager.SCobble) || e.getInventory().contains(ItemManager.SDCobble) || e.getInventory().contains(ItemManager.SPSCobble) || e.getInventory().contains(Material.COBBLESTONE)) {
                for (int i = 0; i < 10; i++) {
                    if (e.getInventory().getItem(i) != null) {
                        if (e.getInventory().getItem(i).isSimilar(ItemManager.SCobble)) {
                            scobblecount++;
                        }
                        if (e.getInventory().getItem(i).isSimilar(ItemManager.SDCobble)) {
                            sdcobblecount++;
                        }
                        if (e.getInventory().getItem(i).isSimilar(ItemManager.SPSCobble)) {
                            sdpcobblecount++;
                        }
                        if (e.getInventory().getItem(i).isSimilar(ItemManager.SDSPSCobble)) {
                            sdpscobblecount++;
                        }
                        if (e.getInventory().getItem(i).getType() == Material.WOODEN_PICKAXE) {
                            pickcount++;
                        }
                        if (e.getInventory().getItem(i).getType() == Material.IRON_PICKAXE) {
                            pickcountiron++;
                        }
                        if (e.getInventory().getItem(i).getType() == Material.STONE_PICKAXE) {
                            pickcountstone++;
                        }
                        if (e.getInventory().getItem(i).getType() == Material.DIAMOND_PICKAXE) {
                            pickcountdiamond++;
                        }
                        if (e.getInventory().getItem(i).isSimilar(vanillacobble)) {
                            cobblecount++;
                        }
                    }
                }
                if (cobblecount >=9){
                    e.getInventory().setResult(ItemManager.SCobble);
                }
                else if (scobblecount >= 9) {
                    e.getInventory().setResult(ItemManager.SDCobble);
                }
                else if (sdcobblecount == 9) {
                    e.getInventory().setResult(ItemManager.SPSCobble);
                }
                else if (sdpcobblecount == 9) {
                    e.getInventory().setResult(ItemManager.SDSPSCobble);
                }
                else if (sdpscobblecount >= 8 && pickcountdiamond >= 1) {
                    e.getInventory().setResult(ItemManager.SDSPSpick);
                }
                else if (scobblecount >= 8 && pickcount >= 1) {
                    e.getInventory().setResult(ItemManager.SCpick);
                }
                else if (sdcobblecount >= 8 && pickcountstone >= 1) {
                    e.getInventory().setResult(ItemManager.SDCpick);
                }
                else if (sdpcobblecount >= 8 && pickcountiron >= 1) {
                    e.getInventory().setResult(ItemManager.SPSCpick);
                }
                else {
                    e.getInventory().setResult(null);
                }
            }
        }
    }
}

