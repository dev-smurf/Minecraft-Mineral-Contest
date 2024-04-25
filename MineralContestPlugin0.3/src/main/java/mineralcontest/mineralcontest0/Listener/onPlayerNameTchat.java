package mineralcontest.mineralcontest0.Listener;

import mineralcontest.mineralcontest0.MineralContest0;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onPlayerNameTchat implements Listener {

    onCreateTeamsListener teamListen = new onCreateTeamsListener();


    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {


        Player player = event.getPlayer();
        String playerName = player.getName();
        MineralContest0.getPlugin().getPlayerTeam(player);

        String newNicknameRed = ChatColor.RED + "" + ChatColor.BOLD + "" + "Red Team " + ChatColor.RESET + playerName;
        String newNicknameBlue = ChatColor.BLUE + "" + ChatColor.BOLD + "" + "Blue Team " + ChatColor.RESET + playerName;
        String newNicknameYellow = ChatColor.YELLOW + "" + ChatColor.BOLD + "" + "Yellow Team "+ ChatColor.RESET  + playerName;
        String newNicknamePurple = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + "Purple Team "+ ChatColor.RESET + playerName;


        if (MineralContest0.getPlugin().getPlayerTeam(player) == "REDTEAM") {

            event.setFormat(newNicknameRed + " : %2$s");
        }
        else if (MineralContest0.getPlugin().getPlayerTeam(player) == "BLUETEAM") {

            event.setFormat(newNicknameBlue + " : %2$s");
        }
        else if (MineralContest0.getPlugin().getPlayerTeam(player) == "YELLOWTEAM") {

            event.setFormat(newNicknameYellow + " : %2$s");
        }
        else if (MineralContest0.getPlugin().getPlayerTeam(player) == "PURPLETEAM") {

            event.setFormat(newNicknamePurple + " : %2$s");
        }
        else {
            event.setFormat(playerName + " : %2$s");
        }

    }
}

