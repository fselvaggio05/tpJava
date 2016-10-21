package business;
//en el ejercicio de ABM Personas, el controlador no tiene conexion con la cada de data..Estara bien??
import java.io.InvalidClassException;


import data.dataPersonaje;
import entities.*;
import util.ApplicationException;

public class CtrlABMCPersonaje {
	private dataPersonaje dataPer;
    ///comentario Florencia2
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
		
		
				dataPer.update(p);
			
		
		
	}
	
	public void delete(Personaje p) throws ApplicationException
	{
		
				dataPer.delete(p);
			
	}
	
	
	public Personaje getPersonaje(String nombre){
		return dataPer.getByNombre(nombre);
 	}
		
}
