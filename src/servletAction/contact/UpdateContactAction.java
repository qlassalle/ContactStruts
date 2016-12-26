package servletAction.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.contact.UpdateContactValidationForm;
import domain.DAOContact;
import services.ContactService;
import servletAction.AccueilAction;

public class UpdateContactAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		final UpdateContactValidationForm uForm = (UpdateContactValidationForm)form;
		
		final int id = (int)request.getSession().getAttribute("contactId");
		final String firstName = uForm.getFirstName();
		final String lastName = uForm.getLastName();
		final String email = uForm.getEmail();
		
		final ContactService cs = new ContactService();
		final String error = cs.update(id, lastName, firstName, email);
		
		final AccueilAction accueil = new AccueilAction();

		return error == null ? accueil.execute(mapping, form, request, response) : mapping.findForward("error");
	}
}