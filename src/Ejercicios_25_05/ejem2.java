package Ejercicios_25_05;

import java.util.Scanner;

public class ejem2 {

	public static void main(String[] args) {
		String nombre;
		
		System.out.println("Ingresa tu nombre: ");
		
		Scanner nom = new Scanner(System.in);
		
		nombre = nom.nextLine();
		
		System.out.println("Buenos dias "+nombre);

	}

}
