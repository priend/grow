package com.github.grow.tack.daba;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理对象的
 *
 * @author rocfly.zhang
 */
public class JdbcClass {

	private static final JdbcClass instance = new JdbcClass();

	// private static final String SETTER_PREFIX = "set";
	private static final String GETTER_PREFIX = "get";

	private JdbcClass() {
	}

	public static JdbcClass getInstance() {

		return instance;
	}

	/**
	 * @param <T> 类型
	 * @param t   实体
	 * @throws Exception 异常
	 */
	public <T> void save(T t) throws Exception {

		StringBuffer strSQL = new StringBuffer("INSERT INTO " + this.getObjectToTableName(t.getClass()));
		StringBuffer sbFiled = new StringBuffer();
		StringBuffer sbValues = new StringBuffer();
		List<Object> params = new ArrayList<Object>();

		for (Map.Entry<String, Object> entry : this.fieldNameValue(t).entrySet()) {
			if (sbFiled.indexOf(",") > -1) {
				sbFiled.append(",");
				sbValues.append(",");
			}
			sbFiled.append(entry.getKey());
			sbValues.append("?");
			params.add(entry.getValue());
		}
		strSQL.append(" ( ").append(sbFiled.toString()).append(" ) ").append("VALUES");
		strSQL.append(" ( ").append(sbValues.toString()).append(" ) ");

		JdbcExecute.doUpdate(strSQL.toString(), params);
	}

	/**
	 * @param <T> 泛化
	 * @param t   实体
	 * @return Map
	 * @throws Exception
	 */
	private <T> Map<String, Object> fieldNameValue(T t) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		for (Method method : t.getClass().getMethods()) {
			if (method.getName().startsWith(GETTER_PREFIX)) {
				map.put(stringAddUnderline(method.getName().toLowerCase().replaceFirst(GETTER_PREFIX, "")),
						method.invoke(t));
			}
		}
		return map;
	}

	/**
	 * @param str 字符串
	 * @return String
	 */
	private String stringAddUnderline(String str) {

		StringBuffer temStr = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (i != 0 && Character.isUpperCase(ch)) {
				temStr.append("_").append(ch);
			} else {
				temStr.append(ch);
			}
		}
		return temStr.toString();
	}

	/**
	 * @param clazz 类性
	 * @return String
	 */
	private String getObjectToTableName(Class<?> clazz) {
		return stringAddUnderline(clazz.getSimpleName());
	}

	// private String capitalize(final String str) {
	//
	// int strLen;
	// if (str == null || (strLen = str.length()) == 0)
	// {
	// return str;
	// }
	//
	// final char firstChar = str.charAt(0);
	// final char newChar = Character.toTitleCase(firstChar);
	// if (firstChar == newChar)
	// {
	// return str;
	// }
	//
	// char[] newChars = new char[strLen];
	// newChars[0] = newChar;
	// str.getChars(1, strLen, newChars, 1);
	// return String.valueOf(newChars);
	// }
}
