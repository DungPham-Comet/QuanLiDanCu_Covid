package ConnectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySql {
	
	public static Connection connectMysql () {
		String url ="jdbc:mysql://localhost:3306/cnpm2023";
		String username ="root";
		String password = "ilovemu1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("vai luon");
			return DriverManager.getConnection(url, username, password);
		
		}
		catch(ClassNotFoundException e){
			System.out.println("vai lon");
			return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
