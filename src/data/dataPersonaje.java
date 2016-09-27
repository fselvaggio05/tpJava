package data;

import java.sql.*;
import entities.*;
import util.ApplicationException;

public class dataPersonaje {
	
public dataPersonaje(){
}

public void add (Personaje p){
	ResultSet rs = null;
	PreparedStatement stmt = null;
	
	try{
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into personaje(vida,energia,defensa,evasion,puntosTotales)"+"values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
		//stmt.setInt(1, p.getVida());
	}
	finally{
		//comment
	}
	
}
}
