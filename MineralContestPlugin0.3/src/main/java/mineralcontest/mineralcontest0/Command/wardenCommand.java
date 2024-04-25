package mineralcontest.mineralcontest0.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Warden;
import org.bukkit.plugin.java.JavaPlugin;

public class wardenCommand implements CommandExecutor {
    private final JavaPlugin plugin;
    private Warden warden;

    public wardenCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("warden") && sender instanceof Player) {
            Player player = (Player) sender;
            World world = player.getWorld();

            if (warden != null && !warden.isDead()) {
                warden.setHealth(0);
            }

            world.setStorm(true);
            world.setThundering(true);
            world.setWeatherDuration(Integer.MAX_VALUE);
            world.setFullTime(18000);

            Location bossSpawn = new Location(player.getWorld(), 12071, 54, 1463);

            warden = (Warden) world.spawnEntity(bossSpawn, EntityType.WARDEN);
            warden.setHealth(warden.getMaxHealth() * 0.4);

            warden.setLootTable(null);

            warden.setAI(true);

            return true;
        }
        return false;
    }
}
