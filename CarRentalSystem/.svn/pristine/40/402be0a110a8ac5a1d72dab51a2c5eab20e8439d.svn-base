package ssdi.carrentalsystem.test.costestimate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ssdi.carrentalsystem.dao.CarLockDAOInterface;
import ssdi.carrentalsystem.utils.CarLockDAOFactory;
import ssdi.carrentalsystem.utils.Constants;

/**
 * 
 * @author haarthi
 *
 */
public class TestCarLockDAO {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testForCarNotLockedForTheDay() {
		CarLockDAOInterface carLockDAO = CarLockDAOFactory.getInstance().getCarLockDAO(Constants.CAR_LOCK_DAO_ACTUAL);
		try {
			List<String> lockedCars = carLockDAO.fetchLockedCars("HN-6112", "2015-04-09 11:00", "2015-04-09 15:00");
			assertEquals(lockedCars, null);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	public void testForCarNotLockedForTheTime() {
		CarLockDAOInterface carLockDAO = CarLockDAOFactory.getInstance().getCarLockDAO(Constants.CAR_LOCK_DAO_ACTUAL);
		try {
			List<String> lockedCars = carLockDAO.fetchLockedCars("HN-6112", "2015-04-10 4:00", "2015-04-10 10:00");
			assertEquals(lockedCars, null);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	@Test
	public void testForCarLocked1() {
		CarLockDAOInterface carLockDAO = CarLockDAOFactory.getInstance().getCarLockDAO(Constants.CAR_LOCK_DAO_ACTUAL);
		try {
			List<String> lockedCars = carLockDAO.fetchLockedCars("HN-6112", "2015-04-10 11:56", "2015-04-11 11:56");
			assertEquals(lockedCars.size(), 1);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	@Test
	public void testForCarLocked2() {
		CarLockDAOInterface carLockDAO = CarLockDAOFactory.getInstance().getCarLockDAO(Constants.CAR_LOCK_DAO_ACTUAL);
		try {
			List<String> lockedCars = carLockDAO.fetchLockedCars("HN-6112", "2015-04-10 8:00", "2015-04-10 20:00");
			assertEquals(lockedCars.size(), 1);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	@Test
	public void testForCarLocked3() {
		CarLockDAOInterface carLockDAO = CarLockDAOFactory.getInstance().getCarLockDAO(Constants.CAR_LOCK_DAO_ACTUAL);
		try {
			List<String> lockedCars = carLockDAO.fetchLockedCars("HN-6112", "2015-04-10 15:00", "2015-04-11 15:00");
			assertEquals(lockedCars.size(), 1);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
}