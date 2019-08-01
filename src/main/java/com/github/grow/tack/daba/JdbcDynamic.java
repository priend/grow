package com.github.grow.tack.daba;

import java.util.HashMap;
import java.util.Map;

/**
 * JDBC配置
 *
 */
public class JdbcDynamic {

	private String driver;
	private String url;
	private String username;
	private String password;

	private Map<String, JdbcDynamic> dataSources = new HashMap<String, JdbcDynamic>();
	private static final JdbcDynamic instance = new JdbcDynamic();

	private JdbcDynamic() {
	}

	/**
	 * @return JdbcDynamic
	 */
	public static JdbcDynamic getInstance() {
		return instance;
	}

	/**
	 * @param sourceName 数据源名称
	 * @param driver     驱动
	 * @param url        链接字符串
	 * @param username   用户名
	 * @param password   密码
	 */
	public void addDataSource(String sourceName, final String driver, final String url, final String username,
			final String password) {

		JdbcDynamic jdbcDynamic = new JdbcDynamic();
		jdbcDynamic.setDriver(driver);
		jdbcDynamic.setUrl(url);
		jdbcDynamic.setUsername(username);
		jdbcDynamic.setPassword(password);
		dataSources.put(sourceName, jdbcDynamic);
	}

	/**
	 * @param sourceName 数据源名称
	 */
	public void initDataSource(String sourceName) {

		JdbcDynamic jdbcDynamic = dataSources.get(sourceName);
		if (null != jdbcDynamic) {
			this.setDriver(jdbcDynamic.getDriver());
			this.setUrl(jdbcDynamic.getUrl());
			this.setUsername(jdbcDynamic.getUsername());
			this.setPassword(jdbcDynamic.getPassword());
		}
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
