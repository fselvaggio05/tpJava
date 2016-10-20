package business;

import entities.*;
import data.*;

public class CtrlCombate {
	

	public static Personaje jugador1, jugador2;
	private dataPersonaje dataPer;
	private int turno=1;
	
	
	
	public void setJugadores(Personaje p1, Personaje p2)
	{
		this.jugador1=p1;
		this.jugador2=p2;
	}
	
	public Personaje getJugador1()
	{
		return jugador1;
	}
	
	public Personaje getJugador2()
	{
		return jugador2;
	}
	
	public void Partida()
	{
		if(jugador1.getVida()>0 && jugador2.getVida()>0)
		{
			this.getPersonajeTurno();
		}
	}
	
	
	
	public Personaje getPersonajeTurno()
	{
		Personaje persTurno=new Personaje();
		

			if(!(turno%2==0))
			{
				persTurno=jugador1;
			}
			else
			{
				persTurno=jugador2;
			}
			
			turno++;
			

		
		return persTurno;
		
		
	}
	
	
	

}
