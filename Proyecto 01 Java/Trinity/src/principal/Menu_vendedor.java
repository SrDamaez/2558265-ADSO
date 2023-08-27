package principal;

import clases.DataBase;
import clases.Productos;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Menu_vendedor extends javax.swing.JFrame {
    private String cedula;
    DataBase basedatos;
    
    public Menu_vendedor( DataBase basedatos, String cedula) {
        this.cedula = cedula;
        this.basedatos = basedatos;
        initComponents();
        initComponentAltern();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        etq_logo = new javax.swing.JLabel();
        etq_subir = new javax.swing.JLabel();
        etq_carrito = new javax.swing.JLabel();
        etq_usuario = new javax.swing.JLabel();
        contentPrincipal = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(414, 598));
        setResizable(false);

        etq_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        etq_subir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        etq_carrito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_carrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etq_carritoMouseClicked(evt);
            }
        });

        etq_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etq_usuarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );

        contentPrincipal.setViewportView(panelPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etq_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etq_subir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etq_carrito, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etq_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etq_logo, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(etq_carrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_subir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void etq_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etq_usuarioMouseClicked
        Info_vendedor ventana = new Info_vendedor(basedatos, cedula);
        dispose();
    }//GEN-LAST:event_etq_usuarioMouseClicked

    private void etq_carritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etq_carritoMouseClicked
        // TODO add your handling code here:
        Carrito ventana = new Carrito(basedatos, cedula);
        dispose();
    }//GEN-LAST:event_etq_carritoMouseClicked

    public void initComponentAltern(){      
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Menú");
        setIconImage( getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda2.png")) );
        
        panelPrincipal.removeAll();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
         
        ArrayList<Productos> productosList = basedatos.obtenerProductos();
        
        for (Productos producto : productosList) {
            contentItems contentTemporal = new contentItems(producto, basedatos, cedula);
            panelPrincipal.add(contentTemporal);
            panelPrincipal.add(Box.createVerticalStrut(0));
        }

        repaint();
        revalidate();
        
        Image img_zelda2 = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda2.png"));
        img_zelda2 = img_zelda2.getScaledInstance(50, 46, Image.SCALE_SMOOTH);
        etq_logo.setIcon(new ImageIcon(img_zelda2));
        
        Image img_carrito = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/carrito.png"));
        img_carrito = img_carrito.getScaledInstance(50, 46, Image.SCALE_SMOOTH);
        etq_carrito.setIcon(new ImageIcon(img_carrito));
        
        Image img_subir = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/mas.png"));
        img_subir = img_subir.getScaledInstance(50, 46, Image.SCALE_SMOOTH);
        etq_subir.setIcon(new ImageIcon(img_subir));
        
        Image img_usuario = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/usuario.png"));
        img_usuario = img_usuario.getScaledInstance(50, 46, Image.SCALE_SMOOTH);
        etq_usuario.setIcon(new ImageIcon(img_usuario));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane contentPrincipal;
    private javax.swing.JLabel etq_carrito;
    private javax.swing.JLabel etq_logo;
    private javax.swing.JLabel etq_subir;
    private javax.swing.JLabel etq_usuario;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
