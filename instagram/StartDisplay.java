package instagram;

import java.util.Scanner;

import exceptions.InvalidEmailException;
import exceptions.InvalidPasswordException;

public class StartDisplay implements IDisplay {
	private Profile profile;
		
	public Profile register(){
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter username:");
		String name = sc.nextLine();
		System.out.println("Enter e-mial:");
		String email = sc.nextLine();
		System.out.println("Enter password: ");
		String password = sc.nextLine();
		profile = new Profile(name, email, password);
		
		sc.close();
		
		return profile;
	}
	
	public void logIn(String userName, String password){
		if (userName.equals(this.profile.getUserName())&&password.equals(this.profile.getPassword())){
			changeDisplay(this.profile.main);
		}
	}
	
	public String forgottenPassword(String email){
		if (email.equals(this.profile.getEmail())){
			return this.profile.getPassword();
		}
		else{
			return new InvalidEmailException("Email not found!").getMessage();
		}
	}

	@Override
	public void changeDisplay(IDisplay display) {
		//open stated display		
	}

}
