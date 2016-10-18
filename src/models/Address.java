package models;


public class Address {

	private String street, city, zip, country;
	private int id;

	public void setId(int value) {
		this.id = value;
	}

	public int getId() {
		return this.id;
	}

	public void setStreet(String value) {
		this.street = value;
	}

	public String getStreet() {
		return this.street;
	}

	public void setCity(String value) {
		this.city = value;
	}

	public String getCity() {
		return this.city;
	}
	
	public void setZip(String value) {
		this.zip = value;
	}

	public String getZip() {
		return this.zip;
	}

	public void setCountry(String value) {
		this.country = value;
	}

	public String getCountry() {
		return this.country;
	}

}
