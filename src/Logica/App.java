/// Jorge Saavedra Sanchez 
/// Rut: 22.347.590-6 
/// Ingenieria en Tecnologias de Informacion

package Logica;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
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
				System.out.println("Ingrese una opcion valida");
			}
			
		} while (opcion != 3);
		
		s.close();
	}
}
