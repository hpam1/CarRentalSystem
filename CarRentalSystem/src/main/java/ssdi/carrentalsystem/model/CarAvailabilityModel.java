/**
 * 
 */
package ssdi.carrentalsystem.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ssdi.carrentalsystem.dao.CarInstanceDAOInterface;
import ssdi.carrentalsystem.dao.CarLockDAOInterface;
import ssdi.carrentalsystem.dao.CarRentalDAOInterface;
import ssdi.carrentalsystem.utils.Constants;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * @author haarthi
 *
 */
public class CarAvailabilityModel {
	private CarInstanceDAOInterface carInstanceDAO = null;
	private CarRentalDAOInterface carRentalDAO = null;
	private CarLockDAOInterface carLockDAO = null;
	
	public CarAvailabilityModel(CarInstanceDAOInterface carInstanceDAO, CarRentalDAOInterface carRentalDAO, CarLockDAOInterface carLockDAO) {
		this.carInstanceDAO = carInstanceDAO;
		this.carRentalDAO = carRentalDAO;
		this.carLockDAO = carLockDAO;
	}
	
	public List<String> getAvailableCarInstances(int carId, String startDate, String toDate) throws Exception {
		System.out.println("INFO: inside CarAvailabilityModel getAvailableCarInstances for " + carId + " from " + startDate + " to " + toDate);
		List<String> carInstanceList;
		List<String> rentedCars;
		List<String> lockedCars;
		try {
			//fetch car instances for the car id
			carInstanceList = carInstanceDAO.fetchCarsForID(carId);
			rentedCars = new ArrayList<String>();
			lockedCars = new ArrayList<String>();
			if(carInstanceList == null || carInstanceList.size() == 0) {
				throw new Exception(UserMessages.NO_CAR_EXISTS);
			} else {
				Iterator<String> carInstanceItr = carInstanceList.iterator();
				while(carInstanceItr.hasNext()) {
					// fetch the car instances rented for the given time and remove it from the carInstance list
					List<String> tempRentedCars = carRentalDAO.fetchCars(carInstanceItr.next(), startDate, toDate);
					if(tempRentedCars != null && tempRentedCars.size() > 0)
						rentedCars.addAll(tempRentedCars);
				}
				carInstanceList.removeAll(rentedCars);
				carInstanceItr = carInstanceList.iterator();
				while(carInstanceItr.hasNext()) {
					// fetch the car instances locked for the given time and remove it from the car instance list
					List<String> tempLockedCars = carLockDAO.fetchLockedCars(carInstanceItr.next(), startDate, toDate);
					if(tempLockedCars != null && tempLockedCars.size() > 0)
						lockedCars.addAll(tempLockedCars);
				}
				carInstanceList.removeAll(lockedCars);
				return carInstanceList;
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}