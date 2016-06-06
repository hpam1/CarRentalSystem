/**
 * 
 */
package ssdi.carrentalsystem.utils;

import ssdi.carrentalsystem.dao.CarDAO;
import ssdi.carrentalsystem.dao.CarDAOInterface;
import ssdi.carrentalsystem.test.mock.CarDAOMock;

/**
 * @author haarthi
 *
 */
public class CarDAOFactory {
	private static CarDAOFactory instance = null;
	private CarDAOFactory() {
		
	}
	
	public static CarDAOFactory getInstance() {
		if(instance == null)
			instance = new CarDAOFactory();
		return instance;
	}
	
	public CarDAOInterface getCarDAO(String type) {
		if(type.equals(Constants.CARDAO_ACTUAL))
			return new CarDAO();
		else if(type.equals(Constants.TEST))
			return new CarDAOMock();
		else
			return new CarDAO();
	}
}
