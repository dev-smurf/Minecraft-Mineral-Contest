package mineralcontest.mineralcontest0;

import mineralcontest.mineralcontest0.Command.*;
import mineralcontest.mineralcontest0.Listener.*;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;

public final class MineralContest0 extends JavaPlugin implements Listener {

    private BukkitAudiences adventure;
    public static int totalScore = 0;

    private HashMap<Player, Scoreboard> scoreBoardHashMap = new HashMap<>();
    private Objective boardObjective;
    private Score classBoardScore;
    private static MineralContest0 plugin;

    public HashMap getHashMapScore() {
        return scoreBoardHashMap;
    }

    public void addPlayerScoreBoard(Player p, Scoreboard board) {
        scoreBoardHashMap.put(p, board);
    }

    public Scoreboard getPlayerScoreboard(Player p) {
        return scoreBoardHashMap.get(p);
    }

    public Scoreboard getboard(Player p) {
        return p.getScoreboard();
    }

    private HashMap<Player, String> classesMap = new HashMap<Player, String>();

    public HashMap<Player, String> getClassesMap() {
        return classesMap;
    }

    public void setClassMap(Player p, String chosenClass) {
        classesMap.put(p, chosenClass);
    }

    public String getClassName(Player p) {
        return classesMap.get(p);
    }

    public void removeClassMap(Player p) {
        classesMap.remove(p);
    }

    public void setPlayerTeamItem(Player p, String chosenTeam, Material itemType, int itemAmount) {
        playerTeam.put(p, chosenTeam);
    }

    private HashMap<Player, String> playerTeam = new HashMap<>();

    public HashMap<Player, String> teamHashMap() {
        return playerTeam;
    }

    public void setTeamMap(Player p, String chosenTeam) {
        playerTeam.put(p, chosenTeam);
    }

    public String getPlayerTeam(Player player) {
        return playerTeam.get(player);
    }

    public void removeTeamMap(Player p) {
        playerTeam.remove(p);
    }


    public @NonNull BukkitAudiences adventure() {
        if(this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return this.adventure;
    }

    @Override
    public void onEnable() {

        plugin = this;
        System.out.println("The plugin started!");

        getServer().getPluginManager().registerEvents(new onJoinLeaveMessage(), this);
        getServer().getPluginManager().registerEvents(new onCreateTeamsListener(), this);
        getServer().getPluginManager().registerEvents(new onClassMenu(), this);
        getServer().getPluginManager().registerEvents(new onChestCompiler(), this);
        getServer().getPluginManager().registerEvents(new onPlayerNameTchat(), this);
        getServer().getPluginManager().registerEvents(new onChickenDropIron(), this);
        getServer().getPluginManager().registerEvents(new onRespawnCoolDown(), this);
        getServer().getPluginManager().registerEvents(new onSmelterInventory(), this);
        getServer().getPluginManager().registerEvents(new onPlayerVoidDeath(), this);
        getServer().getPluginManager().registerEvents(new onSmelterClass(), this);
        getServer().getPluginManager().registerEvents(new onThiefClass(), this);
        getServer().getPluginManager().registerEvents(new onRightClickSilkTouch(), this);
        getServer().getPluginManager().registerEvents(new onWardenDeath(), this);
//        getServer().getPluginManager().registerEvents(new onEntitySpawn(), this);

        getCommand("class").setExecutor(new classMenuCommand());
        getCommand("setup-teams").setExecutor(new createTeamsCommand());
        getCommand("arena").setExecutor(new clickableTextTeleportCommand());
        getCommand("admin").setExecutor(new adminMenuCommand());
        getCommand("chest").setExecutor(new chestNameCommand());
        getCommand("chest-mid").setExecutor(new chestMidNameCommand());
        getCommand("spawn").setExecutor(new chestMidNameCommand());
        getCommand("warden").setExecutor(new wardenCommand(this));
        getCommand("start").setExecutor(new startCommand(plugin));

        minLocation = new Location(getServer().getWorld("world"), 315, 148, -172);
        maxLocation = new Location(getServer().getWorld("world"), 191, 343, -312);

        getServer().getPluginManager().registerEvents(this, this);

        this.adventure = BukkitAudiences.create(this);
    }

    @Override
    public void onDisable() {
        if(this.adventure != null) {
            this.adventure.close();
            this.adventure = null;
        }
    }

    private boolean isInProtectedZone(Location location) {
        return location.getWorld().equals(minLocation.getWorld()) &&
                location.getBlockX() >= minLocation.getBlockX() &&
                location.getBlockX() <= maxLocation.getBlockX() &&
                location.getBlockY() >= minLocation.getBlockY() &&
                location.getBlockY() <= maxLocation.getBlockY() &&
                location.getBlockZ() >= minLocation.getBlockZ() &&
                location.getBlockZ() <= maxLocation.getBlockZ();
    }


    private Location minLocation;
    private Location maxLocation;


    public static MineralContest0 getPlugin() {
        return plugin;
    }
}
