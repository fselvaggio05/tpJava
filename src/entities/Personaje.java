package entities;

public class Personaje {
	private int id;
	private int vida;
	private int energia;
	private int defensa;
	private int evasion;
	private int puntosTotales;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getVida(){
		return this.vida;
	}
	
	public void setVida(int vida){
		this.vida = vida;
	}
	
	public int getEnergia(){
		return this.energia;
	}
	
	public void setEnergia(int energia){
		this.energia = energia;
	}
	
	public int getDefensa(){
		return this.defensa;
	}
	
	public void setDefensa(int defensa){
		this.defensa = defensa;
	}
	
	public int getEvasion(){
		return this.evasion;
	}
	
	public void setEvasion(int evasion){
		this.evasion = evasion;
	}
	
	public int getPuntosTotales(){
		return this.puntosTotales;
	}
	
	public void setPuntosTotales(int puntosTotales){
		this.puntosTotales = puntosTotales;
	}
}
