//package mineralcontest.mineralcontest0.Listener;
//
//import jdk.internal.icu.text.UCharacterIterator;
//import mineralcontest.mineralcontest0.MineralContest0;
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.player.PlayerJoinEvent;
//import org.bukkit.scoreboard.Criteria;
//import org.bukkit.scoreboard.DisplaySlot;
//import org.bukkit.scoreboard.Objective;
//import org.bukkit.scoreboard.Scoreboard;
//
//public class onHealthTag implements Listener {
//
//    @EventHandler
//    public void onPlayerJoin(PlayerJoinEvent event) {
//
//        Scoreboard board1 = Bukkit.getScoreboardManager().getNewScoreboard();
//        Player player = event.getPlayer();
//
//        Objective objectiveHealth = board1.registerNewObjective(MineralContest0.getPlugin().getName() + "_health", Criteria.HEALTH, ChatColor.RED + "❤");
//
//        objectiveHealth.setDisplaySlot(DisplaySlot.BELOW_NAME);
//
//        player.setScoreboard(board1);
//    }
//}





