package de.sirywell.blockclicker.core.enhancement;

@FunctionalInterface
public interface Upgradable<T extends Upgradable<T>> {

    /**
     * Returns the successor of this {@link Upgradable}.
     *
     * @return the successor of this.
     */
    T upgrade();
}
