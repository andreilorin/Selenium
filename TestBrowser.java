package testdriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

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
 * Test message sending by completing the contact form with data from
 * messenger_database, messenger table
 */
public class TestBrowser {
	//Fields
	private WebDriver driver;
	private static SessionFactory factory;
	private Session session;
	
	/**
	 * Runs just once before the test to instantiate a new SessionFactory object,
	 * configured using the "hibernate.cfg.xml" file. Adds the annotated
	 * MessageSender.class
	 */
	@BeforeClass
	public static void runOnceBeforeTesting(){
		
		//Create SessionFactory
		factory = new Configuration()
				.configure()
				.addAnnotatedClass(MessageSender.class)
				.buildSessionFactory();
		
		//Set up gecko driver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Lorin\\Desktop\\Selenium\\geckodriver.exe");
				
	}
	
	/**
	 * Runs before each unit test(before each method annotated with @Test)
	 * Sets up gecko driver, instantiates a Session object and starts 
	 * Firefox browser by instantiating a new FirefoxDriver object.  
	 */
	@Before
	public void setUpBeforeEachTest(){
		
		//Get Session 
		session = factory.getCurrentSession();	
		
		//Instantiate FirefoxDriver(open Firefox)
		driver = new FirefoxDriver();
	}
	
	/**
	 * Simple test for the navigation methods 
	 */
	@Test
	public void simpleNavigationTest(){		
		//Basic navigation methods
		driver.navigate().to("https://google.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
	
	/**
	 * Test message sending with data from the first row in the messenger table.
	 * The MessageSender.class is mapped to the messenger table in order to retrieve data
	 */
	@Test
	public void fillInformationFromFirstRowInTableIntoSiteContactForm(){	
		//Navigate to andreilorin.com
		driver.get("http://www.andreilorin.com");
		
		//Begin SQL transaction
		session.beginTransaction();
		
		//Get the first row from the table as a MessageSender object
		int key = 1;
		MessageSender messageSender = session.get(MessageSender.class, key);
			
		//Commit transaction
		session.getTransaction().commit();		
		
		//Complete contact form with fields from the messageSender object and send the message
		driver.findElement(By.id("name")).sendKeys(messageSender.getName());
		driver.findElement(By.id("email")).sendKeys(messageSender.getEmail());
		driver.findElement(By.id("phone")).sendKeys("" + messageSender.getTel());
		driver.findElement(By.id("message")).sendKeys(messageSender.getMessage());
		
		//Capture screenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);           

		try {
			FileUtils.copyFile(scrFile, new File("C:\\Users\\Lorin\\Desktop\\screenshot" + key + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}    
			
		//Click the send button
		WebElement element = driver.findElement(By.id("name"));
		element.submit();
	}
	
	/**
	 * Close the browser
	 */
	@After
	public void tearDown(){
		try {
			Thread.sleep(2000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

