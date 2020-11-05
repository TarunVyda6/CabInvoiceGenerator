package com.bridgelabz.cabinvoicegenerator;

public class Ride
{

	public final int time;
	public final double distance;
	public CabRide cabRideType;

	public Ride(CabRide cabRideType, double distance, int time)
	{
		this.cabRideType = cabRideType;
		this.distance = distance;
		this.time = time;
	}

}
