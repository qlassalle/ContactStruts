package actionForm.phoneNumber;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdatePhoneNumberValidationForm extends PhoneNumberValidationForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
		if(getKind() == null || getKind().length() < 1) {
			errors.add("kind", new ActionMessage("creation.kind.error.required"));
		}
		if(getNumber() == null || getNumber().length() < 4 || getNumber().length() > 10) {
			errors.add("number", new ActionMessage("creation.number.error.required"));
		}
		return errors;
	}
}
