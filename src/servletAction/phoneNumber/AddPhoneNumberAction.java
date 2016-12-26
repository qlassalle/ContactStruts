package servletAction.phoneNumber;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.phoneNumber.AddPhoneNumberValidationForm;
import services.PhoneNumberService;

public class AddPhoneNumberAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AddPhoneNumberValidationForm apnvf = (AddPhoneNumberValidationForm)form;
		
		int idContact = (int)request.getSession().getAttribute("contactId");
		final String kind = apnvf.getKind();
		final String number = apnvf.getNumber();
		
		PhoneNumberService pns = new PhoneNumberService();
		final String error = pns.save(kind, number, idContact);
		
		return error == null ? mapping.findForward("success") : mapping.findForward("error");
		
	}
}
