package actionForm.global;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import antlr.StringUtils;

public class LoginValidationForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String name, password;

	public String getName() {
		return name;
	}

	public void setName(String user) {
		this.name = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		name = null;
		password = null;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) 
	{
		ActionErrors errors = new ActionErrors();
		if(name == null || name.length() < 1){
			errors.add("user", new ActionMessage("login.user.error.required"));
		}
		if(password == null || password.length() < 1){
			errors.add("password", new ActionMessage("login.password.error.required"));
		}		
		return errors;
	}
}
