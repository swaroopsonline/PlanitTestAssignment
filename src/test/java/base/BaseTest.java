package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.log4testng.Logger;

import utilities.ExcelReader;

public class BaseTest {

	public WebDriver driver;
	private Properties OR = new Properties();
	private Properties config = new Properties();
	private Logger log = Logger.getLogger(BaseTest.class);
	private WebDriverWait wait;
	private FileInputStream fis;
	public ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
//	public MonitoringMail mail = new MonitoringMail();

	
	
	public void setUp(String browser) {

		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		log.info("Test execution started");

		try {
			fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
			log.info("OR Properties loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream("./src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.info("Config Properties loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (browser.equals("chrome")) {

//			Map<String, Object> prefs = new HashMap<String, Object>();
//			prefs.put("profile.default_content_setting_values.notifications", 2);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
//			options.setExperimentalOption("prefs", prefs);
			options.setHeadless(false);

			driver = new ChromeDriver(options);
			log.info("Chrome browser launched");
		} else if (browser.equals("firefox")) {
			
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");
			options.setHeadless(false);
			
			driver = new FirefoxDriver(options);
			log.info("Firefox browser launched");
		}

		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
		
		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to : " + config.getProperty("testsiteurl"));

//		try {
//			DbManager.setMysqlDbConnection();
//			log.info("DB Connection established");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	
	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
			log.info("Test execution completed !!!");
		}
	}

}
