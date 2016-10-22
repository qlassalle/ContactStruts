package actionForm.address;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddAddressValidationForm extends AddressValidationForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	  public ActionErrors validate( 
		      ActionMapping mapping, HttpServletRequest request ) {
		      ActionErrors errors = new ActionErrors();
		      
		      if( getCountry()== null || getCountry().length() < 1 ) {
			        errors.add("first name",new ActionMessage("creation.country.error.required"));
			      }
		      if( getStreet()== null || getStreet().length() < 1 ) {
		        errors.add("first name",new ActionMessage("creation.street.error.required"));
		      }
		      if( getZip()== null || getZip().length() < 1 ) {
		        errors.add("last name",new ActionMessage("creation.zip.error.required"));
		      }
		      if( getCity() == null || getCity().length() < 1 ) {
		        errors.add("email", new ActionMessage("creation.city.error.required"));
		      }
		      return errors;
		  }

}
