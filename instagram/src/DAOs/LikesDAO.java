package DAOs;

import java.sql.*;
import java.util.List;

import exceptions.DataBaseProblemException;
import instagram.DBConnection;
import instagram.Photo;
import instagram.Profile;

public class LikesDAO implements ILike {

	private Connection conn = DBConnection.getInstance().getConnection();

	public void incrementLikes(Photo p) throws DataBaseProblemException {
		if (p != null) {
			try {
				PreparedStatement pstat = conn
						.prepareStatement("UPDATE INTO likes (like_id, number_of_likes) " + "VALUES (null,?,?,?,?)");
				pstat.setInt(2, (p.getNumberOfLikes() + 1));
				pstat.executeUpdate();
				System.out.println("Insert complete!");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't add an profile", e);
			}
		}
	}

	public void derecmentLikes(Photo p) throws DataBaseProblemException {
		if (p != null) {
			try {
				PreparedStatement pstat = conn
						.prepareStatement("UPDATE INTO likes (like_id, number_of_likes) " + "VALUES (null,?,?,?,?)");
				pstat.setInt(2, (p.getNumberOfLikes() - 1));
				pstat.executeUpdate();
				System.out.println("Insert complete!");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't add an profile", e);
			}
		}

	}

	public void addNewRecord(Photo p) throws DataBaseProblemException {
		if (p != null) {

			List<Profile> profiles = DAO.getProfiles();
			int user_id = DAO.getProfileId(profiles, p);

			try {
				PreparedStatement pstat = conn.prepareStatement(
						"INSERT INTO likes (like_id, user_id, number_of_likes, photo_id) " + "VALUES (null,?,?,?)");
				pstat.setInt(1, user_id);
				//pstat.setInt("number_of_likes", p.setCountLikes(p.getCountLikes() + 1));

				// pstat.setString(4, p.);
				pstat.executeUpdate();
				System.out.println("Insert complete!");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't add an profile", e);
			}
		}
	}

}
