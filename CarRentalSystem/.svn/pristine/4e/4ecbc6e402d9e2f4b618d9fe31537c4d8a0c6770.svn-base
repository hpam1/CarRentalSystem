package ssdi.carrentalsystem.test.costestimate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ssdi.carrentalsystem.dao.CarInstanceDAOInterface;
import ssdi.carrentalsystem.utils.CarInstanceDAOFactory;
import ssdi.carrentalsystem.utils.Constants;
import ssdi.carrentalsystem.utils.UserMessages;

/**
 * 
 * @author haarthi
 *
 */
public class TestCarInstanceDAO {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testForNoCarInstance() {
		CarInstanceDAOInterface carInstanceDAO = CarInstanceDAOFactory.getInstance().getCarInstanceDAO(Constants.CARDAO_ACTUAL);
		try {
			carInstanceDAO.fetchCarsForID(7);
			fail("No Exception thrown");
		} catch (Exception e) {
			assertEquals(e.getMessage(), UserMessages.NO_CAR_EXISTS);
		}
	}

	@Test
	public void testForCarInstance() {
		CarInstanceDAOInterface carInstanceDAO = CarInstanceDAOFactory.getInstance().getCarInstanceDAO(Constants.CARDAO_ACTUAL);
		try {
			List<String> carInstance = carInstanceDAO.fetchCarsForID(5);
			assertEquals(carInstance.size(), 3);
		} catch (Exception e) {
			fail("Exception thrown");
		}
	}
}