package Logica;

import java.util.ArrayList;
import java.util.List;

public class Gimnacios {
	private int nGim;
	private String lider;
	private String estado;
	private int cantPok;
	private List<Pokemon> Pokemones = new ArrayList<>();
	
	public Gimnacios(int nGim, String lider, String estado, int cantPok) 
	{
		this.nGim = nGim;
		this.lider = lider;
		this.estado = estado;
		this.cantPok = cantPok;
	}

	public int getnGim() 
	{
		return nGim;
	}

	public String getLider() 
	{
		return lider;
	}

	public String getEstado() 
	{
		return estado;
	}

	public int getCantPok() 
	{
		return cantPok;
	}
	
	public List<Pokemon> getPokemones() 
	{
		return Pokemones;
	}
	
	public void setEstado(String estado) 
	{
		this.estado = estado;
	}

	public void agregarPokemon(Pokemon p)
	{
		Pokemones.add(p);
	}

	@Override
	public String toString() {
		return "" + getLider() + " - Estado: " + getEstado();
	}

	
	
}
