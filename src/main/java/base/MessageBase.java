package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageBase {

	public WebDriver driver;

	public MessageBase(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[contains(text(), 'Thanks')]")
	private WebElement thanksMsg;

	public String getThanksMsg() {

		return thanksMsg.getText();

	}

	@FindBy(id = "forename-err")
	private WebElement foreNameError;
	
	public String foreNameErrorMsg() {		
		
		return foreNameError.getText();
	}

	@FindBy(id = "email-err")
	private WebElement emailError;
	
	public String emailErrorMsg() {
		
		return emailError.getText();
	}
	
	@FindBy(id = "message-err")
	private WebElement feedbackError;
	
	public String feedbackErrorMsg() {
		
		return feedbackError.getText();
	}

}
