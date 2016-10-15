package actionForm.contact;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SearchContactValidationForm extends ContactValidationForm{

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
 
		ActionErrors errors = new ActionErrors();
		if(getFirstName() == null){
			errors.add("first name missing", new ActionMessage("search.fn.error.required")); 
		}
			 
		return errors;
	}

	
}
