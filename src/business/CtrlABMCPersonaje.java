package business;
//en el ejercicio de ABM Personas, el controlador no tiene conexion con la cada de data..Estara bien??
import java.io.InvalidClassException;

import java.util.ArrayList;

import data.dataPersonaje;
import entities.*;
import util.ApplicationException;
//arreglar CONTROLADOR
public class CtrlABMCPersonaje {
	
		
	private dataPersonaje dataPer;
	private Personaje jugador1;
	private Personaje jugador2;
	int turno = 1;
		
		
	public void setPersonajes(Personaje j1, Personaje j2)
	{
		this.jugador1=j1;
		this.jugador2=j2;
	}
	
	
	public Personaje getPersonajeTurno()
	{
		if(!(turno%2==0))
		{
			return jugador1;
		}
		else
		{
			return jugador2;
		}
		turno++;
	}
	
	public CtrlABMCPersonaje(){
		
		dataPer = new dataPersonaje();
		
	}
	
	public void add(Personaje p) throws ApplicationException{
	
	
			/* ver como validar si un personaje ya esta en la bd
			 * if(p.getNombre()==this.getPersonaje(p))
			 
			{
				throw new ApplicationException("El personaje ya existe");
			}
			
			else*/
			{
				dataPer.add(p);
			}
		//}
		
	}
	
	
	public void update(Personaje p) throws ApplicationException{
		
		for (Personaje pers : personajes) {
			if(pers.equals(p))
			{
				dataPer.update(p);
			}
			
			else
			{
				throw new ApplicationException("El personaje no existe ");
			}
		}
		
		
	}
	
	public void delete(Personaje p) throws ApplicationException
	{
		
		for (Personaje pers : personajes) {
			if(pers.equals(p))
			{
				dataPer.delete(p);
			}
			
			else
			{
				throw new ApplicationException("El personaje no existe ");
			}
		}
		
	}
	
	public Personaje getPersonaje(Personaje p){
		return dataPer.getByNombre(p);
 	
		
	
	}
		
}
