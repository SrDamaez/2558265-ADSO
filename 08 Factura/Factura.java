import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.text.AbstractDocument.Content;

import java.util.Locale;
import java.awt.*;
import java.awt.event.*;

public class Factura{
	public static void main(String[] args) {

        JFrame ventana = new JFrame();
		ventana.setTitle("Formato Moneda");
		ventana.setSize(500, 750);
		ventana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);

        JPanel contenedor = new JPanel();
		contenedor.setLayout( new BoxLayout(contenedor, BoxLayout.Y_AXIS) );
		contenedor.setBorder( new EmptyBorder(15,15,15,15) );

        GridBagLayout gbl = new GridBagLayout();
        contenedor.setLayout(gbl);

        GridBagConstraints gcon = new GridBagConstraints();
        gcon.weightx = 1;
        gcon.weighty = 1;
        gcon.fill = GridBagConstraints.BOTH;

        //------------------PRIMERA FILA
        JLabel txt_datoscliente = new JLabel("DATOS CLIENTE: ");
        gcon.gridy = 0;
        gcon.gridx = 0;
        gcon.gridwidth = 4;
        gcon.weightx = 100;
        gcon.weighty = 5;
        txt_datoscliente.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(txt_datoscliente, gcon);

        //------------------SEGUNDA FILA
        JLabel cedula_cliente = new JLabel("CEDULA: ");
        gcon.gridy = 1;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(cedula_cliente, gcon);

		JTextField campo_cedula_cliente = new JTextField();
        gcon.insets = new Insets(0, 0, 5, 5);
		campo_cedula_cliente.setBorder( new EmptyBorder(1,1,1,1) );
        gcon.gridy = 1;
        gcon.gridx = 1;
        gcon.gridwidth = 2;
        gcon.weightx = 80;
        gcon.weighty = 5;
        gbl.setConstraints(campo_cedula_cliente, gcon);

        JButton buscar_cliente = new JButton("BUSCAR");
        gcon.insets = new Insets(5, 5, 5, 5);
        gcon.gridy = 1;
        gcon.gridx = 3;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(buscar_cliente, gcon);

        //------------------TERCERA FILA
        JLabel nombres_cliente = new JLabel("NOMBRES: ");
        gcon.gridy = 2;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(nombres_cliente, gcon);

		JTextField campo_nombres_cliente = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 5);
		campo_nombres_cliente.setBorder( new EmptyBorder(1,1,1,1) );
        gcon.gridy = 2;
        gcon.gridx = 1;
        gcon.gridwidth = 3;
        gcon.weightx = 90;
        gcon.weighty = 5;
        gbl.setConstraints(campo_nombres_cliente, gcon);

        //------------------CUARTA FILA
        JLabel direccion = new JLabel("DIRECCION: ");
        gcon.gridy = 3;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(direccion, gcon);

		JTextField campo_direccion = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 5);
		campo_direccion.setBorder( new EmptyBorder(1,1,1,1) );
        gcon.gridy = 3;
        gcon.gridx = 1;
        gcon.gridwidth = 3;
        gcon.weightx = 90;
        gcon.weighty = 5;
        gbl.setConstraints(campo_direccion, gcon);

        //------------------QUINTA FILA
        JLabel txt_datosvendedor = new JLabel("DATOS VENDEDOR: ");
        gcon.gridy = 4;
        gcon.gridx = 0;
        gcon.gridwidth = 4;
        gcon.weightx = 100;
        gcon.weighty = 5;
        txt_datosvendedor.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(txt_datosvendedor, gcon);

        //------------------SEXTA FILA
        JLabel cedula_vendedor = new JLabel("CEDULA: ");
        gcon.gridy = 5;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(cedula_vendedor, gcon);

		JTextField campo_cedula_vendedor = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 5);
		campo_cedula_vendedor.setBorder( new EmptyBorder(1,1,1,1) );
        gcon.gridy = 5;
        gcon.gridx = 1;
        gcon.gridwidth = 2;
        gcon.weightx = 80;
        gcon.weighty = 5;
        gbl.setConstraints(campo_cedula_vendedor, gcon);

        JButton buscar_vendedor = new JButton("BUSCAR");
        gcon.insets = new Insets(5, 5, 5, 5);
        gcon.gridy = 5;
        gcon.gridx = 3;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(buscar_vendedor, gcon);

        //------------------SEPTIMA FILA
        JLabel nombres_vendedor = new JLabel("NOMBRES: ");
        gcon.gridy = 6;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(nombres_vendedor, gcon);

		JTextField campo_nombres_vendedor = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 5);
		campo_nombres_vendedor.setBorder( new EmptyBorder(1,1,1,1) );
        gcon.gridy = 6;
        gcon.gridx = 1;
        gcon.gridwidth = 3;
        gcon.weightx = 90;
        gcon.weighty = 5;
        gbl.setConstraints(campo_nombres_vendedor, gcon);

        //------------------OCTAVA FILA
        JLabel txt_lista_pro_fac = new JLabel("LISTA PRODUCTOS FACTURADOS: ");
        gcon.gridy = 7;
        gcon.gridx = 0;
        gcon.gridwidth = 4;
        gcon.weightx = 100;
        gcon.weighty = 5;
        txt_lista_pro_fac.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(txt_lista_pro_fac, gcon);

        //------------------NOVENA FILA
        JLabel id = new JLabel("ID");
        gcon.gridy = 8;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 25;
        gcon.weighty = 5;
        gbl.setConstraints(id, gcon);

		JLabel nombre = new JLabel("NOMBRE");
        gcon.gridy = 8;
        gcon.gridx = 1;
        gcon.gridwidth = 1;
        gcon.weightx = 25;
        gcon.weighty = 5;
        gbl.setConstraints(nombre, gcon);

        JLabel cantidad = new JLabel("CANTIDAD");
        gcon.gridy = 8;
        gcon.gridx = 2;
        gcon.gridwidth = 1;
        gcon.weightx = 25;
        gcon.weighty = 5;
        gbl.setConstraints(cantidad, gcon);

        JLabel espacio = new JLabel("");
        gcon.gridy = 8;
        gcon.gridx = 3;
        gcon.gridwidth = 1;
        gcon.weightx = 25;
        gcon.weighty = 5;
        gbl.setConstraints(espacio, gcon);



        //------------------PRIMERA FILA
        contenedor.add(txt_datoscliente);
        //------------------SEGUNDA FILA
        contenedor.add(cedula_cliente);
        contenedor.add(campo_cedula_cliente);
        contenedor.add(buscar_cliente);
        //------------------TERCERA FILA
        contenedor.add(nombres_cliente);
        contenedor.add(campo_nombres_cliente);
        //------------------CUARTA FILA
        contenedor.add(direccion);
        contenedor.add(campo_direccion);
        //------------------QUINTA FILA
        contenedor.add(txt_datosvendedor);
        //------------------SEGUNDA FILA
        contenedor.add(cedula_vendedor);
        contenedor.add(campo_cedula_vendedor);
        contenedor.add(buscar_vendedor);
        //------------------SEPTIMA FILA
        contenedor.add(nombres_vendedor);
        contenedor.add(campo_nombres_vendedor);
        //------------------OCTAVA FILA
        contenedor.add(txt_lista_pro_fac);
        //------------------NOVENA FILA
        contenedor.add(id);
        contenedor.add(nombre);
        contenedor.add(cantidad);
        contenedor.add(espacio);








        ventana.add(contenedor);
		ventana.setVisible(true);
    }
}