package services;

import java.util.List;
import java.util.Map;

import domain.DAOContact;
import exceptions.ContactAlreadyExistsException;
import models.Address;
import models.Contact;

public class ContactService {

	DAOContact daoc;
	
	public ContactService() {
		daoc = new DAOContact();
	}

	public String addContact(String nom, String prenom, String email) {
		return daoc.save(nom, prenom, email); 
	}
	
	public String update(int id, String nom, String prenom, String email) {
		return daoc.update(id, nom, prenom, email);
	}

	public String delete(int id) {
		return daoc.delete(id);
	}
	
	public List<Contact> getContactByFirstName(String lastName) {
		return daoc.getContactByFirstName(lastName);
	}
	
	public List<Contact> getAllContacts() {
		return daoc.getAllContacts();
	}
	
	public String addAddress(int idContact, int idAddress){
		return daoc.addAddress(idContact, idAddress);
	}
	
	public Map<Integer, String> getGroupes(int idContact) {
		return daoc.getGroupes(idContact);
	}
	
	public Contact getContactById(int id) {
		return daoc.getContactById(id);
	}
	
	public Address getContactAddress(int idContact) {
		return daoc.getContactAddress(idContact);
	}
}
