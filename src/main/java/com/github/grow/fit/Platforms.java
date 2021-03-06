package com.github.grow.fit;

import java.io.File;
import java.lang.management.ManagementFactory;

import com.github.grow.util.io.FileType;

/**
 * 变量
 *
 */
public class Platforms {

	// 文件路径分隔符
	public static final String FILE_PATH_SEPARATOR_1 = FileType.PATH_SEPARATOR;
	public static final char FILE_PATH_SEPARATOR_CHAR = File.separatorChar;
	public static final char WINDOWS_FILE_PATH_SEPARATOR_CHAR = '\\';
	public static final char LINUX_FILE_PATH_SEPARATOR_CHAR = '/';

	public static final String CLASS_PATH_SEPARATOR = "/";
	public static final char CLASS_PATH_SEPARATOR_CHAR = '/';

	public static final String USER_DIR = System.getProperty("user.dir");

	// 换行符,JDK7可使用System.lineSeparator()
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	//
	// // 临时目录
	// public static final String TMP_DIR = SystemUtils.JAVA_IO_TMPDIR;
	// // 当前应用的工作目录
	// public static final String WORKING_DIR = SystemUtils.USER_DIR;
	// // 用户 HOME目录
	// public static final String USER_HOME = SystemUtils.USER_HOME;
	// // Java HOME目录
	// public static final String JAVA_HOME = SystemUtils.JAVA_HOME;
	//
	// // Java版本
	// public static final String JAVA_SPECIFICATION_VERSION =
	// SystemUtils.JAVA_SPECIFICATION_VERSION; // e.g. 1.8
	// public static final String JAVA_VERSION = SystemUtils.JAVA_VERSION; //
	// e.g. 1.8.0_102
	// public static final boolean IS_JAVA6 = SystemUtils.IS_JAVA_1_6;
	// public static final boolean IS_JAVA7 = SystemUtils.IS_JAVA_1_7;
	// public static final boolean IS_JAVA8 = SystemUtils.IS_JAVA_1_8;
	// public static final boolean IS_ATLEASET_JAVA6 = IS_JAVA6 || IS_JAVA7 ||
	// IS_JAVA8;
	// public static final boolean IS_ATLEASET_JAVA7 = IS_JAVA7 || IS_JAVA8;
	// public static final boolean IS_ATLEASET_JAVA8 = IS_JAVA8;
	//
	// // 操作系统类型及版本
	// public static final String OS_NAME = SystemUtils.OS_NAME;
	// public static final String OS_VERSION = SystemUtils.OS_VERSION;
	// public static final String OS_ARCH = SystemUtils.OS_ARCH; // e.g. x86_64
	// public static final boolean IS_LINUX = SystemUtils.IS_OS_LINUX;
	// public static final boolean IS_UNIX = SystemUtils.IS_OS_UNIX;
	// public static final boolean IS_WINDOWS = SystemUtils.IS_OS_WINDOWS;

	public static final String SYSTME_CHARSETS = "UTF-8";

	/**
	 * 获得当前进程的PID
	 * 
	 * 当失败时返回-1
	 * 
	 * @return int
	 */
	public static int getPid() {
		// format: "pid@hostname"
		String name = ManagementFactory.getRuntimeMXBean().getName();
		String[] split = name.split("@");
		if (split.length != 2) {
			return -1;
		}

		try {
			return Integer.parseInt(split[0]);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * @return String
	 */
	public static String currentWorkPath() {

		return getParentClassPath(USER_DIR);
	}

	/**
	 * @return String
	 */
	public static String getClassPath() {
		return ClassLoader.getSystemResource("").getPath();
	}

	/**
	 * 获得上层目录的路径
	 * 
	 * @param path 路径
	 * @return String
	 */
	public static String getParentClassPath(String path) {
		String parentPath = path;

		if (Platforms.CLASS_PATH_SEPARATOR.equals(parentPath)) {
			return parentPath;
		}
		if (parentPath.endsWith(Platforms.CLASS_PATH_SEPARATOR)) {
			parentPath = parentPath.substring(0, parentPath.length() - 1);
		}
		int idx = parentPath.lastIndexOf(Platforms.CLASS_PATH_SEPARATOR_CHAR);
		if (idx >= 0) {
			parentPath = parentPath.substring(0, idx + 1);
		} else {
			parentPath = Platforms.CLASS_PATH_SEPARATOR;
		}

		return parentPath;
	}

}
