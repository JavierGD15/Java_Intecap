package Proyecto_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class inicio {
	// atributos
	JFrame inicio = new JFrame();
	JPanel p1 = new JPanel();
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JTextField t1 = new JTextField();
	JPasswordField t2 = new JPasswordField();
	JButton b1 = new JButton();

	// metodo
	private void frame() {
		inicio.setTitle("Login");
		inicio.setLocationRelativeTo(null);

		// x y ancho alto
		inicio.setBounds(500, 300, 500, 500);
		inicio.setVisible(true);
		p1.setBackground(Color.cyan);
		p1.setBounds(500, 300, 500, 500);
		p1.setLayout(null);
		inicio.add(p1);
		etiquetas();

	}

	// etiquetas y jtextfiels
	private void etiquetas() {
		// etiquetas
		l1.setText("Usuario:");
		l1.setFont(new Font("Serig", Font.PLAIN, 25));
		l1.setBounds(50, 100, 100, 80);
		l1.setVisible(true);
		p1.add(l1);

		l2.setText("Contraseña:");
		l2.setFont(new Font("Serig", Font.PLAIN, 25));
		l2.setBounds(50, 230, 180, 80);
		l2.setVisible(true);
		p1.add(l2);

		// jtextfield
		t1.setBounds(200, 115, 200, 40);
		t2.setBounds(200, 255, 200, 40);

		p1.add(t1);
		p1.add(t2);

	}

	private void botones() {
		b1.setText("Ingresar");
		b1.setBounds(200, 380, 100, 40);
		p1.add(b1);

		// Funcionalidad
		ActionListener ingresar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (t1.getText().equals("Admin") && t2.getText().equals("Admin")) {
					JOptionPane.showMessageDialog(null, "Bienvenido");
					inicio.setVisible(false);
					Menu_Principal mp = new Menu_Principal();
					
					try {
						mp.ejecutar();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuario Equivocado");
				}

			}
		};

		// Acción del evento
		b1.addActionListener(ingresar);

	}

	public void ejecutar() {
		frame();
		etiquetas();
		botones();
	}

	public static void main(String[] args) {
		inicio p1 = new inicio();
		p1.ejecutar();

	}

}
