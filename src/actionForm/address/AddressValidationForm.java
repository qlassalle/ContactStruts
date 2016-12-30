package actionForm.address;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import actionForm.global.RegexValidator;

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
		if(!RegexValidator.isCorrectString(getCountry())) {
			errors.add("incorrect country", new ActionMessage("creation.country.error.incorrect"));
		}
		if (getStreet() == null || getStreet().length() < 1) {
			errors.add("street", new ActionMessage("creation.street.error.required"));
		}
		if(!RegexValidator.isCorrectStreetName(getStreet())) {
			errors.add("incorrect street", new ActionMessage("creation.street.error.incorrect"));
		}
		if (getZip() == null || getZip().length() < 1 || getZip().length() > 10) {
			errors.add("zip", new ActionMessage("creation.zip.error.required"));
		}
		if(!RegexValidator.isCorrectNumber(getZip())) {
			errors.add("incorrect zip", new ActionMessage("creation.zip.error.incorrect"));
		}
		if (getCity() == null || getCity().length() < 1) {
			errors.add("city", new ActionMessage("creation.city.error.required"));
		}
		if(!RegexValidator.isCorrectString(getCity())) {
			errors.add("incorrect city", new ActionMessage("creation.city.error.incorrect"));
		}
		return errors;
	}
}
