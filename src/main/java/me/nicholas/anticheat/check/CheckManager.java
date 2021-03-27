package me.nicholas.anticheat.check;

import lombok.Getter;
import me.nicholas.anticheat.check.impl.TestA;
import me.nicholas.anticheat.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicholas
 */
public class CheckManager implements Listener {
    @Getter private static final List<Class<? extends Check>> checkClasses = new ArrayList<>();

    public CheckManager(Plugin plugin) {
        checkClasses.add(TestA.class);
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        for (Check check : PlayerData.get(player).getChecks())
            check.onMove(player);
    }

    @EventHandler
    private void onAttack(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        if (!(damager instanceof Player))
            return;
        Player player = (Player) damager;
        for (Check check : PlayerData.get(player).getChecks())
            check.onAttack(player, event.getEntity());
    }
}