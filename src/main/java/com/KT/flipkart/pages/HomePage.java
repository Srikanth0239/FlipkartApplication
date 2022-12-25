package com.KT.flipkart.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.KT.flipkart.App;

public class HomePage extends App{

	
	public WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//input[@id='oneWayOrigin']")
	WebElement from;
	@FindBy(xpath="//input[@placeholder='To']")
	WebElement to;
	@FindBy(xpath="//input[@type='radio']//parent::div//label[@for='oneWay']")
	WebElement oneway;
	
	@FindBy(xpath="//input[@type='radio']//parent::div//label[@for='roundTrip']")
	WebElement roundTrip;
	@FindBy(xpath="//input[@type='radio']//parent::div//label[@for='multiWay']")
	WebElement multiCity;
	
	@FindBy(xpath="//input[@placeholder='DD MMM YYYY' and @name='roundTripCalendarDepartDate']")
	WebElement outbound;
	@FindBy(xpath="//input[@placeholder='DD MMM YYYY' and @name='roundTripCalendarReturnDate']")
	WebElement returntrip;
	
	@FindBy(xpath="//input[@id='oneWayCalendarDepartDate']")
	WebElement onewaydate;
	
	@FindBy(xpath="//button[@id='dd-guest-class-type']")
	WebElement selectcabin;
	@FindBy(xpath="//button[@id='dd-passenger-type']")
	WebElement passangertype;
	@FindBy(xpath="(//button[@class='close-btn'])[1]")
	WebElement clearDestination;
	
	@FindBy(xpath="//a[@class='dropdown-item']//span//mark")
	WebElement cityname;
	
	@FindBy(xpath="//a[@class='dropdown-item']//span//mark")
	WebElement tocity;
	@FindBy(xpath="//div[@class='CalendarMonth_caption CalendarMonth_caption_1']/strong")
	List<WebElement> monthYear;
	@FindBy(xpath="//div[@aria-label='Move forward to switch to the next month.']")
	WebElement nextbutton;
	
	@FindBy(xpath="(//button[@aria-label='Close'])[1]")
	WebElement close;
	@FindBy(xpath="//table[@class='CalendarMonth_table CalendarMonth_table_1']")
	WebElement calender;
	
	@FindBy(how=How.XPATH ,using="//ul[@class='dropdown-menu']/li")
	List<WebElement> cabinDropDown;
	@FindBy(xpath="(//label[@class='dd-floating-value' ])[2]")
	WebElement Geust;
	@FindBy(xpath="//div[@class='dropdown-menu']//div[@class='ps-type-guest-type-lable']")
	List<WebElement> guestType;
	
	@FindBy(xpath="//div[@class='dropdown-menu']//button[@type='button' and starts-with(@id ,'passenger-type-inc-0')]")
	WebElement increse;
	
	@FindBy(xpath="//button[@class='button col_left ']")
	WebElement Search;
	
	public void selectFrom(String CityFrom) throws InterruptedException
	
	{	
		//System.out.println("city is :"+ CityFrom);
		//from.click();
		if (!from.getAttribute("value").isEmpty())
		{
			System.out.println(from.getText());
			clearDestination.click();
		}
		//Thread.sleep(2000);
		from.sendKeys(CityFrom);
		String fromcity=cityname.getText();
		if(fromcity.equalsIgnoreCase(CityFrom))
		{
			cityname.click();
		}
		
	}
	
	public void selectRT(){
		
		roundTrip.click();
		
	}
	
	public void selectOw() throws InterruptedException
	{
		oneway.click();
		Thread.sleep(200);
		close.click();
	}
	
	public void selectMulticity()
	{
		multiCity.click();
	}
	
	
	public void destination(String destination)
	{
		System.out.println(destination);
		to.click();
		if (!to.getAttribute("value").isEmpty()) {
			to.clear();
		}else {
			//String flyingto=tocity.getText();
		to.sendKeys(destination);
		}
	}
	
	public void outBound(String date) throws InterruptedException{
		
		
		//date="12/Oct/2002";
		String[] temp=date.split("/");
		String dt= temp[0];
		String month=temp[1];
		String year=temp[2];
	
		String monthofYear=month+" "+year;
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.elementToBeClickable(onewaydate));
		onewaydate.click();
		System.out.println("size of the calender si:"+monthYear.size());
		for (int i = 0; i <=monthYear.size(); i++) 
		{
		String calender=monthYear.get(i).getText();
		System.out.println("the value is :"+calender);
		while (!calender.equals(monthofYear))
		{
			//calender=monthYear.getText();
			nextbutton.click();
			//calender=monthYear.getText();
		}
		
		}
		List<WebElement> rows ,col;
		rows=this.calender.findElements(By.tagName("tr"));
		boolean falg=false;
		for (int i = 0; i < rows.size(); i++) 
		{
			col=rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < col.size(); j++) 
			{
				if (col.get(i).getText().equals(dt))
				{
					col.get(j).click();
					falg=true;
					break;
				}
			}
			if (falg) 
			{
				break;
			}
		}
		
	/*	for (int i = 0; i <monthYear.size(); i++)
		{
			String monthAndYear=monthYear.get(i).getText();
			//System.out.println("month and year is :"+ monthAndYear);
			//String[] mon=monthAndYear.split(" ");
			
			if (!(monthAndYear==monthofYear)) 
			{
				monthAndYear=monthYear.get(i).getText();
				nextbutton.click();
			}
			
			
		}*/
		
		
	}
	
	
	public String autoSugession(WebElement ele)
	{
		String cityname = null;
		List<WebElement> city=ele.findElements(By.xpath("//ul[@class='rbt-menu dropdown-menu show']//li//span/mark"));
		for (int i = 0; i < city.size(); i++) 
		{
			 cityname=city.get(i).getText();
		
		}
		
		return cityname;
	}

	public void selectCabin(String cabin) 
	{
		
		System.out.println("given cabin :"+ cabin);
		selectcabin.click();
		List<WebElement> dropdown=cabinDropDown;
		
		for (int i = 0; i <dropdown.size(); i++)
		{
			//System.out.println("Cabins are :"+dropdown.get(i).getText());
			if (dropdown.get(i).getText().equalsIgnoreCase(cabin)) 
			{
				dropdown.get(i).click();
			//	break;
			}
		}
		
		}
	
	public void selectGuest(String type) throws InterruptedException
	{
		Thread.sleep(2000);
		Geust.click();
		List<WebElement> Guesttype=guestType;
		
		for (int i = 0; i <Guesttype.size(); i++)
		{
			
			System.out.println("Guest type  :"+Guesttype.get(i).getText());
			if (Guesttype.get(i).getText().equalsIgnoreCase(type)) 
			{
				Guesttype.get(i).click();
				
			}
		}
		increse.click();
	}
	
	public void clickSearch()
	{
		Search.click();
		
		
	}
}
