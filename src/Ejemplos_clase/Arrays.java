package Ejemplos_clase;

public class Arrays {

	public static void main(String[] args) {
		
		//tipo de dato nombre [] = new tipo de dato cuantas casillas deseamos
		String bin [] = new String [12];
		
		for (int i = 0; i < bin.length; i++) {
			bin[i] = "Alex";
		}
		bin[10] = "Junior";
		bin[11] = "Sergio";
		
		for (int i = 0; i < bin.length; i++) {
			System.out.println(bin[i]);
		}
		
		

	}

}
