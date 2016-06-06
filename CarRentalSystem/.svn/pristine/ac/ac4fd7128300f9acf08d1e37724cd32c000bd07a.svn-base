/**
 * 
 */
package ssdi.carrentalsystem.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author haarthi
 * 
 *         DBConnector is a utility class for connecting with the database
 */
public class DBConnectorFactory {
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_URL = "";

	// Database credentials
	private static String USER = "";
	private static String PASS = "";
	private static DBConnectorFactory connectionInstance;

	private DBConnectorFactory() {
		try {
			readProperties();
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readProperties() throws Exception {
		String propFileName = "DBConfig.properties";
		Properties prop = new Properties();
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		 
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		DB_URL = prop.getProperty("DB_URL");
		USER = prop.getProperty("USER");
		PASS = prop.getProperty("PASS");
		System.out.println(DB_URL + " " + USER + " " + PASS);
	}
	
	/*
	 * create a connection with the database
	 */
	/*public Connection getDBConnection(String mode) throws Exception {
		readProperties(mode);
		Connection conn;
		System.out.println("Connecting to the database");
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(UserMessages.ERROR_CONNECTING_DB);
		}
	}*/

	public Connection getDBConnection() throws Exception {
				
		Connection conn;
		System.out.println("Connecting to the database");
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(UserMessages.ERROR_CONNECTING_DB);
		}
	}
	/*
	 * Close the DB connection
	 */
	public void closeDBConnection(Connection conn) throws Exception {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception se) {
			se.printStackTrace();
			throw new Exception(UserMessages.ERROR_CONNECTING_DB);
		}
	}

	public static DBConnectorFactory getInstance() {
		if (connectionInstance == null) {
			connectionInstance = new DBConnectorFactory();
		}
		return connectionInstance;
	}
}