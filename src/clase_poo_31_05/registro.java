package clase_poo_31_05;

public class registro {

	public static void main(String[] args) {
		Object personas [][]= new Object [4][4];
		for (int i = 0; i < personas.length; i++) {
				persona p1 = new persona();
				p1.setNombre("Cristopher");
				p1.setEdad(20);
				p1.setDpi(3048806);
				p1.setGenero("Masculino");
				
				
				personas[i][0] = p1.getNombre();
				personas[i][1] = p1.getEdad();
				personas[i][2] = p1.getGenero();
				personas[i][3] = p1.getDpi();
				
		}
		
		for (int i = 0; i < personas.length; i++) {
			for (int j = 0; j < personas[i].length; j++) {
				
				System.out.print(personas[i][j]+" | ");
			}
			System.out.println("");
		}

		
	}

}
