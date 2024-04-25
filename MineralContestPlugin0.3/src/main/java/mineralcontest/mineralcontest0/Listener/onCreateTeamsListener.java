package mineralcontest.mineralcontest0.Listener;

import mineralcontest.mineralcontest0.MineralContest0;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scoreboard.Scoreboard;

public class onCreateTeamsListener implements Listener {
    @EventHandler
    public void onTeamSelect(InventoryClickEvent e) {

        //Get the name of the player who clicked on an item
        Player player = (Player) e.getWhoClicked();
        // Gets the players scoreboard
        Scoreboard board = MineralContest0.getPlugin().getPlayerScoreboard(player);
        //Create a table with the player name and a specific id


        //Check if the name of the open inventory is "Choose your team"
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BOLD + "" + ChatColor.DARK_GRAY + "Choose your team")) {

            //Specify the location of the "redTeamSpawn" by x, y, z
            Location redTeamSpawn = new Location(player.getWorld(), 12071, 66, 1408);

            //Specify the location of the "blueTeamSpawn" by x, y, z
            Location blueTeamSpawn = new Location(player.getWorld(), 12126, 66, 1463);

            //Specify the location of the "yellowTeamSpawn" by x, y, z
            Location yellowTeamSpawn = new Location(player.getWorld(), 12071, 66, 1518);

            //Specify the location of the "purpleTeamSpawn" by x, y, z
            Location purpleTeamSpawn = new Location(player.getWorld(), 12016, 66, 1463);

            if (e.getCurrentItem() == null) {

            } else {

                //Create a string with the id "team"
                String team = null;

                switch (e.getCurrentItem().getType()) {

                    //If the player choose the red wool
                    case RED_WOOL:

                        //The string "team" is "Red Team" in this case
                        team = ChatColor.RED + "Red Team";
                        //Save in the table the name of the player who clicked and in this case, the id "RedTeam"
                        MineralContest0.getPlugin().removeTeamMap(player);
                        MineralContest0.getPlugin().setTeamMap(player, "REDTEAM");
                        //Sets the team to the board
                        board.getTeam("NameTeam").setPrefix(ChatColor.GRAY + "» Team:  " + ChatColor.RED + "RED");
                        //Teleport the player at the location determined
                        player.teleport(redTeamSpawn);
                        break;


                    //If the player choose the blue wool
                    case BLUE_WOOL:

                        //The string "team" is "Blue Team" in this case
                        team = ChatColor.BLUE + "Blue Team";
                        //Save in the table the name of the player who clicked and in this case, the id "BlueTeam"
                        MineralContest0.getPlugin().removeTeamMap(player);
                        MineralContest0.getPlugin().setTeamMap(player, "BLUETEAM");

                        //Sets the team to the board
                        board.getTeam("NameTeam").setPrefix(ChatColor.GRAY + "» Team:  " + ChatColor.BLUE + "BLUE");

                        //Teleport the player at the location determined
                        player.teleport(blueTeamSpawn);
                        break;


                    //If the player choose the yellow wool
                    case YELLOW_WOOL:

                        //The string "team" is "Yellow Team" in this case
                        team = ChatColor.YELLOW + "Yellow Team";
                        //Save in the table the name of the player who clicked and in this case, the id "YellowTeam"
                        MineralContest0.getPlugin().removeTeamMap(player);
                        MineralContest0.getPlugin().setTeamMap(player, "YELLOWTEAM");

                        //Sets the team to the board
                        board.getTeam("NameTeam").setPrefix(ChatColor.GRAY + "» Team:  " + ChatColor.YELLOW + "YELLOW");

                        //Teleport the player at the location determined
                        player.teleport(yellowTeamSpawn);
                        break;


                    //If the player choose the purple wool
                    case PURPLE_WOOL:

                        //The string "team" is "Purple Team" in this case
                        team = ChatColor.LIGHT_PURPLE + "Purple Team";
                        //Save in the table the name of the player who clicked and in this case, the id "PurpleTeam"
                        MineralContest0.getPlugin().removeTeamMap(player);
                        MineralContest0.getPlugin().setTeamMap(player, "PURPLETEAM");


                        //Sets the team to the board
                        board.getTeam("NameTeam").setPrefix(ChatColor.GRAY + "» Team:  " + ChatColor.LIGHT_PURPLE + "PURPLE");

                        //Teleport the player at the location determined
                        player.teleport(purpleTeamSpawn);
                        break;


                }
                //Make the player can`t take the item in the inventory
                e.setCancelled(true);

                //Write in the console the player name + the id
                System.out.println(MineralContest0.getPlugin().teamHashMap());
                //Send a message to the player in tchat that says which team he joined
                player.sendMessage("You just joined: " + team + ChatColor.BOLD);


            }

            switch (MineralContest0.getPlugin().getPlayerTeam(player)) {

                //If player id is "REDTEAM" when he respawns, he spawns here
                case "REDTEAM":

                    player.setBedSpawnLocation(redTeamSpawn, true);

                    player.spawnParticle(Particle.END_ROD, player.getLocation(), 50, 0.5, 0.5, 0.5, 0.1);

                    double radiusRed = 1.0;
                    int particleCountRed = 100;
                    for (double theta = 0; theta < 2 * Math.PI; theta += Math.PI / 16) {
                        double x = radiusRed * Math.cos(theta);
                        double z = radiusRed * Math.sin(theta);
                        player.spawnParticle(Particle.REDSTONE, player.getLocation().add(x, 1.0, z), particleCountRed, 0, 0, 0, 1, new Particle.DustOptions(Color.RED, 1));
                    }

                    player.spawnParticle(Particle.SPELL_MOB_AMBIENT, player.getLocation(), 50, 0.5, 0.5, 0.5, 0.1, new Particle.DustOptions(Color.RED, 1));
                    break;

                //If player id is "BLUETEAM" when he respawns, he spawns here
                case "BLUETEAM":

                    player.setBedSpawnLocation(blueTeamSpawn, true);

                    player.spawnParticle(Particle.END_ROD, player.getLocation(), 50, 0.5, 0.5, 0.5, 0.1);

                    double radius = 1.0;
                    int particleCount = 100;
                    for (double theta = 0; theta < 2 * Math.PI; theta += Math.PI / 16) {
                        double x = radius * Math.cos(theta);
                        double z = radius * Math.sin(theta);
                        player.spawnParticle(Particle.REDSTONE, player.getLocation().add(x, 1.0, z), particleCount, 0, 0, 0, 1, new Particle.DustOptions(Color.BLUE, 1));
                    }
                    break;

                //If player id is "YELLOWTEAM" when he respawns, he spawns here
                case "YELLOWTEAM":

                    player.setBedSpawnLocation(yellowTeamSpawn, true);

                    player.spawnParticle(Particle.END_ROD, player.getLocation(), 50, 0.5, 0.5, 0.5, 0.1);

                    double radiusYellow = 1.0;
                    int particleCountYellow = 100;
                    for (double theta = 0; theta < 2 * Math.PI; theta += Math.PI / 16) {
                        double x = radiusYellow * Math.cos(theta);
                        double z = radiusYellow * Math.sin(theta);
                        player.spawnParticle(Particle.REDSTONE, player.getLocation().add(x, 1.0, z), particleCountYellow, 0, 0, 0, 1, new Particle.DustOptions(Color.YELLOW, 1));
                    }
                    break;

                //If player id is "PURPLETEAM" when he respawns, he spawns here
                case "PURPLETEAM":

                    player.setBedSpawnLocation(purpleTeamSpawn, true);

                    player.spawnParticle(Particle.END_ROD, player.getLocation(), 50, 0.5, 0.5, 0.5, 0.1);

                    double radiusPurple = 1.0;
                    int particleCountPurple = 100;
                    for (double theta = 0; theta < 2 * Math.PI; theta += Math.PI / 16) {
                        double x = radiusPurple * Math.cos(theta);
                        double z = radiusPurple * Math.sin(theta);
                        player.spawnParticle(Particle.REDSTONE, player.getLocation().add(x, 1.0, z), particleCountPurple, 0, 0, 0, 1, new Particle.DustOptions(Color.PURPLE, 1));
                    }
                    break;
            }
        }
    }
}

