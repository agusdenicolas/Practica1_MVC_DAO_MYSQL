package factory;

import java.sql.Connection;

import _util.Conexion;
import implementaciones.PersonaImplMySQL;
import interfaces.PersonaDAO;

public class FactoryDAO {
	
	public static PersonaDAO getImpl(String x) {
		if (x.equalsIgnoreCase("mysql")) {
			return new PersonaImplMySQL(Conexion.getConnection());
		}
		return null;
	}
	
}
