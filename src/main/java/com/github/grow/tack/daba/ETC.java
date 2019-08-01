package com.github.grow.tack.daba;

/**
 *
 * @author rocfly.zhang
 */
public abstract class ETC implements ExecuteCall {

	public ETC() throws Exception {

		new ProxyTransaction().getProxyInstance(this);
	}
}
