package com.karsun.fema.gmm.marquess.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;

public class LoadProperties {

	protected static Properties props;
	protected static Properties propswrite;
	static private Properties testProperties = null;

	public static String getProperty(String key) {
		if (testProperties == null) {
			LoadProperties.loadProperties();
		}
		return testProperties.getProperty(key);
	}

	/**
	 * Read configuration values from the stage.properties and driver.properties file
	 */
	public static void loadProperties() {
		try {
			InputStream inputStream = LoadProperties.class.getClassLoader()
					.getResourceAsStream("config/Application.properties");

			InputStream driverProp = LoadProperties.class.getClassLoader()
					.getResourceAsStream("driver.properties");
			testProperties = new Properties();
			testProperties.load(driverProp);
			testProperties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//////////////////////////////              ////////////////////////////////////////

public void storeProperties(String name, String value) {
	try {
		if (name.equals("accesstoken")) {
			propswrite = new Properties();
			Parameters params = new Parameters();
			FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(
					PropertiesConfiguration.class)
							.configure(params.properties().setFileName(System.getProperty("user.dir")
									.concat("/src/test/resources/config/stage.properties")));
			Configuration config = builder.getConfiguration();
			config.setProperty(name, value);
			builder.save();
		}

	} catch (Exception ioe) {
		System.out.println(ioe.getMessage());
	}
}

}
	
	

