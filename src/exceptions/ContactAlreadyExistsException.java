package exceptions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

public class ContactAlreadyExistsException extends ExceptionHandler {

	@Override
	public ActionForward execute(Exception arg0, ExceptionConfig arg1, ActionMapping mapping, ActionForm arg3,
			HttpServletRequest arg4, HttpServletResponse arg5) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("erreur dans ContactAlreadyExists");
		return mapping.findForward("contactAlreadyExists");
	}
}
