package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;

	public WebDriver WebDriverManagaer() throws IOException {
		
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop= new Properties();
		prop.load(file);
		String url=prop.getProperty("QAUrl");
		if(driver == null) {
			System.out.println("=================================="+prop.getProperty("browser"));
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.out.println("=================================="+prop.getProperty("browser")+"===="+ System.getProperty("user.dir"));
	     	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
		}
			if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				
			}
			
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
		
	}
}
