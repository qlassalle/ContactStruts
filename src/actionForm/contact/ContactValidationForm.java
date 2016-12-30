package actionForm.contact;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import actionForm.global.RegexValidator;

public abstract class ContactValidationForm extends ActionForm {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	protected int idContact = 0;
	protected String firstName = null;
	protected String lastName = null;
	protected String email = null;

	public int getIdContact() {
		return idContact;
	}

	public void setIdContact(int id) {
		this.idContact = id;
	}

	/**
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return First Name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return Last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param string
	 *            Sets the Email
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string
	 *            Sets the First Name
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string
	 *            sets the Last Name
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.firstName = null;
		this.lastName = null;
		this.email = null;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getFirstName() == null || getFirstName().length() < 1) {
			errors.add("first name", new ActionMessage("creation.fn.error.required"));
		}
		if (!RegexValidator.isCorrectString(getFirstName())) {
			errors.add("incorrect first name", new ActionMessage("creation.fn.error.incorrect"));
		}
		if (getLastName() == null || getLastName().length() < 1) {
			errors.add("last name", new ActionMessage("creation.ln.error.required"));
		}
		if (!RegexValidator.isCorrectString(getLastName())) {
			errors.add("incorrect last name", new ActionMessage("creation.ln.error.incorrect"));
		}
		if (getEmail() == null || getEmail().length() < 1) {
			errors.add("email", new ActionMessage("creation.email.error.required"));
		}
		if (!RegexValidator.isMailCorrect(getEmail())) {
			errors.add("incorrect email", new ActionMessage("creation.email.error.incorrect"));
		}
		return errors;
	}
}
