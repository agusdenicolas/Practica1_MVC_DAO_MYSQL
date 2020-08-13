package implementaciones;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import _util.DAOException;
import interfaces.PersonaDAO;
import modelos.Persona;

public class PersonaImplMySQL implements PersonaDAO{
	
	private final String INSERT = "INSERT INTO persona(nombre, apellido, edad) VALUES(?,?,?);";
	private final String GETALL = "SELECT * FROM persona;";
	private final String GETONE = "SELECT * FROM persona WHERE id_persona = ?;";
	private final String DELETE = "DELETE FROM persona WHERE id_persona = ?;";
	private final String UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, edad = ? WHERE id_persona = ?";

	private Connection conn = null;
	
	public PersonaImplMySQL(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insertar(Persona p) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(INSERT);
			stat.setString(1, p.getNombre());
			stat.setString(2, p.getApellido());
			stat.setInt(3, p.getEdad());
			if (stat.executeUpdate() == 0) {
				throw new DAOException("No fue ingresada la persona en la bd");
			}
		} catch (SQLException e) {
			throw new DAOException("Error en SQL", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("Error en SQL", e);
				}
			}
		}
	}

	@Override
	public void eliminar(Persona p) throws DAOException{
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(DELETE);
			stat.setInt(1, p.getId());
			if(stat.executeUpdate() == 0) {
				throw new DAOException("No fue eliminar la persona de la bd");
			}
		} catch (SQLException e) {
			throw new DAOException("Error en SQL", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("Error en SQL", e);
				}
			}
		}	
	}

	@Override
	public void modificar(Persona p) throws DAOException{
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE);
			stat.setString(1, p.getNombre());
			stat.setString(2, p.getApellido());
			stat.setInt(3, p.getEdad());
			stat.setInt(4, p.getId());
			if (stat.executeUpdate() == 0) {
				throw new DAOException("No fue posible actualizar los datos de la persona");
			}
		} catch (SQLException e) {
			throw new DAOException("Error en SQL", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("Error en SQL", e);
				}
			}
		}
	}

	@Override
	public List<Persona> getAll() {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Persona> personas = new ArrayList<Persona>();
		try {
			stat = conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			
			while (rs.next()) {
				personas.add(convertir(rs));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return personas;
	}

	@Override
	public Persona getOne(int id) {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Persona p = null;
		try {
			stat = conn.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if(rs.next()) {
				p = convertir(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return p;
	}
	
	public Persona convertir(ResultSet rs) throws SQLException {
		String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");
		int edad = rs.getInt("edad");
		Persona p = new Persona(nombre, apellido, edad);
		p.setId(rs.getInt("id_persona"));
		return p;
	}
}
