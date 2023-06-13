package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.ContactPage;
import pages.HomePage;
import utilities.DataUtil;

public class TestCase1 extends BaseTest {
	
	@Test(dataProviderClass =  DataUtil.class, dataProvider = "dp")
	public void validateErrors(String browser, String foreNameErr, String emailErr, String feedbackErr, String thanks_userName) {
		
		setUp(browser);
		HomePage home = new HomePage(driver);
		ContactPage contactpage = home.gotoContactPage();
		contactpage.click_submitBtn();
		
		System.out.println(BasePage.messageBase.foreNameErrorMsg());
		System.out.println(BasePage.messageBase.emailErrorMsg());
		System.out.println(BasePage.messageBase.feedbackErrorMsg());
		
		AssertJUnit.assertEquals(BasePage.messageBase.foreNameErrorMsg(), foreNameErr);
		AssertJUnit.assertEquals(BasePage.messageBase.emailErrorMsg(), emailErr);
		AssertJUnit.assertEquals(BasePage.messageBase.feedbackErrorMsg(), feedbackErr);
		
		contactpage.feedback_info();
		
		Assert.assertNotEquals(foreNameErr, thanks_userName);
		Assert.assertNotEquals(emailErr, thanks_userName);
		Assert.assertNotEquals(feedbackErr, thanks_userName);		
		
	}	


}
