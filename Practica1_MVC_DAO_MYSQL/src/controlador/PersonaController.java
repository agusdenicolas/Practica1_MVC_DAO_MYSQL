package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import _util.DAOException;
import interfaces.PersonaDAO;
import modelos.Persona;
import vista.PersonaView;

public class PersonaController implements ActionListener{

	PersonaView view;
	PersonaDAO modelo;
	
	public PersonaController(PersonaDAO modelo, PersonaView view) {
		this.modelo = modelo;
		this.view = view;
	}
	
	public void asd() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.view.getBtnInsertar()) { //Boton insertar
			btnInsertar();
		}
	}
	
	public void btnInsertar() {
		String nombre = this.view.getTextFieldNombre().getText();
		String apellido = this.view.getTextFieldApellido().getText();
		int edad = Integer.parseInt(this.view.getTextFieldEdad().getText());
		
		Persona p = new Persona(nombre, apellido, edad);
		try {
			this.modelo.insertar(p);
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
	}
	
	
}
