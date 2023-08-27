package principal;

import clases.DataBase;
import clases.Productos;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Carrito extends javax.swing.JFrame {
    
    DataBase basedatos;
    private String cedula;
    
    public Carrito(DataBase basedatos, String cedula) {
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
        btn_pagar = new javax.swing.JButton();
        etq_usuario = new javax.swing.JLabel();
        btn_volver = new javax.swing.JButton();
        etq_total = new javax.swing.JLabel();
        etq_valortotal = new javax.swing.JLabel();
        contentPrincipal = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        etq_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_pagar.setBackground(java.awt.Color.orange);
        btn_pagar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_pagar.setForeground(new java.awt.Color(255, 255, 255));
        btn_pagar.setText("Pagar");
        btn_pagar.setFocusable(false);
        btn_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagarActionPerformed(evt);
            }
        });

        etq_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etq_usuarioMouseClicked(evt);
            }
        });

        btn_volver.setBackground(java.awt.Color.orange);
        btn_volver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_volver.setForeground(new java.awt.Color(255, 255, 255));
        btn_volver.setText("Volver");
        btn_volver.setFocusable(false);
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        etq_total.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_total.setText("Total:");

        etq_valortotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_valortotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_valortotal.setText("---");

        contentPrincipal.setPreferredSize(new java.awt.Dimension(100, 393));

        panelPrincipal.setPreferredSize(new java.awt.Dimension(320, 390));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
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
                    .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                                .addComponent(etq_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etq_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(etq_total, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                                .addComponent(etq_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etq_logo, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(etq_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contentPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_total)
                    .addComponent(etq_valortotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void etq_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etq_usuarioMouseClicked
        String rol = "";
        ResultSet respuesta = this.basedatos.buscarUsuario(cedula);
        
        try {
            rol = (respuesta.getString("rol"));
            System.out.println(rol);
            System.out.println(cedula);

            if (rol.equalsIgnoreCase("Usuario")) {
                Info_usuario ventana = new Info_usuario(basedatos, cedula);
                dispose();
            }else{
                Info_vendedor ventana = new Info_vendedor(basedatos, cedula);
                dispose();  
            }
        } catch (SQLException ex) {
            System.out.println("Error al procesar el resultado: " + ex.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_etq_usuarioMouseClicked

    private void btn_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagarActionPerformed
        Factura ventana = new Factura(basedatos, cedula);
        dispose();  
    }//GEN-LAST:event_btn_pagarActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        String rol = "";
        ResultSet respuesta = this.basedatos.buscarUsuario(cedula);
        
        try {
            rol = (respuesta.getString("rol"));
            System.out.println(rol);
            System.out.println(cedula);

            if (rol.equalsIgnoreCase("Usuario")) {
                Menu_usuario ventana = new Menu_usuario(basedatos, cedula);
                dispose();
            }else{
                Menu_vendedor ventana = new Menu_vendedor(basedatos, cedula);
                dispose();  
            }
        } catch (SQLException ex) {
            System.out.println("Error al procesar el resultado: " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_volverActionPerformed

    public void initComponentAltern(){
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Carrito");
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda2.png")));
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Obtener la lista de productos del carrito
        ArrayList<Productos> productosList = basedatos.obtenerCarrito();

        // Agregar los productos al JPanel
        for (Productos producto : productosList) {
            contentItemscarrito contentTemporal = new contentItemscarrito(producto, basedatos, cedula);
            contentPanel.add(contentTemporal);
            contentPanel.add(Box.createVerticalStrut(0)); // Espacio entre productos
        }

        // Crear el JScrollPane y configurar el viewport preferido
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setPreferredSize(new Dimension(320, 390)); // Tamaño inicial del viewport

        // Agregar el JScrollPane al contenido principal
        contentPrincipal.setViewportView(scrollPane);

        Image img_zelda2 = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda2.png"));
        img_zelda2 = img_zelda2.getScaledInstance(50, 46, Image.SCALE_SMOOTH);
        etq_logo.setIcon(new ImageIcon(img_zelda2));

        Image img_usuario = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/usuario.png"));
        img_usuario = img_usuario.getScaledInstance(50, 46, Image.SCALE_SMOOTH);
        etq_usuario.setIcon(new ImageIcon(img_usuario));
    }
        


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pagar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JScrollPane contentPrincipal;
    private javax.swing.JLabel etq_logo;
    private javax.swing.JLabel etq_total;
    private javax.swing.JLabel etq_usuario;
    private javax.swing.JLabel etq_valortotal;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
