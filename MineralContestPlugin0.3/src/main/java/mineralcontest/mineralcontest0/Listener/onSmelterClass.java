package mineralcontest.mineralcontest0.Listener;

import mineralcontest.mineralcontest0.MineralContest0;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class onSmelterClass implements Listener {



    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Material blockType = event.getBlock().getType();
        String playerClass = MineralContest0.getPlugin().getClassName(player);

        if (playerClass.equals("SMELTER") && blockType == Material.IRON_ORE) {
            event.setDropItems(false);

            ItemStack ironIngot = new ItemStack(Material.IRON_INGOT, 1);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), ironIngot);
        }

        else if (playerClass.equals("SMELTER") && blockType == Material.DEEPSLATE_IRON_ORE) {
            event.setDropItems(false);

            ItemStack ironIngot = new ItemStack(Material.IRON_INGOT, 1);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), ironIngot);
        }

        else if (playerClass.equals("SMELTER") && blockType == Material.GOLD_ORE) {
            event.setDropItems(false);

            ItemStack goldIngot = new ItemStack(Material.GOLD_INGOT, 1);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), goldIngot);

        }

        else if (playerClass.equals("SMELTER") && blockType == Material.DEEPSLATE_GOLD_ORE) {
            event.setDropItems(false);

            ItemStack deepslateIronIngot = new ItemStack(Material.GOLD_INGOT, 1);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), deepslateIronIngot);
        }


        else if (playerClass.equals("SMELTER") && blockType == Material.COPPER_ORE) {
            event.setDropItems(false);

            ItemStack copperIngot = new ItemStack(Material.COPPER_INGOT, 1);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), copperIngot);

        }

        else if (playerClass.equals("SMELTER") && blockType == Material.DEEPSLATE_COPPER_ORE) {
            event.setDropItems(false);

            ItemStack deepslateCopperIngot = new ItemStack(Material.COPPER_INGOT, 1);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), deepslateCopperIngot);
        }

        }



    }



