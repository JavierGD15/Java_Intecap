package Ejercicios_25_05;

import java.util.Scanner;

public class ejem1 {

	public static void main(String[] args) {
		int num1;
		int num2;
		// 		nombre								
		Scanner resultado = new Scanner(System.in);
		
		System.out.println("Ingrese sus números");
		
		num1 = resultado.nextInt();
		num2 = resultado.nextInt();		
		
		System.out.println("los números ingresados son: "+num1+" y "+num2);

	}

}
