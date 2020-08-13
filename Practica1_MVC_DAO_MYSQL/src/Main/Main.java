package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import _util.DAOException;
import implementaciones.PersonaImplMySQL;
import interfaces.PersonaDAO;
import modelos.Persona;

public class Main {

	public static void main(String[] args) throws DAOException {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba1", "root", "root");
			System.out.println("CONECTADO PERRO");
			PersonaDAO dao = new PersonaImplMySQL(conn);
//			List<Persona> personas = dao.getAll();
//			for (Persona x : personas) {
//				System.out.println(x.toString());
//			}
			Persona p = new Persona("PEPE", "ARGENTO", 45);
			p.setId(4);
			dao.modificar(p);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}

}
