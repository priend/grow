package com.github.grow.context.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.github.grow.fit.Platforms;
import com.github.grow.util.StringUtils;

/**
 *
 */
public class ConfigLog4j {

	private static final String LOG4J_PROPERITES = "log4j.properties";

	/**
	 * @param path 路径
	 */
	public static void loadLogConfigurator(String path) {

		if (StringUtils.isEmpty(path)) {
			loadLogConfigurator();
		} else {
			PropertyConfigurator.configure(path);
		}

	}

	/**
	 * 
	 */
	public static void loadLogConfigurator() {

		PropertyConfigurator.configure(Platforms.getClassPath().concat(LOG4J_PROPERITES));
	}

	/**
	 * @param debug 对象
	 */
	public static void debug(Object debug) {

		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		Logger logger = Logger.getLogger(stack[1].getClassName());
		logger.log(ConfigLog4j.class.getName(), Level.DEBUG, debug, null);
	}

	/**
	 * @param info 对象
	 */
	public static void info(Object info) {

		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		Logger logger = Logger.getLogger(stack[1].getClassName());
		logger.log(ConfigLog4j.class.getName(), Level.INFO, info, null);
	}

	/**
	 * @param error 对象
	 */
	public static void error(Object error) {

		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		Logger logger = Logger.getLogger(stack[1].getClassName());
		logger.log(ConfigLog4j.class.getName(), Level.ERROR, error, null);
	}

	/**
	 * @param debug     对象
	 * @param throwable 异常对象
	 */
	public static void debug(Object debug, Throwable throwable) {

		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		Logger logger = Logger.getLogger(stack[1].getClassName());
		logger.log(ConfigLog4j.class.getName(), Level.DEBUG, debug, throwable);
	}

	/**
	 * @param info      对象
	 * @param throwable 异常对象
	 */
	public static void info(Object info, Throwable throwable) {

		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		Logger logger = Logger.getLogger(stack[1].getClassName());
		logger.log(ConfigLog4j.class.getName(), Level.INFO, info, throwable);
	}

	/**
	 * @param error     对象
	 * @param throwable 异常对象
	 */
	public static void error(Object error, Throwable throwable) {

		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		Logger logger = Logger.getLogger(stack[1].getClassName());
		logger.log(ConfigLog4j.class.getName(), Level.ERROR, error, throwable);
	}

}
