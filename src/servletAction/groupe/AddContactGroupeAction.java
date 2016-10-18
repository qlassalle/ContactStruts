package servletAction.groupe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.groupe.AddContactGroupeValidationForm;
import domain.DAOGroupe;
import servletAction.AccueilAction;

public class AddContactGroupeAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AddContactGroupeValidationForm acgvf = (AddContactGroupeValidationForm)form;

		DAOGroupe daog = new DAOGroupe();
		daog.addContact(acgvf.getId(), acgvf.getIds());
		
		AccueilAction accueil = new AccueilAction();
		return accueil.execute(mapping, form, request, response);
	}
}
