package business;
import entities.*;
import data.*;

public class CtrlCombate {
	

	private Personaje jugador1, jugador2;
	private dataPersonaje dataPer;
	private int turno=1;
	
	
	
	public void setPersonajes(Personaje j1, Personaje j2)
	{
		this.jugador1=j1;
		this.jugador2=j2;
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
		
		while()
		{
			if(!(turno%2==0))
			{
				persTurno=jugador1;
			}
			else
			{
				persTurno=jugador2;
			}
			
			turno++;
			
		}
		
		return persTurno;
		
		
	}
	
	
	

}
