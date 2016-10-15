package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import actionForm.contact.AddContactValidationForm;
import domain.DAOContact;

public class AddContactAction extends Action {

	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) 
	{
		
		final AddContactValidationForm lForm=(AddContactValidationForm)pForm;
		
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();

		// create a new Contact
		final DAOContact daoc = new DAOContact();
		final String error = daoc.save(firstName, lastName, email);
		
		pRequest.setAttribute("lesContacts", daoc.getAllContacts());
		return error == null ? pMapping.findForward("success") : pMapping.findForward("error");
	}
}
