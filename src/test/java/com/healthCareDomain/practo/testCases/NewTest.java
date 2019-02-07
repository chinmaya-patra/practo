package com.healthCareDomain.practo.testCases;

import org.testng.annotations.Test;

import com.healthCareDomain.practo.base.TestBase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class NewTest extends TestBase{
	
	
	@BeforeMethod
	public void doBeforeMethod() {
		
	}
	
	
	@AfterMethod
	public void doAfterMethod() {
		tearDown();
		System.out.println("webdriver instances are being closed");
	}
	

	//@Parameters({ "browser1","url1"})
	@Test
	public void test1(String browser1, String url1) {
		System.out.println("methode test1() running on thread:  "+ Thread.currentThread().getId());
		initialization();
		getPageTitle();
		
	}
	
	
	
	//@Parameters({ "browser","url"})
	@Test
	public void test2(String browser, String url) {
		System.out.println("methode test2() running on thread:  "+ Thread.currentThread().getId());
		initialization();
		getPageTitle();
	}
	
	
	
	
	
}
