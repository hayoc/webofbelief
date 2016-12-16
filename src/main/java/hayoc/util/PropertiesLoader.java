package hayoc.util;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Hayo on 14/12/2016.
 */
public class PropertiesLoader {

    private static final Logger LOG = Logger.getLogger(PropertiesLoader.class);

    private Properties properties;

    public PropertiesLoader(String file) {
        properties = new Properties();
        try {
            InputStream stream = ClassLoader.getSystemResourceAsStream(file);
            properties.load(stream);
        } catch (IOException ex) {
            LOG.error("Failed to load properties file - " + file + "\n" + ex);
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
