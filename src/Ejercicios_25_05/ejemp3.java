package Ejercicios_25_05;

import java.util.Scanner;

public class ejemp3 {

	public static void main(String[] args) {
		int num1;
		Scanner resultado = new Scanner(System.in);
		
		System.out.println("Ingrese su número");
		
		num1 = resultado.nextInt();
		System.out.println("Su doble es: "+ (num1*num1));
		System.out.println("Su triple es: "+ ((num1*num1)*num1));
		

	}

}
