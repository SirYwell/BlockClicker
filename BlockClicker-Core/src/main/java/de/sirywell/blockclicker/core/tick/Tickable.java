package de.sirywell.blockclicker.core.tick;

import de.sirywell.blockclicker.core.Clicker;

public interface Tickable {

    TickResult onTick(Clicker clicker);
}
