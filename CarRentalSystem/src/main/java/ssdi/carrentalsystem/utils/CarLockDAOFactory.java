package ssdi.carrentalsystem.utils;

import ssdi.carrentalsystem.dao.CarLockDAO;
import ssdi.carrentalsystem.dao.CarLockDAOInterface;
import ssdi.carrentalsystem.test.mock.CarLockDAOMock;


/**
 * 
 * @author haarthi
 *
 */
public class CarLockDAOFactory {
	private static CarLockDAOFactory instance = null;
	private CarLockDAOFactory() {
		
	}
	
	public static CarLockDAOFactory getInstance() {
		if(instance == null)
			instance = new CarLockDAOFactory();
		return instance;
	}
	
	public CarLockDAOInterface getCarLockDAO(String type) {
		if(type.equals(Constants.CAR_LOCK_DAO_ACTUAL))
			return new CarLockDAO();
		else if(type.equals(Constants.TEST))
			return new CarLockDAOMock();
		else
			return new CarLockDAO();
	}
}