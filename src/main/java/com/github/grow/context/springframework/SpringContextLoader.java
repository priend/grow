package com.github.grow.context.springframework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author CMCC.HPE.Pactera.Zh
 */
public class SpringContextLoader {

	private ApplicationContext initApplicationContext;

	public SpringContextLoader() {

	}

	/**
	 * @param path 路径
	 */
	public void initClassPathXmlApplicationContext(String... path) {
		initApplicationContext = new ClassPathXmlApplicationContext(path);
	}

	/**
	 * @return ApplicationContext
	 */
	public ApplicationContext getInitApplicationContext() {
		return initApplicationContext;
	}

	/**
	 * @param initApplicationContext 实体上下文
	 */
	public void setInitApplicationContext(ApplicationContext initApplicationContext) {
		this.initApplicationContext = initApplicationContext;
	}
}
