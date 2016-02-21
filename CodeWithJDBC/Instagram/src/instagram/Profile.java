package instagram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Profile implements IProfile {
	private String userName;
	private String password;
	private String email;
	private Subscriber[] subscribers;
	private Photo[] gallery;
	private Photo profilePhoto;
	private Photo[] phonePhotos;

	MainDispaly main;
	StartDisplay start;
	SearchDisplay search;
	PhotoDisplay photoDisplay;
	ProfileDisplay profileDispaly;
	ActivityDispaly activityDisplay;

	Profile(String userName, String email, String password) {
		try {
			try {
				this.setUserName(userName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setPassword(password);
			this.setEmail(email);
		} catch (InvalidUserNameException e) {
			e.getMessage();
		} catch (InvalidPasswordException e) {
			e.getMessage();
		} catch (InvalidEmailException e) {
			e.getMessage();
		}

	}

	@Override
	public void follow(Profile followThisGuy) throws SQLException {
		
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/instagram", "root", "");
		Statement getFollower = con.createStatement();
		ResultSet follower = getFollower.executeQuery("select users.id from instagram.users where users.username = '" + this.userName + "'");
		Statement getFollowing = con.createStatement();
		ResultSet following = getFollowing.executeQuery("select users.id from instagram.users where users.username = '" + followThisGuy.userName + "'");
		follower.next();
		following.next();
		//System.out.println(follower.getInt("id"));
		
		//follower.getInt("id");
		getFollower.executeUpdate("INSERT INTO instagram.followers (`user_id`, `follower_id`) VALUES ("+ follower.getInt("id") +"," + following.getInt("id") +")");

	}

	@Override
	public void unfollow(Profile unfollowThisGuy) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/instagram", "root", "");
		Statement getFollower = con.createStatement();
		ResultSet follower = getFollower.executeQuery("select users.id from instagram.users where users.username = '" + this.userName + "'");
		Statement getFollowing = con.createStatement();
		ResultSet following = getFollowing.executeQuery("select users.id from instagram.users where users.username = '" + unfollowThisGuy.userName + "'");
		follower.next();
		following.next();
		//System.out.println(follower.getInt("id"));
		
		//follower.getInt("id");
		getFollower.executeUpdate("DELETE FROM instagram.followers where user_id = "+ follower.getInt("id") +" and follower_id = " + following.getInt("id"));


	}

	@Override
	public void notifySubscribers() {
		// TODO Auto-generated method stub

	}

	void setUserName(String newName) throws InvalidUserNameException, SQLException {
		if (newName != null && newName.length() > 0) {			
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/instagram", "root", "");
			Statement getFollower = con.createStatement();
			//ResultSet follower = getFollower.executeQuery("select users.username from instagram.users where users.username = '" + this.userName + "'");
			getFollower.executeUpdate("UPDATE users SET username = '" + newName + "' where username = '" + this.userName + "'");
			this.userName = newName;
		} else {
			throw new InvalidUserNameException("Incorect user name!");
		}
	}

	void setPassword(String newPassword) throws InvalidPasswordException {
		if (newPassword != null && newPassword.length() > 10) {
			this.password = newPassword;
		} else {
			throw new InvalidPasswordException("Incorrect password!");
		}
	}

	void setEmail(String email) throws InvalidEmailException {
		if (email != null && email.length() > 0) {
			this.email = email;
		} else {
			throw new InvalidEmailException("Incorrect email!");
		}
	}

	String getUserName() {
		return userName;
	}

	String getPassword() {
		return password;
	}

	String getEmail() {
		return email;
	}

}
