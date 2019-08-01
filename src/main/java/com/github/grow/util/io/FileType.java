package com.github.grow.util.io;

import java.io.File;

/**
 *
 * @author CMCC.HPE.Pactera.Zh
 */
public class FileType {

	public static final String PATH_SEPARATOR = File.separator;

	/**
	 * @param path 路径
	 * @return boolean
	 */
	public static boolean isFile(String path) {

		return visibleFile(path) == null ? false : true;

	}

	/**
	 * @param path 路径
	 * @return File
	 */
	public static File visibleFile(String path) {

		File f = new File(path);

		if (f.exists()) {
			return f;
		} else {
			return null;
		}
	}

	/**
	 * @param path     路径
	 * @param fileName 文件名称
	 * @return String
	 */
	public static String fileNamePath(String path, String fileName) {

		return path.endsWith(PATH_SEPARATOR) ? path + fileName : path + PATH_SEPARATOR + fileName;
	}
}
