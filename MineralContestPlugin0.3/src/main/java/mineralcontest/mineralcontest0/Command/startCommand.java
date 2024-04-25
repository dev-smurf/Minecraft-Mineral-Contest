package mineralcontest.mineralcontest0.Command;

import mineralcontest.mineralcontest0.MineralContest0;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class startCommand implements CommandExecutor {

    private final MineralContest0 plugin;
    private final int countdownSeconds = 3600; // 1 hour in seconds

    public startCommand(MineralContest0 plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        BossBar startBar = BossBar.bossBar(Component.text("Countdown: 1:00:00")
                .color(NamedTextColor.WHITE), 1.0f, BossBar.Color.GREEN, BossBar.Overlay.NOTCHED_10);

        for (Player player : Bukkit.getOnlinePlayers()) {
            Audience audience = this.plugin.adventure().player(player);
            audience.showBossBar(startBar);
        }

        commandSender.sendMessage("Game is starting...");

        final int[] timer = {countdownSeconds};
        new BukkitRunnable() {
            private MineralContest0 plugin;

            @Override
            public void run() {
                timer[0]--;
                if (timer[0] <= 0 || startBar.progress() - (1.0f / countdownSeconds) <= 0.0f) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        Audience audience = this.plugin.adventure().player(player);
                        audience.hideBossBar(startBar);
                    }
                    commandSender.sendMessage("Game is over!");
                    // Make all players spectators
                    makeAllPlayersSpectators();
                    cancel();
                }
                int hours = timer[0] / 3600;
                int minutes = (timer[0] % 3600) / 60;
                int seconds = timer[0] % 60;
                startBar.progress(startBar.progress() - (1.0f / countdownSeconds));
                startBar.name(Component.text("Countdown: " + String.format("%02d:%02d:%02d", hours, minutes, seconds))
                        .color(timer[0] <= 300 ? TextColor.color(NamedTextColor.RED) : NamedTextColor.WHITE));
            }
        }.runTaskTimerAsynchronously(this.plugin, 0, 20);

        // Run the setup-teams command
            Bukkit.dispatchCommand(commandSender, "setup-teams");
            Bukkit.dispatchCommand(commandSender, "class");

        return true;
    }

     private void makeAllPlayersSpectators() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setGameMode(GameMode.SPECTATOR);
        }
    }
}