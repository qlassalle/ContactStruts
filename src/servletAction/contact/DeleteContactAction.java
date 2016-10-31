package servletAction.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.DAOContact;
import services.ContactService;
import servletAction.AccueilAction;

public class DeleteContactAction extends Action {

	public ActionForward execute(final ActionMapping mapping,
			ActionForm pForm, final HttpServletRequest request,
			final HttpServletResponse pResponse) throws Exception {
		
		String id = request.getQueryString();
		int idContact = Integer.valueOf(id.substring(10, id.length()));

		final ContactService cs = new ContactService();
		final String error = cs.delete(idContact);
		
		final AccueilAction accueil = new AccueilAction();
		
		return error == null ? accueil.execute(mapping, pForm, request, pResponse) : mapping.findForward("error");
	}
}
