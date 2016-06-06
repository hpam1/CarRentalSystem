package ssdi.carrentalsystem.utils;

import ssdi.carrentalsystem.dao.CarRentalDAO;
import ssdi.carrentalsystem.dao.CarRentalDAOInterface;
import ssdi.carrentalsystem.test.mock.CarRentalDAOMock;

/**
 * 
 * @author haarthi
 *
 */
public class CarRentalDAOFactory {
	private static CarRentalDAOFactory instance = null;
	private CarRentalDAOFactory() {
		
	}
	
	public static CarRentalDAOFactory getInstance() {
		if(instance == null)
			instance = new CarRentalDAOFactory();
		return instance;
	}
	
	public CarRentalDAOInterface getCarRentalDAO(String type) {
		if(type.equals(Constants.CAR_RENTAL_DAO_ACTUAL))
			return new CarRentalDAO();
		else if(type.equals(Constants.TEST))
			return new CarRentalDAOMock();
		else
			return new CarRentalDAO();
	}
}
