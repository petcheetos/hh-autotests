package org.example.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/configuration.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);

            for (String name : PROPERTIES.stringPropertyNames()) {
                String value = PROPERTIES.getProperty(name);
                if (value.startsWith("${") && value.endsWith("}")) {
                    String envVar = value.substring(2, value.length() - 1);
                    String envValue = System.getenv(envVar);
                    if (envValue != null) {
                        PROPERTIES.setProperty(name, envValue);
                    } else {
                        throw new IllegalStateException("Environment variable " + envVar + " not set");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
