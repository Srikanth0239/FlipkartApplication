package com.KT.flipkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	WebElement cabin;
	@FindBy(xpath="//button[@id='dd-passenger-type']")
	WebElement passangertype;
	@FindBy(xpath="(//button[@class='close-btn'])[1]")
	WebElement clearDestination;
	
	@FindBy(xpath="//a[@class='dropdown-item']//span//mark")
	WebElement cityname;
	
	@FindBy(xpath="//a[@class='dropdown-item']//span//mark")
	WebElement tocity;
	public void selectFrom(String CityFrom) throws InterruptedException
	
	{	
		//System.out.println("city is :"+ CityFrom);
		//from.click();
		if (!from.getAttribute("value").isEmpty())
		{
			System.out.println(from.getText());
			clearDestination.click();
		}
		Thread.sleep(2000);
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
	
	public void selectOw()
	{
		oneway.click();
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
	
	public void outBound(String date){
		
		onewaydate.click();
		date="12/Oct/2002";
		String[] temp=date.split("/");
		String dt= temp[0];
		String month=temp[1];
		String year=temp[2];
		
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
}
