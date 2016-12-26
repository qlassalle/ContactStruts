package servletAction.phoneNumber;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.phoneNumber.UpdatePhoneNumberValidationForm;
import services.PhoneNumberService;

public class UpdatePhoneNumberAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final UpdatePhoneNumberValidationForm aForm = (UpdatePhoneNumberValidationForm)form;
		
		final int id = (int)request.getSession().getAttribute("idPhone");
		
		final String kind = aForm.getKind();
		final String number = aForm.getNumber();
		
		PhoneNumberService service = new PhoneNumberService();
		final String error = service.update(id, kind, number);
		
		return error == null ? mapping.findForward("success") : mapping.findForward("error");
	}

	
	
}
