package actionForm.phoneNumber;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import actionForm.global.RegexValidator;

public abstract class PhoneNumberValidationForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id, idContact;
	private String kind, number;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdContact() {
		return idContact;
	}
	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.id = 0;
		this.idContact = 0;
		this.kind = null;
		this.number = null;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
		
		if(getKind() == null || getKind().length() < 1) {
			errors.add("kind", new ActionMessage("creation.kind.error.required"));
		}
		if(getKind().length() > 20) {
			errors.add("kind too long", new ActionMessage("creation.kind.error.too_long"));
		}
		if(getNumber() == null || getNumber().length() < 4 || getNumber().length() > 10) {
			errors.add("number", new ActionMessage("creation.number.error.required"));
		}
		if(!RegexValidator.isCorrectNumber(getNumber())) {
			errors.add("number incorrect", new ActionMessage("creation.number.error.incorrect"));
		}
		return errors;
	}	
}
