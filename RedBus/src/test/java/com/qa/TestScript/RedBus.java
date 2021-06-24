package com.qa.TestScript;



import java.io.IOException;
import java.util.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Pages.RedbusPages;
import com.qa.Utility.UtilityClass;
import com.sun.jna.platform.win32.WinDef.POINT;


public class RedBus extends TestBaseClass
{
	

	@Test(dataProvider="getData")
	public void main(String fromaddress,String toaddress) throws InterruptedException, IOException
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
		redbus.getclosepopup().click();
		Thread.sleep(2000);
		redbus.getviewseat().click();
		Thread.sleep(2000);
		redbus.getselectseat().click();;
		
		
		WebElement target = driver.findElement(By.xpath("//*[@id=\"rt_8780251\"]/div/div/div/div[3]/div[2]/div[2]/canvas"));   //463   	743
	
		Point point=target.getLocation();
		int xcord=point.getX();
		int ycord=point.getY();
		System.out.println(xcord);
		System.out.println(ycord);
		
		
	}

	@DataProvider
	public String[][] getData() throws IOException
	{
		String xFile="C:\\Users\\ansar\\eclipse-workspace\\RedBus\\src\\test\\java\\com\\qa\\Testdata\\Book 4.xlsx";
		String xSheet="Sheet4";
		int rowCount=UtilityClass.getRowCount(xFile, xSheet);
		int cellCount=UtilityClass.getCellCount(xFile, xSheet, rowCount);

		String[][] data=new String[rowCount][cellCount];	//[5][2]

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


