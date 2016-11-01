package servletAction.contact;

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
import services.ContactService;
import servletAction.AccueilAction;

public class AddContactAction extends Action {

	@Override
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws Exception 
	{
		
		final AddContactValidationForm lForm=(AddContactValidationForm)pForm;
		
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();

		// create a new Contact
		ContactService cs = new ContactService();
		final String error = cs.addContact(lastName, firstName, email);
		
		final AccueilAction accueil = new AccueilAction();
		
		return error == null ? accueil.execute(pMapping, pForm, pRequest, pResponse) : pMapping.findForward("error");
	}
}
