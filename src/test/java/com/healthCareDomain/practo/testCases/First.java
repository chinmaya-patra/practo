package com.healthCareDomain.practo.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class First {
	
	public static void takesScreenshot(WebDriver driver) {
		
		Calendar cal = Calendar. getInstance();
		Date date=cal. getTime();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate=dateFormat. format(date);
		System.out.println(formattedDate);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\chinmaya\\git\\practo\\healthCareDomain\\screenshots\\"+"apple"+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
public static void highLightElement(WebDriver driver, WebElement e) {
	JavascriptExecutor js=((JavascriptExecutor)driver);
	js.executeScript("arguments[0].setAttribute('style','border:5px solid red');", e);
}
	
	
	
	

	public static void main(String[] args) {
		
		Properties prop=new Properties();
		InputStream input=null;
		input=null;
		
		try {
			input=new FileInputStream("C:\\Users\\chinmaya\\eclipse-workspace\\seleniumPractice\\data\\config.properties");
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ChromeOptions options= new ChromeOptions();
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("myhttpProxy:8080");
		//proxy.setSslProxy(sslProxy)
		options.setCapability("proxy", proxy);
		
		DesiredCapabilities cap=new DesiredCapabilities().chrome();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		
		
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\eclipse-workspace\\seleniumPractice\\BrowserDrives\\chromedriver.exe");
	
		
		WebDriver driver = new ChromeDriver(cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		
		
		driver.get(prop.getProperty("url"));
	WebElement usernamebox=	driver.findElement(By.xpath("//input[@id='txtUsername']"));
	highLightElement(driver, usernamebox);
	
	
	takesScreenshot(driver);
	
	
	usernamebox.sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getProperty("password"));
		//driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		/*WebElement logo=driver.findElement(By.xpath("//img[@src='/orangehrm/symfony/web/webres_55a775cf9fcff8.50052456/themes/default/images/logo.png']"));
		
		highLightElement(driver, logo);*/
		
		

	}

}
