package Proyecto_1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

import com.itextpdf.text.DocumentException;

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
		JButton cerrar = new JButton("Cerrar Sesion");
		cerrar.setBackground(Color.red);
		cerrar.setForeground(Color.white);
		cerrar.setBounds(700, 630, 150, 20);	
		
		// Funcion cerrar
		ActionListener funcion_cerrar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inicio log = new inicio ();				
				log.ejecutar();
				principal.setVisible(false);
			}
		};

		// Acción del evento
		cerrar.addActionListener(funcion_cerrar);
		
		principal.add(cerrar);
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

	
	
	
	

}
