package model;

public class FeedBack {
	private String fullName;
	private String emailAddress;
	private String phoneNumber;
	private String Message;
	public FeedBack() {
		super();
	}
	public FeedBack(String fullName, String emailAddress, String phoneNumber, String message) {
		super();
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		Message = message;
	}
	@Override
	public String toString() {
		return "fullName=" + fullName + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber
				+ ", Message=" + Message + "]";
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}

}
