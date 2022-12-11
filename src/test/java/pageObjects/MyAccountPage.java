package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Page Locators:
	@FindBy(xpath="//a[@class='list-group-item' and text()='Logout']")
	WebElement lnkLogout;
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	public boolean ismyAccountPageExists() {
		try {
			return (msgHeading.isDisplayed());
		}
			catch(Exception e) {
				return (false);
			}
		}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
	
}
	
