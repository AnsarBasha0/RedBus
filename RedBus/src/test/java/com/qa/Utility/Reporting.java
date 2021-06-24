package com.qa.Utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	ExtentHtmlReporter htmlReporter;
	ExtentReports xReporters;
	ExtentTest xTest;
	public void onStart(ITestContext Testcontext)
	{
		String timeStamp=new SimpleDateFormat("yyyy,mm,dd,HH,mm,ss").format(new Date());
		String RepName="Test-exe-report"+timeStamp+".html";

		String dest=System.getProperty("user.dir")+"/Reporter/"+RepName;

		htmlReporter =new ExtentHtmlReporter(dest);
		htmlReporter.config().setDocumentTitle("Automation Testing");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);


		xReporters= new ExtentReports();
		xReporters.attachReporter(htmlReporter);
		xReporters.setSystemInfo("hostname","localHost");
		xReporters.setSystemInfo("QA name","ansar");
		xReporters.setSystemInfo("OS","WINDOWS");

	}
	public void onFinish(ITestContext testContext) 
	{
		xReporters.flush();
	}
	public void onTestSuccess(ITestResult tr) 
	{ 
		xTest  =xReporters.createTest(tr.getName());
		xTest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		xTest.log(Status.PASS, "Test is Passed");
		


	}
	public void onTestFailure(ITestResult tr) 
	{
		xTest=xReporters.createTest(tr.getName());
		xTest.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		xTest.log(Status.FAIL, "Test is Failed");
		xTest.log(Status.FAIL,tr.getThrowable());

		String path=System.getProperty("user.dir")+"/ScreenShots/"+tr.getName()+".png";

		File file=new File(path);

		if(file.exists())
		{
			try
			{
				xTest.fail("Screen for failed test is "+xTest.addScreenCaptureFromPath(path));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}

	}
	public void onTestSkipped(ITestResult tr) 
	{
		xTest =xReporters.createTest(tr.getName()); 
		xTest.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		xTest.log(Status.SKIP, "Test is Skipped");
	}

}
