package mineralcontest.mineralcontest0.Listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class onRightClickSilkTouch implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (event.getAction().toString().contains("RIGHT_CLICK") && isPickaxe(item)) {
            if (!item.getEnchantments().containsKey(Enchantment.SILK_TOUCH)) {

                item.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
            } else {

                item.removeEnchantment(Enchantment.SILK_TOUCH);
            }
        }
    }

    private boolean isPickaxe(ItemStack item) {
        Material itemType = item.getType();
        return itemType == Material.WOODEN_PICKAXE ||
                itemType == Material.STONE_PICKAXE ||
                itemType == Material.IRON_PICKAXE ||
                itemType == Material.GOLDEN_PICKAXE ||
                itemType == Material.DIAMOND_PICKAXE ||
                itemType == Material.NETHERITE_PICKAXE;
    }
}