package interfaces;

import java.util.List;

import modelos.Persona;

public interface PersonaDAO {
	
	public void insertar(Persona p);
	
	public void eliminar(Persona p);
	
	public void modificar(Persona p);
	
	public List<Persona> getAll();
	
	public Persona getOne(Persona p);
}
