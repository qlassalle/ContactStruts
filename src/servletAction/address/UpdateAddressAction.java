package servletAction.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.address.UpdateAddressValidationForm;
import services.AddressService;
import servletAction.AccueilAction;

public class UpdateAddressAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UpdateAddressValidationForm uavf = (UpdateAddressValidationForm)form;
		
		final int idAddress = uavf.getId();
		final String street = uavf.getStreet();
		final String city = uavf.getCity();
		final String zip = uavf.getZip();
		final String country = uavf.getCountry();
		
		AddressService as = new AddressService();
		final String erreur = as.update(street, city, zip, country, idAddress);


		AccueilAction accueil = new AccueilAction();
		return erreur == null ? accueil.execute(mapping, form, request, response) : mapping.findForward("erreur");
		
	}
}
