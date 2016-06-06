package ssdi.carrentalsystem.model;

import java.util.Date;

import ssdi.carrentalsystem.dao.CarDAOInterface;
import ssdi.carrentalsystem.io.Car;
import ssdi.carrentalsystem.io.InsuranceCost;
import ssdi.carrentalsystem.io.LicenseFee;
import ssdi.carrentalsystem.io.RentalCar;
import ssdi.carrentalsystem.io.RentalCost;
import ssdi.carrentalsystem.io.SalesTax;
import ssdi.carrentalsystem.utils.Constants;

/**
 * 
 * @author haarthi
 * 
 * Calculates the cost for the chosen car for the selected time period. Uses decorator pattern for cost calculation
 *
 */
public class CostEstimateModel {
	private CarDAOInterface carDAO;
	
	public CostEstimateModel(CarDAOInterface carDAO) {
		this.carDAO = carDAO;
	}
	
	private Car getCarsForId(int carId) throws Exception {
		Car car = carDAO.fetchCar(carId);
		return car;
	}
	
	public RentalCar calculateCost(int carId, Date startDate, Date endDate) throws Exception {
		Car car = getCarsForId(carId);
		car.setStartDate(startDate);
		car.setEndDate(endDate);
		car.calculateRentalCost();
		RentalCar rentalCar = car;
		//rentalCar = new RentalCost(rentalCar, startDate, endDate, car.getRentalCost());
		rentalCar = new InsuranceCost(rentalCar, car.getInsuranceCost());
		rentalCar = new LicenseFee(rentalCar);
		//rentalCar = new SalesTax(rentalCar);
		SalesTax salesTax = new SalesTax(rentalCar);
		car.setCarDescription(salesTax.getDescription());
		car.setCost(salesTax.getCost());
		rentalCar = car;
		return rentalCar;
	}
}