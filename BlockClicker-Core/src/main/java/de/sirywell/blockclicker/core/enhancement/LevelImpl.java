package de.sirywell.blockclicker.core.enhancement;

import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;

class LevelImpl implements Level {
    private final long level;

    LevelImpl(long level) {
        this.level = level;
    }

    @Override
    public Level upgrade() {
        return new LevelImpl(this.level + 1L);
    }

    @Override
    public @NonNull Component asComponent() {
        return Component.text(this.level);
    }
}
