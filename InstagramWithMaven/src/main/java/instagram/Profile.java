package instagram;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import exceptions.InvalidEmailException;
import exceptions.InvalidPasswordException;
import exceptions.InvalidUserNameException;

public class Profile implements IProfile, Comparable<Profile> {
	private String firsName;
	private String lastName;
	private String userName;
	private Set<Profile> subscribers;
	private Set<Photo> gallery;
	private Photo profilePhoto;
	private Set<Photo> phonePhotos;
	private int numberOfSunscribers;
	private String password;
	private String email;

	static Map<String, Profile> profileFinder = new TreeMap<String, Profile>();

	public Profile(String firstName, String lastName, String userName, String email, String password) {
		try {
			this.setUserName(userName);
			this.setPassword(password);
			this.setEmail(email);
			this.firsName = firstName;
			this.lastName = lastName;
		} catch (InvalidUserNameException e) {
			e.getMessage();
		} catch (InvalidPasswordException e) {
			e.getMessage();
		} catch (InvalidEmailException e) {
			e.getMessage();
		}
		this.subscribers = new TreeSet<Profile>();
		this.gallery = new TreeSet<Photo>();
		this.phonePhotos = new TreeSet<Photo>();
		this.numberOfSunscribers = 0;
		profileFinder.put(userName, this);
	}

	public void subscribe(Profile p) {
		if (p != null) {
			p.subscribers.add(this);
			p.addSubscriber();
		}
	}

	public void unsubscribe(Profile p) {
		p.subscribers.remove(this);
		p.removeSubscriber();
	}

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

	public String getUserName() {
		return this.userName;
	}

	public String getPassword() {
		return this.password;
	}

	public int getNumberOfSubscribers() {
		return this.numberOfSunscribers;
	}

	void addSubscriber() {
		this.numberOfSunscribers++;
	}

	void removeSubscriber() {
		this.numberOfSunscribers--;
	}

	void addPhotoToPhoneGalerry(Photo p) {
		if (p != null)
			this.phonePhotos.add(p);
	}

	void addPhotoToInstagram(Photo p) {
		this.gallery.add(p);
	}

	Photo getPhotoFromPhoneGallery(Photo p) {
		for (Photo photo : this.phonePhotos) {
			if (photo.equals(p)) {
				return p;
			}
		}
		return null;
	}

	public String getEmail() {
		return this.email;
	}

	public int compareTo(Profile p) {
		return this.userName.compareTo(p.getUserName());
	}

	@Override
	public String toString() {
		String result = "User name: " + this.userName + " Number of followers: " + this.numberOfSunscribers;
		return result;
	}

	void setProfilePic(Photo p) {
		if (p != null) {
			this.profilePhoto = p;
		}
	}

	public String getFirsName() {
		return firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void deletePhotoFromGAlery(Photo p) {
		if (p != null) {
			this.gallery.remove(p);
		}
	}



}
