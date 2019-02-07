package com.healthCareDomain.practo.testCases;

import org.testng.annotations.Test;

import com.healthCareDomain.practo.base.TestBase;
import com.healthCareDomain.practo.pages.HomePage;
import com.healthCareDomain.practo.pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class LoginTest extends TestBase{
 
	
	
	
	
	
	@Test
  public void loginToapp001() throws InterruptedException {
		
		
		
		
	//  new PageFactory();
	LoginPage loginpage= new LoginPage(driver);
	HomePage homePage=new HomePage(driver);
	
	
	  
	  loginpage.loginToPracto();
	  waitForPageLoad();
	  System.out.println(pageTitle());
	  
	  System.out.println(homePage.getUserName().toString());
	  
	 // homePage.chatWithAdoctorPage();
	  
	 // assertEquals(pageTitle(),"Practo Accounts" );
	  
	  
	  
	// homePage.OrderMedicineOnlinePage();
	  
	  
	  
	  
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  initialization();
	  System.out.println(pageTitle());
	  waitForPageLoad();
	//  dismissAlert();
	  Thread.sleep(5000);
	 // new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
  }

  @AfterMethod
  public void afterMethod() {
	  teardownMethod();
  }

}
