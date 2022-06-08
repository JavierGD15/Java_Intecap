package Proyecto_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;

import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Sucursales_Menu implements Serializable {

	// botones
	JButton crear = new JButton();
	JButton carga = new JButton();
	JButton actualizar = new JButton();
	JButton eliminar = new JButton();
	JButton pdf = new JButton();

	// Matriz
	Object[][] sucursales = new Object[50][5];

	// tabla y complemento
	JTable tabla;
	JScrollPane sp;

	private void botones() {
		crear.setText("Crear");
		crear.setBounds(550, 100, 130, 70);

		// Funcion crear
		ActionListener funcion_crear = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				crear();

			}
		};

		//Acción del evento
		crear.addActionListener(funcion_crear);
		
		//carga masiva
		carga.setText("Carga Masiva");
		carga.setBounds(730, 100, 130, 70);
		
		
		ActionListener funcion_carga = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					carga_masiva();
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};

		//Acción del evento
		carga.addActionListener(funcion_carga);
		
		

		actualizar.setText("Actualizar");
		actualizar.setBounds(550, 260, 130, 70);
		
		// Funcion actualizar
		ActionListener funcion_actualizar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				modificar();

			}
		};

		//Acción del evento
		actualizar.addActionListener(funcion_actualizar);
		
		
		eliminar.setText("Eliminar");
		eliminar.setBounds(730, 260, 130, 70);
		
		// Funcion eliminar
		ActionListener funcion_eliminar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				eliminar();

			}
		};

		//Acción del evento
		eliminar.addActionListener(funcion_eliminar);

		pdf.setText("Exportar pdf");
		pdf.setBounds(550, 420, 310, 70);

	}

	private void tabla() throws ClassNotFoundException {
		String[] datos = { "Codigo", "Nombre", "Direccion", "Correo", "Telefono" };

		// cargar archivo
		try {

			ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("tabla_sucursales.dat"));

			sucursales = (Object[][]) recuperar.readObject();
			recuperar.close();

		}

		catch (IOException e) {
		}

		tabla = new JTable(sucursales, datos);
		sp = new JScrollPane(tabla);
		sp.setBounds(10, 10, 500, 600);

	}

	private void crear() {

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
		

		//jtextfield
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

				sucursal s = new sucursal(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(), t4.getText(),
						Integer.parseInt(t5.getText()));

				for (int i = 0; i < sucursales.length; i++) {
					if (sucursales[i][0] == null) {

						sucursales[i][0] = s.codigo;
						sucursales[i][1] = s.nombre;
						sucursales[i][2] = s.direccion;
						sucursales[i][3] = s.correo;
						sucursales[i][4] = s.telefono;						

						// guardar
						try {
							ObjectOutputStream carga = new ObjectOutputStream(
									new FileOutputStream("tabla_sucursales.dat"));
							carga.writeObject(sucursales);
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
	
	
    private String leerarchivo() {

    	JPanel c1 = new JPanel();
        JFileChooser fc = new JFileChooser();
        int op = fc.showOpenDialog(c1);
        String content = "";
        if (op == JFileChooser.APPROVE_OPTION) {

            File pRuta = fc.getSelectedFile();
            String ruta = pRuta.getAbsolutePath();
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            try {
                archivo = new File(ruta);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea = "";

                while ((linea = br.readLine()) != null) {

                    content += linea + "\n";
                }
                return content;

            } catch (FileNotFoundException ex) {
                String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
            } catch (IOException ex) {
                String resp = (String) JOptionPane.showInputDialog(null, "No se pudo abrir el archivo");
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
                    return "";
                }

            }
            return content;

        }
        return null;
    }

    private void carga_masiva() throws FileNotFoundException, IOException, ParseException {
        int x = 0;
        int y = 0;
        
        String archivo_retorno = leerarchivo();

        JsonParser parse = new JsonParser();
        JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();

        for (int i = 0; i < 50; i++) {
            if (sucursales[i][0] == null) {
                y = i;
                break;
            }
        }

        x = y;

        for (int i = 0; i < matriz.size(); i++) {

            if (sucursales[49][0] == null) {
                JsonObject objeto = matriz.get(i).getAsJsonObject();
                sucursal p = new sucursal(objeto.get("codigo").getAsInt(),objeto.get("nombre").getAsString(),objeto.get("direccion").getAsString(),objeto.get("correo").getAsString(),objeto.get("telefono").getAsInt());

                sucursales[x][0] = p.codigo;
                sucursales[x][1] = p.nombre;
                sucursales[x][2] = p.direccion;
                sucursales[x][3] = p.correo;
                sucursales[x][4] = p.telefono;
               
                x ++;

            } else {
                JOptionPane.showMessageDialog(null, "Tu documento excede tu maximo permitido,por favor modificalo.");
                break;
                
            }
        }
        try {
            ObjectOutputStream tabla = new ObjectOutputStream(new FileOutputStream("tabla_sucursales.dat"));
            tabla.writeObject(sucursales);
            tabla.close();
        } catch (IOException s) {
        }
    }

    private void eliminar() {
    	int posicion = tabla.getSelectedRow();
    	
    	if(posicion != -1) {
    		
    		for (int i = posicion; i < sucursales.length; i++) {
    			
    			if( i == 49) {
    				sucursales[i][0] = null;
    				sucursales[i][1] = null;
    				sucursales[i][2] = null;
    				sucursales[i][3] = null;
    				sucursales[i][4] = null;
    			}
    			
    			else if(sucursales[i][0] != null) {
    				sucursales[i][0] = sucursales[i+1][0];
    				sucursales[i][1] = sucursales[i+1][1];
    				sucursales[i][2] = sucursales[i+1][2];
    				sucursales[i][3] = sucursales[i+1][3];
    				sucursales[i][4] = sucursales[i+1][4];
    			}
			}
    		
            try {
                ObjectOutputStream tabla = new ObjectOutputStream(new FileOutputStream("tabla_sucursales.dat"));
                tabla.writeObject(sucursales);
                tabla.close();
            } catch (IOException s) {
            }
    		
    		
    	}else {
    		 JOptionPane.showMessageDialog(null, "Debe selecionar una Fila");
    	}
    	
    	tabla.clearSelection();
    	
    }
	
    private void modificar() {
    	int seleccionar = tabla.getSelectedRow();
    	if(seleccionar != -1) {
    		
    		JFrame crear = new JFrame("Modificar");
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
    		

    		//jtextfield
    		t1.setBounds(250, 100, 200, 40);
    		t2.setBounds(250, 200, 200, 40);
    		t3.setBounds(250, 300, 200, 40);
    		t4.setBounds(250, 400, 200, 40);
    		t5.setBounds(250, 500, 200, 40);
    		
    		t1.setText(sucursales[seleccionar][0]+"");
    		t2.setText(sucursales[seleccionar][1].toString());
    		t3.setText((String)sucursales[seleccionar][2]);
    		t4.setText(sucursales[seleccionar][3].toString());
    		t5.setText(sucursales[seleccionar][4].toString());
    		

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
    				
    				sucursal objeto = new sucursal(Integer.parseInt(t1.getText()),t2.getText(),t3.getText(),t4.getText(),Integer.parseInt(t5.getText()));
   				
    						sucursales[seleccionar][0] = objeto.codigo;
    						sucursales[seleccionar][1] = objeto.nombre;
    						sucursales[seleccionar][2] = objeto.direccion;
    						sucursales[seleccionar][3] = objeto.correo;
    						sucursales[seleccionar][4] = objeto.telefono;					

    						//guardar
    						try {
    							ObjectOutputStream carga = new ObjectOutputStream(
    									new FileOutputStream("tabla_sucursales.dat"));
    							carga.writeObject(sucursales);
    							carga.close();
    						} catch (IOException j) {

    						}
    						crear.setVisible(false);
    			}
    		};

    		// Acción del evento
    		b1.addActionListener(ingresar);
    	}else {
    		JOptionPane.showMessageDialog(null, "Debe selecionar una Fila");
    	}
    	
    }
	
	public void ejecutar() throws ClassNotFoundException {
		botones();
		tabla();

	}
}
