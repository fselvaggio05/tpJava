package data;

import java.sql.*;
import entities.*;
import util.ApplicationException;

public class dataPersonaje{
	
	//public dataPersonaje(){}

	public void add (Personaje p){
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into personaje(vida,energia,defensa,evasion,puntosTotales)"+"values(?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, p.getId());
			stmt.setInt(2, p.getVida());
			stmt.setInt(3, p.getEnergia());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPuntosTotales());
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setId(rs.getInt(1));
				}
		}
			catch(SQLException e){
				e.printStackTrace();
			} catch (ApplicationException e){
				e.printStackTrace();
			}
		finally{
				try{
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close();
						FactoryConexion.getInstancia().releaseConn();
					} catch(ApplicationException e){
						e.printStackTrace();
					} catch(SQLException e){
						e.printStackTrace();
						}
				}
}
