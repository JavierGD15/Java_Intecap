package Ejemplos_26_5;

import java.util.Scanner;

public class unidimencional {

	public static void main(String[] args) {
		
		//Mostrar en la primera fila Nombre, apellido, telefono, cumpleaños, dpi y luego los datos
		String array [][] = new String [5][5];
		array [0][0] ="Nombre";
		array [0][1] ="Apellido";
		array [0][2] ="Telefono";
		array [0][3] ="Cumpleaños";
		array [0][4] ="DPI";
		
		array [1][0] ="Joel";
		array [1][1] ="Cos";
		array [1][2] ="48751636";
		array [1][3] ="18/01/98";
		array [1][4] ="3014526699778";
		
		array [2][0] ="Junior";
		array [2][1] ="Florian";
		array [2][2] ="48751636";
		array [2][3] ="18/01/90";
		array [2][4] ="3014526699647";
		
		array [3][0] ="Joel";
		array [3][1] ="Cos";
		array [3][2] ="48751636";
		array [3][3] ="18/01/98";
		array [3][4] ="3014526699778";
		
		array [4][0] ="Junior";
		array [4][1] ="Florian";
		array [4][2] ="48751636";
		array [4][3] ="18/01/90";
		array [4][4] ="3014526699647";
		
		for (int i = 0; i < array.length; i++) {
			
			for (int j = 0; j < array[i].length; j++) {
				
				System.out.print("|"+array[i][j]+"|");
				
			}
			System.out.println("");
			
		}
		

	}

}
