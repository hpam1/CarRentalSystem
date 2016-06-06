package ssdi.carrentalsystem.test.costestimate;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ssdi.carrentalsystem.dao.CarDAOInterface;
import ssdi.carrentalsystem.io.Car;
import ssdi.carrentalsystem.utils.CarDAOFactory;
import ssdi.carrentalsystem.utils.Constants;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * 
 * @author haarthi
 *
 */
public class TestCarDAO {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testForNoCar() {
		CarDAOInterface carDAO = CarDAOFactory.getInstance().getCarDAO(Constants.CARDAO_ACTUAL);
		try {
			carDAO.fetchCar(0);
			fail("No Exception thrown");
		} catch (Exception e) {
			assertEquals(e.getMessage(), UserMessages.NO_CAR_EXISTS);
		}
	}

	@Test
	public void testForAvailableCar() {
		CarDAOInterface carDAO = CarDAOFactory.getInstance().getCarDAO(Constants.CARDAO_ACTUAL);
		try {
			Car car = carDAO.fetchCar(5);
			assertEquals(car.getMake(), "Porsche");
			assertEquals(car.getModel(), "Panmera S");
			assertEquals(car.getCarType(), "Sedan");
		} catch (Exception e) {
			fail("Exception thrown");
		}
	}
}