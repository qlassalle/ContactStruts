package servletAction.groupe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.groupe.AddGroupeValidationForm;
import services.GroupeService;
import servletAction.AccueilAction;

public class AddGroupeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final AddGroupeValidationForm gvf = (AddGroupeValidationForm)form;
		
		final String name = gvf.getName();
		
		final GroupeService gs = new GroupeService();
		final String error = gs.save(name);
		
		final AccueilAction accueil = new AccueilAction();
		
		return error == null ? accueil.execute(mapping, form, request, response) : mapping.findForward("error");
	}
}
