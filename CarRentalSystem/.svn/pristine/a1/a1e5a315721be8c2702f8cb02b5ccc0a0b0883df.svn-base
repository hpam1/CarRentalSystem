/**
 * 
 */
package ssdi.carrentalsystem.test.mock;

import java.util.ArrayList;
import java.util.List;

import ssdi.carrentalsystem.dao.CarInstanceDAOInterface;

/**
 * @author haarthi
 *
 */
public class CarInstanceDAOMock implements CarInstanceDAOInterface {

	public List<String> fetchCarsForID(int carId) throws Exception {
		System.out.println("In CarInstance DAOMock " + carId);
		List<String> carInstances = null;
		
		if(carId == 1) {
			carInstances = new ArrayList<String>();
			carInstances.add("LN123");
			carInstances.add("LN124");
			carInstances.add("LN125");
		} if(carId == 2) {
			carInstances  = new ArrayList<String>();
			carInstances.add("KD123");
			carInstances.add("KD124");
			carInstances.add("KD125");
			carInstances.add("KD126");
		} if(carId == 3) {
			carInstances = new ArrayList<String>();
			carInstances.add("AJ123");
		}
		return carInstances;
	}

	public int fetchCarId(String carRegistrationNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
