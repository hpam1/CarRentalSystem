package ssdi.carrentalsystem.io;

/**
 * 
 * @author haarthi
 *
 */
public class SalesTax{
	private RentalCar car;
	
	public SalesTax(RentalCar car) {
		this.car = car;
	}
	
	public String getDescription() {
		return car.getDescription() + "\n" + "Sales tax @ 4.75%: $" + calculateTax();
	}

	private double calculateTax() {
		double salestax = car.getCost() * 4.75 / 100;
		salestax = Math.round(salestax * 100.0) / 100.0;
		return salestax;
	}
	
	public double getCost() {
		return car.getCost() + calculateTax();
	}
}