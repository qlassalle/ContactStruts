package actionForm.groupe;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddGroupeValidationForm extends GroupeValidationForm{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
		if(getName() == null || getName().length() < 1)
		{
			errors.add("name", new ActionMessage("groupe.name.error.required"));
		}
		return errors;
	}
}
