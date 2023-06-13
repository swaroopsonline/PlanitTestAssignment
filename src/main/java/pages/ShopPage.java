package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ShopPage extends BasePage {

	public ShopPage(WebDriver driver) {
		super(driver);
//		PageFactory.initElements(driver, ShopPage.class);
		// TODO Auto-generated constructor stub
	}

	public void buyTeddyBear() {

	}
	
	@FindBy(xpath = "//*[@id=\"product-2\"]/div/p/a")
	public WebElement stuffedFrog;

	public void buyStuffedFrog() {
		
		stuffedFrog.click();		

	}

	public void buyHandMadeDoll() {

	}

	@FindBy(xpath = "//*[@id=\"product-4\"]/div/p/a")
	public WebElement fluffyBunny;

	public void buyFluffyBunny() {		
		
		fluffyBunny.click();		

	}

	public void buySmileyBear() {

	}

	public void buyFunnyCow() {

	}

	@FindBy(xpath = "//*[@id=\"product-7\"]/div/p/a")
	public WebElement valentineBear;
	
	public void buyValentineBear() {
		
		valentineBear.click();		

	}

	public void buySmileyFace() {

	}
	
	@FindBy(id = "nav-cart")
	public WebElement cart;
	
	public CartPage clickOnCart() {

		cart.click();

		return new CartPage(driver);

	}


}
