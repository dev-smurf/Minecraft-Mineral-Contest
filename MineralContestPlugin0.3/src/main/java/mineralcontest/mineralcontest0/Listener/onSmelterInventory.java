package mineralcontest.mineralcontest0.Listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class onSmelterInventory implements Listener {

    @EventHandler
    public void onSmelterInventory(InventoryClickEvent event) {


        ItemStack barrier = new ItemStack(Material.BARRIER, 1);


        if (event.getCurrentItem().getType() == Material.BARRIER && event.getWhoClicked().getGameMode() == GameMode.SURVIVAL) {
            event.setCancelled(true);
        }

    }
}
