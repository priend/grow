package com.github.grow.skill.eff.consume;

/**
 * 
 * @author ROCFLY ZHANGE PENGFEI
 */
public interface EventTask<T> {

	/**
	 * @param ctx 上下文事件
	 * @return T
	 * @throws Exception 处理异常
	 */
	T doInContext(EventContext ctx) throws Exception;
}
