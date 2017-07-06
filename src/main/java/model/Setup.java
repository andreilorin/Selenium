package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.testng.ITestContext;

public class Setup {
	
	private final static Logger logger = LogManager.getLogger(Setup.class);
	
	@BeforeClass
	public static void runOnceBeforeTesting(ITestContext xmlContext){
		logger.info("starting before class");
		
		if (xmlContext.getCurrentXmlTest().getParameter("driver").equalsIgnoreCase("chrome")) {
			logger.info("setting up chrome driver");
			System.setProperty("webdriver.chrome.driver",
					".\\drivers\\chromedriver.exe");
		} else if (xmlContext.getCurrentXmlTest().getParameter("driver").equalsIgnoreCase("firefox")) {
			logger.info("setting up gecko driver");
			System.setProperty("webdriver.gecko.driver",
					".\\drivers\\geckodriver.exe");
		} else {
			logger.error("no driver type speciffied");
		}
	}

}
