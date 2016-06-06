/**
 * 
 */
package ssdi.carrentalsystem.io;

/**
 * @author haarthi
 *
 */
public class InsuranceCost extends RentalCarDecorator {
	private RentalCar car;
	private Double insuranceCost;
	private Double carCost;
	
	public InsuranceCost(RentalCar car, Double insuranceCost) {
		this.car = car;
		this.insuranceCost = insuranceCost;
		carCost = car.getCost();
	}
	
	public String getDescription() {
		return car.getDescription() + "\n" + "Insurance cost: $" + insuranceCost;
	}
	
	public double getCost() {
		return carCost + insuranceCost;
	}
}