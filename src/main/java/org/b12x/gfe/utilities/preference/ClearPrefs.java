package org.b12x.gfe.utilities.preference;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class ClearPrefs {

    private static final Preferences preferences = Preferences.userNodeForPackage(PrefsManager.class);

    public ClearPrefs() { }

    /**
     * Clears all program preferences.
     *
     */
    public static void clearAllPrefs() throws BackingStoreException {
        preferences.clear();
    }
}
