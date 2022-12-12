package com.KT.flipkart;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.KT.flipkart.utlies.PropertyFile;

public class AppTest {
	static WebDriver driver = null;

	public static void main(String[] args) throws IOException, InterruptedException {

		driver = App.startbrowser();
		App.openApplication(driver);
		App.clickAction(driver, "xpath", PropertyFile.getValueForKey("close"));
		App.scrolldown(driver);
		List<WebElement> productname = App.listOfElements(driver, "xpath", PropertyFile.getValueForKey("category"));
		//System.out.println("list size is :" + productname.size());
		
			
			for (int i = 0; i < productname.size(); i++) {
				String NamesoftheCatogery = productname.get(i).getText();
				//System.out.println("printing the name :"+ NamesoftheCatogery);
				 if (NamesoftheCatogery.equalsIgnoreCase(PropertyFile.getValueForKey("SerachCatogery"))) 
				  {
				    System.out.println("Youe have choosen :"+PropertyFile.getValueForKey("SerachCatogery"));
				    App.verification(PropertyFile.getValueForKey("SerachCatogery"));
				 }else if (NamesoftheCatogery.contains(PropertyFile.getValueForKey("SerachCatogery"))) 
				 {
					String product=productname.get(i).getText();
					System.out.println("2nd condition ;"+ product);
					App.verification(product);
					break;
				 }
			}

	}

}
