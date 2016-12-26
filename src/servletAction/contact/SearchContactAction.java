package servletAction.contact;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.contact.SearchContactValidationForm;
import models.Contact;
import services.ContactService;
import servletAction.AccueilAction;

public class SearchContactAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		final SearchContactValidationForm sform = (SearchContactValidationForm)form;
		
		final String firstName = sform.getFirstName();
		
		final ContactService cs = new ContactService();
				
		// TODO manage duplications
		ArrayList<Contact> searchedContacts = (ArrayList<Contact>)cs.getContactByFirstName(firstName);
		
		request.setAttribute("pattern", firstName);
		if(searchedContacts.size() == 1) {
			request.getSession().setAttribute("contactId", searchedContacts.get(0).getIdContact());
			return mapping.findForward("oneContact");
		} else {
			request.setAttribute("lesContacts", searchedContacts);
			return mapping.findForward("manyContacts");
		}
		
		// return !c.isEmpty() ? mapping.findForward("success") : mapping.findForward("erreur");
	}	
}
