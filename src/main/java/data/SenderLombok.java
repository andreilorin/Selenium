package data;

import lombok.Data;

@Data
public class SenderLombok {
	
	private String email;
	private String name;
	private String phone;
	private String message;
	
	public SenderLombok() {
		this.name = "Andrei";
		this.email = "email@mail.com";
		this.phone = "0123456789";
		this.message = "Hi! How are you ?";
	}

}
