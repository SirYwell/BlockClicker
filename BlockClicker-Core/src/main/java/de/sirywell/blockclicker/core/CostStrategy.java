package de.sirywell.blockclicker.core;

import de.sirywell.blockclicker.core.enhancement.Level;

import java.math.BigInteger;
import java.util.function.Function;

@FunctionalInterface
public interface CostStrategy extends Function<Level, BigInteger> {

    BigInteger price(Level level);

    @Override
    default BigInteger apply(Level level) {
        return price(level);
    }
}
