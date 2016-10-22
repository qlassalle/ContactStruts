package servletAction.groupe;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.DAOContact;
import domain.DAOGroupe;
import models.Contact;

public class GetGroupeInfoAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String parameter = request.getQueryString();
		parameter = parameter.substring(3, parameter.length());
		int idGroupe = Integer.valueOf(parameter);
		
		DAOContact daoc = new DAOContact();
		DAOGroupe daog = new DAOGroupe();
		ArrayList<Contact> lesContacts = (ArrayList<Contact>)daoc.getAllContacts();
		ArrayList<Contact> lesMembres = (ArrayList<Contact>)daog.getMembres(Integer.valueOf(idGroupe));
		String []membres = new String[daog.getNbMembre(idGroupe)];
		
		request.setAttribute("lesContacts", lesContacts);
		request.setAttribute("lesMembres", lesMembres);
		
		// set the members of the group to have them checked in the next page
		// the trick is done in AddContactGroupeValidationForm in the reset method
		int i = 0;
		for(Contact c : lesContacts) {
			if(lesMembres.contains(c)) {
				membres[i] = String.valueOf(c.getId());
				i++;
			}
		}
		request.setAttribute("ids", membres);
		
		return mapping.findForward("success");
	}	
}
