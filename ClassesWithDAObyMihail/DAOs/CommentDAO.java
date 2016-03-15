package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import exceptions.DataBaseProblemException;
import instagram.DBConnection;
import instagram.Photo;
import instagram.Profile;

public class CommentDAO implements IComment {

	private Connection conn = DBConnection.getInstance().getConnection();

	public void addComment(Photo p) throws DataBaseProblemException {
		if (p != null) {
			

			List<Profile> profiles = DAO.getProfiles();
			int user_id = DAO.getProfileId(profiles, p);
			
			try {
				PreparedStatement pstat = conn.prepareStatement(
						"INSERT INTO comments (comment_id, user_id, photo_id, text, date_posted) "
								+ "VALUES (null,?,?,?,?)");
				pstat.setInt(1, user_id);
				//pstat.setString(2, p.addComment(DAO.counter));
				pstat.setString(3, p.addComment(DAO.counter));
				pstat.setObject(4, p.getDataOfUpload());
				pstat.executeUpdate();
				System.out.println("Insert complete!");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't add thiscomment", e);
			}
		}
	}

	public void removeComment(String text) throws DataBaseProblemException {
		if (text != null & text.length() > 0) {
			try {
				PreparedStatement ps = conn.prepareStatement("DELETE FROM uscomments WHERE text=?");
				ps.setString(1, text);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't delete comment : " + text, e);
			}
		}

	}
	
	

}
