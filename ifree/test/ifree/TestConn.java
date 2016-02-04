package ifree;

import static org.junit.Assert.*;

import org.junit.Test;




public class TestConn {

	@Test
	public void test() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ifree";

		String user = "root";
		String password = "ifree";
		try {
			Class.forName(driver);
			java.sql.DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
