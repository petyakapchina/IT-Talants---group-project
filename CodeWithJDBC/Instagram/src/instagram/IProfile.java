package instagram;

import java.sql.SQLException;

public interface IProfile {
	void notifySubscribers();
	void follow(Profile followThisGuy) throws SQLException;
	void unfollow(Profile unfollowThisGuy) throws SQLException;

}
