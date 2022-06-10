package Proyecto_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class cobros {
	JPanel filtro = new JPanel();
	JPanel ventas = new JPanel();
	
	private void crear() {
		filtro.setLayout(null);
		ventas.setLayout(null);
		filtro.setBackground(Color.white);
		ventas.setBackground(Color.white);
		filtro.setBounds(20, 30,830, 250);
		ventas.setBounds(20, 300, 830, 280);
	}
	
	private void botones() {
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
        nombre.setBounds(180, 30, 100, 15);
        filtro.add(nombre);
	}
	
	public void ejecutar() {
		crear();
		botones();
	}
	

}
