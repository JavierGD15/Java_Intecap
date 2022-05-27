package Ejercicios_25_05;

import java.util.Scanner;

public class ejemp5 {

	public static void main(String[] args) {
		
		double radio = 0;
		final double PI = 3.14;
		
		Scanner resultado = new Scanner(System.in);
		System.out.println("Ingrese su radio");
		radio = resultado.nextInt();		
		System.out.println("Su longitud es: "+ (2*PI*radio));
		System.out.println("Su area es: "+ (PI*(radio*radio)));
	}

}
