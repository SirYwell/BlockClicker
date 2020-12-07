package de.sirywell.blockclicker.core.enhancement;

import net.kyori.adventure.text.ComponentLike;

public interface Level extends Upgradable<Level>, ComponentLike {

    static Level first() {
        return new LevelImpl(1L);
    }
}
