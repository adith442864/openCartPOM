package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void test_login() {
	
	try {
	
		logger.info("*** Starting TC_002_LoginTest *** ");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		hp.clickLogin();
		logger.info("Clicked on Login Button");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(rb.getString("email")); //valid email, get from config.properties
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		
		MyAccountPage mac = new MyAccountPage(driver);
		boolean targetPage = mac.ismyAccountPageExists();
		Assert.assertEquals(targetPage, true, "Invalid login data");
		
	}
	catch(Exception e) {
		Assert.fail();
	}
		logger.info("*** Finished TC_002_LoginTest ***");
	}

}
