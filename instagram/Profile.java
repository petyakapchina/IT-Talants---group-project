package instagram;

import exceptions.InvalidEmailException;
import exceptions.InvalidPasswordException;
import exceptions.InvalidUserNameException;

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
			this.setUserName(userName);
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
	public void subscribe() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unsubscribe() {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifySubscribers() {
		// TODO Auto-generated method stub

	}

	void setUserName(String newName) throws InvalidUserNameException {
		if (newName != null && newName.length() > 0) {
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
