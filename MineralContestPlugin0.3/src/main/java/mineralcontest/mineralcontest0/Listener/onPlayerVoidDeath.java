package mineralcontest.mineralcontest0.Listener;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class onPlayerVoidDeath implements Listener {



    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        double voidY = -80;

        if (player.getLocation().getY() < voidY) {

            Location targetLocation = new Location(player.getWorld(), 259.6, 255, -258.411, 0, 90);
            player.teleport(targetLocation);
            player.setVelocity(new Vector(0, 0, 0));
        }
    }
}