package me.swipez.chunkminer.items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import me.swipez.chunkminer.ChunkMiner;
import me.swipez.chunkminer.utils.ItemBuilder;

public final class ItemManager {

    // Super
    public static final ItemStack SUPER_COBBLESTONE = ItemBuilder.of(Material.COBBLESTONE)
            .name(ChatColor.DARK_AQUA + "Super Cobblestone")
            .lore(ChatColor.WHITE + "Requires a " + ChatColor.DARK_AQUA + "Wooden Pickaxe " + ChatColor.WHITE + "to craft a special tool!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack SUPER_PICKAXE = ItemBuilder.of(Material.WOODEN_PICKAXE)
            .name(ChatColor.DARK_AQUA + "Ultimate Wooden Pickaxe")
            .lore(ChatColor.GRAY + "Chunk I")
            .enchantment(Enchantment.DURABILITY, 5)
            .unbreakable()
            .build();

    // Super duper
    public static final ItemStack SUPER_DUPER_COBBLESTONE = ItemBuilder.of(Material.COBBLESTONE)
            .name(ChatColor.YELLOW + "Super Duper Cobblestone")
            .lore(ChatColor.WHITE + "Requires a " + ChatColor.YELLOW + "Stone Pickaxe " + ChatColor.WHITE + "to craft a special tool!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack SUPER_DUPER_PICKAXE = ItemBuilder.of(Material.STONE_PICKAXE)
            .name(ChatColor.YELLOW + "Ultimate Stone Pickaxe")
            .lore(ChatColor.GRAY + "Chunk II")
            .enchantment(Enchantment.DURABILITY, 5)
            .unbreakable()
            .build();

    // Super pooper scooper
    public static final ItemStack SUPER_POOPER_SCOOPER_COBBLESTONE = ItemBuilder.of(Material.COBBLESTONE)
            .name(ChatColor.RED.toString() + ChatColor.BOLD + "Super Pooper Scooper Cobblestone")
            .lore(ChatColor.WHITE + "Requires a " + ChatColor.RED + ChatColor.BOLD + "Iron Pickaxe " + ChatColor.WHITE + "to craft a special tool!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack SUPER_POOPER_SCOOPER_PICKAXE = ItemBuilder.of(Material.IRON_PICKAXE)
            .name(ChatColor.YELLOW + "Ultimate Iron Pickaxe")
            .lore(ChatColor.GRAY + "Chunk III")
            .enchantment(Enchantment.DURABILITY, 5)
            .unbreakable()
            .build();

    // Super duper super pooper
    public static final ItemStack SUPER_DUPER_SUPER_POOPER_SCOOPER_COBBLESTONE = ItemBuilder.of(Material.COBBLESTONE)
            .name(ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "Super Duper Super Pooper Scooper Cobblestone")
            .lore(ChatColor.WHITE + "Requires a " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Diamond Pickaxe " + ChatColor.WHITE + "to craft a special tool!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack SUPER_DUPER_SUPER_POOPER_SCOOPER_PICKAXE = ItemBuilder.of(Material.DIAMOND_PICKAXE)
            .name(ChatColor.YELLOW + "Ultimate Diamond Pickaxe")
            .lore(ChatColor.GRAY + "Chunk IV")
            .enchantment(Enchantment.DURABILITY, 5)
            .unbreakable()
            .build();

    private ItemManager() { }

    public static void initRecipes(ChunkMiner plugin) {
        registerCobblestoneRecipe(plugin, "super_cobblestone", SUPER_COBBLESTONE, new ItemStack(Material.COBBLESTONE));
        registerCobblestoneRecipe(plugin, "super_duper_cobblestone", SUPER_DUPER_COBBLESTONE, SUPER_COBBLESTONE);
        registerCobblestoneRecipe(plugin, "super_pooper_scooper_cobblestone", SUPER_POOPER_SCOOPER_COBBLESTONE, SUPER_DUPER_COBBLESTONE);
        registerCobblestoneRecipe(plugin, "super_duper_super_pooper_scooper_cobblestone", SUPER_DUPER_SUPER_POOPER_SCOOPER_COBBLESTONE, SUPER_POOPER_SCOOPER_COBBLESTONE);

        registerPickaxeRecipe(plugin, "super_cobblestone_pickaxe", SUPER_PICKAXE, SUPER_COBBLESTONE, Material.WOODEN_PICKAXE);
        registerPickaxeRecipe(plugin, "super_duper_cobblestone_pickaxe", SUPER_DUPER_PICKAXE, SUPER_DUPER_COBBLESTONE, Material.STONE_PICKAXE);
        registerPickaxeRecipe(plugin, "super_pooper_scooper_cobblestone_pickaxe", SUPER_POOPER_SCOOPER_PICKAXE, SUPER_POOPER_SCOOPER_COBBLESTONE, Material.IRON_PICKAXE);
        registerPickaxeRecipe(plugin, "super_duper_super_pooper_scooper_cobblestone_pickaxe", SUPER_DUPER_SUPER_POOPER_SCOOPER_PICKAXE, SUPER_DUPER_SUPER_POOPER_SCOOPER_COBBLESTONE, Material.DIAMOND_PICKAXE);
    }

    @SuppressWarnings("deprecation") // We can ignore the deprecation on ExactChoice. Draft API does not apply here
    private static void registerCobblestoneRecipe(ChunkMiner plugin, String id, ItemStack cobblestoneResult, ItemStack cobblestoneIngredient) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, id), cobblestoneResult)
                .shape("CCC", "CCC", "CCC")
                .setIngredient('C', new RecipeChoice.ExactChoice(cobblestoneIngredient));
        Bukkit.addRecipe(recipe);
    }

    @SuppressWarnings("deprecation") // We can ignore the deprecation on ExactChoice. Draft API does not apply here
    private static void registerPickaxeRecipe(ChunkMiner plugin, String id, ItemStack pickaxeResult, ItemStack cobblestoneIngredient, Material pickaxeIngredient) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, id), pickaxeResult)
                .shape("CCC", "CPC", "CCC")
                .setIngredient('C', new RecipeChoice.ExactChoice(cobblestoneIngredient))
                .setIngredient('P', pickaxeIngredient);
        Bukkit.addRecipe(recipe);
    }

}
