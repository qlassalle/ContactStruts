package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdateContactValidationForm extends ContactValidationForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	  public ActionErrors validate( 
		      ActionMapping mapping, HttpServletRequest request ) {
		      ActionErrors errors = new ActionErrors();
		      
		      if(getId() <= 0){
		    	errors.add("id", new ActionMessage("creation.id.error.required"));  
		      }
		      if( getFirstName()== null || getFirstName().length() < 1 ) {
		        errors.add("first name",new ActionMessage("creation.fn.error.required"));
		      }
		      if( getLastName()== null || getLastName().length() < 1 ) {
		        errors.add("last name",new ActionMessage("creation.ln.error.required"));
		      }
		      if( getEmail() == null || getEmail().length() < 1 ) {
		        errors.add("email", new ActionMessage("creation.email.error.required"));
		      }
		      return errors;
		  }
		
}
