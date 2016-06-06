/**
 * 
 */
package ssdi.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import ssdi.carrentalsystem.io.Car;
import ssdi.carrentalsystem.utils.DBConnectorFactory;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * @author haarthi
 * 
 * DAO for all queries related to Car table
 *
 */
public class CarDAO implements CarDAOInterface {
	
	/*
	 * (non-Javadoc)
	 * @see ssdi.carrentalsystem.dao.CarDAOInterface#fetchCar(int)
	 */
	public Car fetchCar(int carId) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		Car car = null;
		try {
			car = new Car();
			conn = DBConnectorFactory.getInstance().getDBConnection();
			stmt = conn.createStatement();
		    String sql = "select make, model, type,rental_cost, insurance_cost, description from car where car_id = " + carId;
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    if(rs != null && rs.next()) {
		    	car.setMake(rs.getString(1));
		    	car.setModel(rs.getString(2));
		    	car.setCarType(rs.getString(3));
		    	car.setRentalCost(rs.getDouble(4));
		    	car.setInsuranceCost(rs.getDouble(5));
		    	car.setCarDescription(rs.getString(6));
		    	return car;
		    } else {
		    	throw new Exception(UserMessages.NO_CAR_EXISTS);
		    }
		} catch(Exception e) {
			e.printStackTrace();
			if(e.getMessage().equals(UserMessages.NO_CAR_EXISTS))
				throw e;
			throw new Exception(UserMessages.ERROR_CONNECTING_DB);
		} finally {
			if(conn != null) {
				DBConnectorFactory.getInstance().closeDBConnection(conn);
			}
		}
	}
}