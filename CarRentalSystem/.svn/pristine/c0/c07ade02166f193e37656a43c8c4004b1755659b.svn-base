package ssdi.carrentalsystem.io;

import java.util.Date;

/**
 * 
 * @author haarthi
 *
 */
public class RentalCost {
	private RentalCar car;
	private Date startDate;
	private Date endDate;
	private Double rentalCost;
	private Double totalRentalCost;
	private Double carCost;
	
	public RentalCost(RentalCar car, Date startDate, Date endDate, Double rentalCost) {
		this.car = car;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rentalCost = rentalCost;
		carCost = car.getCost();
	}
	
	public String getDescription() {
		return car.getDescription() + "\n" + "RentalCost at the rate of $"+ rentalCost + " per day for " + getDayDiff() + " : $" + getRentalCost();
	}
	
	private long getDayDiff() {
		long dateDiff = endDate.getTime() - startDate.getTime();
		long diffDays = dateDiff/(24 * 60 * 60 * 1000);
		long diffHours = dateDiff/(60 * 60 * 1000);
		long diffMins = dateDiff /(60 * 1000);
		
		diffHours = diffHours % 24;
		diffMins = diffMins % (24 * 60);
		
		if(diffHours > 0 || diffMins > 0)
			diffDays++;
		return diffDays;
	}
	
	private double getRentalCost() {
		//Date startDate = car.getStartDate();
		//Date endDate = car.getEndDate();
		//Double rentalCost = car.getRentalCost();
		
		long diffDays = getDayDiff();
		totalRentalCost = (double) (rentalCost * diffDays);
		return totalRentalCost;
	}
	
	public double getCost() {
		return carCost + getRentalCost();
	}
}