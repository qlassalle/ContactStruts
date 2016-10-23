package actionForm.contact;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

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

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.firstName = null;
		this.lastName = null;
		this.email = null;
	}
}
