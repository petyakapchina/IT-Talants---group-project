package instagram;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		Profile pesho = new Profile("petruha", "sfafasfa", "sdassafaf");
		Profile ceco = new Profile("cvetan", "sfafasfa", "sdassafaf");		 
			try {
				System.out.println("1");
				pesho.setUserName("peshkata");
				//pesho.unfollow(ceco);
				//ceco.unfollow(pesho);
				//pesho.follow(ceco);
				//ceco.follow(pesho);
				System.out.println("2");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidUserNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		

	}

}
