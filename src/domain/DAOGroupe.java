package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import models.Contact;
import models.Groupe;

public class DAOGroupe extends GlobalConnection {

	Connection connection;
	GlobalConnection globalConnection;
	
	public DAOGroupe() {
		globalConnection = new GlobalConnection();
		connection = globalConnection.getConnection();
	}
	
	public String save(String name) {
		connection = globalConnection.checkConnection(connection);
		Statement stmt;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate("insert into groupe(name) values (\"" + name + "\");");
			stmt.close();
			return null;
		} catch (SQLException sqle) {
			return sqle.getMessage();
		} finally {
			closeConnection(connection);
		}
	}

	public List<Groupe> getAllGroupes() {
		connection = globalConnection.checkConnection(connection);
		List<Groupe> lesGroupes = new ArrayList<Groupe>();
		ResultSet result = null;
		try {
			try (Statement stmt = connection.createStatement()) {
				result = stmt.executeQuery("select * from groupe order by name asc");
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
		connection = globalConnection.checkConnection(connection);
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
		
		connection = globalConnection.checkConnection(connection);
		Statement stmt;
		String req;
		try {
			for(String contact : ids) {
				req = "insert into contact_groupe(idGroupe, idContact) values("+id+"," +contact+");";
				stmt = connection.createStatement();
				System.out.println(req);
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
		connection = globalConnection.checkConnection(connection);
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
}
