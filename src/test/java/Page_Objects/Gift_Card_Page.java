package Page_Objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Gift_Card_Page extends Base_Page {
	public Gift_Card_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//li[@data-cy='SingleGiftCard_468']")
	List<WebElement> giftCards;
	
	public void selectingGiftCard() {
		int randomNumbner= randomNumber();
		int i=1;
		for(WebElement ele:giftCards) {
			if(i==randomNumbner) {
				js.executeScript("arguments[0].click();", ele);
			}
			i++;
		}
	}
	
	

}
