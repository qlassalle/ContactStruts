package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Contact;
import models.Groupe;

public class DAOGroupe extends GlobalConnection {
	
	public DAOGroupe() {
		super();
	}
	
	public String save(String name) {
		connection = checkConnection(connection);
		Statement stmt;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate("insert into groupe(nom) values (\"" + name + "\");");
			stmt.close();
			return null;
		} catch (SQLException sqle) {
			return sqle.getMessage();
		} finally {
			closeConnection(connection);
		}
	}

	public List<Groupe> getAllGroupes() {
		connection = checkConnection(connection);
		List<Groupe> lesGroupes = new ArrayList<Groupe>();
		ResultSet result = null;
		try {
			try (Statement stmt = connection.createStatement()) {
				result = stmt.executeQuery("select * from groupe order by nom asc");
				while(result.next()) {
					lesGroupes.add(new Groupe(result.getInt(1), result.getString(2)));		
				}
			} finally {
				if(result != null) {
					result.close();
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			closeConnection(connection);
		}
		return lesGroupes;
	}

	public Integer getNbMembre(int id) {
		connection = checkConnection(connection);
		try {
			String req = "select count(id) from contact_groupe where idGroupe = ?";
			ResultSet result = null;
			try (PreparedStatement stmt = connection.prepareStatement(req)) {
				stmt.setInt(1, id);
				result = stmt.executeQuery();
				while(result.next()) {
					return result.getInt(1);
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

	public void addContact(int id, String[] ids) {
		deleteAllContacts(id);
		connection = checkConnection(connection);
		Statement stmt;
		String req;
		try {
			for(String contact : ids) {
				req = "insert into contact_groupe(idGroupe, idContact) values("+id+"," +contact+");";
				stmt = connection.createStatement();
				stmt.executeUpdate(req);
				stmt.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			closeConnection(connection);
		}	
	}
	
	public List<Contact> getMembres(int idGroupe)
	{
		List<Contact> lesContacts = new ArrayList<Contact>();
		DAOContact daoc = new DAOContact();
		connection = checkConnection(connection);
		ResultSet result = null;
		try {
			try(Statement stmt = connection.createStatement()) {
				result = stmt.executeQuery("select * from contact_groupe where idGroupe = " + idGroupe);
				while(result.next()) {
					System.out.println(result.getInt("idContact"));
					lesContacts.add(daoc.getContactById(result.getInt("idContact")));
				}
			} finally {
				if(result != null) {
					result.close();
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		finally {
			closeConnection(connection);
		}
		return lesContacts;
	}

	public String delete(int idGroupe) {
		connection = checkConnection(connection);
		String req = "delete from groupe where id = ? ";
		try {
			try(PreparedStatement stmt = connection.prepareStatement(req)) {
				stmt.setInt(1, idGroupe);
				stmt.executeUpdate();
				stmt.close();
				return null;
			}
		} catch(SQLException sqle) {
			return sqle.getMessage();
		} finally {
			closeConnection(connection);
		}
	}
	
	private void deleteAllContacts(int idGroupe) {
		connection = checkConnection(connection);
		String req = "delete from contact_groupe where idGroupe = ?";
		try {
			try(PreparedStatement stmt = connection.prepareStatement(req)) {
				stmt.setInt(1, idGroupe);
				stmt.executeUpdate();
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public String removeFromGroupe(int idContact, int idGroupe) {
		connection = checkConnection(connection);
		String req = "delete from contact_groupe where idContact = ? and idGroupe = ?";
		try {
			try (PreparedStatement stmt = connection.prepareStatement(req)) {
				stmt.setInt(1, idContact);
				stmt.setInt(2, idGroupe);
				stmt.executeUpdate();
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
			return sqle.getMessage();
		} finally {
			closeConnection(connection);
		}
		return null;
	}
}
