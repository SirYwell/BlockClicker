package de.sirywell.blockclicker.core.click;

import de.sirywell.blockclicker.core.CookieBox;

public interface ClickResult {

    static ClickResult success(CookieBox earned) {
        return new SuccessfulClickResult(earned);
    }

    boolean wasSuccessful();

    CookieBox earnedCookies();
}
