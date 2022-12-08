package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test
	public void test_account_Registration() {
		
		try {
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.setFirstName("abc");
		
		regPage.setLastName("xyz");
		
		regPage.setEmail(randomString()+"@gmail.com");
		
		regPage.setTelephone(randomNumber());
		
		String password= randomAlphaNumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		
		regPage.setPrivacyPolicy();
		
		regPage.clickContinue();
		
		String confMsg = regPage.stringGetConfirmationMsg();
		Assert.assertEquals(confMsg, "Your Account Has Been Created!");
		
		}
		catch(Exception e) {
			e.getStackTrace();
			Assert.fail();
		}
		
		
		
		
		
		
	}
	
	
		
	
}
