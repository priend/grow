package com.github.grow.context.data;

import java.util.Properties;

import com.github.grow.tack.base.PropertiesLoader;
import com.github.grow.tack.daba.JdbcDynamic;

/**
 * 数据源
 *
 * @author rocfly.zhang
 */
public class DBContextHolder {

	public static final String USER_GROUP_1 = "user1";
	public static final String USER_GROUP_2 = "user2";
	public static final String USER_GROUP_3 = "user3";

	private static final String DB_FILE = "db.properties";
	private Properties properties;

	/**
	 * 
	 */
	public DBContextHolder() {
		properties = PropertiesLoader.fromFile(DB_FILE);
	}

	/**
	 * 
	 */
	public void init() {

		String driver = properties.getProperty("db.driver");
		String url = properties.getProperty("db.user1.url");
		String username = properties.getProperty("db.user1.username");
		String password = properties.getProperty("db.user1.password");
		JdbcDynamic.getInstance().addDataSource(USER_GROUP_1, driver, url, username, password);

		driver = properties.getProperty("db.driver");
		url = properties.getProperty("db.user2.url");
		username = properties.getProperty("db.user2.username");
		password = properties.getProperty("db.user2.password");
		JdbcDynamic.getInstance().addDataSource(USER_GROUP_2, driver, url, username, password);

		driver = properties.getProperty("db.driver");
		url = properties.getProperty("db.user3.url");
		username = properties.getProperty("db.user3.username");
		password = properties.getProperty("db.user3.password");
		JdbcDynamic.getInstance().addDataSource(USER_GROUP_3, driver, url, username, password);
	}

	/**
	 * @param type 类型
	 */
	public static void setDBType(String type) {
		JdbcDynamic.getInstance().initDataSource(type);
	}

}
