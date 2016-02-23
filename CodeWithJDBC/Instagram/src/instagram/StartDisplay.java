package instagram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import exceptions.InvalidEmailException;
import exceptions.InvalidPasswordException;

public class StartDisplay implements IDisplay {
	private Profile profile;
	private static int user_id;

	public Profile register() {
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

		sc.close();
		try {
			// 1
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram", "root", "****");
			// 2
			Statement myStat = myConn.createStatement();
			// 3
			PreparedStatement pstat = myConn
					.prepareStatement("INSERT INTO USER (user_id, first_name, last_name, email, password, username) "
							+ "VALUES (?,?,?,?,?,?)");
			pstat.setInt(1, user_id);
			pstat.setString(2, first_name);
			pstat.setString(3, last_name);
			pstat.setString(4, email);
			pstat.setString(5, password);
			pstat.setString(6, name);
			pstat.executeUpdate();
			System.out.println("Insert complete!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return profile;
	}

	public void logIn(String userName, String password) {
		if (userName.equals(this.profile.getUserName()) && password.equals(this.profile.getPassword())) {
			// changeDisplay(this.profile.main);
		}
	}

	public String forgottenPassword(String email) {
		if (email.equals(this.profile.getEmail())) {
			return new Exception("A new password was sent to your email!").getMessage();
		} else {
			return new InvalidEmailException("Email not found!").getMessage();
		}
	}

	@Override
	public void changeDisplay(IDisplay display) {
		// open stated display
	}

}
