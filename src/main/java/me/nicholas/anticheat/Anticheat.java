package me.nicholas.anticheat;

import me.nicholas.anticheat.check.CheckManager;
import me.nicholas.anticheat.data.PlayerDataManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Nicholas
 */
public class Anticheat extends JavaPlugin {
    @Override
    public void onEnable() {
        new CheckManager(this);
        new PlayerDataManager(this);
    }
}