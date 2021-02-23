package me.swipez.chunkminer;

import me.swipez.chunkminer.items.ItemManager;
import me.swipez.chunkminer.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ChunkMine implements Listener {


    @EventHandler
    public void onPlayerMine(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE){
            int bup = 0;
            int bout = 0;
            int bacr = 0;

            if (p.getInventory().getItemInMainHand().isSimilar(ItemManager.SCpick)) {
                bup = 2;
                bout = 2;
                bacr = 3;
            }
            if (p.getInventory().getItemInMainHand().isSimilar(ItemManager.SDCpick)) {
                bup = 5;
                bout = 5;
                bacr = 9;
            }
            if (p.getInventory().getItemInMainHand().isSimilar(ItemManager.SPSCpick)) {
                bup = 7;
                bout = 13;
                bacr = 17;
            }
            if (p.getInventory().getItemInMainHand().isSimilar(ItemManager.SDSPSpick)) {
                bup = 100;
                bout = 13;
                bacr = 13;
            }
            List<Block> area = getBlocks(e, bup, bout, bacr);

            for (Block b : area) {
                if (b.getType() != Material.BEDROCK && b.getType() != Material.LAVA && b.getType() != Material.WATER && b.getType() != Material.AIR) {
                    b.breakNaturally();
                }
            }
        }
    }

    public List<Block> getBlocks(BlockBreakEvent e, int blocksUp, int blocksOut, int blocksAcross) {
        int minedX, minedY, minedZ;
        String direction = Utils.getDirection(e.getPlayer().getLocation().getYaw());
        String upordown = Utils.getUpOrDown(e.getPlayer().getLocation().getPitch());
            minedX = 0;
            minedY = 0;
            minedZ = 0;

        List<Block> area = new ArrayList<>();

        if (upordown.equals("DOWN")){
            minedX = e.getBlock().getX() - blocksAcross /2;
            minedY = e.getBlock().getY() - blocksUp;
            minedZ = e.getBlock().getZ() - blocksAcross / 2;

        } else
         if (e.getPlayer().getFacing().equals(BlockFace.EAST)) {
            minedX = e.getBlock().getX();
            minedY = e.getBlock().getY();
            minedZ = e.getBlock().getZ() - (blocksAcross / 2);
        }
        else if (e.getPlayer().getFacing().equals(BlockFace.SOUTH)) {
            minedX = e.getBlock().getX() - blocksAcross / 2;
            minedY = e.getBlock().getY();
            minedZ = e.getBlock().getZ();
        }
        else if (e.getPlayer().getFacing().equals(BlockFace.WEST)) {
            minedX = e.getBlock().getX() - blocksOut;
            minedY = e.getBlock().getY();
            minedZ = e.getBlock().getZ() - blocksAcross / 2;
        }
       else  if (e.getPlayer().getFacing().equals(BlockFace.NORTH)) {
            minedX = e.getBlock().getX() - blocksAcross / 2;
            minedY = e.getBlock().getY();
            minedZ = e.getBlock().getZ() - blocksOut;
        }





        for (int x = 0; x <= blocksAcross; x++) {
            for (int y = 0; y <= blocksUp && minedY + y <= 256; y++) {
                for (int z = 0; z <= blocksOut; z++) {
                    Block b = e.getBlock().getWorld().getBlockAt(minedX + x, minedY + y, minedZ + z);
                    area.add(b);
                }
            }
        }
        return area;
    }

}


