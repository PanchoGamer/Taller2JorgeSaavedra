/// Jorge Saavedra Sanchez 
/// Rut: 22.347.590-6 
/// Ingenieria en Tecnologias de Informacion

package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class App {
	
	public static List<AltoMando> pending = new ArrayList<>();
	public static List<AltoMando> medals = new ArrayList<>();
	public static List<Pokemon> p = new ArrayList<>();
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		cargarPokedex();
		
		String[] Tipos = new String[18];
		Scanner s = new Scanner(System.in);
		int opcion = 0;
		do {
			opcion = 0;
			
			System.out.println("1) Continuar");
			System.out.println("2) Nueva Partida");
			System.out.println("3) Salir");
			System.out.print("Ingrese Opcion: ");
			
			String entrada = s.nextLine();
			
			try
			{
				opcion = Integer.parseInt(entrada);
			} catch (NumberFormatException e)
			{
				System.out.println("\nIngrese una opcion valida\n");
			}
			
			if (opcion == 1)
			{
				cargarPartida();
			}
			
			else if (opcion == 2)
			{
				empezarPartida();
			}
			
		} while (opcion != 3);
		
		s.close();
	}
	
	public static void cargarPartida() throws FileNotFoundException
	{
		File f = new File("txts/Registros.txt");
		Scanner arch = new Scanner(f);
		
		
		if (arch.hasNextLine())
		{
			String linea = arch.nextLine();
			System.out.println("\nPartida Cargada\n");
		}
		else
		{
			System.out.println("\nNo existe Partida Guardada\n");
		}
		
		arch.close();
	}
	
	public static void empezarPartida()
	{
		System.out.println("Empieza :D");
	}
	
	public static void cargarPokedex() throws FileNotFoundException
	{
		File f1 = new File("txts/Pokedex.txt");
		Scanner s1 = new Scanner(f1);
		
		while (s1.hasNextLine())
		{
			String linea = s1.nextLine();
			String[] partes = linea.split(";");
			
			String nP = partes[0];
			String zone = partes[1];
			double prob = Double.parseDouble(partes[2]);
			int life = Integer.parseInt(partes[3]);
			int atq = Integer.parseInt(partes[4]);
			int def = Integer.parseInt(partes[5]);
			int atqEsp = Integer.parseInt(partes[6]);
			int defEsp = Integer.parseInt(partes[7]);
			int vel = Integer.parseInt(partes[8]);
			String type = partes[9];
			
			Pokemon pP = new Pokemon(nP,zone,prob,life,atq,def,atqEsp,defEsp,vel,type);
			
			p.add(pP);
		}
		
	}
}
