package DAOs;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import exceptions.DataBaseProblemException;
import instagram.DBConnection;
import instagram.Photo;
import instagram.Profile;


public class PhotoDAO implements IPhoto{
	
	private Connection conn = DBConnection.getInstance().getConnection();

	public void addPhoto(Photo p) throws DataBaseProblemException {

		
		List<Profile> profiles = DAO.getProfiles();
		int user_id = DAO.getProfileId(profiles, p);

		if (p != null) {
			try {
				PreparedStatement pstat = conn.prepareStatement(
						"INSERT INTO photos (photo_id, photo, user_id, tag, comment, date_posted) "
								+ "VALUES (null,?,?,?,?,?)");
				pstat.setObject(1, p);
				pstat.setInt(2, user_id);
				pstat.setString(3, p.getHashTag());
				pstat.setString(4, "");
				pstat.setObject(5, p.getDataOfUpload());
				pstat.executeUpdate();
				System.out.println("Insert complete!");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Can't add an profile", e);
			}
		}
	}

	public void removePhoto(int photoId) throws DataBaseProblemException {
		if (photoId != 0) {
			try {
				PreparedStatement ps = conn.prepareStatement("DELETE FROM photos WHERE photo_id=?");
				ps.setInt(1, photoId);
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

	@Override
	public void removePhoto(Photo p) throws DataBaseProblemException {
		// TODO Auto-generated method stub
		
	}
	
	
}
