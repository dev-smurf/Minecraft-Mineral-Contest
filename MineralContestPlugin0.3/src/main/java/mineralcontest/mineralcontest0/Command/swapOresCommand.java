package mineralcontest.mineralcontest0.Command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class swapOresCommand implements CommandExecutor {
    private final List<Material> oreMaterials = Arrays.asList(
            Material.COAL_ORE,
            Material.IRON_ORE,
            Material.GOLD_ORE,
            Material.DIAMOND_ORE,
            Material.EMERALD_ORE,
            Material.REDSTONE_ORE,
            Material.LAPIS_ORE
    );

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            World world = Bukkit.getWorld("world");

            swapOres(world);

            player.sendMessage("All ores have been swapped randomly in the ground!");
        }

        return true;
    }

    private void swapOres(World world) {
        for (int x = -3000; x < 3000; x++) {
            for (int y = 1; y < 128; y++) {
                for (int z = -3000; z < 3000; z++) {
                    Material blockType = world.getBlockAt(x, y, z).getType();

                    if (oreMaterials.contains(blockType)) {
                        Material randomOre = getRandomOre();

                        world.getBlockAt(x, y, z).setType(randomOre);
                    }
                }
            }
        }
    }

    private Material getRandomOre() {
        int randomIndex = (int) (Math.random() * oreMaterials.size());
        return oreMaterials.get(randomIndex);
    }
}
