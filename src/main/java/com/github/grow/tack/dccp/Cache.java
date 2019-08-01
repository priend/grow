package com.github.grow.tack.dccp;

/**
 * 缓存 级的控制判断
 *
 */
public class Cache extends MemoryCache {

	private CacheConfiguration configure;
	private CacheListener listener;

	public Cache(CacheConfiguration configure) {
		super(configure);
		this.configure = configure;
		if (!configure.getEternal() && configure.getIsNeedCacheCheckListener()) {
			listener = new CacheListener(this);
			listener.start();
		}
	}

	/**
	 * @return CacheConfiguration
	 */
	public CacheConfiguration getConfigure() {
		return configure;
	}

	/**
	 * 销毁
	 */
	public void destory() {
		try {
			super.clear();
			if (listener != null) {
				listener.interrupt();
				listener = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
