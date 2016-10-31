package servletAction.contact;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.contact.SearchContactValidationForm;
import domain.DAOContact;
import models.Contact;
import services.ContactService;

public class SearchContactAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		final SearchContactValidationForm sform = (SearchContactValidationForm)form;
		
		final String firstName = sform.getFirstName();
		
		final ContactService cs = new ContactService();
				
		// TODO manage doublons
		ArrayList<Contact> c = (ArrayList<Contact>)cs.getContactByFirstName(firstName);
		request.getSession().setAttribute("contactId", c.get(0).getIdContact());
		
		return !c.isEmpty() ? mapping.findForward("success") : mapping.findForward("erreur");
	}	
}
