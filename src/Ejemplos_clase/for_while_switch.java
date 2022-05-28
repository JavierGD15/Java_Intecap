package Ejemplos_clase;

public class for_while_switch {
	public static void main(String[] args) {
		int x = 0;
		//mientras se cumpla se ejecuta
		
		
		//while (x<11) {
			//System.out.println(x);
			
		//}
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			if (i==4) {
				break;
			}
			else if(i==3) {
				System.out.println("se encontro el 3");
				continue;
			}
		}
			
		
		
		//do {
			//System.out.println(x);
			//x++;
		//} while (x<11);	
		
	}

}
