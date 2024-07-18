package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	 public  LandingPage landingPage;
	 public  OffersPage offerPage;
	 public  WebDriver driver;
	 
	 


 public void PageObjectManage(WebDriver drive) {
	 
	 this.driver=driver;
 }

 public LandingPage getLandingPage() {
	 
	 landingPage = new LandingPage(driver);
	 return landingPage;
 }
 
 public OffersPage getOfferPage() {
	 
	 offerPage= new OffersPage(driver);
	 return offerPage;
 }


}
