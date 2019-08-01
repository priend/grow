package com.github.grow.tack.daba;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rocfly.zhang
 */
public class ProxyTransaction {

	private static final Logger logger = LoggerFactory.getLogger(ProxyTransaction.class);
	private Integer level;
	private TransactionExecute transactionExecute;

	public ProxyTransaction() {

		transactionExecute = new TransactionExecute();
	}

	/**
	 * @throws SQLException 数据库异常
	 */
	private void openConnection() throws SQLException {

		if (null == level) {
			this.transactionExecute.open();
		} else {
			this.transactionExecute.open(level);
		}
	}

	/**
	 * @param level 事务等级
	 */
	public void setLevel(Integer level) {

		this.level = level;
	}

	/**
	 * @param <T>    泛化类
	 * @param target 执行对象
	 * @return ExecuteCall
	 * @throws SQLException 执行sql 异常
	 */
	public <T extends ExecuteCall> T getProxyInstance(final T target) throws SQLException {

		try {
			ProxyTransaction.this.openConnection();

			target.doTransaction();

			ProxyTransaction.this.transactionExecute.commit();
			logger.info("database success ");
		} catch (Throwable se) {
			ProxyTransaction.this.transactionExecute.rollback();
			logger.error("commit error ", se);
		} finally {
			ProxyTransaction.this.transactionExecute.close();
			logger.info("database close ");
		}
		return target;
	}
}
