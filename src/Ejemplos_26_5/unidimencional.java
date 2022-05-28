package Ejemplos_26_5;

import java.util.Scanner;

public class unidimencional {

	public static void main(String[] args) {
		
		
		int array [][] = new int [8][8];
		int x = 64;
		
		for (int i = 0; i < array.length; i++) {
			
			for (int j = 0; j < array[i].length; j++) {
				
				array[i][j] = x;
				x--;
				
				System.out.print(array[i][j]);
				
			}
			System.out.println("");
			
		}
		

	}

}
