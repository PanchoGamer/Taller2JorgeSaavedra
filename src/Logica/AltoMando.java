package Logica;

import java.util.ArrayList;
import java.util.List;

public class AltoMando {
	private int id;
	private String nom;
	private List<Pokemon> pDis = new ArrayList<>();
	private boolean derrotado;
	
	public AltoMando(int id, String nom) 
	{
		this.id = id;
		this.nom = nom;
		derrotado = false;
	}
	
	public void agregarPokemon(Pokemon p)
	{
		pDis.add(p);
	}
	
}
