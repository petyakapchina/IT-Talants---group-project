package instagram;

import java.util.Scanner;

import DAOs.ProfileDAO;
import exceptions.DataBaseProblemException;
import exceptions.InvalidPasswordException;
import exceptions.InvalidUserNameException;

public class ProfileDisplay {
	private Profile profile;
	
	private ProfileDAO profileDAO = new ProfileDAO();

	public void editUserName(String newName) throws InvalidUserNameException, DataBaseProblemException {
		profileDAO.changeUserName(newName);
		profile.setUserName(newName);
	}

	public void editProfilePhoto(Photo p) {
		profile.setProfilePic(p);
	}

	@SuppressWarnings("resource")
	public void changePassword() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter password");
		String password = sc.next();

		if (profile.getPassword().equals(password)) {
			System.out.println("Enter new password:");
			profile.setPassword(sc.next());
			profileDAO.changePassword(sc.next());
			System.out.println("Your password was changed successfully!");
		} else{
			throw new InvalidPasswordException("*!Wrong password!*");
		}
		sc.close();
	}

	public void deleteProfile() throws DataBaseProblemException {
		profileDAO.removeProfile(this.profile.getUserName());
		this.profile = null;
	}

}
