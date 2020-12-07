package de.sirywell.blockclicker.bukkit;

import de.sirywell.blockclicker.core.Clicker;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

public class BukkitClicker implements Clicker {
    private final UUID uuid;

    private BukkitClicker(UUID uuid) {
        this.uuid = uuid;
    }

    public static BukkitClicker ofPlayer(Player player) {
        return new BukkitClicker(player.getUniqueId());
    }

    public Optional<Player> toPlayer() {
        return Optional.ofNullable(Bukkit.getPlayer(this.uuid));
    }

    @Override
    public UUID identifier() {
        return this.uuid;
    }


}
