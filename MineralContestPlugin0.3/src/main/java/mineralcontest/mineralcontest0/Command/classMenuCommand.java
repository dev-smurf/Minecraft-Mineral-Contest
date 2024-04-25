package mineralcontest.mineralcontest0.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class classMenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (command.getName().equalsIgnoreCase("class")) {

            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;

                Inventory inventory = Bukkit.createInventory(player, 9, ChatColor.DARK_GRAY + "Choose your class" + ChatColor.RESET);

                //Feather Item Inventory (Agile)
                ItemStack itemFeather = new ItemStack(Material.FEATHER, 1);
                ItemMeta itemMetaFeather = itemFeather.getItemMeta();
                itemMetaFeather.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Agile" + ChatColor.RESET);

                ArrayList<String> loreAgile = new ArrayList<>();
                loreAgile.add("");
                loreAgile.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Strength:" + ChatColor.RESET);
                loreAgile.add(ChatColor.GRAY + "You move with 20% increased speed," + ChatColor.RESET);
                loreAgile.add(ChatColor.GRAY + "and you take no fall damage." + ChatColor.RESET);
                itemMetaFeather.setLore(loreAgile);

                itemFeather.setItemMeta(itemMetaFeather);
                inventory.setItem(0, itemFeather);

                //===========================================================//

                //Diamond Hoe Item Inventory (Worker)
                ItemStack itemDiamondHoe = new ItemStack(Material.DIAMOND_HOE, 1);
                ItemMeta itemMetaDiamondHoe = itemDiamondHoe.getItemMeta();
                itemMetaDiamondHoe.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Worker" + ChatColor.RESET);
                itemMetaDiamondHoe.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

                ArrayList<String> loreWorker = new ArrayList<>();
                loreWorker.add("");
                loreWorker.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Strength:" + ChatColor.RESET);
                loreWorker.add(ChatColor.GRAY + "You increase your team's points earned by 25%." + ChatColor.RESET);
                loreWorker.add(ChatColor.RED + "" + ChatColor.BOLD + "Weakness:" + ChatColor.RESET);
                loreWorker.add(ChatColor.GRAY + "You only have 5 " + ChatColor.RED + "❤" + ChatColor.GRAY + "." + ChatColor.RESET);
                itemMetaDiamondHoe.setLore(loreWorker);

                itemDiamondHoe.setItemMeta(itemMetaDiamondHoe);
                inventory.setItem(1, itemDiamondHoe);

                //===========================================================//

                //Diamond Chestplate Item Inventory (Robust)
                ItemStack itemDiamondChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
                ItemMeta itemMetaDiamondChestplate = itemDiamondChestplate.getItemMeta();
                itemMetaDiamondChestplate.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Robust" + ChatColor.RESET);
                itemMetaDiamondChestplate.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
                itemMetaDiamondChestplate.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);

                ArrayList<String> loreRobust = new ArrayList<>();
                loreRobust.add("");
                loreRobust.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Strength:" + ChatColor.RESET);
                loreRobust.add(ChatColor.GRAY + "You have 15 " + ChatColor.RED + "❤" + ChatColor.GRAY + " and take 15% less damage." + ChatColor.RESET);
                loreRobust.add(ChatColor.RED + "" + ChatColor.BOLD + "Weakness:" + ChatColor.RESET);
                loreRobust.add(ChatColor.GRAY + "Your speed is reduced by 40%." + ChatColor.RESET);
                itemMetaDiamondChestplate.setLore(loreRobust);

                itemDiamondChestplate.setItemMeta(itemMetaDiamondChestplate);
                inventory.setItem(2, itemDiamondChestplate);

                //===========================================================//

                //Diamond Sword Item Inventory (Warrior)
                ItemStack itemDiamondSword = new ItemStack(Material.DIAMOND_SWORD, 1);
                ItemMeta itemMetaDiamondSword = itemDiamondSword.getItemMeta();
                itemMetaDiamondSword.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                itemMetaDiamondSword.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Warrior" + ChatColor.RESET);

                ArrayList<String> loreWarrior = new ArrayList<>();
                loreWarrior.add("");
                loreWarrior.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Strength:" + ChatColor.RESET);
                loreWarrior.add(ChatColor.GRAY + "You deal 25% additional damage." + ChatColor.RESET);
                loreWarrior.add(ChatColor.RED + "" + ChatColor.BOLD + "Weakness:" + ChatColor.RESET);
                loreWarrior.add(ChatColor.GRAY + "You only have 7 " + ChatColor.RED + "❤" + ChatColor.GRAY + "." + ChatColor.RESET);
                itemMetaDiamondSword.setLore(loreWarrior);

                itemDiamondSword.setItemMeta(itemMetaDiamondSword);
                inventory.setItem(3, itemDiamondSword);

                //===========================================================//

                //Furnace Item Inventory (Smelter)
                ItemStack itemFurnace = new ItemStack(Material.FURNACE, 1);
                ItemMeta itemMetaFurnace = itemFurnace.getItemMeta();
                itemMetaFurnace.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                itemMetaFurnace.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Smelter" + ChatColor.RESET);

                ArrayList<String> loreSmelter = new ArrayList<>();
                loreSmelter.add("");
                loreSmelter.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Strength:" + ChatColor.RESET);
                loreSmelter.add(ChatColor.GRAY + "When you mine, the ores are already smelted." + ChatColor.RESET);
                loreSmelter.add(ChatColor.RED + "" + ChatColor.BOLD + "Weakness:" + ChatColor.RESET);
                loreSmelter.add(ChatColor.GRAY + "You will have 9 less inventory slot." + ChatColor.RESET);
                itemMetaFurnace.setLore(loreSmelter);

                itemFurnace.setItemMeta(itemMetaFurnace);
                inventory.setItem(4, itemFurnace);

                //===========================================================//

                //Diamond Pickaxe Item Inventory (Miner)
                ItemStack itemDiamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                ItemMeta itemMetaDiamondPickaxe = itemDiamondPickaxe.getItemMeta();
                itemMetaDiamondPickaxe.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                itemMetaDiamondPickaxe.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Miner" + ChatColor.RESET);

                ArrayList<String> loreMiner = new ArrayList<>();
                loreMiner.add("");
                loreMiner.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Strength:" + ChatColor.RESET);
                loreMiner.add(ChatColor.GRAY + "You mine 20% faster.");
                loreMiner.add(ChatColor.RED + "" + ChatColor.BOLD + "Weakness:" + ChatColor.RESET);

                loreMiner.add(ChatColor.GRAY + "You are limited in the amount of ore you can carry:" + ChatColor.RESET);
                loreMiner.add(ChatColor.GRAY + "- 64 " + ChatColor.DARK_RED + "Redstone" + ChatColor.RESET);
                loreMiner.add(ChatColor.GRAY + "- 48 " + ChatColor.DARK_GRAY + "Iron" + ChatColor.RESET);
                loreMiner.add(ChatColor.GRAY + "- 24 " + ChatColor.GOLD + "Gold" + ChatColor.RESET);
                loreMiner.add(ChatColor.GRAY + "- 8 " + ChatColor.DARK_BLUE + "Diamonds" + ChatColor.RESET);
                loreMiner.add(ChatColor.GRAY + "- 4 " + ChatColor.DARK_GREEN + "Emeralds" + ChatColor.RESET);
                itemMetaDiamondPickaxe.setLore(loreMiner);

                itemDiamondPickaxe.setItemMeta(itemMetaDiamondPickaxe);
                inventory.setItem(5, itemDiamondPickaxe);

                //===========================================================//

                //Gold Ingot Item Inventory (SCAMMER)
                ItemStack itemGoldIngot = new ItemStack(Material.GOLD_INGOT, 1);
                ItemMeta itemMetaGoldIngot = itemGoldIngot.getItemMeta();
                itemMetaGoldIngot.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                itemMetaGoldIngot.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Scammer" + ChatColor.RESET);

                ArrayList<String> loreScammer = new ArrayList<>();
                loreScammer.add("");
                loreScammer.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Strength:" + ChatColor.RESET);
                loreScammer.add(ChatColor.GRAY + "Each redstone you place in your chest deducts 2 points from each team." + ChatColor.RESET);
                loreScammer.add(ChatColor.RED + "" + ChatColor.BOLD + "Weakness:" + ChatColor.RESET);
                loreScammer.add(ChatColor.GRAY + "???" + ChatColor.RESET);
                itemMetaGoldIngot.setLore(loreScammer);

                itemGoldIngot.setItemMeta(itemMetaGoldIngot);
                inventory.setItem(6, itemGoldIngot);

                //===========================================================//

                //Golden Apple Item Inventory (Thief)
                ItemStack itemGoldenApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
                ItemMeta itemMetaGoldenApple = itemGoldenApple.getItemMeta();
                itemMetaGoldenApple.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Thief" + ChatColor.RESET);

                ArrayList<String> loreThief = new ArrayList<>();
                loreThief.add("");
                loreThief.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Strength:" + ChatColor.RESET);
                loreThief.add(ChatColor.GRAY + "After killing an opponent, you will regain 50% of your health." + ChatColor.RESET);
                loreThief.add(ChatColor.RED + "" + ChatColor.BOLD + "Weakness:" + ChatColor.RESET);
                loreThief.add(ChatColor.GRAY + "After your kill, for 10 seconds, your speed will be reduced by 50%." + ChatColor.RESET);
                itemMetaGoldenApple.setLore(loreThief);

                itemGoldenApple.setItemMeta(itemMetaGoldenApple);
                inventory.setItem(7, itemGoldenApple);

                //Open the ClassMenu after the command input
                player.openInventory(inventory);

            }


        }

        return true;
    }

}