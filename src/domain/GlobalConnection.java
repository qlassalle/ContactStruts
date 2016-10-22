package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GlobalConnection {
	
	private final String url = "jdbc:mysql://localhost:8889/contact";
	private final String urlWindows = "jdbc:mysql://localhost:3306/contact";
	private final String utilisateur = "root";
	private final String motDePasse = "root";
	private final String motDePasseWindows = "";
	

	Connection connection;
	
	public GlobalConnection() {
		connection = getConnection();
	}

	protected Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
					+ e.getMessage());
		}
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException e) {
			try {
				connexion = DriverManager.getConnection(urlWindows, utilisateur, motDePasseWindows);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return connexion;
	}
	
	protected Connection checkConnection(Connection connection)
	{
		try {
			if(connection.isClosed()) connection = getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return connection;
	}
	
	protected void closeConnection(Connection connection) {
		if(connection !=  null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
}