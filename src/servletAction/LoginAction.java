package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.global.LoginValidationForm;

public class LoginAction extends Action{

	String monTest = "mon test";
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		final LoginValidationForm lValidationForm = (LoginValidationForm)form;
		
		final String user = lValidationForm.getName();
		final String password = lValidationForm.getPassword();
		AccueilAction accueil = new AccueilAction(); 
		
		return user.equals(password) ? accueil.execute(mapping, lValidationForm, request, response) : mapping.findForward("error");
	}
}
