package rough;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pages.ContactPage;
import pages.HomePage;

public class feedbackInfoTest {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://jupiter.cloud.planittesting.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		HomePage home = new HomePage(driver);
//		HomePage home = PageFactory.initElements(driver, HomePage.class);
		ContactPage contactpage = home.gotoContactPage();	
		contactpage.feedback_info();
		
//		String expected_msg = "Thanks Harry, we appreciate your feedback.";
		String thank_msg = driver.findElement(By.xpath("//*[contains(text(), 'Thanks')]")).getText();
		
//		Assert.assertEquals(expected_msg, thank_msg);
//		Assert.assertNotEquals(null, null)
		
		System.out.println(thank_msg);
		
		//*[contains(text(), 'Thanks')] ---> partial text for assertion
		
		driver.quit();


	}

}
