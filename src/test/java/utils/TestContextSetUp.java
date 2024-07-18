package utils;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class TestContextSetUp {
	
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;

	public TestContextSetUp() {
		
		PageObjectManager pageObjectManager= new PageObjectManager();
	}
}
