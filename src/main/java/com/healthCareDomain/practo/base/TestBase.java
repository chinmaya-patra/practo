package com.healthCareDomain.practo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/"
					+ "healthCareDomain/practo/config/config.properties");
					
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		String url=prop.getProperty("url");
		
		if(browserName.equals("chrome")){
			
			 // Create object of HashMap Class
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
			driver = new ChromeDriver(options); 
		}
		else if(browserName.equals("ff")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\chinmaya\\git\\repository\\healthCareDomain\\driverExecutables\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		
		
		else if(browserName.equals("htmlunit")){
			 driver = new HtmlUnitDriver(true);
		}
		
		else if(browserName.equals("phantomjs")) {
			System.setProperty("phantomjs.binary.path", "C:\\Users\\chinmaya\\git\\repository\\healthCareDomain\\driverExecutables\\phantomjs.exe");
			driver= new PhantomJSDriver();
		}
		
		
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		//eventListener = new WebEventListener();
		//e_driver.register(eventListener);
		//driver = e_driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//driver.get(prop.getProperty("url"));
		driver.get(url);
		
		
		
		
	}
	

	public static void tearDown() {
		driver.quit();
	}
	
	public static void getPageTitle() {
	System.out.println(driver.getTitle());
	}
	public static String pageTitle() {
		String title=driver.getTitle();
		return title;
	}
	
	public static void teardownMethod() {
		driver.quit();
	}
	
	public static void waitForPageLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
	}
	
	public static void dismissAlert() {
		try {

			   // Check the presence of alert
			   Alert alert = driver.switchTo().alert();

			   // if present consume the alert
			   alert.dismiss();;

			  } catch (NoAlertPresentException ex) {
			     //code to do if not exist.
			  }

	}
	
	
	
}
