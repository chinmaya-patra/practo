package com.healthCareDomain.practo.testCases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.healthCareDomain.practo.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingDemo extends TestBase{

	@Test 
	public void demo(){
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
		WebDriver driver = new ChromeDriver(options); 
		driver.get("https://www.facebook.com");
		WebElement username=null;
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//String title=js.executeScript("return document.title").toString();
		//System.out.println(title);
		//js.executeScript("document.getElementById('firstname').value='chinmaya';");
      WebElement firstNAmeTExtbox=  driver.findElement(By.xpath("//input[@name='firstname']"));
      //js.executeScript("arguments[0].value='chinmaya';", firstNAmeTExtbox);
      js.executeScript("document.getElementsByName('firstname')[0].value='chinmaya'");
      JavascriptExecutor js1= (JavascriptExecutor)driver;
     WebElement sexButton=  driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
    // sexButton.click();
      js1.executeScript("arguments[0].click();",sexButton);
     //js1.executeScript("document.getElementById('u_0_a')[0]content.click();");
      Select dayDw=new Select(driver.findElement(By.xpath("//select[@title='Day']")));
      dayDw.selectByValue("14");
      Select monDw=new Select(driver.findElement(By.xpath("//select[@title='Month']")));
      monDw.selectByVisibleText("Feb");
      Select yearDw=new Select(driver.findElement(By.xpath("//select[@title='Year']")));
      yearDw.selectByValue("1991");
      
	}

}
