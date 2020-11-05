package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator
{

	private RideRepository rideRepository;

	public CabInvoiceGenerator()
	{
		rideRepository = new RideRepository();
	}

	/**
	 * @param rides
	 * @return invoice
	 */
	public InvoiceSummary calculateFare(Ride[] rides)
	{
		double totalFare = 0;
		for (Ride ride : rides)
		{
			totalFare += ride.cabRideType.calculateFarePerRide(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	/**
	 * @param userId
	 * @return invoice of a user
	 */
	public InvoiceSummary getInvoiceSummary(String userId)
	{
		return calculateFare(rideRepository.getUserRides(userId));
	}

	/**
	 * @param adds  rides detail for a particular userId
	 * @param rides
	 */
	public void addRides(String userId, Ride[] rides)
	{
		rideRepository.addUserRide(userId, rides);
	}

	public void setRideRepository(RideRepository rideRepository)
	{
		this.rideRepository = rideRepository;

	}
}
