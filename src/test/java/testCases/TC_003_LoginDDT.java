package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp) {
		
		logger.info(" Starting TC_003_LoginDataDrivenTest ");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			MyAccountPage mac=new MyAccountPage(driver);
			boolean targetpage = mac.ismyAccountPageExists();// this method is created MyAccountPage

			if (exp.equals("Valid")) {
				if (targetpage == true) {
					Thread.sleep(3000);
					mac.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) {
				if (targetpage == true) {
					MyAccountPage myaccpage = new MyAccountPage(driver);
					Thread.sleep(3000);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_003_LoginDataDrivenTest");

	}

}
