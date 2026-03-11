package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public final class ConfigLoader {

    private static final String CONFIG_FILE = "/config.json";
    private static Config config;

    private ConfigLoader() {
    }

    public static Config getConfig() {
        if (config == null) {
            loadConfig();
        }
        return config;
    }

    private static void loadConfig() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = ConfigLoader.class.getResourceAsStream(CONFIG_FILE)) {
            if (is == null) {
                throw new IllegalStateException("Config file not found on classpath: " + CONFIG_FILE);
            }
            config = mapper.readValue(is, Config.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config from " + CONFIG_FILE, e);
        }
    }
}

