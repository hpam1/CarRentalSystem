package ssdi.carrentalsystem.test.renewal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import ssdi.carrentalsystem.dao.CarLockDAO;
import ssdi.carrentalsystem.dao.CarLockDAOInterface;
import ssdi.carrentalsystem.dao.CarRentalDAO;
import ssdi.carrentalsystem.dao.CarRentalDAOInterface;
import ssdi.carrentalsystem.model.CarRenewalModel;
import ssdi.carrentalsystem.utils.Constants;

/**
 * 
 * @author haarthi
 *
 */
public class TestCarRenewalModel {
	
	@Test
	public void testfetchStartDate() throws Exception {
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		
		Mockito.when(carRentalDAO.fetchRenewalDate(1)).thenReturn("2015-04-26 11:00");
		CarRenewalModel model = new CarRenewalModel(carRentalDAO, carLockDAO);	
		assertEquals("2015-04-26 11:00", model.getRenewalStartDate(1));
	}
	
	@Test(expected = Exception.class)
	public void testfetchStartDateException() throws Exception {
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		
		Mockito.when(carRentalDAO.fetchRenewalDate(1)).thenThrow(Exception.class);
		CarRenewalModel model = new CarRenewalModel(carRentalDAO, carLockDAO);	
		model.getRenewalStartDate(1);
	}
	
	@Test
	public void testCarRegNo() throws Exception {
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		
		Mockito.when(carRentalDAO.fetchCarRegistrationNo(1)).thenReturn("HN-1234");
		CarRenewalModel model = new CarRenewalModel(carRentalDAO, carLockDAO);	
		assertEquals("HN-1234", model.getCarRegistrationNo(1));
	}
	
	@Test(expected = Exception.class)
	public void testCarRegNoException() throws Exception {
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		
		Mockito.when(carRentalDAO.fetchCarRegistrationNo(1)).thenThrow(Exception.class);
		CarRenewalModel model = new CarRenewalModel(carRentalDAO, carLockDAO);
		model.getCarRegistrationNo(1);
	}
	
	@Test
	public void testCarAvailabilityT() throws Exception {
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		
		
		Mockito.when(carRentalDAO.fetchCarForRenewal("HN123", "2015-04-25 11:00", "2015-04-26 11:00")).thenReturn(null);
		Mockito.when(carLockDAO.fetchLockedCars("HN123", "2015-04-25 11:00", "2015-04-26 11:00")).thenReturn(null);
		CarRenewalModel model = new CarRenewalModel(carRentalDAO, carLockDAO);	
		assertEquals(true, model.getCarAvailability("HN123", 1, "2015-04-25 11:00", "2015-04-26 11:00"));
	}
	
	
	@Test
	public void testCarAvailabilityf1() throws Exception {
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		List<String> cars = new ArrayList<String>();
		cars.add("HN123");
		
		Mockito.when(carRentalDAO.fetchCarForRenewal("HN123", "2015-04-25 11:00", "2015-04-26 11:00")).thenReturn(cars);
		Mockito.when(carLockDAO.fetchLockedCars("HN123", "2015-04-25 11:00", "2015-04-26 11:00")).thenReturn(null);
		CarRenewalModel model = new CarRenewalModel(carRentalDAO, carLockDAO);	
		assertEquals(false, model.getCarAvailability("HN123", 1, "2015-04-25 11:00", "2015-04-26 11:00"));
	}
	
	@Test
	public void testCarAvailabilityf2() throws Exception {
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		List<String> cars = new ArrayList<String>();
		cars.add("HN123");
		
		Mockito.when(carRentalDAO.fetchCarForRenewal("HN123", "2015-04-25 11:00", "2015-04-26 11:00")).thenReturn(null);
		Mockito.when(carLockDAO.fetchLockedCars("HN123", "2015-04-25 11:00", "2015-04-26 11:00")).thenReturn(cars);
		CarRenewalModel model = new CarRenewalModel(carRentalDAO, carLockDAO);	
		assertEquals(false, model.getCarAvailability("HN123", 1, "2015-04-25 11:00", "2015-04-26 11:00"));
	}
	
	@Test(expected = Exception.class)
	public void testCarAvailabilityException1() throws Exception {
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		List<String> cars = new ArrayList<String>();
		cars.add("HN123");
		
		Mockito.when(carRentalDAO.fetchCarForRenewal("HN123", "2015-04-25 11:00", "2015-04-26 11:00")).thenThrow(Exception.class);
		Mockito.when(carLockDAO.fetchLockedCars("HN123", "2015-04-25 11:00", "2015-04-26 11:00")).thenReturn(cars);
		CarRenewalModel model = new CarRenewalModel(carRentalDAO, carLockDAO);
		model.getCarAvailability("HN123",1, "2015-04-25 11:00", "2015-04-26 11:00");
	}
	
	@Test(expected = Exception.class)
	public void testCarAvailabilityException2() throws Exception {
		CarLockDAOInterface carLockDAO = Mockito.mock(CarLockDAO.class);
		CarRentalDAOInterface carRentalDAO = Mockito.mock(CarRentalDAO.class);
		List<String> cars = new ArrayList<String>();
		cars.add("HN123");
		
		Mockito.when(carRentalDAO.fetchCarForRenewal("HN123", "2015-04-25 11:00", "2015-04-26 11:00")).thenReturn(null);
		Mockito.when(carLockDAO.fetchLockedCars("HN123", "2015-04-25 11:00", "2015-04-26 11:00")).thenThrow(Exception.class);
		CarRenewalModel model = new CarRenewalModel(carRentalDAO, carLockDAO);	
		model.getCarAvailability("HN123", 1, "2015-04-25 11:00", "2015-04-26 11:00");
	}
}