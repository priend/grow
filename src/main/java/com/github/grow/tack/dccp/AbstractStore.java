package com.github.grow.tack.dccp;

import java.util.Map;

/**
 * 简单实现
 *
 */
public abstract class AbstractStore implements Store {

	protected Map<Object, Element> map;

	public AbstractStore() {
	}

	public AbstractStore(Map<Object, Element> map) {
		this.map = map;
	}

	public Element get(Object key) {
		return map.get(key);
	}

	public Map<Object, Element> getAll() {
		return map;
	}

	public void clear() {
		map.clear();
	}

	public Element put(Element e) {
		return map.put(e.getKey(), e);
	}

	public void remove(Object key) {
		map.remove(key);
	}

	public Integer size() {
		return map.size();
	}

	public void removeAll(Object[] keys) {
		for (int i = 0; i < keys.length; i++) {
			remove(keys[i]);
		}
	}
}
