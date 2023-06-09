import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Factura extends JFrame{

    Persona clientes[];
    Persona vendedores[];
    Productos productos[];
    JPanel contenedor;
    JTextField campo_cedula_cliente, campo_nombres_cliente, campo_direccion, campo_cedula_vendedor, campo_nombres_vendedor, campo_id, campo_nombre, campo_cantidad, campote;
    JLabel txt_datoscliente, cedula_cliente, nombres_cliente, direccion, txt_datosvendedor, cedula_vendedor, nombres_vendedor, txt_lista_pro_fac, id, nombre, cantidad, espacio;
    JButton buscar_cliente, buscar_vendedor, agregar;

    public Factura( Persona clientes[], Persona vendedores[], Productos productos[] ){
        this.clientes = clientes;
        this.vendedores = vendedores;
        this.productos = productos;
        componentes();
    }

	public void componentes() {

        setTitle("Formato Moneda");
		setSize(700, 970);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo(null);
		setResizable(false);

        contenedor = new JPanel();
		contenedor.setLayout( new BoxLayout(contenedor, BoxLayout.Y_AXIS) );
		contenedor.setBorder( new EmptyBorder(15,15,15,15) );

        GridBagLayout gbl = new GridBagLayout();
        contenedor.setLayout(gbl);

        GridBagConstraints gcon = new GridBagConstraints();
        gcon.weightx = 1;
        gcon.weighty = 1;
        gcon.fill = GridBagConstraints.BOTH;

        //------------------PRIMERA FILA
        txt_datoscliente = new JLabel("DATOS CLIENTE: ");
        gcon.gridy = 0;
        gcon.gridx = 0;
        gcon.gridwidth = 4;
        gcon.weightx = 100;
        gcon.weighty = 5;
        txt_datoscliente.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(txt_datoscliente, gcon);

        //------------------SEGUNDA FILA
        cedula_cliente = new JLabel("CEDULA: ");
        gcon.gridy = 1;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(cedula_cliente, gcon);

		campo_cedula_cliente = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 5);
		campo_cedula_cliente.setBorder( new EmptyBorder(1,1,1,1) );
        gcon.gridy = 1;
        gcon.gridx = 1;
        gcon.gridwidth = 2;
        gcon.weightx = 80;
        gcon.weighty = 5;
        gbl.setConstraints(campo_cedula_cliente, gcon);

        buscar_cliente = new JButton("BUSCAR");
        gcon.insets = new Insets(5, 5, 5, 5);
        gcon.gridy = 1;
        gcon.gridx = 3;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(buscar_cliente, gcon);

        //------------------TERCERA FILA
        nombres_cliente = new JLabel("NOMBRES: ");
        gcon.gridy = 2;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(nombres_cliente, gcon);

		campo_nombres_cliente = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 5);
		campo_nombres_cliente.setBorder( new EmptyBorder(1,1,1,1) );
        gcon.gridy = 2;
        gcon.gridx = 1;
        gcon.gridwidth = 3;
        gcon.weightx = 90;
        gcon.weighty = 5;
        gbl.setConstraints(campo_nombres_cliente, gcon);

        //------------------CUARTA FILA
        direccion = new JLabel("DIRECCION: ");
        gcon.gridy = 3;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(direccion, gcon);

		campo_direccion = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 5);
		campo_direccion.setBorder( new EmptyBorder(1,1,1,1) );
        gcon.gridy = 3;
        gcon.gridx = 1;
        gcon.gridwidth = 3;
        gcon.weightx = 90;
        gcon.weighty = 5;
        gbl.setConstraints(campo_direccion, gcon);

        //------------------QUINTA FILA
        txt_datosvendedor = new JLabel("DATOS VENDEDOR: ");
        gcon.gridy = 4;
        gcon.gridx = 0;
        gcon.gridwidth = 4;
        gcon.weightx = 100;
        gcon.weighty = 5;
        txt_datosvendedor.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(txt_datosvendedor, gcon);

        //------------------SEXTA FILA
        cedula_vendedor = new JLabel("CEDULA: ");
        gcon.gridy = 5;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(cedula_vendedor, gcon);

		campo_cedula_vendedor = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 5);
		campo_cedula_vendedor.setBorder( new EmptyBorder(1,1,1,1) );
        gcon.gridy = 5;
        gcon.gridx = 1;
        gcon.gridwidth = 2;
        gcon.weightx = 80;
        gcon.weighty = 5;
        gbl.setConstraints(campo_cedula_vendedor, gcon);

        buscar_vendedor = new JButton("BUSCAR");
        gcon.insets = new Insets(5, 5, 5, 5);
        gcon.gridy = 5;
        gcon.gridx = 3;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(buscar_vendedor, gcon);

        //------------------SEPTIMA FILA
        nombres_vendedor = new JLabel("NOMBRES: ");
        gcon.gridy = 6;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 10;
        gcon.weighty = 5;
        gbl.setConstraints(nombres_vendedor, gcon);

		campo_nombres_vendedor = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 5);
		campo_nombres_vendedor.setBorder( new EmptyBorder(1,1,1,1) );
        gcon.gridy = 6;
        gcon.gridx = 1;
        gcon.gridwidth = 3;
        gcon.weightx = 90;
        gcon.weighty = 5;
        gbl.setConstraints(campo_nombres_vendedor, gcon);

        //------------------OCTAVA FILA
        txt_lista_pro_fac = new JLabel("LISTA PRODUCTOS FACTURADOS: ");
        gcon.gridy = 7;
        gcon.gridx = 0;
        gcon.gridwidth = 4;
        gcon.weightx = 100;
        gcon.weighty = 5;
        txt_lista_pro_fac.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(txt_lista_pro_fac, gcon);

        //------------------NOVENA FILA
        id = new JLabel("ID");
        gcon.gridy = 8;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 15;
        gcon.weighty = 5;
        id.setHorizontalAlignment(SwingConstants.CENTER);
        gbl.setConstraints(id, gcon);

		nombre = new JLabel("NOMBRE");
        gcon.gridy = 8;
        gcon.gridx = 1;
        gcon.gridwidth = 1;
        gcon.weightx = 55;
        gcon.weighty = 5;
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        gbl.setConstraints(nombre, gcon);

        cantidad = new JLabel("CANTIDAD");
        gcon.gridy = 8;
        gcon.gridx = 2;
        gcon.gridwidth = 1;
        gcon.weightx = 15;
        gcon.weighty = 5;
        cantidad.setHorizontalAlignment(SwingConstants.CENTER);
        gbl.setConstraints(cantidad, gcon);

        espacio = new JLabel("");
        gcon.gridy = 8;
        gcon.gridx = 3;
        gcon.gridwidth = 1;
        gcon.weightx = 15;
        gcon.weighty = 5;
        gbl.setConstraints(espacio, gcon);

        //------------------DECIMA FILA
        campo_id = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 0);
		campo_id.setBorder( new EmptyBorder(1,0,1,0) );
        gcon.gridy = 9;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 15;
        gcon.weighty = 5;
        campo_id.setHorizontalAlignment(SwingConstants.CENTER);
        gbl.setConstraints(campo_id, gcon);

        campo_nombre = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 0);
		campo_nombre.setBorder( new EmptyBorder(1,0,1,0) );
        gcon.gridy = 9;
        gcon.gridx = 1;
        gcon.gridwidth = 1;
        gcon.weightx = 55;
        gcon.weighty = 5;
        campo_nombre.setHorizontalAlignment(SwingConstants.CENTER);
        gbl.setConstraints(campo_nombre, gcon);

        campo_cantidad = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 0);
		campo_cantidad.setBorder( new EmptyBorder(1,0,1,0) );
        gcon.gridy = 9;
        gcon.gridx = 2;
        gcon.gridwidth = 1;
        gcon.weightx = 15;
        gcon.weighty = 5;
        campo_cantidad.setHorizontalAlignment(SwingConstants.CENTER);
        gbl.setConstraints(campo_cantidad, gcon);

        agregar = new JButton("AGREGAR");
        gcon.insets = new Insets(5, 5, 5, 5);
        gcon.gridy = 9;
        gcon.gridx = 3;
        gcon.gridwidth = 1;
        gcon.weightx = 15;
        gcon.weighty = 5;
        gbl.setConstraints(agregar, gcon);

        //------------------DECIMOPRIMERA FILA
        campote = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 5);
		campote.setBorder( new EmptyBorder(1,0,1,0) );
        gcon.gridy = 10;
        gcon.gridx = 0;
        gcon.gridwidth = 4;
        gcon.weightx = 100;
        gcon.weighty = 150;
        gbl.setConstraints(campote, gcon);


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
        //------------------NOVENA FILA
        contenedor.add(campo_id);
        contenedor.add(campo_nombre);
        contenedor.add(campo_cantidad);
        contenedor.add(agregar);
        //------------------DECIMOPRIMERA FILA
        contenedor.add(campote);


        add(contenedor);
		setVisible(true);
    }

    public void deshabilitarInputs(){
        id.setEnabled(false);
        id.setOpaque(false);
        id.setText("");
        cantidad.setEnabled(false);
        cantidad.setOpaque(false);
        cantidad.setText("");
        campo_nombres_vendedor.setText(null);
        nombre.setText("");
    }

    public void habilitarInputs(){
        id.setEnabled(true);
        id.setOpaque(true);
        id.setText("");
        id.requestFocus();
        cantidad.setEnabled(true);
        cantidad.setOpaque(true);
        cantidad.setText("");
        nombre.setText("");
    }
}