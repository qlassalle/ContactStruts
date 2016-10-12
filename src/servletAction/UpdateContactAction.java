package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.UpdateContactValidationForm;
import domain.DAOContact;

public class UpdateContactAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		final UpdateContactValidationForm uForm = (UpdateContactValidationForm)form;
		
		final int id = uForm.getId();
		final String firstName = uForm.getFirstName();
		final String lastName = uForm.getLastName();
		final String email = uForm.getEmail();
		
		final DAOContact daoc = new DAOContact();
		final String uError = daoc.update(id, lastName, firstName, email);
		
		request.setAttribute("lesContacts", daoc.getAllContacts());
		return uError == null ? mapping.findForward("success") : mapping.findForward("error");
	}
	
}
