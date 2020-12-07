package de.sirywell.blockclicker.core.enhancement;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.checkerframework.checker.nullness.qual.NonNull;

public class EnhancementId implements ComponentLike {
    private final String id;

    private EnhancementId(String id) {
        this.id = id;
    }

    public static EnhancementId of(String id) {
        return new EnhancementId(id);
    }

    @Override
    public @NonNull Component asComponent() {
        return Component.text(this.id);
    }
}
