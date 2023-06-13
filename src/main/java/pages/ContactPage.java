package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);
//		PageFactory.initElements(driver, ContactPage.class);
		// TODO Auto-generated constructor stub
	}

//	private WebDriver driver;
//	
//	public ContactPage(WebDriver driver) {
//		
//		this.driver = driver;
//		
//	}
	
	@FindBy(id="forename")
	public WebElement forename;
	
	@FindBy(id="surname")
	public WebElement surname;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="telephone")
	public WebElement telephone;
	
	@FindBy(id="message")
	public WebElement message;
	
	@FindBy(linkText="Submit")
	public WebElement submit;
	
//	@FindBy(className = "alert alert-success")
//	public WebElement text_msg;

	public void feedback_info() {

//		driver.findElement(By.id("forename")).sendKeys("Harry");
//		driver.findElement(By.id("surname")).sendKeys("Potter");
//		driver.findElement(By.id("email")).sendKeys("Harry.Potter@yahoo.com");
//		driver.findElement(By.id("telephone")).sendKeys("425634178");
//		driver.findElement(By.id("message")).sendKeys("It was a fantastic experience");
//		driver.findElement(By.linkText("Submit")).click(); // xpath ---> //a[contains(text(), 'Submit')]

		forename.sendKeys("Harry");
		surname.sendKeys("Potter");
		email.sendKeys("Harry.Potter@hogwarts.com");
		telephone.sendKeys("0123456789");
		message.sendKeys("It was a magical experience");
		submit.click();
		
	}
	
	public void click_submitBtn() {
		
		submit.click();
	}
	
	
	
	

}
