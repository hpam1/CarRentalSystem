package ssdi.carrentalsystem.model;

import java.util.Date;

import ssdi.carrentalsystem.dao.CarDAOInterface;
import ssdi.carrentalsystem.dao.CarInstanceDAOInterface;
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
public class RenewalEstimateModel {
	private CarDAOInterface carDAO;
	private CarInstanceDAOInterface carInstanceDAO;
	
	public RenewalEstimateModel(CarDAOInterface carDAO, CarInstanceDAOInterface carInstanceDAO) {
		this.carDAO = carDAO;
		this.carInstanceDAO = carInstanceDAO;
	}
	
	private Car getCarsForId(int carId) throws Exception {
		Car car = carDAO.fetchCar(carId);
		return car;
	}
	
	public RentalCar calculateCost(String carRegId, Date startDate, Date endDate) throws Exception {
		int carId = carInstanceDAO.fetchCarId(carRegId);
		Car car = getCarsForId(carId);
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