package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;

public class LoginTest extends BaseTest {
	
	@Test
	public void login_test() {
		
		logger.info("Starting Login Test....");
		try {
			
			hp = new HomePage(driver);
			
			hp.clickMyAccount();
			logger.info("Clicked on My Account Link...");
			
			hp.clickLogin();
			logger.info("Clicked on Login Link...");
			
			lp = new LoginPage(driver);
			
			lp.setEmail(rb.getString("email"));
			logger.info("Provided Email");
			
			lp.setPassword(rb.getString("password"));
			logger.info("Provided Password");
			
			lp.clickLogin();
			logger.info("Login Page launched");
			
			boolean flag = lp.isMyAccountPageExists();
			System.out.println(flag);
			
			if(flag) {
				logger.info("Login Success");
				Assert.assertTrue(true); //pass
			}else {
				logger.error("Login fail");
				captureScreen(driver, "login_test");
				Assert.assertTrue(false); //fail
			}
			
			
		}catch(Exception e) {
			logger.fatal("Login failed");
			Assert.fail();
		}
		
		logger.info("Ending Login Test...");
		
	}

}
