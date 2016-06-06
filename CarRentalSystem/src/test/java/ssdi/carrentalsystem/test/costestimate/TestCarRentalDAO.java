package ssdi.carrentalsystem.test.costestimate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ssdi.carrentalsystem.dao.CarRentalDAOInterface;
import ssdi.carrentalsystem.utils.CarRentalDAOFactory;
import ssdi.carrentalsystem.utils.Constants;

/**
 * 
 * @author haarthi
 *
 */
public class TestCarRentalDAO {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testForCarNotRentedForTheDay() {
		CarRentalDAOInterface carRentalDAO = CarRentalDAOFactory.getInstance().getCarRentalDAO(Constants.CAR_RENTAL_DAO_ACTUAL);
		try {
			List<String> rentedCars = carRentalDAO.fetchCars("HN-6112", "2015/04/09 11:00", "2015/04/09 15:00");
			assertEquals(rentedCars, null);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	public void testForCarNotRentedForTheTime() {
		CarRentalDAOInterface carRentalDAO = CarRentalDAOFactory.getInstance().getCarRentalDAO(Constants.CAR_RENTAL_DAO_ACTUAL);
		try {
			List<String> rentedCars = carRentalDAO.fetchCars("HN-6112", "2015/05/05 4:00", "2015/05/05 10:00");
			assertEquals(rentedCars, null);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	@Test
	public void testForCarRented1() {
		CarRentalDAOInterface carRentalDAO = CarRentalDAOFactory.getInstance().getCarRentalDAO(Constants.CAR_RENTAL_DAO_ACTUAL);
		try {
			List<String> rentedCars = carRentalDAO.fetchCars("HN-6112", "2015/05/05 11:00", "2015/05/05 17:00");
			assertEquals(rentedCars.size(), 1);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	@Test
	public void testForCarRented2() {
		CarRentalDAOInterface carRentalDAO = CarRentalDAOFactory.getInstance().getCarRentalDAO(Constants.CAR_RENTAL_DAO_ACTUAL);
		try {
			List<String> rentedCars = carRentalDAO.fetchCars("HN-6112", "2015/05/05 8:00", "2015/05/05 14:00");
			assertEquals(rentedCars.size(), 1);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	@Test
	public void testForCarRented3() {
		CarRentalDAOInterface carRentalDAO = CarRentalDAOFactory.getInstance().getCarRentalDAO(Constants.CAR_RENTAL_DAO_ACTUAL);
		try {
			List<String> rentedCars = carRentalDAO.fetchCars("HN-6112", "2015/05/05 10:00", "2015/05/05 20:00");
			assertEquals(rentedCars.size(), 1);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
}