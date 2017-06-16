package model;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Test message sending by completing the contact form with data from messenger_database, messenger table
 */
public class TestBrowser extends TestBrowserSetup {
	private final static Logger logger = LogManager.getLogger(TestBrowser.class);
	
	private WebDriver driver;
	private static SessionFactory factory;
	private Session session;

	/**
	 * Test message sending with data from the first row in the messenger table.
	 * The MessageSender.class is mapped to the messenger table in order to retrieve data
	 */
	@Test
	public void fillInformationFromFirstRowInTableIntoSiteContactForm(){	
		//Navigate to andreilorin.com
		homepage();
		
		FormPage fPage = new FormPage();
		fPage.refresh();
		fPage.accessGoogle();
		fPage.backPage();
		
		//Begin SQL transaction
		session.beginTransaction();
		
		//Get the first row from the table as a MessageSender object
		int key = 1;
		MessageSender messageSender = session.get(MessageSender.class, key);
			
		//Commit transaction
		session.getTransaction().commit();		
		
		//Complete contact form with fields from the messageSender object and send the message
		fPage.fillName(messageSender.getName());
		fPage.fillEmail(messageSender.getEmail());
		fPage.fillPhone("" + messageSender.getTel());
		fPage.fillMessage(messageSender.getMessage());
		
		//Capture screenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);           

		try {
			FileUtils.copyFile(scrFile, new File("C:\\Users\\Lorin\\Desktop\\screenshot" + key + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}    
			
		//Click the send button
		WebElement element = driver.findElement(By.id("submit"));
		element.submit();
		logger.info("Form submited");
	}
		
}
