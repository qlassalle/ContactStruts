package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.DAOContact;

public class DeleteContactAction extends Action {

	public ActionForward execute(final ActionMapping mapping,
			ActionForm pForm, final HttpServletRequest request,
			final HttpServletResponse pResponse) {
		
		String id = request.getQueryString();
		id = id.substring(3, id.length());
		System.out.println(id);

		final DAOContact daoc = new DAOContact();
		final String lError = daoc.delete(id);
		
		request.setAttribute("lesContacts", daoc.getAllContacts());
		return lError == null ? mapping.findForward("success") : mapping.findForward("error");
	}
}
