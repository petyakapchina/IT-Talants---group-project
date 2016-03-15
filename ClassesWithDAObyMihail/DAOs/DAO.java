package DAOs;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DataBaseProblemException;
import instagram.DBConnection;
import instagram.Photo;
import instagram.Profile;

public class DAO {
	static int counter = 0;

	private static Connection conn = DBConnection.getInstance().getConnection();

	public static List<Profile> getProfiles() throws DataBaseProblemException {
		List<Profile> listOfProfile = new ArrayList<Profile>();

		try {
			java.sql.Statement stm = conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT * FROM users");

			while (result.next()) {
				listOfProfile.add(new Profile(result.getString("first_name"), result.getString("last_name"),
						result.getString("user_name"), result.getString("email"), ""));

			}

		} catch (SQLException e) {
			throw new DataBaseProblemException("Can not do this rigth now", e);
		}
		return listOfProfile;

	}

	public static int getProfileId(List<Profile> list, Photo p) {
		String userName = "";
		int id = 0;

		for (Profile prof : list) {
			boolean equalNames = prof.getEmail() == p.getOwner().getEmail();
			boolean equalLNames = prof.getUserName() == p.getOwner().getUserName();
			if (equalLNames && equalNames) {
				userName = p.getOwner().getUserName();
				break;
			}
		}

		java.sql.Statement stm = null;
		try {
			stm = conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT user_id,username FROM users");
			while (result.next()) {
				String user = result.getString("username");
				if (userName == user) {
					id = result.getInt("user_id");
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;

	}

	public  static int getProfileMada(Profile p) throws DataBaseProblemException {
		int id = 0;
		List<Profile> listOfProfile = DAO.getProfiles();

		for (Profile profile : listOfProfile) {
			if (profile.equals(p)) {
				java.sql.Statement stm = null;
				try {
					stm = conn.createStatement();
					ResultSet result = stm.executeQuery("SELECT user_id,username FROM users ");
					while (result.next()) {
						String user = result.getString("username");
						if (p.getUserName() == user) {
							id = result.getInt("user_id");
						}

					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return id;

	}

	public static List<Photo> getPhotos() throws DataBaseProblemException {
		List<Photo> listOfPhotos = new ArrayList<Photo>();

		try {
			java.sql.Statement stm = conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT * FROM photos");

			while (result.next()) {
				// listOfProfile.add(new Photo()))
			}

		} catch (SQLException e) {
			throw new DataBaseProblemException("Can not do this rigth now", e);
		}
		return listOfPhotos;

	}

}
