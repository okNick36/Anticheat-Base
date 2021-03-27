package me.nicholas.anticheat.data;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

/**
 * @author Nicholas
 */
public class PlayerDataManager implements Listener {
    public PlayerDataManager(Plugin plugin) {
        for (Player player : Bukkit.getOnlinePlayers())
            new PlayerData(player);
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        new PlayerData(event.getPlayer());
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        PlayerData.get(event.getPlayer()).remove();
    }
}