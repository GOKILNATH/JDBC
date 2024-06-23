package dbconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {

    public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnectivity","root","accord");
			System.out.println("DBconnected");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}


