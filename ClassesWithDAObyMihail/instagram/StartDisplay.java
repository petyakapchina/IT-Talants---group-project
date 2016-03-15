package instagram;

import java.util.Scanner;

import DAOs.ProfileDAO;
import exceptions.DataBaseProblemException;
import exceptions.InvalidEmailException;

public class StartDisplay {
	private Profile profile;
	private static int user_id;

	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first name:");
		String first_name = sc.nextLine();
		System.out.println("Enter last name:");
		String last_name = sc.nextLine();
		System.out.println("Enter username:");
		String name = sc.nextLine();
		System.out.println("Enter e-mial:");
		String email = sc.nextLine();
		System.out.println("Enter password: ");
		String password = sc.nextLine();
		profile = new Profile(first_name, last_name, name, email, password);
		user_id++;

		ProfileDAO pDAO = new ProfileDAO();
		try {
			pDAO.addProfile(profile);
		} catch (DataBaseProblemException e) {
			e.printStackTrace();
		}
		sc.close();
	}

	public void logIn(String userName, String password) {
		if (userName.equals(this.profile.getUserName()) && password.equals(this.profile.getPassword())) {
			
		}
	}

	public String forgottenPassword(String email) {
		if (email.equals(this.profile.getEmail())) {
			return new Exception("A new password was sent to your email!").getMessage();
		} else {
			return new InvalidEmailException("Email not found!").getMessage();
		}
	}


}
