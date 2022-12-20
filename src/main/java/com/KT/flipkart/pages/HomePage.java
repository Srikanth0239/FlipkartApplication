package com.KT.flipkart.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	
	public WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='From']")
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
	
	@FindBy(xpath="//table[@class='CalendarMonth_table CalendarMonth_table_1']/tbody/tr/td")
	List<WebElement> deptdate;
	
	@FindBy(xpath="//button[@id='dd-guest-class-type']")
	WebElement cabin;
	@FindBy(xpath="//button[@id='dd-passenger-type']")
	WebElement passangertype;
	
	
	
	public void selectFrom(String CityFrom)
	{
		from.clear();
		from.sendKeys(CityFrom);
		Select sele=new Select(from);
		List<WebElement> cityList=sele.getOptions();
		
		for (WebElement Auto : cityList) 
		{
			if (Auto.getText().equalsIgnoreCase(CityFrom)) 
			{
				Auto.click();
				break;
			}
		}
		
	}
}
