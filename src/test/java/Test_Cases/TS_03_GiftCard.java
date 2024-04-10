package Test_Cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import Page_Objects.Gift_Card_Page;
import Page_Objects.Home_Page;
import Page_Objects.Target_GiftPage;
import test_base.Base_Class;





public class TS_03_GiftCard extends Base_Class {
	@Test(priority = 1 , groups= {"regression"})
	public void switchFrame() {
		
		Home_Page hp= new Home_Page(driver);
		hp.clickGiftCard();
		logger.info("Clicked on Gift Card Button");
		hp.switchWindow();
		logger.info("Switched to Gift Card Window");		
	}
	
	@Test(priority = 2, dependsOnMethods = {"switchFrame"} , groups= {"regression"})
	public void selectingGiftCard() throws InterruptedException {
		
		Gift_Card_Page gcp= new Gift_Card_Page(driver);
		gcp.selectingGiftCard();
		logger.info("Random Gift Card selected");
		
		Target_GiftPage tcp= new Target_GiftPage(driver);
		tcp.noOfGifts(5);
		logger.info("Multiple Gift Card option selected");
		tcp.groupGifting();
		logger.info("Gift card given to multiple people");
		
	}
	
	@Test(priority = 3, dependsOnMethods = "selectingGiftCard" , groups= {"regression"})
	public void insertingData() {
		
		Target_GiftPage tcp= new Target_GiftPage(driver);

		tcp.inputPhoneNumber();
		logger.info("Random phone number given");
		tcp.senderInfo();
		logger.info("Sender info filled in form");
		tcp.clickBuyNow();
		logger.info("Buy Now botton is clicked");
		
	}
	
	@Test(priority = 4, dependsOnMethods = "insertingData" , groups= {"regression"})
	public void cpaturingErrorMessage() throws IOException {
		
		Target_GiftPage tcp= new Target_GiftPage(driver);
		
		String error=tcp.captureErrorMessage();
		
		captureScreen("Error_Message");
		logger.info("Screenshot of error message is taken");
		
		System.out.println("Error Message: "+error);
		logger.info("Error message is read and printed in console");

		Assert.assertEquals(error,"Please enter a valid Email id.");
		logger.info("Assertion is done successfully");
	}
	
}
