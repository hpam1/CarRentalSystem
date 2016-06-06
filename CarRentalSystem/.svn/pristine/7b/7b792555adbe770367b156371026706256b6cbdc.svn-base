/**
 * 
 */
package ssdi.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ssdi.carrentalsystem.utils.DBConnectorFactory;

import com.mysql.jdbc.PreparedStatement;

/**
 * @author mounica
 * 
 * 
 *
 */
public class FinalInsertCarEstimateDetailsDAO {

	/*
	 * Given the search string , check in database
	 */
	public static void insertdetails(String LockedCar, String user,
			String startDate, String endDate) throws Exception {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Connection conn = DBConnectorFactory.getInstance().getDBConnection();
			java.sql.PreparedStatement pst = null;
			Statement statement = null;
			ResultSet rs = null;
			boolean flag = true;
			String today = dateFormat.format(new Date());
			
			String query = ("INSERT INTO car_rental_details(car_license_no,user_email,start_time,end_time, reserved_date) VALUES('" + LockedCar + "', '" + user + "', '" + startDate + "', '" + endDate + "', '"
					+ today + "')");
			System.out.println(query);
			Connection con2 = DBConnectorFactory.getInstance().getDBConnection();
			statement = conn.createStatement();
			statement.executeUpdate(query.toString());

			statement.close();
			conn.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void DeleteValues(String LockedCar,String startDate,String endDate) throws Exception
	{
		try {
			Connection conn = DBConnectorFactory.getInstance().getDBConnection();
			java.sql.PreparedStatement pst = null;
			Statement ps2 = null;
			ResultSet rs = null;
			boolean flag = true;
			String delquery=("DELETE from car_lock_details where Car_license_no= '"+LockedCar+"' and Start_Date='"+startDate+"' and End_Date='"+endDate+"'");

			Connection con2 = DBConnectorFactory.getInstance().getDBConnection();
			ps2 = con2.createStatement();
			//rs = ps2.executeQuery(delquery);
			pst = conn.prepareStatement(delquery);
			flag = pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
