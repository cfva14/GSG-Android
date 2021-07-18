package org.b12x.gfe.utilities.preference;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PrefsManager {

    private static final Preferences preferences = Preferences.userNodeForPackage(PrefsManager.class);

    private PrefsManager() {
    }

    /**
     * Sets the integer value of the named preference.
     *
     * @param name   the preference to be set
     * @param newInt the value to be set
     */
    public static void setPrefInt(String name, int newInt) {
        preferences.putInt(name, newInt);
    }

    /**
     * Gets the integer value of the named preference.
     * Returns zero by default.
     *
     * @param name the preference to be retrieved
     * @return the stored integer
     */
    public static int getPrefInt(String name) {
        return preferences.getInt(name, 1);
    }

    /**
     * Sets the string value of the named preference.
     *
     * @param name      the preference to be set
     * @param newString the value to be set
     */
    public static void setPrefString(String name, String newString) {
        preferences.put(name, newString);
    }

    /**
     * Gets the string value of the named preference.
     * Returns the string "HLA-A" by default.
     *
     * @param name the preference to be retrieved
     * @return the stored string
     */
    public static String getPrefString(String name) {
        return preferences.get(name, "HLA-A");
    }

    /**
     * Sets the boolean value of the named preference.
     *
     * @param name       the preference to be set
     * @param newBoolean the value to be set
     */
    public static void setPrefBoolean(String name, Boolean newBoolean) {
        preferences.putBoolean(name, newBoolean);
    }

    /**
     * Gets the boolean value of the named preference.
     * Returns false by default.
     *
     * @param name the preference to be retrieved
     * @return the stored boolean
     */
    public static Boolean getPrefBoolean(String name) {
        return preferences.getBoolean(name, false);
    }

    /**
     * Removes the named preference.
     *
     * @param name preference to be removed
     */
    public static void wipePref(String name) throws BackingStoreException {
        preferences.remove(name);
        preferences.flush();
    }
}
