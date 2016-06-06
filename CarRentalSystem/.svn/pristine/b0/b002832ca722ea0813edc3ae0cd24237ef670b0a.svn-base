package ssdi.carrentalsystem.dao;

import java.util.List;

/**
 * 
 * @author haarthi
 *
 */
public interface CarLockDAOInterface {
	
	// fetch the car if it is locked for the chosen date
	public List<String> fetchLockedCars(String carRegistrationNo, String startDate, String endDate) throws Exception;
	// lock the given car
	public void lockCar(String carRegistrationNo, String startDate, String endDate) throws Exception;
}
