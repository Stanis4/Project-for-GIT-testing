package com.alevel.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvConfig {

    private String webUrl;
    private int timeoutPageload;
    private int timeoutElemWait;

    public EnvConfig(String envName) {
        String path = System.getProperty("user.dir") + "/src/main/resources/config/"
                + envName + ".properties";

        Properties properties = loadProperties(path);
        webUrl = properties.getProperty("webUrl");
        timeoutPageload = Integer.parseInt(properties.getProperty("timeout.pageLoad"));
        timeoutElemWait = Integer.parseInt(properties.getProperty("timeout.elemWait"));
    }

    private Properties loadProperties(String path) {
        try (InputStream input = new FileInputStream(path)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            throw new IllegalArgumentException("Cannot read property file by specified path!", ex);
        }
    }

    public String getWebUrl() {
        return webUrl;
    }

    public int getTimeoutPageload() {
        return timeoutPageload;
    }

    public int getTimeoutElemWait() {
        return timeoutElemWait;
    }
}
