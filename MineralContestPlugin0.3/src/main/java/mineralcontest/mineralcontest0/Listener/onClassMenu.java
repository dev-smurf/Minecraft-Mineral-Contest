package mineralcontest.mineralcontest0.Listener;

import mineralcontest.mineralcontest0.MineralContest0;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;

public class onClassMenu implements Listener {

    @EventHandler
    public void onClassMenu(InventoryClickEvent event) {
        onCreateTeamsListener teamListen = new onCreateTeamsListener();
        //Check if the name of the open inventory is "Choose your class"
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Choose your class" + ChatColor.RESET)) {

            //Get the name of the player who clicked on an item in the inventory
            Player player = (Player) event.getWhoClicked();
            String currentClass ="";
            Scoreboard board = MineralContest0.getPlugin().getPlayerScoreboard(player);
            if (event.getCurrentItem().getType() == null) {


            } else {

                switch (event.getCurrentItem().getType()) {

                    //If the chosen item is FEATHER, do this
                    case FEATHER:

                        //Send a message to the player in tchat that say which class he chose
                        player.sendMessage(ChatColor.GRAY + "==========================" + ChatColor.RESET);
                        player.sendMessage("You just choose " + ChatColor.BLUE + ChatColor.BOLD + "AGILE" + ChatColor.RESET + " class");
                        player.sendMessage(ChatColor.GRAY + "==========================" + ChatColor.RESET);

                        //Save the player name with the id "AGILE"
                        MineralContest0.getPlugin().removeClassMap(player);
                        MineralContest0.getPlugin().setClassMap(player, "AGILE");


                        //Updates to scoreboard
                        board.getTeam("ClassName").setPrefix(ChatColor.GRAY  + "» Class: " + ChatColor.RESET + "Agile");
                        //Close the inventory after choosing an item
                        player.closeInventory();
                        break;


                    //If the chosen item is DIAMOND_HOE, do this
                    case DIAMOND_HOE:

                        //Send a message to the player in tchat that say which class he chose
                        player.sendMessage(ChatColor.GRAY + "===========================" + ChatColor.RESET);
                        player.sendMessage("You just choose " + ChatColor.BLUE + ChatColor.BOLD + "WORKER" + ChatColor.RESET + " class");
                        player.sendMessage(ChatColor.GRAY + "===========================" + ChatColor.RESET);

                        //Save the player name with the id "WORKER"
                        MineralContest0.getPlugin().removeClassMap(player);
                        MineralContest0.getPlugin().setClassMap(player, "WORKER");



                        //Updates to scoreboard
                        board.getTeam("ClassName").setPrefix(ChatColor.GRAY  + "» Class: " + ChatColor.RESET + "Worker");
//Close the inventory after choosing an item
                        player.closeInventory();
                        break;


                    //If the chosen item is DIAMOND_CHESTPLATE, do this
                    case DIAMOND_CHESTPLATE:

                        //Send a message to the player in tchat that say which class he chose
                        player.sendMessage(ChatColor.GRAY + "===========================" + ChatColor.RESET);
                        player.sendMessage("You just choose " + ChatColor.BLUE + ChatColor.BOLD + "ROBUST" + ChatColor.RESET + " class");
                        player.sendMessage(ChatColor.GRAY + "===========================" + ChatColor.RESET);

                        //Save the player name with the id "ROBUST"
                        MineralContest0.getPlugin().removeClassMap(player);
                        MineralContest0.getPlugin().setClassMap(player, "ROBUST");



                        //Updates to scoreboard
                        board.getTeam("ClassName").setPrefix(ChatColor.GRAY  + "» Class: " + ChatColor.RESET + "Robust");
//Close the inventory after choosing an item
                        player.closeInventory();
                        break;


                    //If the chosen item is DIAMOND_SWORD, do this
                    case DIAMOND_SWORD:

                        //Send a message to the player in tchat that say which class he chose
                        player.sendMessage(ChatColor.GRAY + "============================" + ChatColor.RESET);
                        player.sendMessage("You just choose " + ChatColor.BLUE + ChatColor.BOLD + "WARRIOR" + ChatColor.RESET + " class");
                        player.sendMessage(ChatColor.GRAY + "============================" + ChatColor.RESET);
                        MineralContest0.getPlugin().removeClassMap(player);
                        //Save the player name with the id "WARRIOR"

                        MineralContest0.getPlugin().setClassMap(player, "WARRIOR");



                        //Updates to scoreboard
                        board.getTeam("ClassName").setPrefix(ChatColor.GRAY  + "» Class: " + ChatColor.RESET + "Warrior");

                        //Close the inventory after choosing an item
                        player.closeInventory();
                        break;


                    //If the chosen item is FURNACE, do this
                    case FURNACE:

                        //Send a message to the player in tchat that say which class he chose
                        player.sendMessage(ChatColor.GRAY + "============================" + ChatColor.RESET);
                        player.sendMessage("You just choose " + ChatColor.BLUE + ChatColor.BOLD + "SMELTER" + ChatColor.RESET + " class");
                        player.sendMessage(ChatColor.GRAY + "============================" + ChatColor.RESET);

                        //Save the player name with the id "SMELTER"
                        MineralContest0.getPlugin().removeClassMap(player);
                        MineralContest0.getPlugin().setClassMap(player, "SMELTER");


                        //Updates to scoreboard
                        board.getTeam("ClassName").setPrefix(ChatColor.GRAY  + "» Class: " + ChatColor.RESET + "Smelter");
                        //Close the inventory after choosing an item
                        player.closeInventory();
                        break;


                    //If the chosen item is DIAMOND_PICKAXE, do this
                    case DIAMOND_PICKAXE:

                        //Send a message to the player in tchat that say which class he chose
                        player.sendMessage(ChatColor.GRAY + "==========================" + ChatColor.RESET);
                        player.sendMessage("You just choose " + ChatColor.BLUE + ChatColor.BOLD + "MINER" + ChatColor.RESET + " class");
                        player.sendMessage(ChatColor.GRAY + "==========================" + ChatColor.RESET);

                        //Save the player name with the id "MINER"
                        MineralContest0.getPlugin().removeClassMap(player);
                        MineralContest0.getPlugin().setClassMap(player, "MINER");



                        //Updates to scoreboard
                        board.getTeam("ClassName").setPrefix(ChatColor.GRAY  + "» Class: " + ChatColor.RESET + "Miner");
                        //Close the inventory after choosing an item
                        player.closeInventory();
                        break;


                    //If the chosen item is GOLD_INGOT, do this
                    case GOLD_INGOT:

                        //Send a message to the player in tchat that say which class he chose
                        player.sendMessage(ChatColor.GRAY + "============================" + ChatColor.RESET);
                        player.sendMessage("You just choose " + ChatColor.BLUE + ChatColor.BOLD + "SCAMMER" + ChatColor.RESET + " class");
                        player.sendMessage(ChatColor.GRAY + "============================" + ChatColor.RESET);

                        //Save the player name with the id "SCAMMER"
                        MineralContest0.getPlugin().removeClassMap(player);
                        MineralContest0.getPlugin().setClassMap(player, "SCAMMER");


                        //Updates to scoreboard
                        board.getTeam("ClassName").setPrefix(ChatColor.GRAY  + "» Class: " + ChatColor.RESET + "Scammer");
                        //Close the inventory after choosing an item
                        player.closeInventory();
                        break;


                    //If the chosen item is ENCHANTED_GOLDEN_APPLE, do this
                    case ENCHANTED_GOLDEN_APPLE:

                        //Send a message to the player in tchat that say which class he chose
                        player.sendMessage(ChatColor.GRAY + "==========================" + ChatColor.RESET);
                        player.sendMessage("You just choose " + ChatColor.BLUE + ChatColor.BOLD + "THIEF" + ChatColor.RESET + " class");
                        player.sendMessage(ChatColor.GRAY + "==========================" + ChatColor.RESET);

                        //Save the player name with the id "THIEF"
                        MineralContest0.getPlugin().removeClassMap(player);
                        MineralContest0.getPlugin().setClassMap(player, "THIEF");


                        //Updates to scoreboard
                        board.getTeam("ClassName").setPrefix(ChatColor.GRAY  + "» Class: " + ChatColor.RESET + "Thief");
                        //Close the inventory after choosing an item
                        player.closeInventory();
                        break;

                }

                //Makes the player enable to take an item in the inventory
                event.setCancelled(true);



                System.out.println(MineralContest0.getPlugin().getClassesMap());

            }

            //Write in the console the player name + a determined id





            //The code take the player name and is id to continue the code
            switch (MineralContest0.getPlugin().getClassName(player)) {

                //Every player with the id "AGILE" do this
                case "AGILE":

                    //Add the potion effect "SPEED" for an infinite duration
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SPEED, PotionEffect.INFINITE_DURATION, 0)));
                    //Show in the scoreboard the class name

                    // Faire que les bottes ai lenchantement no fall damage
                    break;


                //Every player with the id "WORKER" do this
                case "WORKER":

                    // Faire que ca augmenter les points de 25%
                    //Gives the player a maximum of 5 hearths
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(10);
                    break;


                //Every player with the id "ROBUST" do this
                case "ROBUST":

                    //Gives the player a maximum of 15 hearths
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(30);
                    //Add the potion effect "SLOW 2" for an infinite duration
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SLOW, PotionEffect.INFINITE_DURATION, 1)));
                    break;


                //Every player with the id "WARRIOR" do this
                case "WARRIOR":

                    //Gives the player a maximum of 7 hearths
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(14);
                    //Add the potion effect "FORCE" for an infinite duration
                    player.addPotionEffect((new PotionEffect(PotionEffectType.INCREASE_DAMAGE, PotionEffect.INFINITE_DURATION, 1)));
                    break;


                //Every player with the id "SMELTER" do this
                case "SMELTER":

                    //Every slot specify gives an item "BARRIER" that the player can't move
                    ItemStack ItemBarrier = new ItemStack(Material.BARRIER, 1);
                    player.getInventory().setItem(9, ItemBarrier);
                    player.getInventory().setItem(10, ItemBarrier);
                    player.getInventory().setItem(11, ItemBarrier);
                    player.getInventory().setItem(12, ItemBarrier);
                    player.getInventory().setItem(13, ItemBarrier);
                    player.getInventory().setItem(14, ItemBarrier);
                    player.getInventory().setItem(15, ItemBarrier);
                    player.getInventory().setItem(16, ItemBarrier);
                    player.getInventory().setItem(17, ItemBarrier);

                    //Faire que les blocs ne peuvent pas etre bouges
                    break;


                case "MINER":

                    player.addPotionEffect((new PotionEffect(PotionEffectType.FAST_DIGGING, PotionEffect.INFINITE_DURATION, 1)));

            }
        }

    }

}
