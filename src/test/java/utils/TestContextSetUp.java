package utils;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class TestContextSetUp {
	
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase; 
    public GenericUtils genericUtils;
    
	public TestContextSetUp() {
		
		testBase = new TestBase();
		pageObjectManager= new PageObjectManager(testBase.WebDriverManagaer());
		genericUtils = new GenericUtils(testBase.WebDriverManagaer());
		
	}
}
