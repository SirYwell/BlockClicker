package de.sirywell.blockclicker.core.enhancement;

import de.sirywell.blockclicker.core.CookieBox;
import de.sirywell.blockclicker.core.Identifiable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface Enhancement extends Identifiable<EnhancementId>, Upgradable<Enhancement>, ComponentLike {

    static Enhancement ofIdentifier(EnhancementId identifier) {
        return new EnhancementImpl(identifier, Level.first());
    }

    default ComponentLike name() {
        return identifier();
    }

    Level level();

    @Override
    default @NonNull Component asComponent() {
        return name().asComponent();
    }

    CookieBox earn();
}
