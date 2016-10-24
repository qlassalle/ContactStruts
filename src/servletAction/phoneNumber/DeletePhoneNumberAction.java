package servletAction.phoneNumber;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.DAOPhoneNumber;

public class DeletePhoneNumberAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DAOPhoneNumber daop = new DAOPhoneNumber();
		String id = request.getQueryString();
		int idPhoneNumber = Integer.valueOf(id.substring(14, id.length()));
		final String error = daop.delete(idPhoneNumber);
		
		return error == null ? mapping.findForward("success") : mapping.findForward("erreur");
	}

	
	
}
