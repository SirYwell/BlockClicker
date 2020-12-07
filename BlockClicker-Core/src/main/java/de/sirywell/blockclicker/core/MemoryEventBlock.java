package de.sirywell.blockclicker.core;

import de.sirywell.blockclicker.core.click.ClickResult;
import de.sirywell.blockclicker.core.click.Clickable;
import de.sirywell.blockclicker.core.enhancement.Enhancement;
import de.sirywell.blockclicker.core.enhancement.EnhancementId;
import de.sirywell.blockclicker.core.enhancement.EnhancementType;
import de.sirywell.blockclicker.core.tick.TickResult;
import de.sirywell.blockclicker.core.tick.Tickable;
import de.sirywell.blockclicker.core.util.SimpleCache;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;

// Dirty proof of concept implementation
// doesn't persist any data

public class MemoryEventBlock implements Clickable, Tickable, Container {
    private final IdentityHashMap<EnhancementType, Map<Clicker, Set<Enhancement>>> cache = new IdentityHashMap<>();
    private final Map<Clicker, Map<EnhancementId, Enhancement>> clickCache = new SimpleCache<>(100);
    private final Map<Clicker, Map<EnhancementId, Enhancement>> tickCache = new SimpleCache<>(100);
    private final Map<Clicker, CookieBox> cookieCache = new SimpleCache<>(100);

    @Override
    public ClickResult onClick(Clicker clicker) {
        Collection<Enhancement> values = this.clickCache.computeIfAbsent(clicker, c -> new HashMap<>()).values();
        CookieBox earned = CookieBox.empty();
        for (Enhancement value : values) {
            earned = earned.add(value.earn());
        }
        this.cookieCache.compute(clicker, insertOrAdd(earned));
        return ClickResult.success(earned);
    }

    @Override
    public TickResult onTick(Clicker clicker) {
        return null;
    }

    @Override
    public Iterable<Enhancement> enhancements(Clicker clicker, EnhancementType enhancementType) {
        //noinspection EnhancedSwitchMigration TODO in probably 20 years
        switch (enhancementType) {
            case CLICK:
                return this.clickCache.computeIfAbsent(clicker, c -> new HashMap<>()).values();
            case IDLE:
                return this.tickCache.computeIfAbsent(clicker, c -> new HashMap<>()).values();
            default:
                throw new UnsupportedOperationException("Unknown type: " + enhancementType);
        }
    }

    @Override
    public Optional<Enhancement> enhancementById(Clicker clicker, EnhancementId id, EnhancementType enhancementType) {
        //noinspection EnhancedSwitchMigration TODO in probably 20 years
        switch (enhancementType) {
            case CLICK:
                return Optional.ofNullable(
                        this.clickCache.computeIfAbsent(clicker, c -> new HashMap<>()).get(id));
            case IDLE:
                return Optional.ofNullable(
                        this.tickCache.computeIfAbsent(clicker, c -> new HashMap<>()).get(id));
            default:
                throw new UnsupportedOperationException("Unknown type: " + enhancementType);
        }
    }

    @Override
    public Enhancement upgrade(Clicker clicker, EnhancementId id, EnhancementType enhancementType) {
        //noinspection EnhancedSwitchMigration TODO in probably 20 years
        switch (enhancementType) {
            case CLICK:
                return this.clickCache.computeIfAbsent(clicker, c -> new HashMap<>())
                        .compute(id, createOrUpgrade());
            case IDLE:
                return this.tickCache.computeIfAbsent(clicker, c -> new HashMap<>())
                        .compute(id, createOrUpgrade());
            default:
                throw new UnsupportedOperationException("Unknown type: " + enhancementType);
        }
    }

    @Override
    public CookieBox cookies(Clicker clicker) {
        return this.cookieCache.computeIfAbsent(clicker, c -> CookieBox.empty());
    }

    private static BiFunction<Clicker, CookieBox, CookieBox> insertOrAdd(CookieBox earned) {
        return (c, prev) -> prev == null ? earned : prev.add(earned);
    }

    private static BiFunction<EnhancementId, Enhancement, Enhancement> createOrUpgrade() {
        return (id, prev) -> prev == null ? Enhancement.ofIdentifier(id) : prev.upgrade();
    }
}
