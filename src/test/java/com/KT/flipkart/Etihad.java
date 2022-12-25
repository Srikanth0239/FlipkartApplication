package com.KT.flipkart;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.KT.flipkart.pages.HomePage;

public class Etihad extends App {
	
	
	static WebDriver driver = null;
	static HomePage hp;
	public static void main(String[] args) throws IOException, InterruptedException {
		
		driver = App.startbrowser();
		App.openApplication(driver);
		hp=new HomePage(driver);
		hp.selectOw();
	//	App.waitforElement(driver, null, null, null);
		hp.selectFrom("Bengaluru");
		hp.destination("Abu Dhabi, AUH");
		//hp.outBound("25/May/2023");
		hp.selectCabin("First");
		hp.selectGuest("Children");
		hp.clickSearch();		
		
		
	}
	
	
}
