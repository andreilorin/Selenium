package testdriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
	
	private static Logger logger = LogManager.getLogger(MainPage.class);
	
	//elements
	@FindBy(id="name")
	private WebElement nameField;
	
	@FindBy(id="email")
	private WebElement emailField;
	
	@FindBy(id="phone")
	private WebElement phoneField;

	@FindBy(id="mesage")
	private WebElement messageField;
	
	@FindBy(css="#btn-success")
	private WebElement sendButton;
	
	//simple actions
	public void clickSend() {
		logger.info("Clicking send button");
		sendButton.click();
	}
	
	public void enterName(String name) {
		logger.info("Entering name: " + name);
		nameField.click();
		//TO-DO flash method
		nameField.clear();
		nameField.sendKeys(name);
	}
	
	public void enterEmail(String email) {
		logger.info("Entering email: " + email);
		emailField.click();
		//TO-DO flash method
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void enterPhone(String phone) {
		logger.info("Entering phone: " + phone);
		phoneField.click();
		//TO-DO flash method
		phoneField.clear();
		phoneField.sendKeys(phone);
	}
	
	public void enterMessage(String message) {
		logger.info("Entering message: " + message);
		messageField.click();
		//TO-DO flash method
		messageField.clear();
		messageField.sendKeys(message);
	}
	
	public void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String color = element.getCssValue("backgroudColor");
		for (int i = 0; i < 3; i++) {
			changeColor();
			changeColor();
	}
		
	//TO-DO changeColor();
}
