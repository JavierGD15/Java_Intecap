package Proyecto_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Sucursales_Menu {

	//botones
	JButton crear = new JButton();
	JButton carga = new JButton();
	JButton actualizar = new JButton();
	JButton eliminar = new JButton();
	JButton pdf = new JButton();
	int suma = 0;
	
	//Matriz
	Object [][] sucursales = new Object [50][5];
	Object[] objetos = new Object[50];
	
	//tabla y complemento
	JTable tabla;
	JScrollPane sp;
	
	private void botones () {
		crear.setText("Crear");
		crear.setBounds(550,100,130,70);
		
		//Funcion crear
		ActionListener funcion_crear = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			crear();

			}
		};

		// Acción del evento
		crear.addActionListener(funcion_crear);
		
		carga.setText("Carga Masiva");
		carga.setBounds(730,100,130,70);
		
		actualizar.setText("Actualizar");
		actualizar.setBounds(550,260,130,70);
		
		eliminar.setText("Eliminar");
		eliminar.setBounds(730,260,130,70);
		
		pdf.setText("Exportar pdf");
		pdf.setBounds(550,420,310,70);

	}
	
	private void tabla() {
		String [] datos = {"Codigo","Nombre", "Direccion","Correo","Telefono"};
		
		
		
		tabla = new JTable(sucursales,datos);
		sp = new JScrollPane(tabla);
		sp.setBounds(10,10,500,600);
		
		
	}
	
	private void crear() {
		
		JFrame crear = new JFrame();
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		
		//etiquetas
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		JLabel l3 = new JLabel();
		JLabel l4 = new JLabel();
		JLabel l5 = new JLabel();
		
		//cajas de texto
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField();
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();
		
		//Boton
		JButton b1 = new JButton();
		
		l1.setText("Codigo:");
		l1.setFont(new Font("Serig", Font.PLAIN, 25));
		l1.setBounds(50, 80, 100, 80);
		l1.setVisible(true);
		p1.add(l1);

		
		l2.setText("Nombre:");
		l2.setFont(new Font("Serig", Font.PLAIN, 25));
		l2.setBounds(50, 180, 180, 80);
		l2.setVisible(true);
		p1.add(l2);
		
		
		l3.setText("Direccion:");
		l3.setFont(new Font("Serig", Font.PLAIN, 25));
		l3.setBounds(50, 280, 180, 80);
		l3.setVisible(true);
		p1.add(l3);
		
		l4.setText("Correo:");
		l4.setFont(new Font("Serig", Font.PLAIN, 25));
		l4.setBounds(50, 380, 100, 80);
		l4.setVisible(true);
		p1.add(l4);
		
		l5.setText("Telefono:");
		l5.setFont(new Font("Serig", Font.PLAIN, 25));
		l5.setBounds(50, 480, 150, 80);
		l5.setVisible(true);
		p1.add(l5);
		
		crear.setTitle("Crear");
		crear.setLocationRelativeTo(null);
		crear.setBounds(500, 150, 600, 700);
		crear.setVisible(true);
		p1.setBackground(Color.cyan);
		crear.add(p1);
		
		// jtextfield
		t1.setBounds(250, 100, 200, 40);
		t2.setBounds(250, 200, 200, 40);
		t3.setBounds(250, 300, 200, 40);
		t4.setBounds(250, 400, 200, 40);
		t5.setBounds(250, 500, 200, 40);
		
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		
		
		//boton
		b1.setText("Guardar");
		b1.setBounds(200, 570, 150, 60);
		p1.add(b1);

		// Funcionalidad
		ActionListener ingresar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				sucursal s = new sucursal(Integer.parseInt(t1.getText()),t2.getText(),t3.getText(),t4.getText(),Integer.parseInt(t5.getText()));
				objetos[suma]=s;
				System.out.println(objetos[0]);

			}
		};

		// Acción del evento
		b1.addActionListener(ingresar);
		
	}
	
	
	public void ejecutar() {
		botones();
		tabla();
		
	}
}
