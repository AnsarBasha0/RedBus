package com.qa.TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Pages.RedbusPages;
import com.qa.Utility.UtilityClass;
public class UnavailableBus extends TestBaseClass
{


	@Test(dataProvider="getData")
	public void unavilablebusses(String fromaddress,String toaddress) throws InterruptedException, IOException
	{
		RedbusPages redbus=new RedbusPages(driver);

		//First Step
		driver.manage().window().maximize();

		Thread.sleep(2000);
		redbus.getFrom().sendKeys("Tirupati");
		Thread.sleep(2000);
		redbus.getTo().sendKeys("Tirupati");
		Thread.sleep(2000);
		redbus.getclickon().click();
		Thread.sleep(2000);
		redbus.getselectdate().click();
		Thread.sleep(2000);
		redbus.getsearchbtn().click();
		String currentURL=driver.getCurrentUrl();
		
		if(currentURL=="https://www.redbus.in/")		
		{
			System.out.println("Available busses");
			Assert.assertTrue(true);
		}
		else
		{			
			System.out.println("No Busses Found");
			CaptureScreenShot(driver,"unavilablebusses");
			Assert.assertTrue(false);
		}
	

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
