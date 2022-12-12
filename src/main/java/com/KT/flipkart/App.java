package com.KT.flipkart;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.KT.flipkart.utlies.PropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {

	static WebDriver driver;

	// static List<WebElement> Name;
	// static ChromeDriver driver;

	public static WebDriver startbrowser() throws IOException {

		String OR = PropertyFile.getValueForKey("Browser");

		if (OR.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (OR.equalsIgnoreCase("fireFox")) {

			WebDriverManager.firefoxdriver().setup();
			// System.setProperty("webdriver.chrome.driver","E:\\Srikanth_82\\HybridFrameWork\\Drivers\\chromedriver.exe");
			driver = new FirefoxDriver();
		} else if (OR.equalsIgnoreCase("Edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		return driver;
	}

	public static WebDriver openApplication(WebDriver driver) throws IOException {
		//String url = PropertyFile.getValueForKey("Url");
		// System.out.println("url is :"+url);
		driver.get(PropertyFile.getValueForKey("Url"));
		driver.manage().window().maximize();
		return driver;
	}

	public static void waitforElement(WebDriver driver, String locatortype, String locatorvalue, String waittime) {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.parse(waittime));

		if (locatortype.equalsIgnoreCase("id")) {
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
		} else if (locatortype.equalsIgnoreCase("xpath")) {
			System.out.println("waiting for " + locatortype + "  " + locatorvalue);
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
		} else if (locatortype.equalsIgnoreCase("name")) {
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
		} else {
			System.out.println("unable to loacte waitforelement method with" + "  " + locatortype);
		}

	}

	public static void dataFetching(WebDriver driver, String locatortype, String locatorvalue) {
		if (locatortype.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorvalue));

		} else if (locatortype.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorvalue));

		} else {
			System.out.println("unable to loacte typeAction method with" + "  " + locatortype);
		}
	}

	/*
	 * public static String formatText(String input) { String name = input; String
	 * words[] = name.split("\\s"); String capitalizeWord = ""; for (String w :
	 * words) { String first = w.substring(0, 1); String afterfirst =
	 * w.substring(1); capitalizeWord += first.toUpperCase() +
	 * afterfirst.toLowerCase() + " "; } return capitalizeWord; }
	 */
	public static void verification(String text) throws InterruptedException {
		
		String name = text;
		String words[] = name.split("\\s");
		String capitalizeWord = "";
		for (String w : words) {
			String first = w.substring(0, 1);
			String afterfirst = w.substring(1);
			capitalizeWord += first.toUpperCase() + afterfirst.toLowerCase()+" ";
		}
		
		String formated=capitalizeWord.trim();

		//System.out.println("Formated text  :" + capitalizeWord);
//
		// System.out.println("//div[@data-tracking-id='" + formated +"']//a/div[2]");
		List<WebElement> productlist = driver.findElements(By.xpath("//div[@data-tracking-id='"+ formated +"']//a/div[2]"));

		for (int i = 0; i < productlist.size(); i++) {
			String productName = productlist.get(i).getText();
			if (i==5) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@data-tracking-id='"+ formated +"']//div[@class='_35l9rN _31Mq1b']")).click();
				Thread.sleep(2000);
			}
		System.out.println("name is :" + productName);
		}
	}

	public static List<WebElement> listOfElements(WebDriver driver, String locatortype, String locatorvalue) {

		List<WebElement> Name = null;

		if (locatortype.equalsIgnoreCase("id")) {
			Name = driver.findElements(By.id(locatorvalue));

		} else if (locatortype.equalsIgnoreCase("xpath")) {
			Name = driver.findElements(By.xpath(locatorvalue));
		} else {
			System.out.println("unable to loacte  method with" + "  " + locatortype);
		}

		return Name;

	}

	public static WebDriver scrolldown(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down till the bottom of the page
		// int height=(int)
		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		 int height = (int) js.executeScript("return document.body.scrollHeight");
		
		//WebElement ele=driver.findElement(By.xpath("//footer[@class='_3voSl0']"));
		
		//js.executeScript("window.scrollTo(0 ,document.body.scrollHeight)");
		//Thread.sleep(100);
		
		//js.executeScript("arguments[0].scrollIntoView(true)", ele);
		for (int i = 0; i < 7000; i += 7) {
			js.executeScript("window.scrollTo(0, " + i + ")");
			//js.executeScript("arguments[0].scrollIntoView(true)", ele);
			//Thread.sleep(100);
		}

		return driver;

	}

	public static void clickAction(WebDriver driver, String locatortype, String locatorvalue) {
		if (locatortype.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorvalue)).click();

		} else if (locatortype.equalsIgnoreCase("xpath")) {
			// System.out.println("clicking the button "+locatortype+"" +locatorvalue);
			driver.findElement(By.xpath(locatorvalue)).click();

		} else {
			System.out.println("unable to loacte clickAction method with" + " " + locatortype);
		}
	}

	public static void closeApp(WebDriver driver, String locatortype, String locatorvalue) {
		if (locatortype.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorvalue)).click();

		} else if (locatortype.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorvalue)).click();

		} else {
			System.out.println("unable to loacte close method with" + "  " + locatortype);
			driver.close();
		}
	}

	public static String formatText(String valueForKey) {
		//System.out.println("given string  :"+valueForKey);
		String name = valueForKey;
		 String words[] = name.split("\\s");
			String capitalizeWord = "";
			for (String w : words) {
				String first = w.substring(0, 1);
				String afterfirst = w.substring(1);
				capitalizeWord += first.toUpperCase() + afterfirst.toLowerCase() + " ";
		
	}
			//System.out.println("Converted  :"+capitalizeWord);
			return capitalizeWord;
	}

	
}
