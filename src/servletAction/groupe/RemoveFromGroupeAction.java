package servletAction.groupe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.DAOGroupe;

public class RemoveFromGroupeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int idContact = (int)request.getSession().getAttribute("contactId");
		String parameter = request.getQueryString();
		int idGroupe = Integer.valueOf(parameter.substring(9, parameter.length()));
		DAOGroupe daog = new DAOGroupe();
		final String error = daog.removeFromGroupe(idContact, idGroupe);
		
		return error == null ? mapping.findForward("success") : mapping.findForward("erreur");
	}
}
