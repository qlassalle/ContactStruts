package servletAction.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.address.AddAddressValidationForm;
import domain.DAOAddress;
import domain.DAOContact;
import services.AddressService;
import services.ContactService;
import servletAction.AccueilAction;

public class AddAddressAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		int idContact = (int)session.getAttribute("contactId");
		
		final AddAddressValidationForm lForm=(AddAddressValidationForm)form;
		
		final String street = lForm.getStreet();
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String country = lForm.getCountry();
		
		// create a new Address
		AddressService as = new AddressService();
		final int idAddress = as.addAddress(street, city, zip, country);
		
		// add the address to the contact
		final ContactService cs = new ContactService();
		final String erreur = cs.addAddress(idContact, idAddress);
		
		return erreur == null ? mapping.findForward("success") : mapping.findForward("erreur");
	}
}
