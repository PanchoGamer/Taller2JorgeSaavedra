/// Jorge Saavedra Sanchez 
/// Rut: 22.347.590-6 
/// Ingenieria en Tecnologias de Informacion

package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.util.Random;

public class App {
	
	public static List<Gimnacios> gim = new ArrayList<>();
	public static List<AltoMando> altoMando = new ArrayList<>();
	public static List<Pokemon> p = new ArrayList<>();
	public static List<String> Tipos = new ArrayList<>();
	public static List<Pokemon> pPropio = new ArrayList<>();
	public static List<Pokemon> PC = new ArrayList<>();
	public static String apodo = null;
	
	public static void main(String[] args) throws IOException 
	{
		
		cargarPokedex();
		
		Scanner s = new Scanner(System.in);
		int opcion = 0;
		do {
			opcion = 0;
			
			System.out.println("\n1) Continuar");
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
				cargarPartida(s);
			}
			
			else if (opcion == 2)
			{
				empezarPartida(s);
			}
			
		} while (opcion != 3);
		
		s.close();
	}
	
	public static void cargarPartida(Scanner s) throws FileNotFoundException
	{
		File f = new File("txts/Registros.txt");
		Scanner arch = new Scanner(f);
		
		
		if (arch.hasNextLine())
		{
			String linea = arch.nextLine();
			String[] partes = linea.split(";");
			System.out.println("\nPartida Cargada\n");
			System.out.println("Bienvenido " + partes[0] + "!");
			partida(s);
		}
		
		else
		{
			System.out.println("\nNo existe Partida Guardada\n");
		}
		
		arch.close();
	}
	
	public static void empezarPartida(Scanner s) throws IOException
	{
		System.out.print("Ingrese apodo de jugador: ");
		apodo = s.nextLine();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("txts/Registros.txt"));
		
		bw.write(apodo);
		bw.newLine();
		bw.close();
		System.out.println("Bienvenido " + apodo + "!!");
		partida(s);
		
		
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
			
			if (!Tipos.contains(type))
			{
				Tipos.add(type);
			}
			
			Pokemon pP = new Pokemon(nP,zone,prob,life,atq,def,atqEsp,defEsp,vel,type);
			
			p.add(pP);
		}
		s1.close();
	}
	
	public static void partida(Scanner s) throws FileNotFoundException
	{
		int option = 0;
		do
		{
			System.out.println("1) Revisar Equipo");
			System.out.println("2) Salir a capturar");
			System.out.println("3) Acceso al PC");
			System.out.println("4) Retar un gimansio");
			System.out.println("5) Desafiar al Alto Mando");
			System.out.println("6) Curar Pokemon");
			System.out.println("7) Guardar");
			System.out.println("8) Guardar y Salir");
			System.out.print(">");
			
			String entry = s.nextLine();
			
			try
			{
				option = Integer.parseInt(entry);
			} 
			catch (NumberFormatException e)
			{
				System.out.println("Ingrese opcion valida");
			}
			
			if (option == 1)
			{
				revisarEquipo();
			}
			
			if (option == 2)
			{
				int op = 0;
				String bFinal = "";
				
				System.out.println("Donde deseas ir a explorar?\n");
				System.out.println("Zonas Disponibles:\n");
				System.out.println("1) Lago");
				System.out.println("2) Cueva");
				System.out.println("3) Montaña");
				System.out.println("4) Bosque");
				System.out.println("5) Prado");
				System.out.println("6) Mar");
				System.out.println("7) Volver al menu");
				System.out.print(">");
					
				String tipoBioma = s.nextLine();
				
				try
				{
					op = Integer.parseInt(tipoBioma);
				} catch (NumberFormatException e)
				{
					System.out.println("Ingrese una opcion valida");
				}
				
				switch (op)
				{
				case 1:
					bFinal = "Lago";
					capturarPokemon(s,bFinal);
					break;
				case 2:
					bFinal = "Cueva";
					capturarPokemon(s,bFinal);
					break;
				case 3:
					bFinal = "Montaña";
					capturarPokemon(s,bFinal);
					break;
				case 4:
					bFinal = "Bosque";
					capturarPokemon(s,bFinal);
					break;
				case 5:
					bFinal = "Prado";
					capturarPokemon(s,bFinal);
					break;
				case 6:
					bFinal = "Mar";
					capturarPokemon(s,bFinal);
					break;
				case 7:
					break;
				}
			}
			
			if (option == 3)
			{
				accesoPC(s);
			}
			
			if (option == 4)
			{
				gimnacio(s);
			}
			
		} while (option != 8);
	}
	
	public static void revisarEquipo()
	{
		if (!pPropio.isEmpty())
		{
			System.out.println("");
			for (int i = 0; i < pPropio.size(); i++)
			{
				System.out.print((i+1) + ") ");
				System.out.println(pPropio.get(i));
			}
			System.out.println("");
		}
		else
		{
			System.out.println("\nNo tienes pokemons en tu equipo\n");
		}
	}
	
	public static void capturarPokemon(Scanner s,String Bioma)
	{
		List<Pokemon> pBioma = new ArrayList<>();
		Random r = new Random();
		double pC = r.nextDouble(0, 1);
		Pokemon encontrado = null;
		double acumulado = 0;
		
		for(Pokemon pok: p)
		{
			if (pok.getHabitat().equals(Bioma))
			{
				pBioma.add(pok);
			}
		}
		
		for(Pokemon pok: pBioma)
		{
			acumulado += pok.getProb();
			if (acumulado >= pC)
			{
				encontrado = pok;
				break;
			}
		}
		int decision = 0;
		System.out.println("\nOh!! Ha aparecido un increible " + encontrado.getNom() + "!!");
		System.out.println("\nQue deseas hacer?\n");
		System.out.println("1) Capturar");
		System.out.println("2) Huir");
		System.out.print(">");
		
		try
		{
			decision = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException e)
		{
			System.out.println("Eliga una opcion valida");
		}
		

		if (decision == 1)
		{
			if (pPropio.size() < 6)
			{
				if (pPropio.contains(encontrado))
				{
					PC.add(encontrado);
					System.out.println("\n" + encontrado.getNom() + " capturado y mandado a la PC!!\n");
				}
				else
				{
					pPropio.add(encontrado);
					System.out.println("\n" + encontrado.getNom() + " capturado con exito!!\n");
				}
			}
			else
			{
				PC.add(encontrado);
				System.out.println("\n" + encontrado.getNom() + " capturado y mandado a la PC!!\n");
			}
		}
		
		else
		{
			System.out.println("\n" + encontrado.getNom() + " ha huido D:\n");
		}
		
	}
	
	public static void accesoPC(Scanner s)
	{
		if (!PC.isEmpty())
		{
			int indice = 1;
			for (Pokemon p: PC)
			{
				System.out.println(indice + ")" + p);
				indice++;
			}
			System.out.println("\nQue desea hacer?");
			
			System.out.println("\n1) Cambiar Pokemon");
			System.out.println("2) Salir");
			System.out.print(">");
			
			int decision = 0;
			
			String ent = s.nextLine();
			
			try
			{
				decision = Integer.parseInt(ent);
			} catch (NumberFormatException e)
			{
				System.out.println("\nError, ingrese un valor correcto\n ");
			}
			
			if(decision == 1)
			{
				int index = 0;
				int index2 = 0;
				
				System.out.println("Que Pokemon sacaras?");
				System.out.print(">");
				String c1 = s.nextLine();
				
				for (int i =0; i < pPropio.size(); i++)
				{
					System.out.println(i+1 + ")" + pPropio.get(i));
				}
				System.out.println("Que Pokemon quieres cambiar?");
				System.out.print(">");
				
				String c2 = s.nextLine();
				
				try 
				{
					index = Integer.parseInt(c1) - 1;
					index2 = Integer.parseInt(c2) - 1;
					
				} catch (NumberFormatException e)
				{
					System.out.println("Error, uno(o ambos) de los valores no es valido");
				}
				
				if (pPropio.contains(PC.get(index)))
				{
					System.out.println("Ya tienes ese pokemon en tu equipo");
				}
				else
				{
					Pokemon aux = pPropio.get(index2);
					pPropio.set(index2, PC.get(index));
					PC.set(index,aux);
					
					System.out.println("Pokemon intercambiado con exito!\n");
				}
			}
		}
		else
		{
			System.out.println("No tienes ningun pokemon en la PC");
		}
	}
	
	public static void cargarGimnacios() throws FileNotFoundException
	{
		File fG = new File("txts/Gimnasios.txt");
		Scanner sG = new Scanner(fG);
		
		while (sG.hasNextLine())
		{
			String linea = sG.nextLine();
			String[] partes = linea.split(";");
			
			int id = Integer.parseInt(partes[0]);
			String lider = partes[1];
			String estado = partes[2];
			
		}
	}
	
	public static void gimnacio(Scanner s) throws FileNotFoundException
	{
		cargarGimnacios();
	}
}
