package Test_Cases;

import java.io.IOException;


import org.testng.annotations.Test;

import Page_Objects.Home_Page;
//import Page_Objects.Pop_up_Page;
import test_base.Base_Class;

public class TS_02_HotelAdultCount extends Base_Class {

	@Test(groups= {"regression"})
	public void noOfAdults() throws IOException {
		
		Home_Page hp= new Home_Page(driver);
		hp.clickHotelTab();
		logger.info("Clicked on Hotel tab");
		hp.listData();
		logger.info("All element in list is printed in Console");
		captureScreen("Adult_List");
		logger.info("Screenshot of adult List taken");
		
	}
}
