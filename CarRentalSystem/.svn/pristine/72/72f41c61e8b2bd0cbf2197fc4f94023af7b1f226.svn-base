/*package ssdi.carrentalsystem.test.costestimate;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

import ssdi.carrentalsystem.dao.CarDAO;
import ssdi.carrentalsystem.dao.CarDAOInterface;
import ssdi.carrentalsystem.io.Car;
import ssdi.carrentalsystem.model.CostEstimateModel;
import ssdi.carrentalsystem.utils.Constants;

*//**
 * 
 * @author haarthi
 *
 *//*
public class TestCostEstimateModel {
	
	@Test
	public void testCostForHRS() throws Exception {
		CarDAOInterface carDAO = Mockito.mock(CarDAO.class);
		Car car = new Car();
		car.setCarDescription("BMW i8 model");
		car.setCarType("sedan");
		car.setInsuranceCost(14.5);
		car.setMake("BMW");
		car.setModel("i8");
		car.setRentalCost(99.99);
		
		Mockito.when(carDAO.fetchCar(1)).thenReturn(car);
		CostEstimateModel model = new CostEstimateModel(carDAO);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		
		Date startDate = format.parse("2014/04/02 11:10");
		Date endDate = format.parse("2014/04/02 22:00");
		
		assertEquals(model.calculateCost(1, startDate, endDate).getCost(),120.98, 0.01) ;
	}

	@Test
	public void testCostForDay() throws Exception {
		CarDAOInterface carDAO = Mockito.mock(CarDAO.class);
		Car car = new Car();
		car.setCarDescription("BMW i8 model");
		car.setCarType("sedan");
		car.setInsuranceCost(14.5);
		car.setMake("BMW");
		car.setModel("i8");
		car.setRentalCost(99.99);
		
		Mockito.when(carDAO.fetchCar(1)).thenReturn(car);
		CostEstimateModel model = new CostEstimateModel(carDAO);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		
		Date startDate = format.parse("2014/04/02 11:10");
		Date endDate = format.parse("2014/04/03 11:10");
		
		assertEquals(model.calculateCost(1, startDate, endDate).getCost(),120.98, 0.01) ;
	}
	
	@Test
	public void testCostForTwoDays() throws Exception {
		CarDAOInterface carDAO = Mockito.mock(CarDAO.class);
		Car car = new Car();
		car.setCarDescription("BMW i8 model");
		car.setCarType("sedan");
		car.setInsuranceCost(14.5);
		car.setMake("BMW");
		car.setModel("i8");
		car.setRentalCost(99.99);
		
		Mockito.when(carDAO.fetchCar(1)).thenReturn(car);
		CostEstimateModel model = new CostEstimateModel(carDAO);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		
		Date startDate = format.parse("2014/04/02 11:10");
		Date endDate = format.parse("2014/04/03 11:11");
		
		assertEquals(model.calculateCost(1, startDate, endDate).getCost(),225.72, 0.01) ;
	}
	
	@Test
	public void testCostForTwoDays2() throws Exception {
		CarDAOInterface carDAO = Mockito.mock(CarDAO.class);
		Car car = new Car();
		car.setCarDescription("BMW i8 model");
		car.setCarType("sedan");
		car.setInsuranceCost(14.5);
		car.setMake("BMW");
		car.setModel("i8");
		car.setRentalCost(99.99);
		
		Mockito.when(carDAO.fetchCar(1)).thenReturn(car);
		CostEstimateModel model = new CostEstimateModel(carDAO);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		
		Date startDate = format.parse("2014/04/02 11:10");
		Date endDate = format.parse("2014/04/03 13:11");
		
		assertEquals(model.calculateCost(1, startDate, endDate).getCost(),225.72, 0.01) ;
	}
}*/