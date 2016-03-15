import static org.junit.Assert.*;

import org.junit.Test;

import instagram.DBConnection;

public class junit {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	public void testConnection() {
		assertNotNull(DBConnection.getInstance().getConnection());
	}
	
	
	
	
}
