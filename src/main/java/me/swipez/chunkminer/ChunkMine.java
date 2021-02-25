package me.swipez.chunkminer;

import me.swipez.chunkminer.items.ItemManager;
import me.swipez.chunkminer.utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class ChunkMine implements Listener {

    private static final Set<Material> IGNORED_BLOCKS = EnumSet.of(
        Material.BEDROCK,
        Material.LAVA,
        Material.WATER,
        Material.AIR
    );

    @EventHandler
    private void onPlayerMine(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE) {
            return;
        }

        int blocksUp = 0;
        int blocksOut = 0;
        int blocksAcross = 0;

        ItemStack handItem = p.getInventory().getItemInMainHand();
        if (ItemManager.SUPER_PICKAXE.isSimilar(handItem)) {
            blocksUp = 2;
            blocksOut = 2;
            blocksAcross = 3;
        }
        else if (ItemManager.SUPER_DUPER_PICKAXE.isSimilar(handItem)) {
            blocksUp = 5;
            blocksOut = 5;
            blocksAcross = 9;
        }
        else if (ItemManager.SUPER_POOPER_SCOOPER_PICKAXE.isSimilar(handItem)) {
            blocksUp = 7;
            blocksOut = 13;
            blocksAcross = 17;
        }
        else if (ItemManager.SUPER_DUPER_SUPER_POOPER_SCOOPER_PICKAXE.isSimilar(handItem)) {
            blocksUp = 100;
            blocksOut = 13;
            blocksAcross = 13;
        }

        List<Block> area = getBlocks(e, blocksUp, blocksOut, blocksAcross);
        if (area.size() <= 1) {
            return;
        }

        for (Block b : area) {
            if (!IGNORED_BLOCKS.contains(b.getType())) {
                b.breakNaturally();
            }
        }
    }

    public List<Block> getBlocks(BlockBreakEvent e, int blocksUp, int blocksOut, int blocksAcross) {
        int minedX = 0, minedY = 0, minedZ = 0;
        String direction = Utils.getDirection(e.getPlayer().getLocation().getYaw());
        String upordown = Utils.getUpOrDown(e.getPlayer().getLocation().getPitch());

        Block block = e.getBlock();
        List<Block> area = new ArrayList<>();

        if (upordown.equals("DOWN")){
            minedX = block.getX() - blocksAcross /2;
            minedY = block.getY() - blocksUp;
            minedZ = block.getZ() - blocksAcross / 2;
        }
        else if (e.getPlayer().getFacing().equals(BlockFace.EAST)) {
            minedX = block.getX();
            minedY = block.getY();
            minedZ = block.getZ() - (blocksAcross / 2);
        }
        else if (e.getPlayer().getFacing().equals(BlockFace.SOUTH)) {
            minedX = block.getX() - blocksAcross / 2;
            minedY = block.getY();
            minedZ = block.getZ();
        }
        else if (e.getPlayer().getFacing().equals(BlockFace.WEST)) {
            minedX = block.getX() - blocksOut;
            minedY = block.getY();
            minedZ = block.getZ() - blocksAcross / 2;
        }
        else if (e.getPlayer().getFacing().equals(BlockFace.NORTH)) {
            minedX = block.getX() - blocksAcross / 2;
            minedY = block.getY();
            minedZ = block.getZ() - blocksOut;
        }

        for (int x = 0; x <= blocksAcross; x++) {
            for (int y = 0; y <= blocksUp && minedY + y <= 256; y++) {
                for (int z = 0; z <= blocksOut; z++) {
                    Block b = block.getWorld().getBlockAt(minedX + x, minedY + y, minedZ + z);
                    area.add(b);
                }
            }
        }

        return area;
    }

}
