package clase_poo_31_05;

public class Objeto {
	//atributos
	protected String marca;
	protected String color;
	protected int matricula;
	
	
	//metodos
	public void devolver_marca() {
		System.out.println(marca);
	}
	
	public String encender() {
		return "El carro se enciende";
	}
	
	
	//constructor
	public Objeto(String marca, String color, int matricula) {
		this.marca = marca;
		this.color = color;
		this.matricula = matricula;
		
	}


	//ejecutador
	public static void main(String[] args) {
		
		Objeto rayo = new Objeto("Toyota","Rojo",88888);
		System.out.println(rayo.encender());
		rayo.devolver_marca();
		Objeto carro = new Objeto("Honda","verde",999999);
		carro.devolver_marca();
		
	}
	

}
