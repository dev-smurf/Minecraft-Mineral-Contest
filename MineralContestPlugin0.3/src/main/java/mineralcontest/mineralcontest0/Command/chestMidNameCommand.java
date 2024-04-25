package mineralcontest.mineralcontest0.Command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class chestMidNameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (command.getName().equalsIgnoreCase("chest-mid")) {

            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;

                ItemStack itemScoreChest = new ItemStack(Material.CHEST, 1);
                Inventory inventory = player.getInventory();

                ItemMeta chestMetaItem = itemScoreChest.getItemMeta();
                chestMetaItem.setDisplayName("Mid Chest");
                itemScoreChest.setItemMeta(chestMetaItem);

                inventory.setItem(8, itemScoreChest);

            }
        }
        return true;
    }
}
