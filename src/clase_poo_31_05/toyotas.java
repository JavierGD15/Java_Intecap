package clase_poo_31_05;

//extendemos de el padre
public class toyotas extends Objeto{
	
	//atributos
	int año;
	int ventas_al_año;
	
	
	//contructor
	public toyotas(String marca, String color, int matricula, int año, int ventas_al_año) {
		super(marca, color, matricula);
		this.año = año;
		this.ventas_al_año = ventas_al_año;
	}

	public void mostrar_auto() {
		System.out.println("Marca: "+ marca);
		System.out.println("Color: " + color);
		System.out.println("Matricula: "+ matricula);
		System.out.println("año: " + año);
		System.out.println("ventas realizadas: "+ ventas_al_año);
	}
	


	public static void main(String[] args) {
		toyotas carro1 = new toyotas("Echo","azul pavo",44444,2003,8888);
		carro1.mostrar_auto();
	}
}
