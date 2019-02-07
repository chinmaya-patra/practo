package com.healthCareDomain.practo.testCases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CalanderJs {

	public static void main(String[] args) throws InterruptedException {
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
WebDriver driver = new ChromeDriver(options); 
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://www.redbus.in/");

//driver.findElement(By.xpath("//li[@class='datepicker flex1']//input[contains(@placeholder,'')]")).click();

//WebElement date=driver.findElement(By.xpath("//td[@id='09/02/2019']"));
//scrollIntoView(driver, date);
//date.click();
//WebElement adultCount=driver.findElement(By.xpath("//span[@class='adultcount'][contains(text(),'1')]"));
//JavascriptExecutor js=((JavascriptExecutor)driver);
//js.executeScript("arguments[0].setAttribute('value','2');",adultCount);


WebElement from=driver.findElement(By.xpath("//div[@class='fl search-box clearfix']//div//input[@type='text']"));
String fromCity="Bangalore";
destinationSelector(from, driver, fromCity);





WebElement to=driver.findElement(By.xpath("//input[@id='dest']"));
String toCity="hyderabad";
destinationSelector(to, driver, toCity);



WebElement departDate=driver.findElement(By.xpath("//input[@id='onward_cal']"));

String srtdate="12-Feb-2019";
//Actions actions = new Actions(driver);

//actions.moveToElement(date).click().perform();
//String departDateValue="23 Feb' 2019";
//dateAndDaySelector(driver, departDate, departDateValue);
scrollIntoView(driver, departDate, srtdate);


driver.findElement(By.xpath("//button[@class='fl button']")).click();







	}
	
	
	public static void scrollIntoView(WebDriver driver, WebElement departDate,String date) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+date+"');", departDate);
	}
	
	
	public static void destinationSelector(WebElement element,WebDriver driver, String destination) {
		element.sendKeys(destination);
		List<WebElement> toOptions=driver.findElements(By.xpath("//ul[@class='autoFill']/li"));
		
		toOptions.get(0).click();
		
		}
	}
	
	


