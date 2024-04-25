package mineralcontest.mineralcontest0.Listener;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class onWardenDeath implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntityType() == EntityType.WARDEN) {
            World world = event.getEntity().getWorld();

            world.setTime(12000);

            for (ItemStack drop : event.getDrops()) {

                if (drop.getType() == Material.SCULK_CATALYST) {

                    event.getDrops().remove(drop);
                    break;
                }
            }

            event.getEntity().getWorld().dropItem(event.getEntity().getLocation(), getRandomItemStack(Material.IRON_INGOT, 15, 20, 1.0));
            event.getEntity().getWorld().dropItem(event.getEntity().getLocation(), getRandomItemStack(Material.GOLD_INGOT, 10, 15, 0.8));
            event.getEntity().getWorld().dropItem(event.getEntity().getLocation(), getRandomItemStack(Material.DIAMOND, 3, 6, 0.7));
            event.getEntity().getWorld().dropItem(event.getEntity().getLocation(), getRandomItemStack(Material.EMERALD, 1, 2, 0.5));
        }
    }

    @EventHandler
    public void onWardenDeathEvent(EntityDeathEvent event) {
        if (event.getEntity().getType() == EntityType.WARDEN) {
            World world = event.getEntity().getWorld();

            world.setFullTime(6000);
            world.setStorm(false);
            world.setThundering(false);
        }
    }

    private ItemStack getRandomItemStack(Material material, int minAmount, int maxAmount, double dropChance) {
        if (Math.random() <= dropChance) {
            int amount = (int) (minAmount + Math.random() * (maxAmount - minAmount + 1));
            return new ItemStack(material, amount);
        }
        return new ItemStack(Material.AIR);
    }
}
