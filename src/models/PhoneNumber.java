package models;

public class PhoneNumber {

	private Contact contact;
	private int id;
	private String kind, number;
	
	public PhoneNumber(Contact contact, int id, String kind, String number) {
		super();
		this.contact = contact;
		this.id = id;
		this.kind = kind;
		this.number = number;
	}

	public void setContact(Contact value) {
		this.contact = value;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setId(int value) {
		this.id = value;
	}

	public int getId() {
		return this.id;
	}

	public void setKind(String value) {
		this.kind = value;
	}

	public String getKind() {
		return this.kind;
	}

	public void setNumber(String value) {
		this.number = value;
	}

	public String getNumber() {
		return this.number;
	}

}
