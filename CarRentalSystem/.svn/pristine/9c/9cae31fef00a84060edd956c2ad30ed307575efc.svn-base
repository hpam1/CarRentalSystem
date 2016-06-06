/**
 * 
 */
package ssdi.carrentalsystem.model;

import java.util.Iterator;
import java.util.List;

import ssdi.carrentalsystem.dao.CarLockDAOInterface;
import ssdi.carrentalsystem.utils.Constants;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * @author haarthi
 * Check if the car is locked and if not lock the car.
 */
public class LockCarModel {
	private CarLockDAOInterface carLockDAO;
	
	public LockCarModel(CarLockDAOInterface carLockDAO) {
		this.carLockDAO = carLockDAO;
	}
	
	public String lockCar(List<String> carInstance, String startDate, String endDate) throws Exception {
		boolean flag = false;
		String lockedCar = null;
		if(carInstance != null && carInstance.size() > 0) {
			Iterator<String> carItr = carInstance.iterator();
			while(carItr.hasNext()) {
				String car = carItr.next();
				List<String> lockedCarsList = carLockDAO.fetchLockedCars(car, startDate, endDate);
				if(lockedCarsList != null && lockedCarsList.size() > 0) {
					continue;
				} else {
					carLockDAO.lockCar(car, startDate, endDate);
					lockedCar = car;
					flag = true;
					break;
				}
			}
			if(!flag)
				throw new Exception(UserMessages.NO_CAR_EXISTS);
			return lockedCar;
		} else {
			throw new Exception(UserMessages.NO_CAR_EXISTS);
		}
	}
	
	public void lockCar(String carRegId, String startDate, String endDate) throws Exception {
		boolean flag = false;
		List<String> lockedCarsList = carLockDAO.fetchLockedCars(carRegId, startDate, endDate);
		if(lockedCarsList != null && lockedCarsList.size() > 0) {
			flag = false;
		} else {
			carLockDAO.lockCar(carRegId, startDate, endDate);
			flag = true;
		}
		System.out.println("Flag " + flag);
		if(!flag)
			throw new Exception(UserMessages.NO_CAR_EXISTS);
	}
}