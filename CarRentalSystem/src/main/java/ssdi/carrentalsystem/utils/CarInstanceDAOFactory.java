package ssdi.carrentalsystem.utils;

import ssdi.carrentalsystem.dao.CarInstanceDAO;
import ssdi.carrentalsystem.dao.CarInstanceDAOInterface;
import ssdi.carrentalsystem.test.mock.CarInstanceDAOMock;

/**
 * 
 * @author haarthi
 *
 */
public class CarInstanceDAOFactory {
	private static CarInstanceDAOFactory instance = null;
	private CarInstanceDAOFactory() {
		
	}
	
	public static CarInstanceDAOFactory getInstance() {
		if(instance == null)
			instance = new CarInstanceDAOFactory();
		return instance;
	}
	
	public CarInstanceDAOInterface getCarInstanceDAO(String type) {
		System.out.println(type);
		if(type.equals(Constants.CAR_INSTANCE_DAO_ACTUAL))
			return new CarInstanceDAO();
		else if(type.equals(Constants.TEST)) {
			System.out.println("returning mock");
			return new CarInstanceDAOMock();
		}
		else
			return new CarInstanceDAO();
	}
}
