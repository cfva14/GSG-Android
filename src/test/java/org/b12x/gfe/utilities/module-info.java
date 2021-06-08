open module org.b12x.gfe.utilities.preference { // GSG.main {
    requires transitive org.b12x.gfe.utilities.preference.PrefsManager;
    requires transitive org.b12x.gfe.utilities.preference.PrefsManagerTest;
    requires org.b12x.gfe.utilities.preference.Prefs;
    requires org.b12x.gfe.utilities.preference.PrefsTest;
    requires kotlin.stdlib;

    exports org.b12x.gfe.utilities.preference;
}
