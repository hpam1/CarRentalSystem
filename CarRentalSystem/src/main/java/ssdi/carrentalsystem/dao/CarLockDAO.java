/**
 * 
 */
package ssdi.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ssdi.carrentalsystem.utils.DBConnectorFactory;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * @author haarthi
 * 
 * DAO for all queries related to Car_lock_details table
 *
 */
public class CarLockDAO implements CarLockDAOInterface {
	/*
	 * (non-Javadoc)
	 * @see ssdi.carrentalsystem.dao.CarLockDAOInterface#fetchLockedCars(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<String> fetchLockedCars(String carRegistrationNo, String startDate, String endDate) throws Exception {
		Connection conn = null;
		Statement stmnt = null;
		List<String> rentedCars = null;
		try {
			conn = DBConnectorFactory.getInstance().getDBConnection();
			stmnt = conn.createStatement();
			String query = "select car_license_no from car_lock_details where car_license_no = '" + carRegistrationNo + "' and "
					+ "(('" + startDate + "' >= start_date and '" + startDate + "' <= end_date) or ('" + endDate + "' >= start_date and '"
							+ endDate + "' <= end_date) or ('" + startDate + "' <= start_date and '" + endDate + "' >= end_date))";
			ResultSet rs = stmnt.executeQuery(query);
			while(rs!= null && rs.next()) {
				if(rentedCars == null)
					rentedCars = new ArrayList<String>();
				rentedCars.add(rs.getString(1));
			}
			return rentedCars;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception(UserMessages.ERROR_CONNECTING_DB);
		} finally {
			if(conn != null)
				DBConnectorFactory.getInstance().closeDBConnection(conn);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ssdi.carrentalsystem.dao.CarLockDAOInterface#lockCar(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void lockCar(String carRegistrationNo, String startDate, String endDate) throws Exception {
		Connection conn = null;
		Statement stmnt = null;
		try {
			conn = DBConnectorFactory.getInstance().getDBConnection();
			stmnt = conn.createStatement();
			String query = "insert into car_lock_details (car_license_no, start_date,end_date) values('" + carRegistrationNo + "','" + startDate + "','" + endDate + "')";
			System.out.println(query);
			int status = stmnt.executeUpdate(query);
			if(status != 1)
				throw new Exception(UserMessages.ERROR_CONNECTING_DB);
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception(UserMessages.ERROR_CONNECTING_DB);
		} finally {
			if(conn != null)
				DBConnectorFactory.getInstance().closeDBConnection(conn);
		}
	}
}