package me.nicholas.anticheat.check.impl;

import me.nicholas.anticheat.check.Check;
import me.nicholas.anticheat.check.CheckInfo;
import me.nicholas.anticheat.data.PlayerData;
import org.bukkit.entity.Player;

/**
 * @author Nicholas
 */
@CheckInfo(name = "Test (A)")
public class TestA extends Check {
    public TestA(PlayerData playerData) {
        super(playerData);
    }

    @Override
    public void onMove(Player player) {
        flag();
    }
}