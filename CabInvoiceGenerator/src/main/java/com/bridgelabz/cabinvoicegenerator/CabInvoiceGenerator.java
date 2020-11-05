package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator
{

	private static final double COST_PER_KILOMETER = 10;
	private static final double COST_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;
	private RideRepository rideRepository;

	public CabInvoiceGenerator() {
		rideRepository = new RideRepository();
	}
	public double calculateFare(double distance, int time)
	{
		double totalFare = COST_PER_KILOMETER * distance + COST_PER_MINUTE * time;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	public InvoiceSummary calculateFare(Ride[] rides)
	{
		double totalFare = 0;
		for (Ride ride : rides)
		{
			totalFare += calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return calculateFare(rideRepository.getUserRides(userId));
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addUserRide(userId, rides);
	}
}
