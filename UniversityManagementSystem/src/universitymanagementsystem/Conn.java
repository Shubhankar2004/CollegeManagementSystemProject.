package universitymanagementsystem;
import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
	
	public Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegemanagementsystem","root","shubhankar@2004");
			s=c.createStatement();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
