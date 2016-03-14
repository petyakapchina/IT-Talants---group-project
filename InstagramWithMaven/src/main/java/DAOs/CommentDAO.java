package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exceptions.DataBaseProblemException;
import instagram.DBConnection;
import instagram.Photo;

public class CommentDAO implements IComment {

	private Connection conn = DBConnection.getInstance().getConnection();

	public void addComment(Photo p) throws DataBaseProblemException {
		if (p != null) {
			try {
				PreparedStatement pstat = conn.prepareStatement(
						"INSERT INTO comments (comment_id, user_id, photo_id, text, date_posted) "
								+ "VALUES (null,?,?,?,?)");
				pstat.setString(2, p.getFirsName());
				pstat.setString(3, p.getLastName());
				pstat.setString(4, p.getAllComments());
				pstat.setObject(5, p.getDataOfUpload());
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
