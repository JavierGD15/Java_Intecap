package Práctica;

import java.util.Scanner;

public class juego {

	public static void main(String[] args) {

		Scanner opcion = new Scanner(System.in);

		System.out.println("=====MENU PRINCIPAL=====");
		System.out.println("1. Iniciar Juego");
		System.out.println("2. Retomar Juego");
		System.out.println("3. Generar Reportes");
		System.out.println("4. Salir");

		int resultado = opcion.nextInt();
		int numeros =64;
		boolean par = true;

		switch (resultado) {
		case 1:
			
			String bordes [][] = new String [8][8];
			
			System.out.println("-----------------------------------------");
			//for con i
			for (int i = 0; i < bordes.length; i++) {
				//comparacion si es true va al reves y si es false va normal
				if(par == true) {
					for (int j = (bordes[i].length)-1; j >-1 ; j--) {
						
						if(j ==7) {
							bordes [i][j] = "|  "+numeros+"|";
						}
						else {
						bordes [i][j] = "  "+numeros+"|";}
						numeros--;
					}
						
					par = false;
					
				}
				else {
					for (int j = 0; j < bordes[i].length; j++) {
						if(j ==0) {
							bordes [i][j] = "|  "+numeros+"|";
						}
						else {
						bordes [i][j] = "  "+numeros+"|";
						}
						numeros--;
					}
					par = true;
				}

				
			}
			
			//impresion
			for (int i = 0; i < bordes.length; i++) {
				for (int j = 0; j < bordes[i].length; j++) {
					System.out.print(bordes[i][j]);
				}
				System.out.println("");
				System.out.println("--------------------");
			}

			break;
		case 2:
			System.out.println("Retomar juego");

			break;
		case 3:
			System.out.print("Se genero el reporte");
			break;
		case 4:
			System.exit(0);
			break;

		default:
			break;
		}
	}

}
