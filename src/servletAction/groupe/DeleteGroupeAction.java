package servletAction.groupe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import services.GroupeService;
import servletAction.AccueilAction;

public class DeleteGroupeAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		GroupeService gs = new GroupeService();
		String id = request.getQueryString();
		int idGroupe = Integer.valueOf(id.substring(3, id.length()));
		final String error = gs.delete(idGroupe);
	
		AccueilAction accueil = new AccueilAction();
		
		return accueil.execute(mapping, form, request, response);
	}

	
}
