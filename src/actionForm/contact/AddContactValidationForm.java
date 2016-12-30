package actionForm.contact;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import actionForm.global.RegexValidator;
public class AddContactValidationForm extends ContactValidationForm {

	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		return super.validate(mapping, request);
	}
}
