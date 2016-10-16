package data;

import java.sql.*;
import entities.*;
import util.ApplicationException;

public class dataPersonaje {
	
	
	public dataPersonaje(){
		
	}
	
	public void add(Personaje p){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into personas(nombre,vida,energia,defensa,evasion,puntosTotales)"+
					" values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
						
			
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getId());
			stmt.setInt(3, p.getVida());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6,p.getPuntosTotales());
			stmt.execute();
			
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void update(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
					"update personas set vida=?, energia=?, defensa=?, evasion=?, puntosTotales=?"+
					" where id=?");
			
			stmt.setInt(1, p.getVida());
			stmt.setInt(2, p.getEnergia());
			stmt.setInt(3, p.getDefensa());
			stmt.setInt(4, p.getEvasion());
			stmt.setInt(5, p.getPuntosTotales());
			stmt.setInt(6, p.getId());
			stmt.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from personaje where id=?");
			stmt.setInt(1, p.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public Personaje getByNombre(Personaje per){
		Personaje p=null;
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id, nombre, vida, energia, defensa, evasion, puntosTotales from personaje where nombre=?");
			stmt.setString(1, per.getNombre());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Personaje();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setVida(rs.getInt("vida"));
				p.setEnergia(rs.getInt("energia"));
				p.setDefensa(rs.getInt("defensa"));
				p.setEvasion(rs.getInt("evasion"));
				p.setPuntosTotales(rs.getInt("puntosTotales"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
		
		return p;
	}
	
}