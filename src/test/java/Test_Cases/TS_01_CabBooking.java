package Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;


import Page_Objects.Cab_Booking_Page;
import Page_Objects.Home_Page;
import Utils.Data_Providers;
import test_base.Base_Class;


public class TS_01_CabBooking extends Base_Class {
	@Test(priority = 1, dataProvider = "DataInput", dataProviderClass=Data_Providers.class, groups= {"sanity" ,"regression"})
	public void fillingDetails(String fromCity,String toCity, String date, String time ,String zone) throws InterruptedException, IOException {
		Home_Page hp= new Home_Page(driver);
		hp.clickCabTab();
		hp.fillFromCity(fromCity);
		logger.info(fromCity+" is put in 'from' City");
		hp.fillToCity(toCity);
		logger.info(toCity+" is put in 'to' City");
		hp.datePicker(date);
		logger.info("Date picked successfully");
		hp.timeSelector(time,zone);
		logger.info("Time selected successfully");
		captureScreen("Data_Provided");
		logger.info("Screenshot Captured");
		hp.clickSearch();
		logger.info("Search option clicked");
		
		Cab_Booking_Page cbp= new Cab_Booking_Page(driver);
		cbp.clickSUV();
		logger.info("SUV clickbox selected");
		captureScreen("Min_Cab_Price");
		logger.info("Screenshot Captured");
		cbp.minPrice(fromCity,toCity);
		logger.info("Minimum price is read and printed");
		
		cbp.returnHomePage();
		logger.info("Returned to MakeMyTrip Home page");
	}
	

}
