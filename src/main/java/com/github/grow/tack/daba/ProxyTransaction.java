package com.github.grow.tack.daba;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @file ProxyExecuteTransaction.java
 * @author rocfly.zhang
 * @dateTime 2017年10月30日 下午5:08:28
 */
public class ProxyTransaction {

	private static final Logger logger = LoggerFactory.getLogger(ProxyTransaction.class);
	private Integer level;
	private TransactionExecute transactionExecute;

	public ProxyTransaction() {

		transactionExecute = new TransactionExecute();
	}

	/**
	 * @throws SQLException
	 */
	private void openConnection() throws SQLException {

		if (null == level) {
			this.transactionExecute.open();
		} else {
			this.transactionExecute.open(level);
		}
	}

	/**
	 * @param level
	 */
	public void setLevel(Integer level) {

		this.level = level;
	}

	/**
	 * @param target
	 * @return
	 * @throws SQLException
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
