package mineralcontest.mineralcontest0.Listener;

import mineralcontest.mineralcontest0.MineralContest0;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;

public class onChestCompiler implements Listener {
    private HashMap<Player, Score> playerScores = new HashMap<>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        Scoreboard board = MineralContest0.getPlugin().getPlayerScoreboard(player);

        if (inventory.getType() == InventoryType.CHEST) {
            ItemStack item = event.getCurrentItem();
            if (item != null) {
                Material itemType = item.getType();
                int itemAmount = item.getAmount();
                int points = onPointsManager.getPointsForMaterial(itemType) * itemAmount;

                if (points > 0) {
                    Score score = playerScores.computeIfAbsent(player, k -> {
                        Objective boardObjective = board.getObjective("Class");
                        int initialScore = getInitialScore();
                        Score scoreEntry = boardObjective.getScore(ChatColor.GRAY + "» Score: " + initialScore);
                        scoreEntry.setScore(initialScore);
                        return scoreEntry;
                    });

                    int totalScore = score.getScore() + points;
                    score.setScore(totalScore);
                }

                event.setCurrentItem(new ItemStack(Material.AIR));
                player.updateInventory();
            }
        }
    }

    private int getInitialScore() {
        return 0;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        playerScores.remove(player);
    }
}
