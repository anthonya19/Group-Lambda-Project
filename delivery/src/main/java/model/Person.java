package model;

public class Person {

	private String ID;
	private String FName;
	private String LName;
	private String Email;
	private String Address;
	private float Note;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public float getNote() {
		return Note;
	}
	public void setNote(float note) {
		Note = note;
	}
	public Person(String iD, String fName, String lName, String email, String address, float note) {
		super();
		ID = iD;
		FName = fName;
		LName = lName;
		Email = email;
		Address = address;
		Note = note;
	}
	
	
}
