package de.sirywell.blockclicker.core.enhancement;

import de.sirywell.blockclicker.core.CookieBox;

import java.math.BigInteger;

class EnhancementImpl implements Enhancement {
    private final EnhancementId identifier;
    private final Level level;

    public EnhancementImpl(EnhancementId identifier, Level level) {
        this.identifier = identifier;
        this.level = level;
    }

    @Override
    public EnhancementId identifier() {
        return this.identifier;
    }

    @Override
    public Level level() {
        return this.level;
    }

    @Override
    public CookieBox earn() {
        // TODO
        return CookieBox.of(new BigInteger("123"));
    }

    @Override
    public Enhancement upgrade() {
        return new EnhancementImpl(this.identifier, this.level.upgrade());
    }

}
