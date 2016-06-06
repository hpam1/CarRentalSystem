package ssdi.carrentalsystem.io;

import java.util.Date;

/**
 * 
 * @author haarthi
 *
 */
public class Car implements RentalCar {

	private String carDescription;
	private double rentalCost;
	private double insuranceCost;
	private String make;
	private String model;
	private String carType;
	private Date startDate;
	private Date endDate;
	private double cost;
	
	public Car() {
		this.cost = 0;
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getRentalCost() {
		return rentalCost;
	}

	public void setRentalCost(double rentalCost) {
		this.rentalCost = rentalCost;
	}

	public double getInsuranceCost() {
		return insuranceCost;
	}

	public void setInsuranceCost(double insuranceCost) {
		this.insuranceCost = insuranceCost;
	}

	public void setCarDescription(String description) {
		carDescription = description;
	}
	
	public String getDescription() {
		return carDescription;
	}

	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public void calculateRentalCost() {
		RentalCost rentalCost = new RentalCost(this, this.startDate, this.endDate, this.rentalCost);
		this.setCarDescription(rentalCost.getDescription());
		this.setCost(rentalCost.getCost());
	}
}