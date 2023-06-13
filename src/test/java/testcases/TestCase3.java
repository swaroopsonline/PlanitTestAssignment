package testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ShopPage;
import rough.CartTest;
import utilities.DataUtil;

public class TestCase3 extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	public void shoppingItems(String browser, String frog_qty, String frog_price, String bunny_qty, String bunny_price,
			String bear_qty, String bear_price) {

		setUp(browser);
		HomePage home = new HomePage(driver);
		ShopPage shoppage = home.clickOnStartShopping();

		float frogprice = Float.parseFloat(frog_price);
		float frogqty = Float.parseFloat(frog_qty);

		int fqty = Math.round(frogqty);

		double frog_price_total = frogprice * fqty;
		double frogTotalPrice = Math.round(frog_price_total * 100.0) / 100.0;
		System.out.println("frog price total is " + frogTotalPrice);

		for (int i = 1; i <= fqty; i++) {
			shoppage.buyStuffedFrog();
		}

		float bunnyprice = Float.parseFloat(bunny_price);
		float bunnyqty = Float.parseFloat(bunny_qty);

		int bqty = Math.round(bunnyqty);

		double bunny_price_total = bunnyprice * bqty;
		double bunnyTotalPrice = Math.round(bunny_price_total * 100.0) / 100.0;

		System.out.println("bunny price total is " + bunnyTotalPrice);

		for (int i = 1; i <= bqty; i++) {
			shoppage.buyFluffyBunny();
		}

		float bearprice = Float.parseFloat(bear_price);
		float bearqty = Float.parseFloat(bear_qty);

		int brqty = Math.round(bearqty);

		double bear_price_total = bearprice * brqty;
		double bearTotalPrice = Math.round(bear_price_total * 100.0) / 100.0;

		System.out.println("bear price total is " + bearTotalPrice);

		for (int i = 1; i <= brqty; i++) {
			shoppage.buyValentineBear();
		}

		double sum_Total = frogTotalPrice + bunnyTotalPrice + bearTotalPrice;
		double sumTotal = Math.round(sum_Total * 100.0) / 100.0;

		System.out.println("Sum Total is " + sumTotal);

		/* All the price verification begins from the below lines */

		CartPage cartpage = shoppage.clickOnCart();

		List<WebElement> cartPageElement = cartpage.cartPageElements();

		for (WebElement webElement : cartPageElement) {

			boolean frogPriceElement = webElement.getText().contentEquals("$" + frog_price);
			boolean bunnyPriceElement = webElement.getText().contentEquals("$" + bunny_price);
			boolean bearPriceElement = webElement.getText().contentEquals("$" + bear_price);

			boolean frogPriceTotalElement = webElement.getText().contentEquals("$" + frogTotalPrice);
			boolean bunnyPriceTotalElement = webElement.getText().contentEquals("$" + bunnyTotalPrice);
			boolean bearPriceTotalElement = webElement.getText().contentEquals("$" + bearTotalPrice);

			if (frogPriceElement == true) {

//				System.out.println("frogPriceElement is " + frogPriceElement);
				Assert.assertTrue(frogPriceElement, "$" + frog_price);

			}

			if (bunnyPriceElement == true) {

//				System.out.println("bunnyPriceElement is " + bunnyPriceElement);
				Assert.assertTrue(bunnyPriceElement, "$" + bunny_price);

			}

			if (bearPriceElement == true) {

//				System.out.println("bearPriceElement is " + bearPriceElement);
				Assert.assertTrue(bearPriceElement, "$" + bear_price);
			}

			if (frogPriceTotalElement == true) {

//				System.out.println("frogPriceTotalElement is " + frogPriceTotalElement);
				Assert.assertTrue(frogPriceTotalElement, "$" + frogTotalPrice);

			}

			if (bunnyPriceTotalElement == true) {

//				System.out.println("bunnyPriceTotalElement is " + bunnyPriceTotalElement);
				Assert.assertTrue(bunnyPriceTotalElement, "$" + bunnyTotalPrice);

			}

			if (bearPriceTotalElement == true) {

//				System.out.println("bearPriceTotalElement is " + bearPriceTotalElement);
				Assert.assertTrue(bearPriceTotalElement, "$" + bearTotalPrice);

			}

		}

		String totalFromCartPage = cartpage.total.getText();
		System.out.println("totalFromCartPage is --->" + totalFromCartPage);

		boolean total = cartpage.total.getText().contentEquals("Total: " + sumTotal);

		System.out.println("total is " + total);
		Assert.assertTrue(total);

	}

}
