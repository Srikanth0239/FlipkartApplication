package com.KT.flipkart.utlies;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethodes {
	public static WebDriver driver;

	public void clickingelement(WebElement element, long timoutInSeconnds) {

		WebDriverWait waittime = new WebDriverWait(driver, Duration.ofSeconds(timoutInSeconnds));
		WebElement elements = null;
		try {
			elements = waittime.until(ExpectedConditions.elementToBeClickable(element));
			elements.click();
		} catch (Exception e) {

			System.out.println("Element is not clickable with in the time :");
			e.printStackTrace();
		}
	}

	public void enterTextvalue(WebElement element, String text) {
		try {
			element.click();
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			System.out.println("Entering the text failed");
			e.printStackTrace();
		}
	}
	
	public void handleingAlret(WebDriver driver ,String text )
	{
		if (text.equalsIgnoreCase("Accept"))
		{
			driver.switchTo().alert().accept();
		}else if(text.equalsIgnoreCase("dismiss"))
		{
			driver.switchTo().alert().dismiss();
		}else
		{
			String msg=driver.switchTo().alert().getText();
			System.out.println("Message in alret box is :" + msg);
		}
		
	}
	
	public WebElement waitForElement(WebElement nameOftheElement , long timeOutofSeconds) {
	
		WebDriverWait waitTime=new WebDriverWait(driver, Duration.ofSeconds(timeOutofSeconds));
		WebElement element=waitTime.until(ExpectedConditions.elementToBeClickable(nameOftheElement));
		return element;
		
	}
	
}
