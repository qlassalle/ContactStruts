package actionForm.contact;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
public class AddContactValidationForm extends ContactValidationForm {

	  
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  
	  @Override
	public ActionErrors validate( 
		      ActionMapping mapping, HttpServletRequest request ) {
		      ActionErrors errors = new ActionErrors();
		      
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
