
import java.io.*;
import java.util.*;

/**
 * 
 */
public class LanguageSingleton implements Serializable {
    private static final long serialVersionUID = 1L;
    public LanguageSingleton() {
    }

    /**
     * 
     */
    private void static LanguageManager instance;

    /**
     * 
     */
    private void Locale currentLocale;

    /**
     * 
     */
    private void ResourceBundle bundle;


    /**
     * @param Lang lang 
     * @return
     */
    public void setLanguage(void Lang lang) {
        // TODO implement here
        return null;
    }

    /**
     * @param String key 
     * @return
     */
    public String getString(void String key) {
        // TODO implement here
        return "";
    }

}