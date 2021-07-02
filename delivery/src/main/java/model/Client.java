package model;

public class Client extends Person {

	public Client(String iD, String fName, String lName, String email, String address, float note) {
		super(iD, fName, lName, email, address, note);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Client [getID()=" + getID() + ", getFName()=" + getFName() + ", getLName()=" + getLName()
				+ ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress() + ", getNote()=" + getNote()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	}
