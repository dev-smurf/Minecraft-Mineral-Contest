package mineralcontest.mineralcontest0.Command;

import mineralcontest.mineralcontest0.Listener.onCreateTeamsListener;
import mineralcontest.mineralcontest0.MineralContest0;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Map;

public class clickableTextTeleportCommand implements CommandExecutor {
    private onCreateTeamsListener teamListen = new onCreateTeamsListener();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("arena")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You are not a player. You can't use this command!");
                return true;
            }

            Player player = (Player) sender;
            MineralContest0.getPlugin().getPlayerTeam(player);

            if (args.length == 0) {

                sendCountdown(player, 15);

                return true;
            }

            if (args[0].equalsIgnoreCase("tp")) {
                Location redTeamArenaLocation = new Location(player.getWorld(), 12071, 57, 1429);
                Location blueTeamArenaLocation = new Location(player.getWorld(), 12105, 57, 1463);
                Location yellowTeamArenaLocation = new Location(player.getWorld(), 12071, 57, 1497);
                Location purpleTeamArenaLocation = new Location(player.getWorld(), 12037, 57, 1463);

                for (Map.Entry<Player, String> entry : MineralContest0.getPlugin().teamHashMap().entrySet()) {
                    Player p = entry.getKey();
                    String team = entry.getValue();

                    if (MineralContest0.getPlugin().getPlayerTeam(player) == "REDTEAM") {
                        player.teleport(redTeamArenaLocation);
                    } else if (MineralContest0.getPlugin().getPlayerTeam(player) == "BLUETEAM") {
                        player.teleport(blueTeamArenaLocation);
                    } else if (MineralContest0.getPlugin().getPlayerTeam(player) == "YELLOWTEAM") {
                        player.teleport(yellowTeamArenaLocation);
                    } else if (MineralContest0.getPlugin().getPlayerTeam(player) == "PURPLETEAM") {
                        player.teleport(purpleTeamArenaLocation);
                    }
                }

                player.sendMessage(ChatColor.GREEN + "You just teleported your team to the arena!");
                return true;
            }

            player.sendMessage(ChatColor.RED + "Usage: /arena");
            return true;
        }
        return false;
    }

    private void sendCountdown(Player player, int seconds) {
        new BukkitRunnable() {
            int countdown = seconds;

            @Override
            public void run() {
                if (countdown > 0) {

                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        onlinePlayer.sendMessage("Time before teleportation: " + ChatColor.BLUE + ChatColor.BOLD + Integer.toString(countdown));
                    }
                    countdown--;
                } else {

                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {

                        TextComponent message = new TextComponent("Click Me!");
                        message.setColor(ChatColor.GREEN);
                        message.setBold(true);
                        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/arena tp"));
                        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                                new ComponentBuilder("Click here if you want to teleport your team to the arena!")
                                        .color(ChatColor.GREEN).create()));
                        onlinePlayer.spigot().sendMessage(message);

                    }

                    this.cancel();
                }
            }
        }.runTaskTimer(MineralContest0.getPlugin(), 0L, 20L);
    }
}
