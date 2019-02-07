package com.healthCareDomain.practo.testCases;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmail {

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
driver.get("https://www.gmail.com");

	}

}
