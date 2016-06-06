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
 * DAO for all queries related to Car_rental_details table
 */
public class CarRentalDAO implements CarRentalDAOInterface {
	
	/*
	 * (non-Javadoc)
	 * @see ssdi.carrentalsystem.dao.CarRentalDAOInterface#fetchCars(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<String> fetchCars(String carRegistrationNo, String startDate, String endDate) throws Exception {
		String query = "select car_license_no from car_rental_details where car_license_no = '" + carRegistrationNo + "' and "
					+ "(('" + startDate + "' >= start_time and '" + startDate + "' <= end_time) or ('" + endDate + "' >= start_time and '"
							+ endDate + "' <= end_time) or ('"+ startDate + "' <= start_time and '"+ endDate + "' >= end_time))";
		System.out.println(query);
		return fetchCarDetails(query);
	}
	
	
	public List<String> fetchCarForRenewal(String carRegistrationNo, String startDate, String endDate) throws Exception {
		String query = "select car_license_no from car_rental_details where car_license_no = '" + carRegistrationNo + "' and "
				+ "(('" + startDate + "' >= start_time and '" + startDate + "' < end_time) or ('" + endDate + "' >= start_time and '"
						+ endDate + "' <= end_time) or ('"+ startDate + "' <= start_time and '"+ endDate + "' >= end_time))";
		System.out.println(query);
		return fetchCarDetails(query);
	}
	
	private List<String> fetchCarDetails(String query) throws Exception {
		Connection conn = null;
		Statement stmnt = null;
		List<String> rentedCars = null;
		try {
			conn = DBConnectorFactory.getInstance().getDBConnection();
			stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery(query);
			while(rs != null && rs.next()) {
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
	
	public String fetchRenewalDate(int rentalId) throws Exception {
		Connection conn = null;
		Statement stmnt = null;
		String startDate = null;
		
		try {
			conn = DBConnectorFactory.getInstance().getDBConnection();
			stmnt = conn.createStatement();
			String query = "select end_time from car_rental_details where rental_id = " + rentalId + " limit 1";
			System.out.println(query);
			ResultSet rs = stmnt.executeQuery(query);
			if(rs != null && rs.next()) {
				startDate = rs.getString(1);
			}
			return startDate;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception(UserMessages.ERROR_CONNECTING_DB);
		} finally {
			if(conn != null)
				DBConnectorFactory.getInstance().closeDBConnection(conn);
		}
	}
	
	public String fetchCarRegistrationNo(int rentalId) throws Exception {
		Connection conn = null;
		Statement stmnt = null;
		String carRegNo = null;
		try {
			conn = DBConnectorFactory.getInstance().getDBConnection();
			stmnt = conn.createStatement();
			String query = "select car_license_no from car_rental_details where rental_id = " + rentalId + " limit 1";
			System.out.println(query);
			ResultSet rs = stmnt.executeQuery(query);
			if(rs != null && rs.next()) {
				carRegNo = rs.getString(1);
			}
			return carRegNo;
 		} catch(Exception e) {
 			e.printStackTrace();
 			throw new Exception(UserMessages.ERROR_CONNECTING_DB);
 		} finally {
 			if(conn != null)
 				DBConnectorFactory.getInstance().closeDBConnection(conn);
 		}
	}
	
}