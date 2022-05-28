package Ejemplos_clase;

import java.util.Scanner;

public class If_else {
	public static void main(String[] args) {
		int x = 2, y = 3;
		
		//If normal
		if (x<y) {
			//ejecutamos si cumple
			System.out.println("es mejor a y");
		}
		
		
		//if-else
		if (x<y) {
			System.out.println("es mejor a y");
		} else {
			System.out.println("y es mayor");
		}
		
		//if anidado
		if (x<y) {
			
			if (x<0) {
				System.out.println("es mejor a y, menor a 0");
			}else {
				System.out.println("es mejor a y");
			}
			
		}else {
			System.out.println("y es mayor");
		}
		
		//else-if
		
		//primera comparacion
		if (x<y) {
			//hacemos x cosa
		}
		//segunda comparacion
		else if(x == y) {
			//hacemos y cosa
		}
		// si no cumple ejecutamos ...
		else {
			//y es mayor.
			
		}
		
		
		
		//Switch
		int menu = 0;
		Scanner men = new Scanner(System.in);
		System.out.println("Ingrese que desea realizar");
		System.out.println("1 es Suma");
		System.out.println("2 es resta");
		System.out.println("3 es Multiplicación");
		System.out.println("4 es división");
		menu = men.nextInt();
		int num1;
		int num2;
		
		Scanner resultado = new Scanner(System.in);
		
		switch (menu) {
		case 1: 
			//suma
			System.out.println("Ingrese sus dos numeros");
			num1 = resultado.nextInt();
			num2 = resultado.nextInt();	
			
			System.out.println("El resultado es: "+(num1+num2));
			break;
		
		case 2:
			//resta
			System.out.println("Ingrese sus dos numeros");
			num1 = resultado.nextInt();
			num2 = resultado.nextInt();	
			
			System.out.println("El resultado es: "+(num1-num2));
			break;
			
		case 3:
			//multiplicación
			System.out.println("Ingrese sus dos numeros");
			num1 = resultado.nextInt();
			num2 = resultado.nextInt();	
			
			System.out.println("El resultado es: "+(num1*num2));
			break;
		
		case 4:
			//division
			System.out.println("Ingrese sus dos numeros");
			num1 = resultado.nextInt();
			num2 = resultado.nextInt();	
			
			System.out.println("El resultado es: "+(num1/num2));
			break;
		
		default:
			System.out.println("por favor ingresa un valor correcto");
			break;
		}
		
		
		
		//Ternario
		
		//si se cumple sera el primero y si no se cumple sera el segundo
		
		int rep1 = 2;
		int rep2 =3;
		
		boolean result = (rep1<rep2)?true:(rep1==rep2)?true:false;

		
	}

}
