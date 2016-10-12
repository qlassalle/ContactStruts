package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Contact;

public class DAOContact {

	private Connection connexion = null;
	private final String url = "jdbc:mysql://localhost:8889/contact";
	private final String urlWindows = "jdbc:mysql://localhost:3306/contact";
	private final String utilisateur = "root";
	private final String motDePasse = "root";
	private final String motDePasseWindows = "";

	public DAOContact() {
		connexion = getConnection();
	}

	public String save(String nom, String prenom, String email) {
		Statement stmt;
		try {
			stmt = connexion.createStatement();
			System.out.println("insert into contact(nom, prenom, email) values(\"" + nom + "\",\""
					+ prenom + "\",\"" + email + "\");");
			stmt.executeUpdate("insert into contact(nom, prenom, email) values(\"" + nom + "\",\""
					+ prenom + "\",\"" + email + "\");");
			stmt.close();
			return null;

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String update(int id, String nom, String prenom, String email) {
		int result = 0;
		String req = "update contact set id = ?, nom = ?, prenom = ?, email = ? where id = ?";
		System.out.println("id:" + id);
		try {
			PreparedStatement stmt = connexion.prepareStatement(req);
			stmt.setInt(1, id);
			stmt.setString(2, nom);
			stmt.setString(3, prenom);
			stmt.setString(4, email);
			stmt.setInt(5, id);
			result = stmt.executeUpdate();
			stmt.close();
			// connexion.close();
			return null;
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String delete(String id) {
		ResultSet result = null;
		String req = "delete from contact where id = ?";
		try {
			try (PreparedStatement stmt = connexion.prepareStatement(req)) {
				stmt.setString(1, id);
				stmt.executeUpdate();
				stmt.close();
			}
		} catch (SQLException sqle) {
			return sqle.getMessage();
		}
		return null;
	}

	public Contact research(int id) {
		return getContact(id);
	}

	public List<Contact> getAllContacts() {
		List<Contact> lesContacts = new ArrayList<Contact>();
		ResultSet result = null;
		try {
			try (Statement stmt = connexion.createStatement()) {
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
		return lesContacts;
	}

	public Contact getContact(int id) {
		Contact c = null;
		try {
			String req = "select * from contact where id = ?";
			ResultSet result;
			try (PreparedStatement stmt = connexion.prepareStatement(req)) {
				stmt.setInt(1, id);
				result = stmt.executeQuery();
				while (result.next()) {
					c = new Contact(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
					+ e.getMessage());
		}
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			System.out.println("Connecté à la bdd");
		} catch (SQLException e) {
			try {
				connexion = DriverManager.getConnection(urlWindows, utilisateur, motDePasseWindows);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return connexion;
	}
}
