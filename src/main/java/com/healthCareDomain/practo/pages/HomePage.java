package com.healthCareDomain.practo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.healthCareDomain.practo.base.TestBase;

public class HomePage extends TestBase{
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath="//span[@class='up-triangle']//span[@class='user_info_top'][contains(text(),'Chinmaya')]")
	WebElement userName;
	
	
	
	@FindBy(xpath="//div[@class='u-d nav-dropdown text-left active-state']//a[@class='user_name'][contains(text(),'Chinmaya')]")
	WebElement userName1;
	
	@FindBy(xpath="//a[@title='Chat with a doctor']")
	WebElement chatWithADoctorLink;
	

	


	public Object getUserName() {
		System.out.println("get user name method is being executed");
		userName.click();
		// TODO Auto-generated method stub
		 return userName1.getText();
	}



	public Object chatWithAdoctorPage() {
		System.out.println("redirecting to 'chat with a doctor page.'");
		chatWithADoctorLink.click();
		System.out.println(driver.getTitle());
		
		
		return driver.getTitle();
		
	}
	
	
	
	@FindBy(xpath="//a[@title='Order medicines']")
	WebElement orderMedocineLink;
	
	public Object OrderMedicineOnlinePage() {
		
		orderMedocineLink.click();
		
		System.out.println(driver.getTitle());
		
		return driver.getTitle();
		
	}
	
	
	
	
	
	

}
