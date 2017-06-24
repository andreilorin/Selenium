package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	private static Logger logger = LogManager.getLogger(MainPage.class);
	
	private WebDriver driver;
	
	public MainPage() {
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lorin\\git\\Selenium\\drivers\\chromedriver.exe");
	}
	
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
		scrollIntoView(nameField);
		nameField.click();
		flash(nameField, driver);
		nameField.clear();
		nameField.sendKeys(name);
	}
	
	public void enterEmail(String email) {
		logger.info("Entering email: " + email);
		scrollIntoView(emailField);
		emailField.click();
		flash(emailField, driver);
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void enterPhone(String phone) {
		logger.info("Entering phone: " + phone);
		scrollIntoView(phoneField);
		phoneField.click();
		flash(phoneField, driver);
		phoneField.clear();
		phoneField.sendKeys(phone);
	}
	
	public void enterMessage(String message) {
		logger.info("Entering message: " + message);
		scrollIntoView(messageField);
		messageField.click();
		flash(messageField, driver);
		messageField.clear();
		messageField.sendKeys(message);
	}
	
	public void accessGoogle(){
		logger.info("Go to google");
		driver.navigate().to("https://www.google.com");
	}
	
	public void accessMyPage(){
		logger.info("Go to my page");
		driver.navigate().to("https://www.andreilorin.com");
	}
	
	public void backPage(){
		driver.navigate().back();
	}
	
	public void forwardPage(){
		driver.navigate().forward();
	}
	
	public void refresh(){
		driver.navigate().refresh();
	}
	
	public void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String color = element.getCssValue("backgroudColor");
		for (int i = 0; i < 3; i++) {
			changeColor(element, color, js);
		}
	}

	public void changeColor(WebElement element, String color, JavascriptExecutor js) {
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'" + element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor)element).executeScript("arguments[0].scrollIntoView(true);", driver);
	}
}
