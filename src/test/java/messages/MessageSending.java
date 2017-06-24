package messages;

import org.testng.annotations.Test;
import model.MainPage;

public class MessageSending {
	
	@Test
	public void sendMessage() {
		
		MainPage mainPage = new MainPage();
		mainPage.accessGoogle();
		mainPage.accessMyPage();
	}
}
