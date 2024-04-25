package mineralcontest.mineralcontest0.Command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {



        if (command.getName().equalsIgnoreCase("spawn")) {
            if (commandSender instanceof Player) {

                Player player = (Player) commandSender;
             Location spawn = new Location(player.getWorld(), 259.6, 255, -258.411, 0, 90);

                player.teleport(spawn);
                player.sendMessage("All players have been teleported to spawn");

            }
        }
        return true;
    }
}

