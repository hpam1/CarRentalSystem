package ssdi.carrentalsystem.test.mock;

import java.util.ArrayList;
import java.util.List;

import ssdi.carrentalsystem.dao.CarRentalDAOInterface;

/**
 * 
 * @author haarthi
 *
 */
public class CarRentalDAOMock implements CarRentalDAOInterface {

	public List<String> fetchCars(String carRegistrationNo, String startDate,
			String endDate) throws Exception {
		List<String> carInstances = null;
		
		if(carRegistrationNo.startsWith("LN")) {
			carInstances = null;
		}
		
		if(carRegistrationNo.startsWith("KD")) {
			carInstances = null;
		}
		
		if(carRegistrationNo.startsWith("AJ")) {
			carInstances = new ArrayList<String>();
			carInstances.add("AJ123");
		}
		return carInstances;
	}

	public String fetchRenewalDate(int rentalId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String fetchCarRegistrationNo(int rentalId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> fetchCarForRenewal(String carRegistrationNo,
			String startDate, String endDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
