package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest
{
	CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

	@Test
	public void givenDistanceAndTime_WhenAnalyse_ShouldReturnTotalFare()
	{
		double totalFare = cabInvoiceGenerator.calculateFare(2.5, 5);
		Assert.assertEquals(30, totalFare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_WhenAnalyse_ShouldReturnMinimumFare()
	{
		double totalFare = cabInvoiceGenerator.calculateFare(0.1, 1);
		Assert.assertEquals(5, totalFare, 0.0);
	}

	@Test
	public void givenMultipleRides_WhenAnalyse_ShouldReturnInvoiceSummary()
	{

		Ride[] rides = { new Ride(2.5, 5), new Ride(0.2, 1) };
		InvoiceSummary actualInvoiceSummary = cabInvoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 35);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

}
