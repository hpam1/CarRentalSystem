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
 * DAO for all queries related to the car instance table
 *
 */
public class CarInstanceDAO implements CarInstanceDAOInterface {
	
	/*
	 * (non-Javadoc)
	 * @see ssdi.carrentalsystem.dao.CarInstanceDAOInterface#fetchCarsForID(int)
	 */
	public List<String> fetchCarsForID(int carId) throws Exception {
		Connection conn = null;
		Statement stmnt;
		List<String> carInstanceList;
		try {
			conn = DBConnectorFactory.getInstance().getDBConnection();
			stmnt = conn.createStatement();
			carInstanceList = new ArrayList<String>();
			
			String query = "Select car_license_no from car_instance where car_id = " + carId;
			ResultSet rs = stmnt.executeQuery(query);
			while(rs != null && rs.next()) {
				carInstanceList.add(rs.getString(1));
			}
			if(carInstanceList == null || carInstanceList.size() < 1)
				throw new Exception(UserMessages.NO_CAR_EXISTS);
			return carInstanceList;
		} catch(Exception e) {
			e.printStackTrace();
			if(e.getMessage().equals(UserMessages.NO_CAR_EXISTS))
				throw e;
			throw new Exception(UserMessages.ERROR_CONNECTING_DB);
		} finally {
			if(conn != null)
				DBConnectorFactory.getInstance().closeDBConnection(conn);
		}
	}
	
	public int fetchCarId(String carRegistrationNo) throws Exception {
		Connection conn = null;
		Statement stmnt;
		int carId;
		try {
			conn = DBConnectorFactory.getInstance().getDBConnection();
			stmnt = conn.createStatement();
			
			String query = "Select car_id from car_instance where car_license_no = '" + carRegistrationNo + "' limit 1";
			System.out.println(query);
			ResultSet rs = stmnt.executeQuery(query);
			if(rs != null && rs.next()) {
				carId = rs.getInt(1);
			} else {
				throw new Exception(UserMessages.NO_CAR_EXISTS);
			}
			return carId;
		} catch(Exception e) {
			e.printStackTrace();
			if(e.getMessage().equals(UserMessages.NO_CAR_EXISTS))
				throw e;
			throw new Exception(UserMessages.ERROR_CONNECTING_DB);
		} finally {
			if(conn != null)
				DBConnectorFactory.getInstance().closeDBConnection(conn);
		}
	}
}