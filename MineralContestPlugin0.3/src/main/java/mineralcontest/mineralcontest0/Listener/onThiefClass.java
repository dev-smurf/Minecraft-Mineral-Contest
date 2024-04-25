package mineralcontest.mineralcontest0.Listener;

import mineralcontest.mineralcontest0.MineralContest0;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class onThiefClass implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        // Vérifiez si le joueur décédé est de la classe "THIEF"
        Player victim = event.getEntity();
        if (MineralContest0.getPlugin().getClassName(victim).equals("THIEF")) {
            Player killer = victim.getKiller();
            if (killer != null) {
                // Restaurez 50% de la vie du tueur
                double maxHealth = killer.getAttribute(Attribute.valueOf("generic.maxHealth")).getValue();
                double currentHealth = killer.getHealth();
                double restoredHealth = maxHealth * 0.5;

                if (currentHealth + restoredHealth > maxHealth) {
                    restoredHealth = maxHealth - currentHealth;
                }

                killer.setHealth(currentHealth + restoredHealth);
            }
        }
    }
}
