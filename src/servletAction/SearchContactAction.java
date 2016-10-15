package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.contact.SearchContactValidationForm;
import domain.DAOContact;

public class SearchContactAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		final SearchContactValidationForm sform = (SearchContactValidationForm)form;
		
		final String firstName = sform.getFirstName();
		
		final DAOContact daoc = new DAOContact();
		request.setAttribute("lesContacts", daoc.getContactByFirstName(firstName));
		return mapping.findForward("success");
	}

	
}
