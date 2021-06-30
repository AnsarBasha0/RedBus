package com.qa.TestScript;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class TestBaseClass 
{
	protected static WebDriver driver;
	
	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void Setup(String Browser,String Url)
	{
		
		if(Browser.equalsIgnoreCase("edge")) 
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\ansar\\git\\repository4\\RedBus\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\ansar\\git\\repository4\\RedBus\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(Url);
		
		
	}
	@AfterClass
	public void tearDown()
	{
		System.out.println("completed");
		driver.close();
	}
	
	
	public void CaptureScreenShot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver ;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"/ScreenShots/"+tname+".png";
		FileUtils.copyFile(source, new File(dest));
		
	}
	
	
}
