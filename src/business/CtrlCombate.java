package business;

import entities.*;
import data.*;

public class CtrlCombate {
	
	private static CtrlCombate ctrlCombate;
	
	public Personaje jugador1, jugador2; //porque eran static las variables jugador  y 2?
	private dataPersonaje dataPer;
	private int turno=1;
	public Personaje persTurno;
	
	
	
	private CtrlCombate()
	{
		dataPer = new dataPersonaje();
		persTurno = new Personaje();
	}
	
	
	public static CtrlCombate getInstanciaUnica()
	{
		if (ctrlCombate==null)
		{
			ctrlCombate = new CtrlCombate();
		}
		
		else
		{
			//System.out.println("error al crear instancia del controlador");
		}
		
		return ctrlCombate;
		
	}
	
	
	public void setJugadores(Personaje p1, Personaje p2)
	{
		this.jugador1=p1;
		this.jugador2=p2;
	}
	
	public Personaje getJugador1()
	{
		return this.jugador1;
	}
	
	public Personaje getJugador2()
	{
		return jugador2;
	}
	
	public boolean Partida(int energiaUsada)
	{
		if((jugador1.getVidaActual()>0 && jugador2.getVidaActual()>0))
		{
			this.persTurno.atacar(energiaUsada);
			this.getTurnoAnterior().recibirAtaque(energiaUsada);
			this.getPersonajeTurno();
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	
	
	public Personaje getPersonajeTurno()
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
			
			return persTurno;
		
	}
	
	public Personaje getPersTurno()
	{
		return persTurno;
	}
	
	
	public Personaje getTurnoAnterior()
	{
		if(this.persTurno.equals(jugador1))
		{
			return jugador2;
		}
		
		else
		{
			return jugador1;
		}
	}
	
	

}
