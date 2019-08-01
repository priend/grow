package com.github.grow.context.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * LOG4J2
 *
 */
public class ConfigLog4j2 {

	private static final String DEFAULT_LOG4J_2_PAHT = "log4j2.xml";

	/**
	 * 
	 */
	public static void loadLogConfigurator() {
		try {
			Configurator.initialize(null, new ConfigurationSource(new FileInputStream(new File(DEFAULT_LOG4J_2_PAHT))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param url 加载URL
	 */
	public static void loadLogConfigurator(URL url) {

		try {
			Configurator.initialize(null, new ConfigurationSource(new FileInputStream(new File(url.getPath())), url));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param path 加载路径
	 */
	public static void loadLogConfigurator(String path) {

		try {
			File file = new File(path);
			Configurator.initialize(null, new ConfigurationSource(new FileInputStream(file), file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
