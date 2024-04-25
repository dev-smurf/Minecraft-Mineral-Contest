package mineralcontest.mineralcontest0.Listener;

import mineralcontest.mineralcontest0.MineralContest0;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class onChickenDropIron implements Listener {


    @EventHandler
    public void onChickenDeathDropIron(EntityDeathEvent event) {

        if(event.getEntityType() == EntityType.CHICKEN) {

            Chicken chicken = (Chicken) event.getEntity();


            Player player = chicken.getKiller();

            ItemStack ironIngot = new ItemStack(org.bukkit.Material.IRON_INGOT, 1);

            Item ironIngotEntity = player.getWorld().dropItem(chicken.getLocation(), ironIngot);
            ironIngotEntity.setPickupDelay(0);

            event.getDrops().clear();
        }

    }
}
