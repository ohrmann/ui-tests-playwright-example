package settingsAndUtils;

import java.io.IOException;
import java.util.Properties;
/**
 * Class is for work with properties (like passwords, links, parameters etc.)
 * */
public class Configs {
    private Properties properties;

    public Configs() throws IOException {
        this("app.properties");
        Configs.class.getClassLoader().getResourceAsStream("app.properties");
    }

    public Configs(String props) throws IOException {
        properties = new Properties();
        properties.load( Configs.class.getClassLoader().getResourceAsStream(props));
    }

    public String getProperty(String propName) {
        if (System.getProperty(propName) != null) {
            return System.getProperty(propName);
        } else {
            return properties.getProperty(propName);
        }
    }
}
