package DAOs;

import java.sql.*;

import exceptions.DataBaseProblemException;
import instagram.DBConnection;
import instagram.Profile;

public class ProfileDAO implements IProfile {

	private Connection conn = DBConnection.getInstance().getConnection();

	public void addProfile(Profile p) throws DataBaseProblemException {
		if (p != null) {
			try {
				PreparedStatement pstat = conn.prepareStatement(
						"INSERT INTO users (user_id, first_name, last_name, email, password, username) "
								+ "VALUES (null,?,?,?,?,?)");
				pstat.setString(1, p.getFirsName());
				pstat.setString(2, p.getLastName());
				pstat.setString(3, p.getEmail());
				pstat.setString(4, p.getPassword());
				pstat.setString(5, p.getUserName());
				pstat.executeUpdate();
				System.out.println("Insert complete!");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't add an profile", e);
			}
		}
	}

	public void removeProfile(String userName) throws DataBaseProblemException {
		if (userName != null & userName.length() > 0) {
			try {
				PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE username=?");
				ps.setString(1, userName);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't delete an profile with username : " + userName, e);
			}
		}

	}

	public Profile getProfileByUserName(String userName) throws DataBaseProblemException {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE userName=?");
			ps.setString(1, userName);
			ResultSet result = ps.executeQuery();
			result.next();
			String firstName = result.getString(2);
			String lastName = result.getString(3);
			String email = result.getString(4);
			String password = "YOU ARE NOT ALLOWED TO SEE IT!";

			return new Profile(firstName, lastName, userName, email, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseProblemException("Can't find an author with ID : " + userName, e);
		}
	}

	public void changeUserName(String newName) throws DataBaseProblemException {
		if (newName != null && newName.length() > 0) {
			try {
				PreparedStatement pstat = conn.prepareStatement("UPDATE INTO users (username) " + "VALUES (?)");
				pstat.setString(1, newName);
				pstat.executeUpdate();
				System.out.println("Insert complete!");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't edit profile", e);
			}
		}
	}

	public void changePassword(String newPassword) throws DataBaseProblemException {
		if (newPassword != null && newPassword.length() > 0) {
			try {
				PreparedStatement pstat = conn.prepareStatement("UPDATE INTO users (password) " + "VALUES (?)");
				pstat.setString(1, newPassword);
				pstat.executeUpdate();
				System.out.println("Insert complete!");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't edit profile", e);
			}
		}
	}
}
