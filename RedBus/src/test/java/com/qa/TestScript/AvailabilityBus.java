package com.qa.TestScript;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Pages.RedbusPages;
import com.qa.Utility.UtilityClass;

public class AvailabilityBus extends TestBaseClass
{

	

	@Test(dataProvider="getData")
	public void signIn(String fromaddress,String toaddress) throws InterruptedException, IOException
	{
		RedbusPages redbus=new RedbusPages(driver);
		 
		 //First Step
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		redbus.getFrom().sendKeys(fromaddress);
		Thread.sleep(2000);
		redbus.getTo().sendKeys(toaddress);
		Thread.sleep(2000);
		redbus.getclickon().click();
		Thread.sleep(2000);
		redbus.getselectdate().click();
		Thread.sleep(2000);
		redbus.getsearchbtn().click();
		
		//second step
		
		Thread.sleep(5000);
		//redbus.getclosepopup().click();
		String availability_of_seats=redbus.getavailableseat().getText();
		System.out.println("Total : "+availability_of_seats);
		
	}

	@DataProvider
	public String[][] getData() throws IOException
	{
		String xFile="C:\\Users\\ansar\\git\\repository4\\RedBus\\src\\test\\java\\com\\qa\\Testdata\\Book 4.xlsx";
		String xSheet="Sheet4";
		int rowCount=UtilityClass.getRowCount(xFile, xSheet);
		int cellCount=UtilityClass.getCellCount(xFile, xSheet, rowCount);

		String[][] data=new String[rowCount][cellCount];	

		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=UtilityClass.getCellData(xFile, xSheet, i, j);  
			}
		}

		return data;
	}




}
