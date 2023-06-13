package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
//		PageFactory.initElements(driver, HomePage.class);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Contact")
	public WebElement contact;

	@FindBy(linkText = "Start Shopping »")
	public WebElement shopping;

	public ContactPage gotoContactPage() {

//		WebElement contact = driver.findElement(By.linkText("Contact"));
		contact.click();

		return new ContactPage(driver);
//		return PageFactory.initElements(driver, ContactPage.class);

	}

	public ShopPage clickOnStartShopping() {

//		driver.findElement(By.linkText("Start Shopping"));

		shopping.click();

		return new ShopPage(driver);
//		return PageFactory.initElements(driver, ShopPage.class);

	}

}
