package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
	
	
	public List<WebElement> cartPageElements() {
		
		List<WebElement> cartPageElement =  driver.findElements(By.xpath("//td[@class='ng-binding']"));
		
//		System.out.println(cartPageElement.size());
		
		for(WebElement webElement  : cartPageElement) {
			
			String cartElement = webElement.getText();
//			System.out.println(cartElement);
		}
		
		return cartPageElement;
	}	
	
	@FindBy(xpath = "//*[@class='total ng-binding']")
	public WebElement total;
	
}
