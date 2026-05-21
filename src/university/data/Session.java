package university.data;

import java.util.Locale;
import java.util.ResourceBundle;
import university.users.User;

public class Session {
    private static User currentUser;
    private static ResourceBundle bundle;

    static {
        // По умолчанию ставим английский
        setLocale(new Locale("en"));
    }

    public static User getCurrentUser() { return currentUser; }
    public static void setCurrentUser(User user) { currentUser = user; }

    public static ResourceBundle getBundle() { return bundle; }
    
    public static void setLocale(java.util.Locale locale) {
        bundle = ResourceBundle.getBundle("university.data.messages", locale, new ResourceBundle.Control() {
            @Override
            public ResourceBundle newBundle(String baseName, java.util.Locale locale, String format, 
                                            ClassLoader loader, boolean reload) 
                                            throws java.io.IOException, IllegalAccessException, InstantiationException {
                String bundleName = toBundleName(baseName, locale);
                String resourceName = toResourceName(bundleName, "properties");
                java.io.InputStream stream = loader.getResourceAsStream(resourceName);
                if (stream != null) {
                    try (java.io.Reader reader = new java.io.InputStreamReader(stream, java.nio.charset.StandardCharsets.UTF_8)) {
                        return new java.util.PropertyResourceBundle(reader);
                    }
                }
                return super.newBundle(baseName, locale, format, loader, reload);
            }
        });
    }
    
    public static String getString(String key, Object... args) {
        String pattern = bundle.getString(key);
        return java.text.MessageFormat.format(pattern, args);
    }

    public static void clear() {
        currentUser = null;
    }
}