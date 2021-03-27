package me.nicholas.anticheat.check;

import me.nicholas.anticheat.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * @author Nicholas
 */
public abstract class Check {
    protected final PlayerData playerData;

    private final CheckInfo checkInfo;

    public Check(PlayerData playerData) {
        this.playerData = playerData;
        if (!getClass().isAnnotationPresent(CheckInfo.class))
            throw new IllegalArgumentException("@CheckInfo is missing!");
        checkInfo = getClass().getAnnotation(CheckInfo.class);
    }

    public void onMove(Player player) {}

    public void onAttack(Player player, Entity entity) {}

    protected void flag() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("anticheat.alerts")) {
                player.sendMessage("§6§lAC§8§l> §c" + playerData.getPlayer().getName() + " §7failed §c" + checkInfo.name() + "§7.");
            }
        }
    }
}