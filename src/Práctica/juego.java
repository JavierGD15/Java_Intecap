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
            
            for (int i = 0; i < castigo2; i++) {
            	int irandom = (int) (Math.random()* 8 + 0);
				int jrandom = (int) (Math.random()* (5-3+1)+3);
				tablero[irandom][jrandom] = "#";
			}
            
            for (int i = 0; i < castigo3; i++) {
				int irandom = (int) (Math.random()* 8 + 0);
				int jrandom = (int) (Math.random()* (2-0+1)+0);
				tablero[irandom][jrandom] = "#";
			}
            
            tablero[7][7] = "@";
            int posicion = 0;
            
            while (posicion<65) {
            	System.out.println("Que desea hacer ? 1 para lanzar dado, 2 para pausar");
            	
            	int pausa = opcion.nextInt();
            	switch (pausa) {
				case 1: 
					
					int dado = (int) (Math.random()* (6-1+1)+1);
					System.out.println("El dado mostro " + dado);
					posicion+=dado;
					
					//Eliminar arrobas
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero[i].length; j++) {
							if(tablero[i][j].equals("@")) {
								tablero[i][j] = "";
								
							}
						}
					}
					
                    if (posicion >= 57) {
                    	
                        tablero[0][7 - (posicion - 57)] = "@";
                    } else if (posicion >= 49) {
                    	tablero[1][7 - (posicion - 49)] = "@";
                    } else if (posicion >= 41) {
                    	tablero[2][7 - (posicion - 41)] = "@";
                    } else if (posicion >= 33) {
                    	tablero[3][7 - (posicion - 33)] = "@";
                    } else if (posicion == 25) {
                    	tablero[4][7] = "@";
                    } else if (posicion == 24) {
                    	tablero[4][7] = "@";
                    } else if (posicion > 25) {
                    	tablero[4][7 - (posicion - 25)] = "@";
                    } else if (posicion >= 16) {
                    	tablero[5][7 - (posicion - 16)] = "@";
                    } else if (posicion >= 8) {
                    	
                    	if(tablero[6][7 - (posicion - 8)].equals("#"))
                    	{
                    		System.out.println("Ustd ha caido en una trampa");
                    		tablero[6][7 - (posicion - 8)] = "@";
                    	}
                    	else {
                    		tablero[6][7 - (posicion - 8)] = "@";
                    	}
                    } else {
                    	if(tablero[7][7 - posicion].equals("#"))
                    	{
                    		System.out.println("Ustd ha caido en una trampa");
                    		tablero[7][7 - posicion] = "@";
                    	}
                    	else {
                    	tablero[7][7 - posicion] = "@";
                    	}
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
					
					System.out.println("=====MENU PRINCIPAL=====");
					System.out.println("1. Iniciar Juego");
					System.out.println("2. Retomar Juego");
					System.out.println("3. Salir");

					int fin = opcion.nextInt();
					
					if(fin == 2) {
						continue;
					}
					else if(fin == 1) {
						posicion = 80;
					}
					else if(fin == 3) {
						System.exit(0);
						break;
					}
				
					
				}
            	
            	
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
