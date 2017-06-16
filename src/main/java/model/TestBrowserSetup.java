package newtestdriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class TestBrowserSetup {
	static Logger logger = LogManager.getLogger(TestBrowserSetup.class);
	
	private static SessionFactory factory;
	private WebDriver driver;
	private Session session;
	
	@BeforeClass
	public static void runOnceBeforeTesting(){
		 logger.info("starting before class");
		
		//Create SessionFactory
		factory = new Configuration()
				.configure()
				.addAnnotatedClass(MessageSender.class)
				.buildSessionFactory();
						
		//Set up gecko driver
		logger.info("setting up gecko driver");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Lorin\\Desktop\\Selenium\\geckodriver.exe");
				
	}
	
	@Before
	public void setUpBeforeEachTest(){
		
		//Get Session 
		session = factory.getCurrentSession();	
		
		//Instantiate FirefoxDriver(open Firefox)
		driver = new FirefoxDriver();
	}
	
	@After
	public void tearDown(){
		try {
			Thread.sleep(2000);
			factory.close();
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void homepage() {
		driver.get("http://www.andreilorin.com");
	}


}
