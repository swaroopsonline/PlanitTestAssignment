package rough;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ShopPage;
import utilities.DataUtil;

public class CartTest extends BaseTest {
	
	public boolean frogPriceElement;
	HomePage home = new HomePage(driver);
	ShopPage shoppage = home.clickOnStartShopping();
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	public boolean frogPriceAssertion(String browser, String frog_qty, String frog_price, String bunny_qty, String bunny_price,
			String bear_qty, String bear_price) {
		
		//setUp(browser);
//		HomePage home = new HomePage(driver);
//		ShopPage shoppage = home.clickOnStartShopping();

		CartPage cartpage = shoppage.clickOnCart();

		List<WebElement> cartPageElement = cartpage.cartPageElements();

		for (WebElement webElement : cartPageElement) {

			boolean frogPriceElement = webElement.getText().contentEquals("$" + frog_price);
			if (frogPriceElement == true) {
				System.out.println("frogPriceElement is " + frogPriceElement);
				Assert.assertTrue(frogPriceElement, "$" + frog_price);
			}

		}
		
		return frogPriceElement;

	}

	public void bunnyPriceAssertion(String browser, String frog_qty, String frog_price, String bunny_qty, String bunny_price,
			String bear_qty, String bear_price) {

	}

	public void bearPriceAssertion(String browser, String frog_qty, String frog_price, String bunny_qty, String bunny_price,
			String bear_qty, String bear_price) {

	}

}
