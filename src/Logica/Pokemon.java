package Logica;

public class Pokemon {
	private String nom;
	private String habitat;
	private double prob;
	private int life;
	private int atq;
	private int def;
	private int atqEsp;
	private int defEsp;
	private int vel;
	private String type;
	
	public Pokemon(String nom, String habitat, double prob, int life, int atq, int def, int atqEsp, int defEsp, int vel, String type) {
		this.nom = nom;
		this.habitat = habitat;
		this.prob = prob;
		this.life = life;
		this.atq = atq;
		this.def = def;
		this.atqEsp = atqEsp;
		this.defEsp = defEsp;
		this.vel = vel;
		this.type = type;
	}

	public String getNom() 
	{
		return nom;
	}

	public String getHabitat() 
	{
		return habitat;
	}

	public double getProb() 
	{
		return prob;
	}

	public int getLife() 
	{
		return life;
	}

	public int getAtq() 
	{
		return atq;
	}

	public int getDef() 
	{
		return def;
	}

	public int getAtqEsp() 
	{
		return atqEsp;
	}

	public int getDefEsp() 
	{
		return defEsp;
	}

	public int getVel() 
	{
		return vel;
	}

	public String getType() 
	{
		return type;
	}
	
	
	
}
