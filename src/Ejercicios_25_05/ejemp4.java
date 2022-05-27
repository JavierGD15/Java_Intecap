package Ejercicios_25_05;

import java.util.Scanner;

public class ejemp4 {

	public static void main(String[] args) {
		
		double grado = 0;
		
		Scanner resultado = new Scanner(System.in);
		System.out.println("Ingrese su temperatura");
		grado = resultado.nextInt();
		
		double result = 32+(9*(grado/5));
		
		System.out.println("El resultado es: "+ result);
		
		
		

	}

}
