package principal;

import clases.DataBase;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Info_usuario extends javax.swing.JFrame {
    
    private String cedula;
    DataBase basedatos;
    
    public Info_usuario( DataBase basedatos, String cedula) {
        this.cedula = cedula;
        this.basedatos = basedatos;
        initComponents();
        initComponents2();
        
        ResultSet respuesta = this.basedatos.buscarUsuario(cedula);
        try {
            campo_nombre.setText(respuesta.getString("nombre"));
            campo_contrasena.setText(respuesta.getString("contrasena"));
            campo_cedula.setText(respuesta.getString("cedula"));
        } catch (SQLException ex) {
            Logger.getLogger(Info_usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etq_img_user = new javax.swing.JLabel();
        etq_titulo = new javax.swing.JLabel();
        etq_rol = new javax.swing.JLabel();
        campo_rol = new javax.swing.JComboBox<>();
        etq_nombre = new javax.swing.JLabel();
        campo_nombre = new javax.swing.JTextField();
        etq_contrasena = new javax.swing.JLabel();
        campo_contrasena = new javax.swing.JPasswordField();
        etq_cedula = new javax.swing.JLabel();
        campo_cedula = new javax.swing.JTextField();
        btn_volver = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuario");
        setMinimumSize(new java.awt.Dimension(414, 598));
        setResizable(false);

        etq_img_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        etq_titulo.setBackground(new java.awt.Color(0, 0, 0));
        etq_titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etq_titulo.setForeground(java.awt.Color.orange);
        etq_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_titulo.setText("INFORMACIÓN");

        etq_rol.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_rol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_rol.setText("ROL");

        campo_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Vendedor", " " }));
        campo_rol.setEnabled(false);

        etq_nombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_nombre.setText("NOMBRE");

        campo_nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        etq_contrasena.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_contrasena.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_contrasena.setText("CONTRASEÑA");

        campo_contrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        etq_cedula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_cedula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_cedula.setText("CÉDULA");

        campo_cedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campo_cedula.setEnabled(false);
        campo_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_cedulaActionPerformed(evt);
            }
        });

        btn_volver.setBackground(java.awt.Color.orange);
        btn_volver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_volver.setForeground(new java.awt.Color(255, 255, 255));
        btn_volver.setText("VOLVER");
        btn_volver.setFocusable(false);
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        btn_editar.setBackground(java.awt.Color.orange);
        btn_editar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_editar.setForeground(new java.awt.Color(255, 255, 255));
        btn_editar.setText("EDITAR");
        btn_editar.setFocusable(false);
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_salir.setBackground(java.awt.Color.orange);
        btn_salir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(255, 255, 255));
        btn_salir.setText("SALIR");
        btn_salir.setFocusable(false);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_img_user, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(etq_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etq_img_user, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(etq_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(etq_rol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_contrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_cedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        String rol = campo_rol.getSelectedItem().toString();
        String nombre = campo_nombre.getText();
        String contrasena = campo_contrasena.getText();
        
        boolean respuesta = basedatos.actualizarUsuarios(cedula, nombre, contrasena, rol);
        if (respuesta){
            Menu_usuario ventana = new Menu_usuario(basedatos, cedula);
            dispose();
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        Menu_usuario ventana = new Menu_usuario(basedatos, cedula);
        dispose();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        this.basedatos.borrarDatosCarrito();
        Login ventana = new Login();
        dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void campo_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_cedulaActionPerformed
    
    public void initComponents2(){
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Info");
        setIconImage( getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda2.png")));
        
        Image img_usuario = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda.png"));
        img_usuario = img_usuario.getScaledInstance(160, 120, Image.SCALE_SMOOTH);
        etq_img_user.setIcon(new ImageIcon(img_usuario));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_volver;
    private javax.swing.JTextField campo_cedula;
    private javax.swing.JTextField campo_contrasena;
    private javax.swing.JTextField campo_nombre;
    private javax.swing.JComboBox<String> campo_rol;
    private javax.swing.JLabel etq_cedula;
    private javax.swing.JLabel etq_contrasena;
    private javax.swing.JLabel etq_img_user;
    private javax.swing.JLabel etq_nombre;
    private javax.swing.JLabel etq_rol;
    private javax.swing.JLabel etq_titulo;
    // End of variables declaration//GEN-END:variables
}
