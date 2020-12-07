package de.sirywell.blockclicker.core;

import de.sirywell.blockclicker.core.enhancement.Enhancement;
import de.sirywell.blockclicker.core.enhancement.EnhancementId;
import de.sirywell.blockclicker.core.enhancement.EnhancementType;

import java.util.Optional;

public interface Container {

    /**
     * Returns the enhancements of the clicker stored in this container.
     *
     * @param clicker         the clicker to get the enhancements for.
     * @param enhancementType the type of enhancement.
     * @return an Iterable of enhancements.
     */
    Iterable<Enhancement> enhancements(Clicker clicker, EnhancementType enhancementType);

    /**
     * Returns the enhancement with the given id wrapped in an {@link Optional} or {@link Optional#empty()}
     * if no such enhancement exists for the given clicker.
     *
     * @param clicker         the clicker to get the enhancement for.
     * @param id              the id of the enhancement.
     * @param enhancementType the type of the enhancement.
     * @return an optional enhancement.
     */
    Optional<Enhancement> enhancementById(Clicker clicker, EnhancementId id, EnhancementType enhancementType);

    /**
     * Upgrades the enhancement of the given id for the clicker if present. If the clicker does
     * not have the enhancement with that id, the enhancement will be added.
     *
     * @param clicker         the clicker to upgrade the enhancement for.
     * @param id              the id of the enhancement to upgrade.
     * @param enhancementType the type of enhancement.
     * @return the upgraded enhancement.
     */
    Enhancement upgrade(Clicker clicker, EnhancementId id, EnhancementType enhancementType);

    /**
     * Returns the cookies of the clicker stored in this container as a {@link CookieBox}.
     *
     * @param clicker the clicker to get the cookies for.
     * @return a CookieBox containing the clicker's cookies.
     */
    CookieBox cookies(Clicker clicker);
}
