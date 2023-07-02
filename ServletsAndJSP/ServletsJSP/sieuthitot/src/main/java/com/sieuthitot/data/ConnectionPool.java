package com.sieuthitot.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionPool {
	
	private static final String DB_URL = "db.url";
	private static final String DB_USERNAME = "db.username";
	private static final String DB_PASSWORD = "db.password";
	
	private static Properties properties = null;
	private static ConnectionPool pool = null;
	private static MysqlDataSource dataSource = null;
	
	private ConnectionPool() {
		try {
			File filePath = new File(ConnectionPool.class.getResource("/database.properties").getFile());

			properties = new Properties();
			properties.load(new FileInputStream(filePath.getAbsoluteFile()));
			
			dataSource = new MysqlDataSource();
			dataSource.setUrl(properties.getProperty(DB_URL));
			dataSource.setUser(properties.getProperty(DB_USERNAME));
			dataSource.setPassword(properties.getProperty(DB_PASSWORD));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Make sure only one instance of ConnectionPool class to be created
	 * @return the ConnectionPool
	 */
	public static synchronized ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}








