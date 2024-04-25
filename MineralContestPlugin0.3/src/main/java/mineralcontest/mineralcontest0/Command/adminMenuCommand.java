package mineralcontest.mineralcontest0.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class adminMenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (command.getName().equalsIgnoreCase("admin")) {

            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;

                Inventory adminMenu = Bukkit.createInventory(player, 9, ChatColor.RED + "Admin Menu" + ChatColor.RESET);

                //Vanish Admin Command
                ItemStack itemFeather = new ItemStack(Material.FEATHER, 1);
                ItemMeta itemMetaFeather = itemFeather.getItemMeta();
                itemMetaFeather.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Vanish" + ChatColor.RESET);

                ArrayList<String> loreAgile = new ArrayList<>();
                loreAgile.add("");
                loreAgile.add(ChatColor.GRAY + "Become vanish or visible to other player" + ChatColor.RESET);
                itemMetaFeather.setLore(loreAgile);

                itemFeather.setItemMeta(itemMetaFeather);
                adminMenu.setItem(0, itemFeather);


                player.openInventory(adminMenu);
            }
        }

        return true;
    }
}
