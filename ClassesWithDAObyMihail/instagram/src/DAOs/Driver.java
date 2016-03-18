package DAOs;
import java.sql.*;
public class Driver {
	
	public static void main(String[] args) throws SQLException {
		
			//1
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "Imamuspeshenbiznes1$");
			//2
			Statement myStat = myConn.createStatement();
			//3
			ResultSet rsl = myStat.executeQuery(
					"SELECT department_name FROM departments ORDER BY substring(department_name,3,3)");
			while(rsl.next())
				System.out.println(rsl.getString("department_name"));
			
			
		   
	}

}
