package Práctica;

import java.util.Random;

public class ayuda {

	public static void main(String[] args) {
		
		
        
        
        for (int i = 0; i < 20; i++) {
        	int xrandom = (int) (Math.random()* 8 + 0);
        	int yrandom = (int) (Math.random()* 2 + 6);
        	System.out.println("Coordenada generada : "+xrandom+" , "+ yrandom);
		}
	}

}
