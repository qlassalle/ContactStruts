package actionForm.groupe;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddContactGroupeValidationForm extends GroupeValidationForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String[] ids;
	
	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if(getIds() == null || getIds().length < 1) {
			errors.add("id", new ActionMessage("ajout.contact_groupe.error.required"));
		}
		return errors;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		if(getIds() == null) {
			ids = (String[]) request.getAttribute("ids");
		}
	}	
	
	
}
