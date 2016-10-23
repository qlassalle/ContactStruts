package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Address;

public class DAOAddress extends GlobalConnection{
	
	public DAOAddress() {
		super();
	}

	public Address getAddress(int id)
	{
		Address address = null;
		connection = checkConnection(connection);
		try {
			String req = "select * from address where id = ? ";
			ResultSet result;
			try (PreparedStatement stmt = connection.prepareStatement(req)){
				stmt.setInt(1, id);
				result = stmt.executeQuery();
				while(result.next()){
					address = new Address(result.getInt(1), result.getString(2),
							result.getString(3), result.getString(4), result.getString(5));
				}
			} 
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			closeConnection(connection);
		}
		return address;
	}


	public int save(String street, String city, String zip, String country) {
		connection = checkConnection(connection);
		PreparedStatement stmt = null;
		try
		{
			String req = "insert into address(street, city, zip, country) values (?,?,?,?);";
			System.out.println(req);
			stmt = connection.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, street);
			stmt.setString(2, city);
			stmt.setString(3, zip);
			stmt.setString(4, country);
			stmt.executeUpdate();
			try (ResultSet id = stmt.getGeneratedKeys()) {
				if(id.next()) {
					return id.getInt(1);
				}
			}
			stmt.close();
			return 0;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return 0;
		}
		finally {
			closeConnection(connection);
		}
	}

	public String delete(int id) {
		connection = checkConnection(connection);
		String req = "delete from address where id = ?;";
		try {
			try(PreparedStatement stmt = connection.prepareStatement(req)){
				stmt.setInt(1, id);
				stmt.executeUpdate();
				stmt.close();
				return null;
			}
		} catch (SQLException sqle) {
			return sqle.getMessage();
		} finally {
			closeConnection(connection);
		}
	}
}
