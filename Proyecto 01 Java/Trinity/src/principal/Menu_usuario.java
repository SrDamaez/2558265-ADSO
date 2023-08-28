package principal;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import clases.DataBase;
import clases.Productos;
import javax.swing.Box;

public class Menu_usuario extends javax.swing.JFrame {
    private String cedula;
    DataBase basedatos;
    
    public Menu_usuario(DataBase basedatos, String cedula) {
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
        etq_carrito = new javax.swing.JLabel();
        etq_usuario = new javax.swing.JLabel();
        contentPrincipal = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(414, 598));
        setResizable(false);

        etq_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
            .addGap(0, 384, Short.MAX_VALUE)
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
                .addComponent(etq_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(etq_carrito, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etq_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(contentPrincipal))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etq_logo, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(etq_carrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void etq_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etq_usuarioMouseClicked
        Info_usuario ventana = new Info_usuario(basedatos, cedula);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_etq_usuarioMouseClicked
    
    private void etq_carritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etq_carritoMouseClicked
        Carrito ventana = new Carrito(basedatos, cedula);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_etq_carritoMouseClicked

    
    public void initComponentAltern(){  
        repaint();
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
        
        Image img_usuario = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/usuario.png"));
        img_usuario = img_usuario.getScaledInstance(50, 46, Image.SCALE_SMOOTH);
        etq_usuario.setIcon(new ImageIcon(img_usuario));
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane contentPrincipal;
    private javax.swing.JLabel etq_carrito;
    private javax.swing.JLabel etq_logo;
    private javax.swing.JLabel etq_usuario;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

}
