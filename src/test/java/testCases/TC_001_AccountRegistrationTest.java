package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test
	public void test_account_Registration() {
//		logger.debug("application logs");
		logger.info("***Starting TC_001_AccountRegistrationTest***");
		
	try {
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		logger.info("Providing Customer data");
		regPage.setFirstName("abc");
		
		
		regPage.setLastName("xyz");
		
		regPage.setEmail(randomString()+"@gmail.com");
		
		regPage.setTelephone(randomNumber());
		
		String password= randomAlphaNumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		
		regPage.setPrivacyPolicy();
		
		regPage.clickContinue();
		logger.info("Clicked on Continue Button");
		
		String confMsg = regPage.stringGetConfirmationMsg();
		logger.info("Validating expected message");
		Assert.assertEquals(confMsg, "Your Account Has Been Created!");
		
		
		}
	catch(Exception e) {
			e.getStackTrace();
			logger.error("Test Failed...");
			Assert.fail();
		}
		
		
	logger.info("***Finished TC_001_AccountRegistrationTest***");
		
		
		
	}
	
	
		
	
}
