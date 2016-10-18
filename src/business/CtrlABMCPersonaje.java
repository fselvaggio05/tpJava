package business;
//en el ejercicio de ABM Personas, el controlador no tiene conexion con la cada de data..Estara bien??
import java.io.InvalidClassException;
import java.util.ArrayList;

import data.dataPersonaje;
import entities.*;
import util.ApplicationException;

public class CtrlABMCPersonaje {
	
	private ArrayList<Personaje> personajes;
	
	private dataPersonaje dataPer;
	private Personaje jugador1;
	private Personaje jugador2;
	static int turno;
	
		
		
	public void setPersonajes(Personaje j1, Personaje j2)
	{
		this.jugador1=j1;
		this.jugador2=j2;
	}
	
	
	public Personaje getPersonajeTurno()
	{
		System.out.println(turno);
		if(!(turno%2==0))
		{
			return jugador1;
		}
		else
		{
			return jugador2;
		}
		//turno++;
	}
	
	public CtrlABMCPersonaje(){
		
		dataPer = new dataPersonaje();
		turno=0;
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
		
		
				dataPer.update(p);
			
		
		
	}
	
	public void delete(Personaje p) throws ApplicationException
	{
		
				dataPer.delete(p);
			
	}
	
	
	public Personaje getPersonaje(Personaje p){
		return dataPer.getByNombre(p);
 	}
		
}
