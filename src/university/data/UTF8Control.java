package university.data;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class UTF8Control extends ResourceBundle.Control {

    @Override
    public ResourceBundle newBundle(
            String baseName,
            Locale locale,
            String format,
            ClassLoader loader,
            boolean reload)
            throws IllegalAccessException,
                   InstantiationException,
                   IOException {

        String bundleName = toBundleName(baseName, locale);
        String resourceName = toResourceName(bundleName, "properties");

        InputStream stream = null;

        if (reload) {
            URL url = loader.getResource(resourceName);

            if (url != null) {
                URLConnection connection = url.openConnection();

                if (connection != null) {
                    connection.setUseCaches(false);
                    stream = connection.getInputStream();
                }
            }
        } else {
            stream = loader.getResourceAsStream(resourceName);
        }

        if (stream == null) {
            return null;
        }

        try (InputStreamReader reader =
                     new InputStreamReader(stream, StandardCharsets.UTF_8)) {

            return new PropertyResourceBundle(reader);
        }
    }
}