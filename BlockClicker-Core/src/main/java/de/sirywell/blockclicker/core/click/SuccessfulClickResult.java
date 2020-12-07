package de.sirywell.blockclicker.core.click;

import de.sirywell.blockclicker.core.CookieBox;

public class SuccessfulClickResult implements ClickResult {
    private final CookieBox earned;

    public SuccessfulClickResult(CookieBox earned) {
        this.earned = earned;
    }

    @Override
    public boolean wasSuccessful() {
        return true;
    }

    @Override
    public CookieBox earnedCookies() {
        return this.earned;
    }
}
