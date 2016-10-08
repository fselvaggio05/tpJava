package business;

import java.io.InvalidClassException;
import java.util.ArrayList;

import data.dataPersonaje;
import entities.*;
import util.ApplicationException;

public class CtrlABMCPersonaje {
	
	private ArrayList<Personaje> personajes;
	
	private dataPersonaje dataPer;
	
	public CtrlABMCPersonaje(){
		personajes = new ArrayList<Personaje>();
		dataPer = new dataPersonaje();
	}
	
	public void add(Personaje p) throws ApplicationException{
	
		for (Personaje personaje : personajes) {
			if(personaje.equals(p))
			{
				throw new ApplicationException("El personaje ya existe");
			}
			
			else
			{
				personajes.add(p);
			}
		}
		
	}
	
	
	private void update(Personaje p) throws ApplicationException{
		
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
