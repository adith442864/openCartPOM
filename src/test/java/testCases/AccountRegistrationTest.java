package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseTest;

public class AccountRegistrationTest extends BaseTest {
	
	@Test(groups= {"regression", "master"})
	public void Verify_Registration_Test() throws Exception {
	
	try {
		
		logger.info("Starting Registration Test....");
		 
		 hp = new HomePage(driver);
		 hp.clickMyAccount();
		 logger.info("Clicked on My Account Link...");
		 hp.clickRegister();
		 logger.info("Clicked on Registration Link...");
		 
//		 regPage = new AccountRegistrationPage(driver);
		 
		 regPage.setFirstName("John");
		 logger.info("Provided FirstName...");
		 
		 regPage.setLastName("Peter");
		 logger.info("Provided LastName...");
		 
		 regPage.setEmail(randomString()+"@gmail.com");
		 logger.info("Provided Email...");
		 
		 regPage.setTelephone(randomNumber()+"12345");
		 logger.info("Provided Telephone...");
		 
		 regPage.setPassword("test@123");
		 logger.info("Provided Password...");
		 
		 regPage.setConfirmPassword("test@123");
		 logger.info("Provided ConfirmPassword...");
		 
		 regPage.setPrivacyPolicy();
		 logger.info("Agree Policy...");
		 
		 regPage.clickContinue();
		 logger.info("Clicked on Continue...");
		 
		 String confmsg = regPage.stringGetConfirmationMsg();
		 
		 
		 if(confmsg.equals("Your Account Has Been Created!")) {
			logger.info("Account Registration Success...");
			Assert.assertTrue(true);
		 }
		 else
			 logger.info("Account Registration Failed...");
		 	captureScreen(driver, "Verify_Registration_Test");
			 //System.out.println("Test Failed...");
		 	Assert.assertTrue(false);
		}
		catch (Exception e) {
			logger.error("Account Registration Failed...");
			Assert.fail();
		
		}
	
		logger.info("Ending Registration Test...");
		
	}
		
	
	
	
	
	
}
