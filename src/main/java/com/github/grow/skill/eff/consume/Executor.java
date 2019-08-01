package com.github.grow.skill.eff.consume;

/**
 * 
 * @author ROCFLY ZHANGE PENGFEI
 */
public interface Executor {

	/**
	 * 
	 */
	public void start();

	/**
	 * 
	 */
	public void shutdown();

	/**
	 * 
	 * @param command 线程
	 */
	public void execute(Runnable command);

}
