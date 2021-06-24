package com.qa.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

	@Test
	public class RedbusPages 
	{
		
		WebDriver driver;
		
		@FindBy(id="i-icon-profile")
		WebElement signIn;
		public WebElement getsignIn()
		{
			
			return signIn;
		}
		
		
		

		@FindBy(id="hc")
		WebElement signInLink;
		public WebElement getsignInLink()
		{
			
			return signInLink;
		}
		
		@FindBy(id="mobileNoInp")
		WebElement mobilenumber1;
		public WebElement getmobilenumber1()
		{
			
			return mobilenumber1;
		}
		
		@FindBy(id="src")
		WebElement From;
		public WebElement getFrom()
		{
			
			return From;
		}
		
		
		
		
		
		@FindBy(id="dest")
		WebElement To;
		public WebElement getTo()
		{
			
			return To;
		}
		
		
		@FindBy(id="onward_cal")
		WebElement clickon;
		
		public WebElement getclickon()
		{
			
			return clickon;
		}
		
		@FindBy(id="onward_cal")
		static WebElement selection;
		
		public static Select getselection()
		{
			Select sel=new Select(selection);
			return sel;
		}
		
		@FindBy(xpath="//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[7]/td[3]")
		WebElement selectdate;
		
		public WebElement getselectdate()
		{
			
			return selectdate;
		}
		
		@FindBy(xpath="//button[@id='search_btn']")
		WebElement searchbtn;
		public WebElement getsearchbtn()
		{
			return searchbtn;
		}
		

		
		//*[@id="root"]/div/div[3]/div[1]/i
		@FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div[1]/i")
		WebElement closepopup;
		
		public WebElement getclosepopup()
		{
			
			return closepopup;
		}
		//*[@id="8780251"]/div/div[1]/div[1]/div[7]/div[1]/span
		@FindBy(xpath="//*[@id=\"8780251\"]/div/div[1]/div[1]/div[7]/div[1]")
		WebElement availableseat;
		
		public WebElement getavailableseat()
		{
			
			return availableseat;
		}
		
		
		//*[@id="8780251"]/div/div[2]/div[1]
		
		@FindBy(xpath="//*[@id=\"8780251\"]/div/div[2]/div[1]")
		WebElement viewseat;
		public WebElement getviewseat()
		{
			
			return viewseat;
		}
		
		//*[@id="rt_8780251"]/div/div/div/div[3]/div[2]/div[2]/canvas	-->lower
		//*[@id="rt_8780251"]/div/div/div/div[3]/div[2]/div[3]/canvas	-->upper
		@FindBy(className="pointer")
		WebElement selectseat;
		
		public WebElement getselectseat()
		{
			
			return selectseat;
		}
		
		//*[@id="8780251"]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[2]/button
		
		@FindBy(xpath="//*[@id=\"8780251\"]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[2]/button")
		WebElement proceed;
		
		public WebElement getproceed()
		{
			
			return proceed;
		}
		//*[@id="seatno-04"]
		
		@FindBy(xpath="*[@id=\"seatno-04\"]")
		WebElement passname;
		
		public WebElement getpassname()
		{
			
			return passname;
		}
		
		@FindBy(xpath="//*[@id=\"div_22_0\"]")
		WebElement gender;
		
		public WebElement getgender()
		{
			
			return gender;
		}
		
		//*[@id="seatno-01"]
		
		@FindBy(xpath="//*[@id=\"seatno-01\"]")
		WebElement age;
		
		public WebElement getage()
		{
			
			return age;
		}
		
		//*[@id="seatno-05"]
		
		@FindBy(xpath="//*[@id=\"seatno-05\"]")
		WebElement mail;
		
		public WebElement getmail()
		{
			
			return mail;
		}
		
		//*[@id="seatno-06"]
		@FindBy(xpath="//*[@id=\"seatno-06\"]")
		WebElement mobilenumber;
		
		public WebElement getmobilenumber()
		{
			
			return mobilenumber1;
		}
		
		//*[@id="root"]/div/div[4]/div[2]/div/div[5]/div/div[2]/div/label[2]/span
		
		@FindBy(xpath="//*[@id=\"root\"]/div/div[4]/div[2]/div/div[5]/div/div[2]/div/label[2]/span")
		WebElement insurence;
		
		public WebElement getinsurence()
		{
			
			return insurence;
		}
		
		//*[@id="root"]/div/div[4]/div[3]/div[2]/div[2]/input
		
		@FindBy(xpath="//*[@id=\"root\"]/div/div[4]/div[3]/div[2]/div[2]/input")
		WebElement payment;
		
		public WebElement getpayment()
		{
			
			return payment;
		}
		
		
			public RedbusPages(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
			
		
	}
