package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.PhoneNumber;

public class DAOPhoneNumber extends GlobalConnection{

	public DAOPhoneNumber () {
		super();
	}
	
	public List<PhoneNumber> getPhoneNumbers(int idContact) {
		List<PhoneNumber> numbers = new ArrayList<PhoneNumber>();
		connection = checkConnection(connection);
		ResultSet result = null;
		try {
			String req = "select * from phone where idContact = ?";
			try(PreparedStatement stmt = connection.prepareStatement(req)) {
				stmt.setInt(1, idContact);
				result = stmt.executeQuery();
				while(result.next()) {
					numbers.add(new PhoneNumber(result.getInt(1), result.getString(2), result.getString(3), 
							result.getInt(4)));
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return numbers;
	}

	public String save(String kind, String number, int idContact) {
		connection = checkConnection(connection);
		try {
			String req = "insert into phone(kind, number, idContact) values(?, ?, ?)";
			try (PreparedStatement stmt = connection.prepareStatement(req)) {
				stmt.setString(1, kind);
				stmt.setString(2, number);
				stmt.setInt(3, idContact);
				stmt.executeUpdate();
				return null;
			}
		} catch (SQLException sqle) {
			return sqle.getMessage();
		} finally {
			closeConnection(connection);
		}
	}
}
