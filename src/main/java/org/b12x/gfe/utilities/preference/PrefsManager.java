package org.b12x.gfe.utilities.preference;

import java.util.prefs.Preferences;

public class PrefsManager {

    private static final Preferences preferences = Preferences.userNodeForPackage(PrefsManager.class);

    private PrefsManager() { }

    /**
     * Gets the index of which loci was last selected on the GFE tab.
     * Used by the GFE Loci dropdown
     */
    public static int getCurrentGfeLoci() {
        return preferences.getInt("GFE_LOCI", 0);
    }

    /* set any int pref */
    public static void setPrefInt(String name, int newInt) {
        preferences.putInt(name, newInt);
    }

    /* get any int pref */
    public static int getPrefInt(String name) {
        return preferences.getInt(name, 0);
    }

    /* set any string pref */
    public static void setPrefString(String name, String newString) {
        preferences.put(name, newString);
    }

    /* get any string pref */
    public static String getPrefString(String name) {
        return preferences.get(name, "");
    }
}
