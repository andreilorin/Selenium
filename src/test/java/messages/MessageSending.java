package messages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.SenderLombok;
import model.MainPage;

public class MessageSending {

	@DataProvider(name = "test1")
	public Object[][] createData1() {
		SenderLombok sender = new SenderLombok();
		sender.setName("Lorin");
		return new Object[][] { { sender } };
	}


	@Test(dataProvider = "test1")
	public void sendMessage(SenderLombok sender) {

		MainPage mainPage = new MainPage();
		mainPage.accessGoogle();
		mainPage.accessMyPage();
		mainPage.backPage();
		mainPage.forwardPage();
		
		mainPage.enterName(sender.getName());
		mainPage.enterEmail(sender.getEmail());
		mainPage.enterPhone(sender.getPhone());
		mainPage.enterMessage(sender.getMessage());
		
		mainPage.quit();
	}
}
