package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage {
	private final static Logger logger = LogManager.getLogger(FormPage.class);
	
	private WebDriver driver;
	
	@FindBy(id="name")
	private WebElement nameField;
	@FindBy(id="email")
	private WebElement emailFieldElement;
	@FindBy(id="phone")
	private WebElement phoneElement;
	@FindBy(id="message")
	private WebElement messageElement;
	
	public void fillName(String name){
		logger.info("Filling name: " + name);
		nameField.clear();
		nameField.sendKeys(name);
	}
	
	public void fillEmail(String email){
		logger.info("Filling email: " + email);
		nameField.clear();
		nameField.sendKeys(email);
	}
	
	public void fillPhone(String phone){
		logger.info("Filling phone: " + phone);
		nameField.clear();
		nameField.sendKeys(phone);
	}
	
	public void fillMessage(String message){
		logger.info("Filling message: " + message);
		nameField.clear();
		nameField.sendKeys(message);
	}
	
	public void accessGoogle(){
		logger.info("Go to google");
		driver.navigate().to("https://google.com");
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
}
