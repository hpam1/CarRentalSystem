package ssdi.carrentalsystem.model;

import java.util.List;

import ssdi.carrentalsystem.dao.CarLockDAOInterface;
import ssdi.carrentalsystem.dao.CarRentalDAOInterface;
import ssdi.carrentalsystem.utils.Constants;

public class CarRenewalModel {
	private CarRentalDAOInterface carRentalDAO = null;
	private CarLockDAOInterface carLockDAO = null;
	
	public CarRenewalModel(CarRentalDAOInterface carRentalDAO, CarLockDAOInterface carLockDAO) {
		this.carRentalDAO = carRentalDAO;
		this.carLockDAO = carLockDAO;
	}
	
	public String getRenewalStartDate(int rentalId) throws Exception{
		String startDate = null;
		try {
			startDate = carRentalDAO.fetchRenewalDate(rentalId);
			return startDate;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public boolean getCarAvailability(String carRegId, int rentalId, String startDate, String endDate) throws Exception {
		System.out.println("INFO: inside CarAvailabilityModel getAvailableCarInstances for " + carRegId + " from " + startDate + " to " + endDate);
		try {
			//fetch car instances for the car id
			List<String> tempRentedCars = carRentalDAO.fetchCarForRenewal(carRegId, startDate, endDate);
			if(tempRentedCars != null && tempRentedCars.size() > 0)
				return false;	
			else {
				List<String> tempLockedCars = carLockDAO.fetchLockedCars(carRegId, startDate, endDate);
				if(tempLockedCars != null && tempLockedCars.size() > 0)
					return false;
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public String getCarRegistrationNo(int rentalId) throws Exception {
		String registrationNo = null;
		try {
			registrationNo = carRentalDAO.fetchCarRegistrationNo(rentalId);
			return registrationNo;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}