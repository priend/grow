package com.github.grow.util;

/**
 *
 */
public class StringUtils {
	/**
	 * @param cs 字符串
	 * @return boolean
	 */
	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	/**
	 * @param cs 字符串
	 * @return boolean
	 */
	public static boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}
}
