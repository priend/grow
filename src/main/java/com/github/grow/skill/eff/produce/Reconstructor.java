package com.github.grow.skill.eff.produce;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.github.grow.skill.eff.consume.EventContext;
import com.github.grow.skill.eff.consume.EventExecutor;
import com.github.grow.skill.eff.consume.GenerantSingle;

/**
 * 
 */
public class Reconstructor {

	private static Reconstructor instance;
	private Queue<Resource<?>> resources;

	/**
	 * 
	 */
	private Reconstructor() {
		resources = new ConcurrentLinkedQueue<Resource<?>>();
	}

	/**
	 * @return Reconstructor
	 */
	public static Reconstructor getInstance() {
		if (null == instance) {
			instance = new Reconstructor().worker();
		}
		return instance;
	}

	/**
	 * @param <T>      实体
	 * @param resource 实体类
	 */
	public <T extends Resource<T>> void cleanResource(T resource) {
		resources.add(resource);
	}

	/**
	 * @return Reconstructor
	 */
	private Reconstructor worker() {
		new GenerantSingle(new EventExecutor(), new Reconstructor.EventTask()).run();
		return this;
	}

	/**
	 * 
	 * @author ROCFLY ZHANGE PENGFEI
	 */
	private class EventTask implements EventContext {

		@Override
		public Boolean task() {
			if (resources.size() >= 1) {
				resources.poll().detach();
				return true;
			}
			return false;
		}

		@Override
		public void close() {
			System.out.println("线程结束: " + new Date(System.currentTimeMillis()));
		}
	}
}
