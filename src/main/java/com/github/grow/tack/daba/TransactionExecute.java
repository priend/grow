package com.github.grow.tack.daba;

import java.sql.SQLException;

/**
 *
 */
public class TransactionExecute {

	public int TRANSACTION_READ_UNCOMMITTED = 1;
	public int TRANSACTION_READ_COMMITTED = 2;
	public int TRANSACTION_REPEATABLE_READ = 4;
	public int TRANSACTION_SERIALIZABLE = 8;

	private ConnectionDispersed connectionDispersed = ConnectionDispersed.getInstance();

	/**
	 * @throws SQLException 数据库异常
	 */
	public void open() throws SQLException {

		this.connectionDispersed.getConn().setAutoCommit(false);
	}

	/**
	 * 开启事务
	 * 
	 * @param level 事务等级
	 * @throws SQLException 数据库异常
	 */
	public void open(Integer level) throws SQLException {

		this.open();

		if (null != level) {
			this.connectionDispersed.getConn().setTransactionIsolation(level);
		}
	}

	/**
	 * 
	 * @throws SQLException 数据库异常
	 */
	public void commit() throws SQLException {

		this.connectionDispersed.commit();
	}

	/**
	 * 
	 * @throws SQLException 数据库异常
	 */
	public void rollback() throws SQLException {

		this.connectionDispersed.rollback();
	}

	/**
	 * @throws SQLException 数据库异常
	 */
	public void close() throws SQLException {

		this.connectionDispersed.close();
	}
}
