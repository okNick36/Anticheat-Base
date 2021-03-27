package me.nicholas.anticheat.data;

import lombok.Getter;
import lombok.SneakyThrows;
import me.nicholas.anticheat.check.Check;
import me.nicholas.anticheat.check.CheckManager;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nicholas
 */
@Getter
public class PlayerData {
    private static final Map<Player, PlayerData> cache = new HashMap<>();

    private final Player player;
    private final List<Check> checks = new ArrayList<>();

    @SneakyThrows
    public PlayerData(Player player) {
        this.player = player;
        for (Class<? extends Check> checkClasses : CheckManager.getCheckClasses())
            checks.add((Check) checkClasses.getConstructors()[0].newInstance(this));
        cache.put(player, this);
    }

    public void remove() {
        cache.remove(player);
    }

    public static PlayerData get(Player player) {
        return cache.get(player);
    }
}