package payments.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class AppConfig {

    private static final String APPLICATION_PROPERTIES = "oauth.properties";
    private Properties properties;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    public void initConfig() {
	logger.info("Loading AppConfig");
	InputStream propertyStream = Thread.currentThread().getContextClassLoader()
		.getResourceAsStream(APPLICATION_PROPERTIES);

	if (propertyStream == null) {
	    logger.error("Application Properties was not found");
	    throw new RuntimeException("Application Properties was not found");
	}

	properties = new Properties();

	try {
	    properties.load(propertyStream);
	    logger.info("Properties Loaded");
	} catch (IOException e) {
	    logger.error("Properties Failed to load ", e.getMessage());
	    throw new RuntimeException("Could not load application properties");
	}
    }

    public String getConfigValue(String key) {
	if (!properties.containsKey(key))
	    throw new RuntimeException(key + " does not exist");

	return properties.getProperty(key);
    }
}
