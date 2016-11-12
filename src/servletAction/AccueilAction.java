package servletAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import models.Groupe;
import services.AddressService;
import services.ContactService;
import services.GroupeService;

public class AccueilAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		final ContactService cs = new ContactService();
		final GroupeService gs = new GroupeService();
		final AddressService as = new AddressService();
		List<Integer> nbMembre = new ArrayList<Integer>();
		
		ArrayList<Groupe> lesGroupes = (ArrayList<Groupe>)gs.getAllGroupes();
		request.setAttribute("lesGroupes", lesGroupes);
		for(Groupe groupe : lesGroupes) {
			nbMembre.add(gs.getNbMembre(groupe.getId()));
		}
		request.setAttribute("nbMembre", nbMembre);
		request.setAttribute("lesContacts", cs.getAllContacts());
		request.setAttribute("lesAdresses", as.getAllAddresses());
		
		return mapping.findForward("success");
	}	
}
