package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.DataBaseProblemException;
import instagram.DBConnection;
import instagram.Photo;


public class PhotoDAO implements IPhoto{
	
	private Connection conn = DBConnection.getInstance().getConnection();

	public void addPhoto(Photo p) throws DataBaseProblemException {
		if (p != null) {
			try {
				PreparedStatement pstat = conn.prepareStatement(
						"INSERT INTO photos (photo_id, photo, user_id, tag, comment, date_posted) "
								+ "VALUES (null,?,?,?,?,?)");
				pstat.setObject(2, p);
				pstat.setInt(3, p.getOwner()));
				pstat.setString(4, p.getHashTag());
				pstat.setString(5, p.get);
				pstat.setObject(6, p.getDataOfUpload());
				pstat.executeUpdate();
				System.out.println("Insert complete!");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't add an profile", e);
			}
		}
	}

	public void removePhoto(Photo p) throws DataBaseProblemException {
		if (p != null) {
			try {
				PreparedStatement ps = conn.prepareStatement("DELETE FROM photos WHERE photo_id=?");
				ps.setString(1, p.);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't delete an this picture...",e);
			}
		}
	}

	public Photo getPhotoByHashTag(String hashTag) throws DataBaseProblemException {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM photos WHERE tag=?");
			ps.setString(1, hashTag);
			ResultSet result = ps.executeQuery();
			result.next();
			return new Photo(hashTag);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseProblemException("Can't find an photo with tag : " + hashTag, e);
		}
	}
	
}
