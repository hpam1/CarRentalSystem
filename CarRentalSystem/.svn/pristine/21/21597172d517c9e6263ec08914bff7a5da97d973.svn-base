package ssdi.carrentalsystem.test.mock;

import java.util.ArrayList;
import java.util.List;

import ssdi.carrentalsystem.dao.CarLockDAOInterface;

/**
 * 
 * @author haarthi
 *
 */
public class CarLockDAOMock implements CarLockDAOInterface {

	public List<String> fetchLockedCars(String carRegistrationNo,
			String startDate, String endDate) throws Exception {
		List<String> carInstance =  null;
		
		if(carRegistrationNo.startsWith("LN")) {
			carInstance = null;
		}
		if(carRegistrationNo.startsWith("KD")) {
			if(startDate.equals("2015/05/06 10:00") && endDate.equals("2015/05/06 15:00")) {
				carInstance = new ArrayList<String>();
				carInstance.add("KD123");
				carInstance.add("KD124");
				carInstance.add("KD125");
				carInstance.add("KD126");
			} else {
				carInstance = new ArrayList<String>();
				carInstance.add("KD123");
				carInstance.add("KD124");
			}
		}
		if(carRegistrationNo.startsWith("AJ")) {
			carInstance = null;
		}
		return carInstance;
	}

	public void lockCar(String carRegistrationNo, String startDate,
			String endDate) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
