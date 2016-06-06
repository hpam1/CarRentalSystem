/**
 * 
 */
package ssdi.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import ssdi.carrentalsystem.io.LoginIO;
import ssdi.carrentalsystem.utils.DBConnectorFactory;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * @author haarthi
 * 
 * Database utility class for all queries
 *
 */
public class LoginDAO {
	
	/*
	 * Given the user login details, query the database table for its correctness
	 */
	public LoginIO validateLoginDetails(LoginIO loginIO) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBConnectorFactory.getInstance().getDBConnection();
			stmt = conn.createStatement();
		    String sql = "select * from login_details where username = '" + loginIO.getUserName() + "' and password = '" + loginIO.getPassword() + "'";
		    ResultSet rs = stmt.executeQuery(sql);

		    if(rs != null && rs.next()) {
		        String role = rs.getString("role");
		    	loginIO.setRole(role);
		    	return loginIO;
		    } else {
		    	throw new Exception(UserMessages.INVALID_USER_PWD);
		    }
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(conn != null) {
				DBConnectorFactory.getInstance().closeDBConnection(conn);
			}
		}
	}
}