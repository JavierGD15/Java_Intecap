package clase_poo_31_05;

public class clientes extends humano {
	
	int nit;
	String idCliente;
	String direccion;
	public clientes(String nombre, int edad, String genero, int dpi, int nit,  String direccion) {
		super(nombre, edad, genero, dpi);
		this.nit = nit;
		this.direccion = direccion;
		this.idCliente = nombre+nit;
	}
	
	//metodo de impresion
	public void impresion() {
		System.out.println("nombre: "+nombre);
		System.out.println("edad: "+edad);
		System.out.println("dpi: "+dpi);
		System.out.println("nit: "+nit);
		System.out.println("idCliente: "+ idCliente);
		System.out.println("direccion: "+direccion);
		
	}
	public static void main(String[] args) {
		clientes c1 = new clientes("Jamieson", 24, "M", 346555, 145287,"villa nueva");
		c1.impresion();
	}
	
	
	
	

	

}
