package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Contact;

public class DAOContact extends GlobalConnection{

	Connection connection;
	GlobalConnection globalConnection;

	public DAOContact() {
		globalConnection = new GlobalConnection();
		connection = globalConnection.getConnection();
	}

	public String save(String nom, String prenom, String email) {
		connection = globalConnection.checkConnection(connection);
		Statement stmt;
		try {
			stmt = connection.createStatement();
			System.out.println("insert into contact(nom, prenom, email) values(\"" + nom + "\",\""
					+ prenom + "\",\"" + email + "\");");
			stmt.executeUpdate("insert into contact(nom, prenom, email) values(\"" + nom + "\",\""
					+ prenom + "\",\"" + email + "\");");
			stmt.close();
			return null;

		} catch (SQLException e) {
			return e.getMessage();
		}
		finally {
			closeConnection(connection);
		}
	}

	public String update(int id, String nom, String prenom, String email) {
		connection = globalConnection.checkConnection(connection);
		int result = 0;
		String req = "update contact set id = ?, nom = ?, prenom = ?, email = ? where id = ?";
		System.out.println("id:" + id);
		try {
			PreparedStatement stmt = connection.prepareStatement(req);
			stmt.setInt(1, id);
			stmt.setString(2, nom);
			stmt.setString(3, prenom);
			stmt.setString(4, email);
			stmt.setInt(5, id);
			result = stmt.executeUpdate();
			stmt.close();
			// connection.close();
			return null;
		} catch (SQLException e) {
			return e.getMessage();
		}
		finally {
			closeConnection(connection);
		}
	}

	public String delete(String id) {
		connection = globalConnection.checkConnection(connection);
		String req = "delete from contact where id = ?";
		try {
			try (PreparedStatement stmt = connection.prepareStatement(req)) {
				stmt.setString(1, id);
				stmt.executeUpdate();
				stmt.close();
			}
		} catch (SQLException sqle) {
			return sqle.getMessage();
		}
		finally {
			closeConnection(connection);
		}
		return null;
	}

	public List<Contact> getContactByFirstName(String firstName) {
		return getContact(firstName);
	}

	public List<Contact> getAllContacts() {
		connection = globalConnection.checkConnection(connection);
		List<Contact> lesContacts = new ArrayList<Contact>();
		ResultSet result = null;
		try {
			try (Statement stmt = connection.createStatement()) {
				result = stmt.executeQuery("select * from contact ORDER BY nom ASC");
				while (result.next()) {
					lesContacts.add(new Contact(result.getLong(1), result.getString(2), result.getString(3),
							result.getString(4)));
				}

			} finally {
				if (result != null)
					result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(connection);
		}
		return lesContacts;
	}

	public List<Contact> getContact(String firstName) {
		connection = globalConnection.checkConnection(connection);
		List<Contact> lesContacts = new ArrayList<Contact>();
		Contact c = null;
		try {
			String req = "select * from contact where nom like ?";
			ResultSet result;
			try (PreparedStatement stmt = connection.prepareStatement(req)) {
				stmt.setString(1, "%" + firstName + "%");
				result = stmt.executeQuery();
				while (result.next()) {
					c = new Contact(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
					lesContacts.add(c);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(connection);
		}
		return lesContacts;
	}
	
	public Contact getContactById(int id) {
		connection = globalConnection.checkConnection(connection);
		Contact c = null;
		try {
			String req = "select * from contact where id like ?";
			ResultSet result;
			try (PreparedStatement stmt = connection.prepareStatement(req)) {
				stmt.setInt(1, id);
				result = stmt.executeQuery();
				while (result.next()) {
					c = new Contact(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(connection);
		}
		return c;
	}
}
