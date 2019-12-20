package netty.game;

import java.util.Properties;

/** @author zwb */
public abstract class Config {

    protected final Properties properties;

    public Config() {
        properties = new Properties();
    }

    int getInteger(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
}
