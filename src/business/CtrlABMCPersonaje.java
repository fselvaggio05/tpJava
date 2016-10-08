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
	
	public void add(Personaje p){
		dataPer.add(p);
	}
	
	private void update(Personaje p){
		dataPer.update(p);
	}
	
	public void delete(){
		
	}

}
