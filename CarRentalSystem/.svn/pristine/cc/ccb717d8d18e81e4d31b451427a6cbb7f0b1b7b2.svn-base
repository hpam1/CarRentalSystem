package ssdi.carrentalsystem.test.costestimate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import ssdi.carrentalsystem.dao.CarInstanceDAO;
import ssdi.carrentalsystem.dao.CarInstanceDAOInterface;
import ssdi.carrentalsystem.dao.CarLockDAO;
import ssdi.carrentalsystem.dao.CarLockDAOInterface;
import ssdi.carrentalsystem.dao.CarRentalDAO;
import ssdi.carrentalsystem.dao.CarRentalDAOInterface;
import ssdi.carrentalsystem.model.CarAvailabilityModel;
import ssdi.carrentalsystem.utils.Constants;

/**
 * 
 * @author haarthi
 *
 */
public class TestCarAvailabilityModel {
	
	@Test(expected = Exception.class)
	public void testNoCarsForId() throws Exception {
		CarInstanceDAOInterface carInstanceDAO = Mockito.mock(CarInstanceDAO.class);
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		
		
		Mockito.when(carInstanceDAO.fetchCarsForID(1)).thenReturn(null);
		CarAvailabilityModel model = new CarAvailabilityModel(carInstanceDAO, carRentalDAO, carLockDAO);
		
		model.getAvailableCarInstances(1, "2014-04-03", "2014-04-04");
	}
	
	@Test
	public void testCarsForIdAllAvailable() throws Exception {
		CarInstanceDAOInterface carInstanceDAO = Mockito.mock(CarInstanceDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		
		List<String> cars = new ArrayList<String>();
		cars.add("1"); cars.add("2"); cars.add("3");
				
		Mockito.when(carInstanceDAO.fetchCarsForID(1)).thenReturn(cars);
		Mockito.when(carRentalDAO.fetchCars("1", "2014-04-03", "2014-04-04")).thenReturn(null);
		Mockito.when(carRentalDAO.fetchCars("2", "2014-04-03", "2014-04-04")).thenReturn(null);
		Mockito.when(carRentalDAO.fetchCars("3", "2014-04-03", "2014-04-04")).thenReturn(null);
		Mockito.when(carLockDAO.fetchLockedCars("1", "2014-04-03", "2014-04-04")).thenReturn(null);
		Mockito.when(carLockDAO.fetchLockedCars("2", "2014-04-03", "2014-04-04")).thenReturn(null);
		Mockito.when(carLockDAO.fetchLockedCars("3", "2014-04-03", "2014-04-04")).thenReturn(null);
		
		CarAvailabilityModel model = new CarAvailabilityModel(carInstanceDAO, carRentalDAO, carLockDAO);
		
		List<String> carInstance = model.getAvailableCarInstances(1, "2014-04-03", "2014-04-04");
		System.out.println(carInstance);
		assertEquals(carInstance.size(), 3);	
	}
	
	@Test
	public void testCarsAllRented() throws Exception {
		CarInstanceDAOInterface carInstanceDAO = Mockito.mock(CarInstanceDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		
		List<String> cars = new ArrayList<String>();
		cars.add("1"); cars.add("2"); cars.add("3");
				
		Mockito.when(carInstanceDAO.fetchCarsForID(1)).thenReturn(cars);
		Mockito.when(carRentalDAO.fetchCars("1", "2014-04-03", "2014-04-04")).thenReturn(cars);
		Mockito.when(carLockDAO.fetchLockedCars("1", "2014-04-03", "2014-04-04")).thenReturn(null);
		
		CarAvailabilityModel model = new CarAvailabilityModel(carInstanceDAO, carRentalDAO, carLockDAO);
		
		assertEquals(0, model.getAvailableCarInstances(1, "2014-04-03", "2014-04-04").size());
	}
	
	@Test
	public void testCarsAllLocked() throws Exception {
		CarInstanceDAOInterface carInstanceDAO = Mockito.mock(CarInstanceDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		
		List<String> cars = new ArrayList<String>();
		cars.add("1"); cars.add("2"); cars.add("3");
				
		Mockito.when(carInstanceDAO.fetchCarsForID(1)).thenReturn(cars);
		Mockito.when(carRentalDAO.fetchCars("1", "2014-04-03", "2014-04-04")).thenReturn(null);
		Mockito.when(carLockDAO.fetchLockedCars("1", "2014-04-03", "2014-04-04")).thenReturn(cars);
		
		CarAvailabilityModel model = new CarAvailabilityModel(carInstanceDAO, carRentalDAO, carLockDAO);
		
		assertEquals(0, model.getAvailableCarInstances(1, "2014-04-03", "2014-04-04").size());
	}
	
	@Test
	public void testCarsfewAvailable() throws Exception {
		CarInstanceDAOInterface carInstanceDAO = Mockito.mock(CarInstanceDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		
		List<String> cars = new ArrayList<String>();
		cars.add("1"); cars.add("2"); cars.add("3");
		
		List<String> lockedCars = new ArrayList<String>();
		lockedCars.add("1");
		
		List<String> rentedCars = new ArrayList<String>();
		rentedCars.add("2");
		
		Mockito.when(carInstanceDAO.fetchCarsForID(1)).thenReturn(cars);
		Mockito.when(carRentalDAO.fetchCars("1", "2014-04-03", "2014-04-04")).thenReturn(rentedCars);
		Mockito.when(carLockDAO.fetchLockedCars("1", "2014-04-03", "2014-04-04")).thenReturn(lockedCars);
		
		CarAvailabilityModel model = new CarAvailabilityModel(carInstanceDAO, carRentalDAO, carLockDAO);
		
		List<String> availableCars =  model.getAvailableCarInstances(1, "2014-04-03", "2014-04-04");
		assertEquals(availableCars.size(), 1);
	}
}