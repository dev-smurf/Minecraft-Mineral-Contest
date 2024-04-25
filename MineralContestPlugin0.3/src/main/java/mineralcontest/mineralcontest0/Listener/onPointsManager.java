package mineralcontest.mineralcontest0.Listener;

import org.bukkit.Material;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;

public class onPointsManager{
        private static Map<Material, Integer> itemPoints = new HashMap<>();

        static {
            itemPoints.put(Material.COPPER_INGOT, 20);
            itemPoints.put(Material.IRON_INGOT, 40);
            itemPoints.put(Material.GOLD_INGOT, 120);
            itemPoints.put(Material.DIAMOND, 200);
            itemPoints.put(Material.EMERALD, 350);
        }

        public static int getPointsForMaterial(Material material) {
            return itemPoints.getOrDefault(material, 0);
        }
    }

