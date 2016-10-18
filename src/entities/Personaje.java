package entities;

public class Personaje {
	private int id;
	private String nombre;
	private int vida;
	private int energia;
	private int defensa;
	private int evasion;
	private int puntosTotales;
	private int consumoEnergia;
	private int danio;
	
	
boolean resultado;
	
	
	public Personaje(String nombre, int vida, int energia, int defensa, int evasion)
	{
		this.setNombre(nombre);
		int ptsTotales=vida + energia + defensa + evasion;		 
		if(ptsTotales > 200)
		{
			resultado = false;
		}
		
		else
		{
			if(defensa>20)
			{
				resultado = false;
			}
			else
			{
				if(evasion>80)
				{
					resultado = false;
				}
				else
				{
					this.setVida(vida);
					this.setEnergia(energia);
					this.setDefensa(defensa);
					this.setEvasion(evasion);
					this.setPuntosTotales(ptsTotales);
					resultado = true;
				}
			}
			
		}
	}
	
	
	public void atacar(int energia)
	{
		consumoEnergia = consumoEnergia + energia;
	}
	
	
	public void recibirAtaque(int energia)
	{
		/*if(evade())
		{
			//mostrar cartel desde la interfaz "ataque evadido'
		}
		else
		{*/
			danio = danio + energia;
		//}
	}
	
	
	public int getEnergiaActual()
	{
		return energia - consumoEnergia;
	}
	
	
	public int getVidaActual()
	{
		return vida - danio;
	}
	
	
	public boolean evade()
	{
		boolean evade=false;
		
		if(Math.random()*100>evasion)
		{
			evade=true;
		}
		return evade ;
	}
	
	public void defender()
	{
		int energiaRecuperar = (energia * defensa)/100;
		consumoEnergia=consumoEnergia - energiaRecuperar;
		
		int vidaRecuperar = (vida*defensa)/250;
		danio=danio-vidaRecuperar;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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
	
	
	
	@Override
	public boolean equals (Object p)
	{
		return p instanceof Personaje && ((Personaje)p).getNombre()==this.getNombre() ;
		
	}
	 
}
