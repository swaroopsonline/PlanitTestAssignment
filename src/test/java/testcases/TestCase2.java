package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.ContactPage;
import pages.HomePage;
import utilities.DataUtil;

public class TestCase2 extends BaseTest{
	
	@Test(dataProviderClass =  DataUtil.class, dataProvider = "dp", invocationCount = 5)
	public void giveFeedback(String browser, String runmode, String thanks_userName) {
		
		if(runmode.equals("N")) {
			
			throw new SkipException("Skipping the test as the Run mode is NO");
			
		}
		
//		setUp("chrome");	
		setUp(browser);
		HomePage home = new HomePage(driver);		
		ContactPage contactpage = home.gotoContactPage();	
		contactpage.feedback_info();
		
		System.out.println(BasePage.messageBase.getThanksMsg());
		AssertJUnit.assertEquals(BasePage.messageBase.getThanksMsg(), thanks_userName);
		
	}
	
	

}
