package stepDefinations;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetUp;

public class LandingPageStepDefination {
	
	WebDriver driver;
	public String landingPageProductName;
	TestContextSetUp testContextSetup;
	public String offersPageProductName;
	
	// Sprint framework, EJB
	
public LandingPageStepDefination(TestContextSetUp testContextSetup) {

	this.testContextSetup= testContextSetup;
}

@Given("User is on GreeCart Landing  Page")
public void user_is_on_gree_cart_landing_page() {
   
	System.setProperty("webdriver.chrome.driver", "E://ECLIPSEWorknew//CucumberFramework//chromedriver.exe");
	testContextSetup.driver= new ChromeDriver();
	testContextSetup.driver.manage().window().maximize();
	testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	testContextSetup.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}



@When("user searched with Shortname {string} and extracted actual name of product")
public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
	
	LandingPage landingPage= testContextSetup.pageObjectManager.getLandingPage();
	landingPage.searchItem(shortName);
	Thread.sleep(2000);	
	testContextSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim(); // trim()-> will remove spaces from front and back
	System.out.println(landingPageProductName +" is extracted from HomePage ");
	

  }
	
	
}
