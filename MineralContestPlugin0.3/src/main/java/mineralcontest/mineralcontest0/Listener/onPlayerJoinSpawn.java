package mineralcontest.mineralcontest0.Listener;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlayerJoinSpawn implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        //Get the player who made the event
        Player player = event.getPlayer();
        //Spawn Location
        Location locationSpawn = new Location(player.getWorld(), 259.6, 255, -258.411, 0, 90);

        player.teleport(locationSpawn);
    }
}
