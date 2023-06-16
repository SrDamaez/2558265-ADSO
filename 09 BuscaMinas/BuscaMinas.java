import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class BuscaMinas extends JFrame{

    JPanel contenedor, f2_campo;
    JLabel f1_contador_bombas, f1_tiempo;
    JButton f1_imagen;
    JButton botones[][];

    public BuscaMinas(){
        componentes();
    }

    public void componentes(){

        setTitle("Busca Minas");
		setSize(300, 400);
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
        f1_contador_bombas = new JLabel("020");
        gcon.gridy = 0;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weighty = 3;
        gcon.weightx = 33;
        f1_contador_bombas.setBorder(new EmptyBorder(10,10,10,10));
        f1_contador_bombas.setOpaque(true);
        f1_contador_bombas.setForeground(Color.RED);
        f1_contador_bombas.setBackground(Color.BLACK);
        f1_contador_bombas.setHorizontalAlignment(SwingConstants.CENTER);
        f1_contador_bombas.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(f1_contador_bombas, gcon);

        f1_imagen = new JButton(":D");
        gcon.gridy = 0;
        gcon.gridx = 1;
        gcon.gridwidth = 1;
        gcon.weighty = 3;
        gcon.weightx = 33;
        f1_imagen.setBorder(new EmptyBorder(10,10,10,10));
        f1_imagen.setOpaque(true);
        f1_imagen.setHorizontalAlignment(SwingConstants.CENTER);
        f1_imagen.setFont(new Font("Arial", Font.BOLD, 18));
        Dimension buttonSize = new Dimension(5, 5); // Establece el tamaño deseado del botón
        f1_imagen.setPreferredSize(buttonSize);
        f1_imagen.setMinimumSize(buttonSize);
        gbl.setConstraints(f1_imagen, gcon);

        f1_tiempo = new JLabel("000");
        gcon.gridy = 0;
        gcon.gridx = 2;
        gcon.gridwidth = 1;
        gcon.weighty = 3;
        gcon.weightx = 33;
        f1_tiempo.setBorder(new EmptyBorder(10,10,10,10));
        f1_tiempo.setOpaque(true);
        f1_tiempo.setForeground(Color.RED);
        f1_tiempo.setBackground(Color.BLACK);
        f1_tiempo.setHorizontalAlignment(SwingConstants.CENTER);
        f1_tiempo.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(f1_tiempo, gcon);

        //------------------SEGUNDA FILA
        f2_campo = new JPanel(new GridLayout(9, 9));
        gcon.gridy = 1;
        gcon.gridx = 0;
        gcon.gridwidth = 3;
        gcon.weighty = 100;
        gcon.weightx = 100;
        f2_campo.setBorder(new EmptyBorder(0,0,0,0));
        f2_campo.setOpaque(true);
        f2_campo.setForeground(Color.RED);
        f2_campo.setBackground(Color.WHITE);
        f2_campo.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(f2_campo, gcon);

        botones = new JButton[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JButton boton = new JButton();
                boton.setMargin(new Insets(0, 0, 0, 0));
                f2_campo.add(boton);
                botones[i][j] = boton;
            }
        }

        //------------------PRIMERA FILA
        contenedor.add(f1_contador_bombas);
        contenedor.add(f1_imagen);
        contenedor.add(f1_tiempo);
        //------------------SEGUNDA FILA
        contenedor.add(f2_campo);




        add(contenedor);
        setVisible(true);
    }

}
