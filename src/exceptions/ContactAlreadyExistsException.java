package exceptions;

public class ContactAlreadyExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactAlreadyExistsException() {
		System.out.println("Le contact existe déjà");
	}	
}