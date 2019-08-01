package com.github.grow.tack.dccp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 缓存核心类
 * 
 */
public class CacheManager {
	/**
	 * 默认单例
	 */
	private CacheManager() {
	}

	private static class Singleton {
		private static CacheManager instance = new CacheManager();
	}

	/**
	 * @return CacheManager
	 */
	public static CacheManager getInstance() {
		return Singleton.instance;
	}

	public static Map<String, Cache> MAP_NAMES_CACHE = new HashMap<String, Cache>();

	/**
	 * 存放 取出 缓存对象
	 * 
	 * @param CacheName 缓存名称
	 * @return Cache
	 */
	public Cache getCache(String CacheName) {
		Cache cache = MAP_NAMES_CACHE.get(CacheName);
		return cache;
	}

	/**
	 * @param cache 缓存
	 */
	public void putCache(Cache cache) {
		if (cache != null && !MAP_NAMES_CACHE.containsKey(cache.getName())) {
			MAP_NAMES_CACHE.put(cache.getName(), cache);
		}
	}

	/**
	 * 移除
	 * 
	 * @param cacheName 缓存名称
	 */
	public void remove(String cacheName) {
		Cache c = MAP_NAMES_CACHE.remove(cacheName);
		c.destory();
	}

	/**
	 * 关闭所有缓存
	 */
	public void shutDown() {
		removeAllCaches();
		MAP_NAMES_CACHE.clear();
	}

	/**
	 * 移除所有
	 */
	public void removeAllCaches() {
		String[] cacheNames = getCacheNames();
		for (String cacheName : cacheNames) {
			remove(cacheName);
		}
	}

	/**
	 * 获得名字
	 * 
	 * @return String[]
	 */
	public String[] getCacheNames() {
		return MAP_NAMES_CACHE.keySet().toArray(new String[0]);
	}

}
