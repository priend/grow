package com.github.grow.skill.eff.consume;

/**
 * 
 * @author ROCFLY ZHANGE PENGFEI
 */
public interface Generant {

	/**
	 * 
	 * 方法说明：增加任务
	 * 
	 */
	public void run();

	/**
	 * 
	 * 方法说明：停止
	 * 
	 */
	public void interrupt();

	/**
	 * 
	 * 方法说明：设置暂停
	 * 
	 */
	public void suspend();

	/**
	 * 
	 * 方法说明：是否暂停
	 * 
	 * @return Boolean
	 */
	public Boolean isInterrupted();

	/**
	 * 
	 * 方法说明：外部结束时调用
	 * 
	 */
	public void disclose();

	/**
	 * 方法说明：线程活动时间 (ms)
	 * 
	 * @param frequencyMillis 时间
	 */
	public void setFrequencyMillis(Long frequencyMillis);
}
