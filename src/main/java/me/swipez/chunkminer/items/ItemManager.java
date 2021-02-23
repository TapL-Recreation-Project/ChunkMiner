package me.swipez.chunkminer.items;

import me.swipez.chunkminer.Chunkminer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack SCobble;
    public static ItemStack SCpick;
    public static ItemStack SDCobble;
    public static ItemStack SDCpick;
    public static ItemStack SPSCobble;
    public static ItemStack SPSCpick;
    public static ItemStack SDSPSCobble;
    public static ItemStack SDSPSpick;

    Chunkminer plugin;

    public ItemManager(Chunkminer plugin) {
        this.plugin = plugin;
    }

    public static void init(){
        createSCobble();
        createSCPick();
        createSDCobble();
        createSDCPick();
        createSPSCobble();
        createSPSCPick();
        createSDSPSCobble();
        createSDSPSPick();
    }

    private static void createSCobble(){
        ItemStack scobble = new ItemStack(Material.COBBLESTONE, 1);
        ItemMeta meta = scobble.getItemMeta();
        meta.addEnchant(Enchantment.CHANNELING, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();
        lore.add("§fRequires a §3Wooden Pickaxe §fto craft a special tool!");
        meta.setLore(lore);
        meta.setDisplayName("§3Super Cobblestone");
        scobble.setItemMeta(meta);
        SCobble = scobble;

        ItemStack item = ItemManager.SCobble;
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("scobble"), item);
        recipe.shape("CCC", "CCC", "CCC");
        recipe.setIngredient('C', Material.COBBLESTONE);

        Bukkit.addRecipe(recipe);
    }
    private static void createSCPick(){
        ItemStack scpick = new ItemStack(Material.WOODEN_PICKAXE, 1);
        ItemMeta meta = scpick.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        List<String> lore = new ArrayList<>();
        lore.add("§7Chunk I");
        meta.setLore(lore);
        meta.setDisplayName("§3Ultimate Wooden Pickaxe");
        meta.setUnbreakable(true);
        scpick.setItemMeta(meta);
        SCpick = scpick;

        ItemStack item = SCpick;
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("scpick"), item);
        recipe.shape("CCC", "CPC", "CCC");
        recipe.setIngredient('C', Material.COBBLESTONE);
        recipe.setIngredient('P', Material.WOODEN_PICKAXE);

        Bukkit.addRecipe(recipe);
    }
    private static void createSDCobble(){
        ItemStack sdcobble = new ItemStack(Material.COBBLESTONE, 1);
        ItemMeta meta = sdcobble.getItemMeta();
        meta.addEnchant(Enchantment.CHANNELING, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();
        lore.add("§fRequires a §eStone Pickaxe §fto craft a special tool!");
        meta.setLore(lore);
        meta.setDisplayName("§eSuper Duper Cobblestone");
        sdcobble.setItemMeta(meta);
        SDCobble = sdcobble;
    }
    private static void createSDCPick(){
        ItemStack sdcpick = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta meta = sdcpick.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        List<String> lore = new ArrayList<>();
        lore.add("§7Chunk II");
        meta.setLore(lore);
        meta.setDisplayName("§eUltimate Stone Pickaxe");
        meta.setUnbreakable(true);
        sdcpick.setItemMeta(meta);
        SDCpick = sdcpick;

        ItemStack item = SDCpick;
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("sdcpick"), item);
        recipe.shape("CCC", "CPC", "CCC");
        recipe.setIngredient('C', Material.COBBLESTONE);
        recipe.setIngredient('P', Material.STONE_PICKAXE);

        Bukkit.addRecipe(recipe);
    }
    private static void createSPSCobble(){
        ItemStack spscobble = new ItemStack(Material.COBBLESTONE, 1);
        ItemMeta meta = spscobble.getItemMeta();
        meta.addEnchant(Enchantment.CHANNELING, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();
        lore.add("§fRequires a §l§4Iron Pickaxe §r§fto craft a special tool!");
        meta.setLore(lore);
        meta.setDisplayName("§l§4Super Pooper Scooper Cobblestone");
        spscobble.setItemMeta(meta);
        SPSCobble = spscobble;
    }
    private static void createSPSCPick(){
        ItemStack spscpick = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta meta = spscpick.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        List<String> lore = new ArrayList<>();
        lore.add("§7Chunk III");
        meta.setLore(lore);
        meta.setDisplayName("§eUltimate Iron Pickaxe");
        meta.setUnbreakable(true);
        spscpick.setItemMeta(meta);
        SPSCpick = spscpick;

        ItemStack item = SPSCpick;
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("spscpick"), item);
        recipe.shape("CCC", "CPC", "CCC");
        recipe.setIngredient('C', Material.COBBLESTONE);
        recipe.setIngredient('P', Material.IRON_PICKAXE);

        Bukkit.addRecipe(recipe);
    }
    private static void createSDSPSCobble(){
        ItemStack sdspscobble = new ItemStack(Material.COBBLESTONE, 1);
        ItemMeta meta = sdspscobble.getItemMeta();
        meta.addEnchant(Enchantment.CHANNELING, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();
        lore.add("§fRequires a §l§5Diamond Pickaxe §r§fto craft a special tool!");
        meta.setLore(lore);
        meta.setDisplayName("§l§5Super Duper Super Pooper Scooper Cobblestone");
        meta.setUnbreakable(true);
        sdspscobble.setItemMeta(meta);
        SDSPSCobble = sdspscobble;
    }
    private static void createSDSPSPick(){
        ItemStack sdspspick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = sdspspick.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        List<String> lore = new ArrayList<>();
        lore.add("§7Chunk IV");
        meta.setLore(lore);
        meta.setDisplayName("§eUltimate Diamond Pickaxe");
        meta.setUnbreakable(true);
        sdspspick.setItemMeta(meta);
        SDSPSpick = sdspspick;

        ItemStack item = SDSPSpick;
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("sdspcpick"), item);
        recipe.shape("CCC", "CPC", "CCC");
        recipe.setIngredient('C', Material.COBBLESTONE);
        recipe.setIngredient('P', Material.DIAMOND_PICKAXE);

        Bukkit.addRecipe(recipe);
    }
}
