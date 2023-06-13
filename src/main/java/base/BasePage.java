package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public static WebDriver driver;
	public static MessageBase messageBase;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		messageBase = new MessageBase(driver);
		PageFactory.initElements(driver, this);
		
	}

}
