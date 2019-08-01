package com.github.grow.tack.dccp;

import java.util.Iterator;
import java.util.Map;

/**
 * 检查的的一些方式
 *
 */
public class CheckManager {

	protected CacheConfiguration configure;
	protected Map<Object, Element> map;

	/**
	 * @param configure 缓存配置
	 * @param map       存储
	 */
	public CheckManager(CacheConfiguration configure, Map<Object, Element> map) {
		this.map = map;
		this.configure = configure;
	}

	/**
	 * 添加检查元素是否已经到达最大值，或者已经过期
	 * 
	 * @param elementSize 添加元素最大值
	 * @return Object[]
	 */
	public Object[] checkConfigure(int elementSize) {
		int removeSize = map.size() + elementSize - configure.getMaxElementsInMemory();
		// 判断缓存是否已满
		if (removeSize > 0) {
			// 按规则删除元素，这里不写磁盘
			if (!configure.getDiskPersistent()) {
				return removeElementByEvictionType(removeSize);
			}
		}
		return null;
	}

	/**
	 * 根据方式移除
	 * 
	 * @param removeSize 异常元素大小
	 * @return Object[]
	 */
	public Object[] removeElementByEvictionType(int removeSize) {
		if (configure.getMemoryStoreEvictionPolicy().equals(EvictionType.LRU.name())) {
			return removeElementByLRU(removeSize);
		}
		return null;
	}

	/**
	 * 暂时默认根据最少使用次数进行删除
	 * 
	 * @param removeSize 最少使用次数 进行删除
	 * @return Object[]
	 */
	private Object[] removeElementByLRU(int removeSize) {
		Object keys[] = new Object[removeSize];
		long hits[] = new long[removeSize];
		Iterator<?> it = map.keySet().iterator();
		// 找出hit值最小的 removeSize 个元素
		int index = 0;
		while (it.hasNext()) {
			Object key = it.next();
			Element e = map.get(key);
			long hit = e.getHitCount();
			if (index < removeSize) {
				hits[index] = hit;
				keys[index] = key;
				index++;
			} else {
				long pos = getMinIndex(hits, hit);
				if (pos >= 0) {
					keys[(int) pos] = key;
				}
			}
		}
		return keys;
	}

	/**
	 * @param hits 数组
	 * @param hit  插入顺序
	 * @return long
	 */
	private long getMinIndex(long hits[], long hit) {
		long pos = -1;
		for (int i = 0; i < hits.length; i++) {
			if (hits[i] > hit) {
				hits[i] = hit;
				pos = i;
			}
		}
		return pos;
	}

}
