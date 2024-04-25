package mineralcontest.mineralcontest0.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class createTeamsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (command.getName().equalsIgnoreCase("setup-teams")) {

            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;

                Inventory inventory = Bukkit.createInventory(player, 9, ChatColor.BOLD + "" + ChatColor.DARK_GRAY + "Choose your team");


                //RED TEAM
                ItemStack redWoolItem = new ItemStack(Material.RED_WOOL);
                ItemMeta redWoolItemMeta = redWoolItem.getItemMeta();
                redWoolItemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.RED + "[RED]" + ChatColor.RESET + " Team");
                redWoolItem.setItemMeta(redWoolItemMeta);
                inventory.setItem(0, redWoolItem);



                //BLUE TEAM
                ItemStack blueWoolItem = new ItemStack(Material.BLUE_WOOL);
                ItemMeta blueWoolItemMeta = blueWoolItem.getItemMeta();
                blueWoolItemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.BLUE + "[BLUE]" + ChatColor.RESET + " Team");
                blueWoolItem.setItemMeta(blueWoolItemMeta);
                inventory.setItem(1, blueWoolItem);



                //YELLOW TEAM
                ItemStack yellowWoolItem = new ItemStack(Material.YELLOW_WOOL);
                ItemMeta yellowWoolItemMeta = yellowWoolItem.getItemMeta();
                yellowWoolItemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.YELLOW + "[YELLOW]" + ChatColor.RESET + " Team");
                yellowWoolItem.setItemMeta(yellowWoolItemMeta);
                inventory.setItem(2, yellowWoolItem);



                //PURPLE TEAM
                ItemStack purpleWoolItem = new ItemStack(Material.PURPLE_WOOL);
                ItemMeta purpleWoolItemMeta = purpleWoolItem.getItemMeta();
                purpleWoolItemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "[PURPLE]" + ChatColor.RESET + " Team");
                purpleWoolItem.setItemMeta(purpleWoolItemMeta);
                inventory.setItem(3, purpleWoolItem);



                player.openInventory(inventory);

            }

        }


        return true;
    }
}
