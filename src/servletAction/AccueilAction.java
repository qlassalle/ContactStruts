package servletAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.DAOContact;
import domain.DAOGroupe;
import models.Groupe;

public class AccueilAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		final DAOContact daoc = new DAOContact();
		final DAOGroupe daog = new DAOGroupe();
		List<Integer> nbMembre = new ArrayList<Integer>();
		
		ArrayList<Groupe> lesGroupes = (ArrayList<Groupe>)daog.getAllGroupes();
		request.setAttribute("lesGroupes", lesGroupes);
		for(Groupe groupe : lesGroupes) {
			nbMembre.add(daog.getNbMembre(groupe.getId()));
		}
		request.setAttribute("nbMembre", nbMembre);
		request.setAttribute("lesContacts", daoc.getAllContacts());
		return mapping.findForward("success");
	}	
}
