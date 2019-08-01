package com.github.grow.tack.dccp;

import java.util.Collection;

public interface Store {

	/**
	 * 
	 * @param elements 元素
	 * @return 数组
	 */
	public Collection<Element> putAll(Collection<Element> elements);

	/**
	 * 获得缓存名字
	 * 
	 * @return String
	 */
	public String getName();

	/**
	 * 存放
	 * 
	 * @param e 元素
	 * @return Element
	 */
	public Element put(Element e);

	/**
	 * 获取
	 * 
	 * @param key 键
	 * @return Element
	 */
	public Element get(Object key);

	/**
	 * 移除
	 * 
	 * @param key 键
	 */
	public void remove(Object key);

	/**
	 * @param keys 键
	 */
	public void removeAll(Object[] keys);

	/**
	 * 清除
	 */
	public void clear();

	/**
	 * 获得的元素
	 * 
	 * @return Integer
	 */
	public Integer size();
}
