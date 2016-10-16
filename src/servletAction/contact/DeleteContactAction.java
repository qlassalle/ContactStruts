package servletAction.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.DAOContact;
import servletAction.AccueilAction;

public class DeleteContactAction extends Action {

	public ActionForward execute(final ActionMapping mapping,
			ActionForm pForm, final HttpServletRequest request,
			final HttpServletResponse pResponse) throws Exception {
		
		String id = request.getQueryString();
		id = id.substring(3, id.length());
		System.out.println(id);

		final DAOContact daoc = new DAOContact();
		final String error = daoc.delete(id);
		
		final AccueilAction accueil = new AccueilAction();
		
		return error == null ? accueil.execute(mapping, pForm, request, pResponse) : mapping.findForward("error");
	}
}
