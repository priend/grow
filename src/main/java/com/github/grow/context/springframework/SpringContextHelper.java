package com.github.grow.context.springframework;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 */
public class SpringContextHelper implements ApplicationContextAware {

	private static final ThreadLocal<ApplicationContext> currentContext;

	static {
		currentContext = new ThreadLocal<ApplicationContext>();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		currentContext.set(applicationContext);
	}

	/**
	 * @param <T> 类型
	 * @param t   实体
	 * @return T
	 */
	public static <T> T getBean(Class<T> t) {
		return currentContext.get().getBean(t);
	}

	/**
	 * @param <T>      类型
	 * @param beanName 类名
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		return (T) currentContext.get().getBean(beanName);
	}

}
