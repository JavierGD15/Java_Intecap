package Práctica;

import java.util.Random;
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
			String tablero[][] = new String [8][8];
			
			
			//for para tablero
			for (int i = 0; i < bordes.length; i++) {
				//comparacion si es true va al reves y si es false va normal
				if(par == true) {
					
						for (int j = (bordes[i].length)-1; j >-1 ; j--) {
							
							if(numeros<10) {
								if(j ==0) {
									bordes [i][j] = "|   "+numeros+"|";
								}
								else {
								bordes [i][j] = "   "+numeros+"|";
								}
								numeros--;
							}else {
								if(j ==0) {
									bordes [i][j] = "|  "+numeros+"|";
								}
								else {
								bordes [i][j] = "  "+numeros+"|";
								}
								numeros--;
								
							}
						}
					
						
					par = false;
					
				}
				else {
					if(numeros<10) {
						for (int j = 0; j < bordes[i].length; j++) {
							if(j ==0) {
								bordes [i][j] = "|   "+numeros+"|";
							}
							else {
							bordes [i][j] = "   "+numeros+"|";
							}
							numeros--;
						}
						
					}else {
						for (int j = 0; j < bordes[i].length; j++) {
							if(j ==0) {
								bordes [i][j] = "|  "+numeros+"|";
							}
							else {
							bordes [i][j] = "  "+numeros+"|";
							}
							numeros--;
						}
					}
					par = true;
				}

				
			}
			
			//Quitar nulls usuarios
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++) {
					tablero[i][j] = "";
					
				}
			}
			
			int castigo1 = (int) (Math.random()* 3 + 2);
            int castigo2 = (int) (Math.random()* 3 + 2);
            int castigo3 = (int) (Math.random()* 3 + 2);
            
            for (int i = 0; i < castigo1; i++) {
				int irandom = (int) (Math.random()* 8 + 0);
				int jrandom = (int) (Math.random()* 2 + 6);
				tablero[irandom][jrandom] = "#";
			}
            
            for (int i = 0; i < castigo1; i++) {
            	int irandom = (int) (Math.random()* 8 + 0);
				int jrandom = (int) (Math.random()* (5-3+1)+3);
				tablero[irandom][jrandom] = "#";
			}
            
            for (int i = 0; i < castigo1; i++) {
				int irandom = (int) (Math.random()* 8 + 0);
				int jrandom = (int) (Math.random()* (2-0+1)+0);
				tablero[irandom][jrandom] = "#";
			}
            
            
			
			//impresion
            System.out.println("-----------------------------------------");
			for (int i = 0; i < bordes.length; i++) {
				for (int j = 0; j < bordes[i].length; j++) {
					System.out.print(bordes[i][j]);	
				}
				System.out.println("");
				
				for (int j = 0; j < tablero[i].length; j++) {
					if(j ==0) {
						if (tablero[i][j]=="") {
							System.out.print("|    "+tablero[i][j]+"|");
						}
						else {
						System.out.print("|   "+tablero[i][j]+"|");	}
						
					}
					else {
						if (tablero[i][j]=="") {
							System.out.print("    "+tablero[i][j]+"|");	
						}
						else {System.out.print("   "+tablero[i][j]+"|");	}
						}
				}
				System.out.println("");
				System.out.println("-----------------------------------------");
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
