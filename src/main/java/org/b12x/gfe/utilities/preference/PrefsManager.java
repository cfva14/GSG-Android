package org.b12x.gfe.utilities.preference;

import java.util.prefs.Preferences;

public class PrefsManager {

    private static final Preferences preferences = Preferences.userNodeForPackage(PrefsManager.class);

    private PrefsManager() { }

    /**
     * Sets the integer value of the named preference.
     *
     * @param name the name of the preference to be set
     * @param newInt the integer value to be set
     */
    public static void setPrefInt(String name, int newInt) {
        preferences.putInt(name, newInt);
    }

    /**
     * Gets the integer value of the named preference.
     * Returns zero by default.
     *
     * @param name the name of the preference to be set
     * @return the stored integer
     */
    public static int getPrefInt(String name) {
        return preferences.getInt(name, 0);
    }

    /**
     * Sets the string value of the named preference.
     *
     * @param name the name of the preference to be set
     * @param newString the string value to be set
     */
    public static void setPrefString(String name, String newString) {
        preferences.put(name, newString);
    }

    /**
     * Gets the string value of the named preference.
     * Returns an empty string by default.
     *
     * @param name the name of the preference to be set
     * @return the stored string
     */
    public static String getPrefString(String name) {
        return preferences.get(name, "");
    }

    /**
     * Sets the boolean value of the named preference.
     *
     * @param name the name of the preference to be set
     * @param newBoolean the boolean value to be set
     */
    public static void setPrefBoolean(String name, Boolean newBoolean) {
        preferences.putBoolean(name, newBoolean);
    }

    /**
     * Gets the boolean value of the named preference.
     * Returns false by default.
     *
     * @param name the name of the preference to be set
     * @return the stored boolean
     */
    public static Boolean getPrefBoolean(String name) {
        return preferences.getBoolean(name, false);
    }
}
