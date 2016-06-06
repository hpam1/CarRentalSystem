/**
 * 
 */
package ssdi.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ssdi.carrentalsystem.utils.DBConnectorFactory;

import com.mysql.jdbc.PreparedStatement;

/**
 * @author mounica
 * 
 * 
 *
 */
public class DeleteUserDAO {

	/*
	 * Given the search string , check in database
	 */
	
	public static void DeleteUser(String user) throws Exception
	{
		try {
			Connection conn = DBConnectorFactory.getInstance().getDBConnection();
			java.sql.PreparedStatement pst = null;
			Statement ps2 = null;
			ResultSet rs = null;
			boolean flag = true;
            String delquery=("DELETE from user_details where emailid='"+user+"'");
			Connection con2 = DBConnectorFactory.getInstance().getDBConnection();
			ps2 = con2.createStatement();
			//rs = ps2.executeQuery(delquery);
			pst = conn.prepareStatement(delquery);
			flag = pst.execute();
			pst.close();
			conn.close();

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
	public static void Deletelogindetails(String user) throws Exception
	{
		try {
			Connection conn = DBConnectorFactory.getInstance().getDBConnection();
			java.sql.PreparedStatement pst = null;
			Statement ps2 = null;
			ResultSet rs = null;
			boolean flag = true;
            String delquery1=("DELETE from login_details where username='"+user+"'");
			Connection con2 = DBConnectorFactory.getInstance().getDBConnection();
			ps2 = con2.createStatement();
			//rs = ps2.executeQuery(delquery1);
			pst = conn.prepareStatement(delquery1);
			flag = pst.execute();
			pst.close();
			conn.close();

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
	}
