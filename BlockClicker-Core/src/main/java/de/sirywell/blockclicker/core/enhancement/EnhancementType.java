package de.sirywell.blockclicker.core.enhancement;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Optional;

public enum EnhancementType implements ComponentLike {
    CLICK,
    IDLE,
    ;

    public static Optional<EnhancementType> fromString(String string) {
        //noinspection EnhancedSwitchMigration TODO in probably 20 years
        switch (string) {
            case "click":
                return Optional.of(CLICK);
            case "idle":
                return Optional.of(IDLE);
            default:
                return Optional.empty();
        }
    }

    @Override
    public @NonNull Component asComponent() {
        return Component.text(name().toLowerCase());
    }
}
