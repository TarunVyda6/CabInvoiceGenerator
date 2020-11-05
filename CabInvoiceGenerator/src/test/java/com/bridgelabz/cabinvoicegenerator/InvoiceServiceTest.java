package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest
{
	@Test
	public void givenDistanceAndTime_WhenAnalyse_ShouldReturnTotalFare()
	{
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		double totalFare = cabInvoiceGenerator.calculateFare(2.5, 5);
		Assert.assertEquals(30, totalFare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_WhenAnalyse_ShouldReturnMinimumFare()
	{
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		double totalFare = cabInvoiceGenerator.calculateFare(0.1, 1);
		Assert.assertEquals(5, totalFare, 0.0);
	}

	@Test
	public void givenMultipleRides_WhenAnalyse_ShouldReturnAggregate()
	{
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(2.5, 5), new Ride(0.2, 1) };
		double fare = cabInvoiceGenerator.calculateFare(rides);
		Assert.assertEquals(35, fare, 0);
		
		
	}
	
	
}
