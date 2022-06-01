package clase_poo_31_05;

public class carnivoro extends animal {

	public void alimentarse() {
		System.out.println("Se alimenta de carne");
	}
	
	
	
public static void main(String[] args) {
	
	carnivoro car = new carnivoro();
	car.alimentarse();
}
}

