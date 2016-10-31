package services;

import domain.DAOAddress;

public class AddressService {

	private DAOAddress daoa;
	
	public AddressService() {
		daoa = new DAOAddress();
	}

	public int addAddress(String street, String city, String zip, String country) {
		
		return daoa.save(street, city, zip, country);
	}
	
	public String delete(int idAddress) {
		return daoa.delete(idAddress);
	}
}
