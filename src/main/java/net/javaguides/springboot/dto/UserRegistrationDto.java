package net.javaguides.springboot.dto;

public class UserRegistrationDto {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
<<<<<<< HEAD
	private String contactNo;
	


=======
	
>>>>>>> de673a181aaa950f8165b243a12240a51ce250fa
	public UserRegistrationDto(){
		
	}
	
<<<<<<< HEAD
	public UserRegistrationDto(String firstName, String contactNo,String lastName, String email, String password) {
=======
	public UserRegistrationDto(String firstName, String lastName, String email, String password) {
>>>>>>> de673a181aaa950f8165b243a12240a51ce250fa
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
<<<<<<< HEAD
		this.contactNo = contactNo;
=======
>>>>>>> de673a181aaa950f8165b243a12240a51ce250fa
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
<<<<<<< HEAD
	
	
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
=======
>>>>>>> de673a181aaa950f8165b243a12240a51ce250fa
}
