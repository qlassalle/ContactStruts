package servletAction.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.address.SelectAddressValidationForm;
import services.ContactService;

public class SelectAddressAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int idContact = (int)request.getSession().getAttribute("contactId");
		
		final SelectAddressValidationForm aForm = (SelectAddressValidationForm)form;
		final int idAddress = aForm.getId();
		
		ContactService cs = new ContactService();
		final String erreur = cs.addAddress(idContact, idAddress);
		
		return erreur == null ? mapping.findForward("success") : mapping.findForward("erreur");
	}
}
