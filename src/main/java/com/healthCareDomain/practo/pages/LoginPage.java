package com.healthCareDomain.practo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.healthCareDomain.practo.base.TestBase;

public class LoginPage extends TestBase{
WebDriver driver;

public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);

}


@FindBy(xpath="//a[@class='btn-border nav-login nav-interact ']")
WebElement signinLink;



@FindBy(xpath="//input[@id='username']")
WebElement userNameTextbox;


@FindBy(xpath="//input[@id='password']")
WebElement pswTextbox;


@FindBy(xpath="//button[@id='login']")
WebElement SinginButton;




public void loginToPracto() throws InterruptedException {
	
	signinLink.click();
	
	Thread.sleep(5000);
	
	userNameTextbox.sendKeys(prop.getProperty("username"));
	pswTextbox.sendKeys(prop.getProperty("password"));
	//System.out.println("hii");
	
	SinginButton.click();
}



}
