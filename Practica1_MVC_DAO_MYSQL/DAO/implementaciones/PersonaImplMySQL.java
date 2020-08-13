package implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import interfaces.PersonaDAO;
import modelos.Persona;

public class PersonaImplMySQL implements PersonaDAO{
	
	private final String INSERT = "INSERT INTO persona(nombre, apellido, edad) VALUES(?,?,?);";
	private final String GETALL = "SELECT * FROM persona;";
	private final String GETONE = "SELECT * FROM persona WHERE id_persona = ?;";
	private final String DELETE = "DELETE FROM persona WHERE id_persona = ?;";

	Connection conn = null;
	
	public PersonaImplMySQL(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void insertar(Persona p) {
		
		
	}

	@Override
	public void eliminar(Persona p) {
	
		
	}

	@Override
	public void modificar(Persona p) {
	
		
	}

	@Override
	public List<Persona> getAll() {
		
		return null;
	}

	@Override
	public Persona getOne(Persona p) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(GETONE);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	
}
