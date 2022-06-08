package Proyecto_1;

import java.awt.Color;

import javax.swing.*;

public class Menu_Principal {
	
	JFrame principal = new JFrame();
	JTabbedPane pestañas = new JTabbedPane();

	//Paneles para las pestañas
	JPanel sucursales = new JPanel();
	JPanel clientes = new JPanel();
	JPanel vendedores = new JPanel();
	JPanel productos = new JPanel();
	
	Sucursales_Menu sm = new Sucursales_Menu();
	
	private void valores_iniciales() throws ClassNotFoundException {
		
		//Frame datos
		principal.setTitle("Modulo Administrador");
		principal.setLocationRelativeTo(null);
		principal.setBounds(500, 150, 900, 700);
		principal.setVisible(true);
		principal.add(pestañas);
		
		//colores de los paneles
		sucursales.setBackground(Color.cyan);
		clientes.setBackground(Color.cyan);
		vendedores.setBackground(Color.cyan);
		productos.setBackground(Color.cyan);
		
		sucursales.setLayout(null);
		clientes.setLayout(null);
		vendedores.setLayout(null);
		productos.setLayout(null);
		
		
		
		
		
		//agregamos los paneles
		pestañas.addTab("Sucursales",sucursales);
		pestañas.addTab("Clientes",clientes);
		pestañas.addTab("Vendedores",vendedores);
		pestañas.addTab("Productos",productos);
		
		
		sm.ejecutar();
		sucursales.add(sm.crear);
		sucursales.add(sm.carga);
		sucursales.add(sm.actualizar);
		sucursales.add(sm.eliminar);
		sucursales.add(sm.pdf);
		
		sucursales.add(sm.sp);
		
		
	}
	
	public void ejecutar() throws ClassNotFoundException {
		valores_iniciales();
	
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		Menu_Principal menu = new Menu_Principal();
		menu.valores_iniciales();		
	}
	
	
	
	

}
