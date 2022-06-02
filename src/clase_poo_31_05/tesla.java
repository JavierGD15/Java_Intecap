package clase_poo_31_05;

public class tesla extends Objeto{
	int motores;
	int puertas;
	
	//constructor
	public tesla(String marca, String color, int matricula, int motores, int puertas) {
		super(marca, color, matricula);
		this.motores = motores;
		this.puertas = puertas;
	}
	
	//metodo
	public void imprimir_datos() {
		System.out.println("Marca: "+ marca);
		System.out.println("Color: " + color);
		System.out.println("Matricula: "+ matricula);
		System.out.println("Motores: " + motores);
		System.out.println("Puertas: "+ puertas);
	}
	
	
	public static void main(String[] args) {
		tesla carro1 = new tesla("Model S", "azul", 74123, 3, 2);
		carro1.encender();
		carro1.imprimir_datos();


	}
	
	
	
	
	
	
	

}
