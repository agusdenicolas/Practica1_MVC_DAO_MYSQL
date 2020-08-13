package interfaces;

import java.util.List;

import _util.DAOException;
import modelos.Persona;

public interface PersonaDAO {
	
	public void insertar(Persona p) throws DAOException;
	
	public void eliminar(Persona p) throws DAOException;
	
	public void modificar(Persona p) throws DAOException;
	
	public List<Persona> getAll() throws DAOException;
	
	public Persona getOne(int id) throws DAOException;
}
