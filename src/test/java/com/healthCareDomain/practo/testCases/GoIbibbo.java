package com.healthCareDomain.practo.testCases;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoIbibbo {
	
	public static void CitySelector(WebDriver driver, String City, WebElement element) {
		
//	element.sendKeys(City);
//Actions act=new Actions(driver);
//act.moveToElement(element).sendKeys(Keys.ARROW_DOWN).click().build();
		

//WebElement e1=driver.findElement(By.xpath(locator));
JavascriptExecutor js=((JavascriptExecutor)driver);
js.executeScript("arguments[0].setAttribute('value','"+City+"');", element);
		
		
		
	}
	
	
	
	/*
	 * private static void datepicker(WebDriver driver, String travelDate,
	 * WebElement travelDateBox) { travelDateBox.click(); String
	 * locator="//div[@id='fare_"+travelDate+"']"; WebElement
	 * e1=driver.findElement(By.xpath(locator)); JavascriptExecutor
	 * js=((JavascriptExecutor)driver); js.executeScript("argument[0].click();",
	 * e1);
	 * 
	 * }
	 */
	
	
	
	
	
	

	public static void main(String[] args) {
		
			Map<String, Object> prefs = new HashMap<String, Object>();
	        
	        // Set the notification setting it will override the default setting
	prefs.put("profile.default_content_setting_values.notifications", 2);

	        // Create object of ChromeOption class
	ChromeOptions options = new ChromeOptions();

	        // Set the experimental option
	options.setExperimentalOption("prefs", prefs);

	        // pass the options object in Chrome driver

	//System.setProperty("webdriver.chrome.driver", "???");	
	WebDriverManager.chromedriver().setup(); 
	//initialising wendriver instance
	WebDriver driver = new ChromeDriver(options);
	//appling implicit wait for webdriver instance
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//maximising the windows
	driver.manage().window().maximize();
	//navigating the website"hptts//www.goibibo.com"
	driver.get("https://www.goibibo.com");
	
//	//clicking on the flight option
//	driver.findElement(By.xpath("//i[@class='icon-flights db blue ico24 lh1-2 padT5 padB5']")).click();
//	
//	//clickon oneway flight radio button
//	driver.findElement(By.xpath("//label[contains(text(),'One Way')]")).click();		
//	
//	//entering From City
//	String fromCity="Bangalore (BLR)";
//	WebElement FromTextBox=driver.findElement(By.xpath("//input[@placeholder='From: City or Airport']"));
//	CitySelector(driver, fromCity, FromTextBox);
//	
//	
//	//entering to city
//	
//	String toCity="pune";
//	WebElement toTextBox=driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']"));
//	CitySelector(driver, toCity, toTextBox);
//	
	//entering travel date
	//String travelDate="20190223";
	//WebElement travelDateBox=driver.findElement(By.xpath("//input[@class='form-control inputTxtLarge widgetCalenderTxt' and @xpath='1']"));
  //datepicker(driver, travelDate,travelDateBox);
	
	//JavascriptExecutor js=((JavascriptExecutor)driver);
	//js.executeScript("arguments[0].setAttribute('value','');", element);
	//travelDateBox.sendKeys(travelDate);
    
    //clicking on search button
    
    driver.findElement(By.xpath("//button[@id='gi_search_btn']")).click();
    
    
    
	}







	
}
