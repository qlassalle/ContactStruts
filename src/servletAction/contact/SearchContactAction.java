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
import domain.DAOGroupe;
import models.Groupe;

public class SearchContactAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		final SearchContactValidationForm sform = (SearchContactValidationForm)form;
		
		final String firstName = sform.getFirstName();
		
		final DAOContact daoc = new DAOContact();
		final DAOGroupe daog = new DAOGroupe();
		List<Integer> nbMembre = new ArrayList<Integer>();
		
		ArrayList<Groupe> lesGroupes = (ArrayList)daog.getAllGroupes();
		request.setAttribute("lesGroupes", lesGroupes);
		for(Groupe groupe : lesGroupes) {
			nbMembre.add(daog.getNbMembre(groupe.getId()));
		}
		request.setAttribute("nbMembre", nbMembre);
		request.setAttribute("lesContacts", daoc.getContactByFirstName(firstName));
		return mapping.findForward("success");
	}

	
}
