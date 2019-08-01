package com.github.grow.tack.base;

import java.util.HashMap;
import java.util.Map;

import com.github.grow.util.StringUtils;

/**
 *
 * @author CMCC.HPE.Pactera.Zh
 */
public class Envariables {

	private static Map<String, String> ENVAS_MAP = new HashMap<String, String>();

	private static class EnvariablesInstance {

		private static final Envariables ENVARIABLES = new Envariables();
	}

	/**
	 * @return Envariables
	 */
	public static Envariables getInstance() {

		return EnvariablesInstance.ENVARIABLES;
	}

	/**
	 * @param key   键
	 * @param value 值
	 */
	public void setSystemProperty(String key, String value) {

		if (StringUtils.isEmpty(ENVAS_MAP.get(key))) {
			ENVAS_MAP.put(key, value);
		}
		{
			System.setProperty(key, ENVAS_MAP.get(key));
		}
	}

	/**
	 * @param key 键
	 * @return String
	 */
	public String getUserSystemProperty(String key) {

		if (StringUtils.isEmpty(ENVAS_MAP.get(key))) {
			return null;
		} else {
			return ENVAS_MAP.get(key);
		}
	}
}
