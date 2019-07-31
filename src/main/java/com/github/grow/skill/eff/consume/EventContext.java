package com.github.grow.skill.eff.consume;

/**
 * 
 * @file EventContext.java
 * @author ROCFLY ZHANGE PENGFEI
 * @dateTime 2014年7月16日 下午5:58:21
 */
public interface EventContext {

	/**
	 * @return
	 */
	public Boolean task();

	/**
	 * 
	 */
	public void close();
}
