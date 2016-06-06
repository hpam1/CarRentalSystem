package ssdi.carrentalsystem.dao;

import java.util.List;

/**
 * 
 * @author haarthi
 *
 */
public interface CarRentalDAOInterface {
	// fetch the car rented out for the chosen time
	public List<String> fetchCars(String carRegistrationNo, String startDate, String endDate) throws Exception;	
	
	public String fetchRenewalDate(int rentalId) throws Exception;
	
	public String fetchCarRegistrationNo(int rentalId) throws Exception;
	
	public List<String> fetchCarForRenewal(String carRegistrationNo, String startDate, String endDate) throws Exception;
}