package Main;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba1", "root", "root");
			System.out.println("CONECTADO PERRO");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
