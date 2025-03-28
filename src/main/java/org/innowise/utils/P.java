package org.innowise.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class P {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }

    public static String CONFIG(String key) {
        return properties.getProperty(key);
    }


}
