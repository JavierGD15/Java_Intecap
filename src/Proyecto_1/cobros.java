package Proyecto_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.*;

import com.itextpdf.text.DocumentException;

public class cobros {
	JPanel filtro = new JPanel();
	JPanel ventas = new JPanel();
	String [] resultados = new String[100]; 
	JComboBox combo_filtro = new JComboBox(resultados);
	Object [][] clientes;
	
	//tabla
	JTable tabla_compras;
	JScrollPane sp;
	
	//cajas filtro
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    
    //tabla
    Object [][] agregar_productos = new Object [10][5];
    int aumento = 0;
	
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
		clientes_funciones sf = new clientes_funciones();
		clientes = sf.listar();
		
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
			correo_filtro(t2.getText());
			break;
		case 3:
			nit_filtro(Integer.parseInt(t3.getText()));
			break;
		case 4:
			genero_filtro(t4.getText());
			break;			
		default:
			break;
		}
	}
	
	private void filtro_nombre(String nombre) throws ClassNotFoundException {
		vaciar();
		

		boolean respuesta = false;
		int contador =0;
		for (int i = 0; i < clientes.length; i++) {
			if(nombre.equals(clientes[i][1])) {
				//aplica filtro
				resultados[contador] = nombre;
				contador++;				
				respuesta = true;
			}
		}
		
		if(respuesta == true) {
			combo_filtro.setVisible(false);
			combo_filtro = new JComboBox(resultados);
			combo_filtro.setBounds(250, 200, 250, 20);
	        filtro.add(combo_filtro);
		}else {
				if (t2.getText().isEmpty() != false) {
					if (t3.getText().isEmpty() != false) {
						if (t4.getText().isEmpty() != false) {
							JOptionPane.showMessageDialog(null, "Por favor llena un filtro");
							
						}else {
							//aplicamos filtro de Genero
							genero_filtro(t4.getText());
						}
					}else {
						//aplicamos filtro de NIT
						nit_filtro(Integer.parseInt(t3.getText()));
					}
				}else {
					//aplicamos filtro de correo
					correo_filtro(t2.getText());
				}
				
			}
			
		}
	
	private void correo_filtro(String correo) throws ClassNotFoundException {
		vaciar();
		

		boolean respuesta = false;
		int contador =0;
		for (int i = 0; i < clientes.length; i++) {
			if(correo.equals(clientes[i][3])) {
				//aplica filtro
				resultados[contador] = clientes[i][1]+"";
				contador++;				
				respuesta = true;
			}
		}
		
		if(respuesta == true) {
			combo_filtro.setVisible(false);
			combo_filtro = new JComboBox(resultados);
			combo_filtro.setBounds(250, 200, 250, 20);
	        filtro.add(combo_filtro);
		}else {
				
					if (t3.getText().isEmpty() != false) {
						if (t4.getText().isEmpty() != false) {
							JOptionPane.showMessageDialog(null, "Por favor llena un filtro");
							
						}else {
							//aplicamos filtro de Genero
							genero_filtro(t4.getText());
						}
					}else {
						//aplicamos filtro de NIT
						nit_filtro(Integer.parseInt(t3.getText()));
					}
				
			}
	}
	
	private void nit_filtro(int nit) throws ClassNotFoundException {
		vaciar();
		
		

				boolean respuesta = false;
				int contador =0;
				for (int i = 0; i < clientes.length; i++) {
					
					if((nit+"").equals(clientes[i][2]+"")) {
						//aplica filtro
						resultados[contador] = clientes[i][1]+"";
						contador++;				
						respuesta = true;
					}
				}
				
				if(respuesta == true) {
					combo_filtro.setVisible(false);
					combo_filtro = new JComboBox(resultados);
					combo_filtro.setBounds(250, 200, 250, 20);
			        filtro.add(combo_filtro);
				}else {
						if (t4.getText().isEmpty() != false) {
							JOptionPane.showMessageDialog(null, "Datos no encontrados");
									
						}else {
							//aplicamos filtro de Genero
							genero_filtro(t4.getText());
						}
					}
		
	}
	
	private void genero_filtro(String genero) throws ClassNotFoundException {
		vaciar();
		
				boolean respuesta = false;
				int contador =0;
				for (int i = 0; i < clientes.length; i++) {
					if(genero.equals(clientes[i][4])) {
						//aplica filtro
						resultados[contador] = clientes[i][1]+"";
						contador++;				
						respuesta = true;
					}
				}
				
				if(respuesta == true) {
					combo_filtro.setVisible(false);
					combo_filtro = new JComboBox(resultados);
					combo_filtro.setBounds(250, 200, 250, 20);
			        filtro.add(combo_filtro);
				}else {
					JOptionPane.showMessageDialog(null, "Datos no encontrados");
				}
	}
	
	
	private void modulo_ventas() {
		
		JLabel l1_fecha = new JLabel("Fecha");
		l1_fecha.setBounds(400, 5, 50, 30);
		ventas.add(l1_fecha);
		
		JLabel l1_ayuda = new JLabel();
		l1_ayuda.setBounds(480, 5, 100, 30);
		ventas.add(l1_ayuda);
		
		JLabel l2_factura = new JLabel("No.");
		l2_factura.setBounds(700, 5, 50, 30);
		ventas.add(l2_factura);
		
		JLabel l2_ayuda = new JLabel(); 
		l2_ayuda.setBounds(780, 5, 50, 30);
		ventas.add(l2_ayuda);
		
		JLabel l3_codigo = new JLabel("Codigo");
		l3_codigo.setBounds(100, 50, 50, 30);
		ventas.add(l3_codigo);
		
		JLabel l4_cantidad = new JLabel("Cantidad");
		l4_cantidad.setBounds(400, 50, 50, 30);
		ventas.add(l4_cantidad);
		
		
		
		JTextField t1_codigo = new JTextField();
		t1_codigo.setBounds(180, 50, 180, 30);
		ventas.add(t1_codigo);
		
		JTextField t2_cantidad = new JTextField();
		t2_cantidad.setBounds(480, 50, 180, 30);
		ventas.add(t2_cantidad);
		
		
		JTextField t3_total = new JTextField();
		
		
		
		JButton agregar = new JButton("Agregar");
		agregar.setBounds(700, 50, 100, 30);
		ventas.add(agregar);
		
		ActionListener funcion_comprar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				funciones_productos fp = new funciones_productos();
				productos x = new productos();
				x = fp.buscar_producto(Integer.parseInt(t1_codigo.getText()), Integer.parseInt(t2_cantidad.getText()));
				
				if(x == null) {
					JOptionPane.showMessageDialog(null, "Ingresa nuevamente");
        			
				}else {		
				agregar_productos[aumento][0]= x.getCodigo();
				agregar_productos[aumento][1] = x.getNombre();
				agregar_productos[aumento][2]= Integer.parseInt(t2_cantidad.getText());
				agregar_productos[aumento][3] = x.getPrecio();
				agregar_productos[aumento][4] = (Integer.parseInt(t2_cantidad.getText())*x.getPrecio());
				aumento++;
				sp.setVisible(false);
				tabla();
				}

			}
		};

		// Acción del evento
		agregar.addActionListener(funcion_comprar);
		
		
		
		
		//sin agregar aun 
		JLabel l5_total = new JLabel("Total");
		JButton vender = new JButton();
		
				
		
		
		
		
		
	}
	
	private void tabla() {
		String[] datos = { "Codigo", "Nombre", "Cantidad", "Precio", "Subtotal" };
		
		tabla_compras = new JTable(agregar_productos,datos);		
		sp = new JScrollPane(tabla_compras);
		sp.setBounds(80, 120, 700, 100);
		ventas.add(sp);
	}
	
	
	private void vaciar() {
		for (int i = 0; i < resultados.length; i++) {
			resultados[i]="";
		}
	}
	
	
	public void ejecutar() throws ClassNotFoundException {
		crear();
		modulo_ventas();
		botones();
		tabla();
	}
	

	

}
