package me.nicholas.anticheat.check.impl;

import me.nicholas.anticheat.check.Check;
import me.nicholas.anticheat.check.CheckInfo;
import me.nicholas.anticheat.data.PlayerData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * @author Nicholas
 */
@CheckInfo(name = "Test (B)")
public class TestB extends Check {
    public TestB(PlayerData playerData) {
        super(playerData);
    }

    @Override
    public void onAttack(Player player, Entity entity) {
        flag();
    }
}