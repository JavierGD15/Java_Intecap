package Proyecto_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class cobros {
	JPanel filtro = new JPanel();
	JPanel ventas = new JPanel();
	String [] resultados = new String[100]; 
	JComboBox combo_filtro = new JComboBox(resultados);
	Object [][] clientes = new Object [100][5];
	
	//cajas filtro
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
	
	private void crear() {
		filtro.setLayout(null);
		ventas.setLayout(null);
		filtro.setBackground(Color.white);
		ventas.setBackground(Color.white);
		filtro.setBounds(20, 30,830, 250);
		ventas.setBounds(20, 300, 830, 280);
	}
	
	private void botones() throws ClassNotFoundException {
		
		// cargar archivo
		try {

			ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("tabla_clientes.dat"));

			clientes = (Object[][]) recuperar.readObject();
			recuperar.close();

		}

		catch (IOException e) {
		}
		
		//Etiquetas
        JLabel filtros = new JLabel("Filtrar por: ");
        filtros.setLocation(50, 30);
        filtros.setSize(100, 15);
        filtros.setFont(new Font("Serig", Font.PLAIN, 15));
        //Subrayado
        Font font = filtros.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        filtros.setFont(font.deriveFont(attributes));
        
        filtro.add(filtros);
        
        JLabel nombre = new JLabel("Nombre: ");
        nombre.setBounds(180, 30, 100, 15);
        filtro.add(nombre);
		
        JLabel correo = new JLabel("Correo: ");
        correo.setBounds(180, 90, 100, 15);
        filtro.add(correo);
        
        JLabel nit = new JLabel("NIT: ");
        nit.setBounds(525, 30, 100, 15);
        filtro.add(nit);
		
        JLabel genero = new JLabel("Genero: ");
        genero.setBounds(525, 90, 100, 15);
        filtro.add(genero);
        
        

        t1.setBounds(250, 25, 200, 25);
        filtro.add(t1);
        
        
        t2.setBounds(250, 85, 200, 25);
        filtro.add(t2);
        
        
        t3.setBounds(580, 25, 200, 25);
        filtro.add(t3);
        
        
        t4.setBounds(580, 85, 200, 25);
        filtro.add(t4);
        
        
        
        JButton b_filtro = new JButton("Aplicar Filtro");
        b_filtro.setBounds(180, 150, 600, 30);
        filtro.add(b_filtro);
        
		// Funcion crear
		ActionListener funcion_filtro = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					aplicar_filtro();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};

		// Acción del evento
		b_filtro.addActionListener(funcion_filtro);
        
        
        
       
        JLabel l2 = new JLabel("Filtrados: ");
        l2.setLocation(50, 200);
        l2.setSize(100, 15);
        l2.setFont(new Font("Serig", Font.PLAIN, 15));
        //Subrayado
        Font font1 = l2.getFont();
        Map<TextAttribute, Object> attributes1 = new HashMap<>(font1.getAttributes());
        attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        l2.setFont(font.deriveFont(attributes1));
        filtro.add(l2);
        
        JLabel cliente = new JLabel("Cliente");
        cliente.setBounds(180, 200, 100, 15);
        
        filtro.add(cliente);
        
        
        combo_filtro.setBounds(250, 200, 250, 20);
        
        filtro.add(combo_filtro);
        
        JButton nuevo = new JButton("Nuevo Cliente");
        nuevo.setBounds(600, 200, 150, 20);
        filtro.add(nuevo);
        
		// Funcion crear
		ActionListener funcion_crear = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					crear_cliente();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};

		// Acción del evento
		nuevo.addActionListener(funcion_crear);
        
        
	}
	

	private void crear_cliente() throws ClassNotFoundException {
		
		// cargar archivo
		try {

			ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("tabla_clientes.dat"));

			clientes = (Object[][]) recuperar.readObject();
			recuperar.close();

		}

		catch (IOException e) {
		}

		JFrame crear = new JFrame();
		JPanel p1 = new JPanel();
		p1.setLayout(null);

		// etiquetas
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		JLabel l3 = new JLabel();
		JLabel l4 = new JLabel();
		JLabel l5 = new JLabel();

		// cajas de texto
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField();
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();

		// Boton
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

		l3.setText("NIT:");
		l3.setFont(new Font("Serig", Font.PLAIN, 25));
		l3.setBounds(50, 280, 180, 80);
		l3.setVisible(true);
		p1.add(l3);

		l4.setText("Correo:");
		l4.setFont(new Font("Serig", Font.PLAIN, 25));
		l4.setBounds(50, 380, 100, 80);
		l4.setVisible(true);
		p1.add(l4);

		l5.setText("Genero:");
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

		// boton
		b1.setText("Guardar");
		b1.setBounds(200, 570, 150, 60);
		p1.add(b1);

		// Funcionalidad
		ActionListener ingresar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				clientes c = new clientes(Integer.parseInt(t1.getText()),t2.getText(),Integer.parseInt(t3.getText()),t4.getText(),t5.getText());

				for (int i = 0; i < clientes.length; i++) {
					if (clientes[i][0] == null) {

						clientes[i][0] = c.codigo;
						clientes[i][1] = c.nombre;
						clientes[i][2] = c.nit;
						clientes[i][3] = c.correo;
						clientes[i][4] = c.genero;

						// guardar
						try {
							ObjectOutputStream carga = new ObjectOutputStream(
									new FileOutputStream("tabla_clientes.dat"));
							carga.writeObject(clientes);
							carga.close();
						} catch (IOException j) {

						}

						crear.setVisible(false);

						break;

					}
				}

			}
		};

		// Acción del evento
		b1.addActionListener(ingresar);

	}

	private void aplicar_filtro() throws ClassNotFoundException {
		
		int x =0;
		
		if(t1.getText().isEmpty() != false) {
			if (t2.getText().isEmpty() != false) {
				if (t3.getText().isEmpty() != false) {
					if (t4.getText().isEmpty() != false) {
						JOptionPane.showMessageDialog(null, "Por favor llena un filtro");
						
					}else {
						//aplicamos filtro de Genero
						x = 4;
					}
				}else {
					//aplicamos filtro de NIT
					x =3;
				}
			}else {
				//aplicamos filtro de correo
				x =2;
			}
			
		}else {
			//aplicamos filtro de nombre
			x = 1;
		}
		
		switch (x) {
		case 1:
			filtro_nombre(t1.getText());
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;			
		default:
			break;
		}
	}
	
	private void filtro_nombre(String nombre) throws ClassNotFoundException {
		
		// cargar archivo
		try {

			ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("tabla_clientes.dat"));

			clientes = (Object[][]) recuperar.readObject();
			recuperar.close();

		}

		catch (IOException e) {
		}
		
		for (int i = 0; i < clientes.length; i++) {
			if(nombre == clientes[i][1]) {
				//aplica filtro
				System.out.println("aplica filtro");
			}else {
				
			}
		}
		
	}
	
	public void ejecutar() throws ClassNotFoundException {
		crear();
		botones();
	}
	

}
