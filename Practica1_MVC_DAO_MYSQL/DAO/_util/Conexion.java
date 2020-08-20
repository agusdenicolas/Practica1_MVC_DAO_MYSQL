package _util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {
	
	public static Connection getConnection(){
		Properties prop = new Properties();
		InputStream is;
		Connection conn = null;
		
		try {
			is = new FileInputStream("Propiedades.properties");
			prop.load(is);
			conn = DriverManager.getConnection(prop.getProperty("bd_url") + prop.getProperty("bd_name"), prop.getProperty("bd_user"), prop.getProperty("bd_password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
