package ssdi.carrentalsystem.io;

/**
 * 
 * @author haarthi
 *
 */
public class LicenseFee extends RentalCarDecorator {
	private RentalCar car;
	private Double carCost;
	
	public LicenseFee(RentalCar car) {
		this.car = car;
		carCost = car.getCost();
	}
	
	public String getDescription() {
		return car.getDescription() + "\n" + "License fee: $" + getLicenseFee();
	}

	private double getLicenseFee() {
		return 1d;
	}
	
	public double getCost() {
		return carCost + getLicenseFee();
	}
	
}
