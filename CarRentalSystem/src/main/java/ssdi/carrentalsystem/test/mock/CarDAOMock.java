package ssdi.carrentalsystem.test.mock;

import ssdi.carrentalsystem.dao.CarDAOInterface;
import ssdi.carrentalsystem.io.Car;

/**
 * 
 * @author haarthi
 *
 */
public class CarDAOMock implements CarDAOInterface {

	public Car fetchCar(int carId) throws Exception {
		Car car = null;
		if(carId == 1) {
			car = new Car();
			car.setMake("BMW");
			car.setModel("i8");
			car.setCarType("sedan");
			car.setCarDescription("BMW i8 sedan");
			car.setRentalCost(159.99);
			car.setInsuranceCost(100.0);
		}
		if(carId == 2) {
			car = new Car();
			car.setMake("BMW");
			car.setModel("i8");
			car.setCarType("sedan");
			car.setCarDescription("BMW i8 sedan");
			car.setRentalCost(159.99);
			car.setInsuranceCost(0.0);
		}		
		return car;
	}
}