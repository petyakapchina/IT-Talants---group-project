package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.DataBaseProblemException;
import instagram.DBConnection;
import instagram.Profile;

public class SubscriberDAO implements ISubsciber {

	private Connection conn = DBConnection.getInstance().getConnection();

	public void addSubscriber(Profile user, Profile subscriber) throws DataBaseProblemException {

		if (user != null && subscriber != null) {
			int userId = DAO.getProfileMada(user);
			int subId = DAO.getProfileMada(subscriber);

			try {
				PreparedStatement pstat = conn.prepareStatement("INSERT INTO subscribers VALUES (?,?)");
				pstat.setInt(1, userId);
				pstat.setInt(2, subId);
				pstat.executeUpdate();
				System.out.println("Insert complete!");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Unsuccessful. Problem occured.", e);
			}
		}
	}

	public void removeSubscriber(Profile user, Profile subscriber) throws DataBaseProblemException {
		if (user != null & subscriber != null) {
			int userId = DAO.getProfileMada(user);
			int subId = DAO.getProfileMada(subscriber);

			try {
				PreparedStatement ps = conn
						.prepareStatement("DELETE FROM subscribers WHERE subscriber_id=?, user_id=?");
				ps.setInt(1, userId);
				ps.setInt(1, subId);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataBaseProblemException("Unsuccessful. Problem occured.", e);
			}
		}
	}

}
