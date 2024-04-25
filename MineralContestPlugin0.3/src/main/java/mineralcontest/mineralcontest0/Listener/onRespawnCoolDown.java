package mineralcontest.mineralcontest0.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.HashMap;
import java.util.UUID;

public class onRespawnCoolDown implements Listener {
    private HashMap<UUID, Long> respawnCooldowns = new java.util.HashMap<>();
    private long cooldownTime = 60 * 1000;

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        UUID playerId = event.getPlayer().getUniqueId();

        if (respawnCooldowns.containsKey(playerId)) {
            long lastRespawnTime = respawnCooldowns.get(playerId);
            long currentTime = System.currentTimeMillis();

            if (currentTime - lastRespawnTime < cooldownTime) {
                event.setRespawnLocation(event.getPlayer().getBedSpawnLocation());
                event.getPlayer().sendMessage("YOU ARE DEAD");
            } else {
                respawnCooldowns.put(playerId, currentTime);
            }
        } else {
            respawnCooldowns.put(playerId, System.currentTimeMillis());
        }
    }
}