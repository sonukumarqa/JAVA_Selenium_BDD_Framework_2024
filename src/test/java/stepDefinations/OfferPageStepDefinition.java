package stepDefinations;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.OffersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetUp;

public class OfferPageStepDefinition {
	
TestContextSetUp testContextSetup;
public String offersPageProductName;

public OfferPageStepDefinition(TestContextSetUp testContextSetup) {
	
	this.testContextSetup=testContextSetup;
}
	
@Then("user searched for {string} shortname in offers page")
public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
	switchToOfferpage();
    OffersPage offerPage= new OffersPage(testContextSetup.driver);
    offerPage.searchItem(shortName);
	offersPageProductName= offerPage.getProductName();
    System.out.println("offersPageProductName: "+ offersPageProductName);                                             
}

 public void switchToOfferpage() throws InterruptedException {
	 
//	    if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
//	    {
//	    	System.out.println("alreay switched");
//	    }
	 
	   // LandingPage landingPage= new LandingPage(testContextSetup.driver);
	 LandingPage landingPage= testContextSetup.pageObjectManager.getLandingPage();
	    Thread.sleep(3000);
	    landingPage.selectTopDeals();
	    testContextSetup.driver.findElement(By.linkText("Top Deals")).click();		
		Set<String> s1  = testContextSetup.driver.getWindowHandles();
	    Iterator<String> i1= s1.iterator();
	    String ParentWindow= i1.next();
	    String childWindow= i1.next();
	    
	    testContextSetup.driver.switchTo().window(childWindow); 
	      
 }

  @Then("validate product name in offers page matches with Landing Page")
  public void validate_product_name_in_offers_page_matches_with_Landing_Page()
  {
	Assert.assertEquals(offersPageProductName, testContextSetup.landingPageProductName);
	testContextSetup.driver.quit();  
  }


	
	
}
