package mineralcontest.mineralcontest0.Listener;

import mineralcontest.mineralcontest0.MineralContest0;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.*;

public class onJoinLeaveMessage implements Listener {
    //Message in global chat when a player join
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        String playerName = p.getDisplayName();
        event.setJoinMessage(ChatColor.BLUE + "" + ChatColor.BOLD + playerName + ChatColor.RESET + " joined the server!");

        Scoreboard board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
        Objective boardObjective = board.registerNewObjective("Class", "dummy");
        boardObjective.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Mineral Contest");
        boardObjective.setDisplaySlot(DisplaySlot.SIDEBAR);


        Score SectionDivider = boardObjective.getScore(ChatColor.BOLD + "=============" + ChatColor.RESET + ChatColor.WHITE);
        SectionDivider.setScore(4);

        Team classNameTeam = board.registerNewTeam("ClassName");
        classNameTeam.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE);
        classNameTeam.setPrefix(ChatColor.GRAY + "» Class: " + ChatColor.RESET);

        Team teamName = board.registerNewTeam("NameTeam");
        teamName.addEntry(ChatColor.RED + "" + ChatColor.WHITE);
        teamName.setPrefix(ChatColor.GRAY + "» Team:  ");
        boardObjective.getScore(ChatColor.BLACK + "" + ChatColor.WHITE).setScore(2);
        boardObjective.getScore(ChatColor.RED + "" + ChatColor.WHITE).setScore(3);


        MineralContest0.getPlugin().addPlayerScoreBoard(p, board);
        p.setScoreboard(MineralContest0.getPlugin().getPlayerScoreboard(p));


        int initialScore = 0;
        Score score = boardObjective.getScore(ChatColor.GRAY + "» Score: " + initialScore);
        score.setScore(1);
    }


    //Message in global chat when a player leave
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {

        //Get the player who made the event
        Player player = event.getPlayer();

        //Save the name of the player who join or leave
        String playerName = player.getDisplayName();

        //Send a message in global chat with the name of the player who leaved
        event.setQuitMessage(ChatColor.BLUE + "" + ChatColor.BOLD + playerName + ChatColor.RESET + " left the server!");
    }
}


