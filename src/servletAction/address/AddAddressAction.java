package servletAction.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.address.AddAddressValidationForm;
import services.AddressService;
import servletAction.AccueilAction;

public class AddAddressAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		final AddAddressValidationForm lForm=(AddAddressValidationForm)form;
		
		final String street = lForm.getStreet();
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String country = lForm.getCountry();
		
		// create a new Address
		AddressService as = new AddressService();
		final int idAddress = as.addAddress(street, city, zip, country);
				
		final AccueilAction accueil = new AccueilAction();
		
		return idAddress != 0 ? accueil.execute(mapping, lForm, request, response) : mapping.findForward("erreur");
	}
}
