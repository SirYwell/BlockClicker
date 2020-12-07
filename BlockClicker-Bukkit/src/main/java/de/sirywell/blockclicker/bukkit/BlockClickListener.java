package de.sirywell.blockclicker.bukkit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockClickListener implements Listener {

    @EventHandler
    public void onBlockClick(BlockBreakEvent event) {
        Player player = event.getPlayer();
        BukkitClicker clicker = BukkitClicker.ofPlayer(player);

    }
}
