package servletAction.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.address.UpdateAddressValidationForm;
import services.AddressService;

public class UpdateAddressAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UpdateAddressValidationForm uavf = (UpdateAddressValidationForm)form;
		
		final int idAddress = (int)request.getSession().getAttribute("idAddress");
		final String street = uavf.getStreet();
		final String city = uavf.getCity();
		final String zip = uavf.getZip();
		final String country = uavf.getCountry();
		
		AddressService as = new AddressService();
		final String erreur = as.update(street, city, zip, country, idAddress);
		return erreur == null ? mapping.findForward("success") : mapping.findForward("erreur");
		
	}
}
