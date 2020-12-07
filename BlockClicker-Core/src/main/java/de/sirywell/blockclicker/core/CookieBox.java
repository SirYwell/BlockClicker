package de.sirywell.blockclicker.core;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.math.BigInteger;

public interface CookieBox extends ComponentLike {

    static CookieBox of(BigInteger amount) {
        return new ImmutableCookieBox(amount);
    }

    static CookieBox empty() {
        return of(BigInteger.ZERO);
    }

    BigInteger value();

    CookieBox add(CookieBox addend);

    CookieBox subtract(CookieBox minuend);

    @Override
    default @NonNull Component asComponent() {
        return Component.text(value().toString());
    }
}
