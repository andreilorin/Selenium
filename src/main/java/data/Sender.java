package data;

//This class can be used as a data provider for testNG 
public class Sender {
	
	private String name;
	
	private String email;
	
	private String tel;
	
	private String message;
	
	public Sender() {
		this.name = "Andrei";
		this.email = "email@mail.com";
		this.tel = "0123456789";
		this.message = "Hi! How are you ?";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
