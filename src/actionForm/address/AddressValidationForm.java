package actionForm.address;

import javax.servlet.ServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public abstract class AddressValidationForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected String street, city, zip, country;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public void reset(ActionMapping mapping, ServletRequest servlet) {
		this.street = null;
		this.city = null;
		this.zip = null;
		this.country = null;
	}
	
	
}
