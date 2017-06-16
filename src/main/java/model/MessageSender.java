package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class mapped to the messenger table of the messenger_database DB
 */
@Entity
@Table(name="messenger")
public class MessageSender {	
	//Primary key
	@Id
	@Column(name="id")
	private int id;
		
	@Column(name="senderName")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="tel")
	private int tel;
	
	@Column(name="message")
	private String message;
	
	//Default constructor
	public MessageSender(){}	
	//Constructor, without id field
	public MessageSender(String name, String email, int tel, String message){
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.message = message;
	}

	//Getters and Setters
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}

	public int getTel() {return tel;}
	public void setTel(int tel) {this.tel = tel;}

	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}
}
