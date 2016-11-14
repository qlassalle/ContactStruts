package actionForm.address;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public abstract class AddressValidationForm extends ActionForm {

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

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getCountry() == null || getCountry().length() < 1) {
			errors.add("country", new ActionMessage("creation.country.error.required"));
		}
		if (getStreet() == null || getStreet().length() < 1) {
			errors.add("street", new ActionMessage("creation.street.error.required"));
		}
		if (getZip() == null || getZip().length() < 1) {
			errors.add("zip", new ActionMessage("creation.zip.error.required"));
		}
		if (getCity() == null || getCity().length() < 1) {
			errors.add("city", new ActionMessage("creation.city.error.required"));
		}
		System.out.println("called");
		return errors;
	}

}
