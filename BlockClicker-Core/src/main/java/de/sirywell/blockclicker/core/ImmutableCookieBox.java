package de.sirywell.blockclicker.core;

import java.math.BigInteger;

class ImmutableCookieBox implements CookieBox {
    private final BigInteger cookies;

    ImmutableCookieBox(BigInteger cookies) {
        this.cookies = cookies;
    }

    @Override
    public BigInteger value() {
        return this.cookies;
    }

    @Override
    public CookieBox add(CookieBox addend) {
        return new ImmutableCookieBox(this.cookies.add(addend.value()));
    }

    @Override
    public CookieBox subtract(CookieBox minuend) {
        return new ImmutableCookieBox(this.cookies.subtract(minuend.value()));
    }
}
