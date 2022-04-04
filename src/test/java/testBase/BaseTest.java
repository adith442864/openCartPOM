package testBase;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class BaseTest {
	
	public WebDriver driver;
	public HomePage hp;
	public AccountRegistrationPage regPage;
	public Logger logger; //for logging
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browserName) {
		
		// load config.properties file
		rb = ResourceBundle.getBundle("config");
		
		logger = LogManager.getLogger(this.getClass());
		
		//driver handle
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Launched Chrome Browser" +browserName);
		} else 	if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Launched Firefox Browser" +browserName);
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Launched Edge Browser" +browserName);
		}else {
			System.out.println("Incorrect Browser.. Please pass the correct browser" +browserName);
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//read value from the properties file dynamically:
		driver.get(rb.getString("appURL"));
		logger.info("Launch HomePage");
		hp = new HomePage(driver);
		regPage = new AccountRegistrationPage(driver);
		
	}
	
	//create Java Method to random pick the email ID at the runtime
		public String randomString() {
			String generatedString = RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		
		public int randomNumber() {
			String generatedNumber = RandomStringUtils.randomNumeric(5);
			return (Integer.parseInt(generatedNumber));
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}


}