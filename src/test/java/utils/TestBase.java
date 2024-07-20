package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;

	public WebDriver WebDriverManagaer() {
		if(driver == null) {
		System.setProperty("webdriver.chrome.driver", "E://ECLIPSEWorknew//CucumberFramework//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
		
	}
}
