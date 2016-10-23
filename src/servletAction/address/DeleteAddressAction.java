package servletAction.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.DAOAddress;

public class DeleteAddressAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		DAOAddress daoa = new DAOAddress();
		String id = request.getQueryString();
		int idAddress = Integer.valueOf(id.substring(3, id.length()));
		final String error = daoa.delete(idAddress);
		System.out.println(request.getSession().getAttribute("contactId"));
		return error == null ? mapping.findForward("success") : mapping.findForward("erreur");
	}	
}