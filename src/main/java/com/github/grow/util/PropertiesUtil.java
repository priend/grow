package com.github.grow.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 */
public class PropertiesUtil {

	private static Map<String, String> propertiesMap = new HashMap<String, String>();

	private static class PropertiesInstance {

		private static final PropertiesUtil props = new PropertiesUtil();
	}

	/**
	 * @return PropertiesUtil
	 */
	public static PropertiesUtil getInstance() {
		return PropertiesInstance.props;
	}

	/**
	 * @param p 属性
	 */
	public void addProperties(Properties p) {

		if (null == p) {
			return;
		}
		for (Enumeration<?> e = p.propertyNames(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			propertiesMap.put(key, p.getProperty(key));
		}
	}

	/**
	 * @param key 键
	 */
	public void getElement(String key) {

		propertiesMap.get(key);
	}
}
