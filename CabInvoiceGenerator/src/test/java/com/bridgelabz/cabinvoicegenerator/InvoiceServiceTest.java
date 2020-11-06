package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest
{
	CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

	@Test
	public void givenUserIdAndRidesForNormaAndPremimum_WhenAnalyse_ShouldReturnInvoiceSummary()
	{
		RideRepository rideRepository = new RideRepository();
		String userId = "user@id.com";
		Ride[] rides = { new Ride(CabRide.PREMIUM, 2, 5), new Ride(CabRide.NORMAL, 0.2, 1),
				new Ride(CabRide.NORMAL, 5, 5) };
		cabInvoiceGenerator.setRideRepository(rideRepository);
		cabInvoiceGenerator.addRides(userId, rides);
		InvoiceSummary actualInvoiceSummary = cabInvoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 100);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

}
