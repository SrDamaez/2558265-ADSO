package principal;

import java.awt.Image;
import javax.swing.ImageIcon;
import clases.DataBase;

public class Registrarse extends javax.swing.JFrame {
    
    DataBase basedatos;
    
    public Registrarse() {
        this.basedatos = new DataBase();
        initComponents();
        initComponents2();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etq_logo = new javax.swing.JLabel();
        etq_titulo = new javax.swing.JLabel();
        etq_cedula = new javax.swing.JLabel();
        campo_cedula = new javax.swing.JTextField();
        etq_nombre = new javax.swing.JLabel();
        campo_nombre = new javax.swing.JTextField();
        etq_contrasena = new javax.swing.JLabel();
        campo_contrasena = new javax.swing.JTextField();
        etq_rol = new javax.swing.JLabel();
        campo_rol = new javax.swing.JTextField();
        btn_registrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(414, 598));
        setPreferredSize(new java.awt.Dimension(414, 598));
        setResizable(false);

        etq_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        etq_titulo.setBackground(new java.awt.Color(0, 0, 0));
        etq_titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etq_titulo.setForeground(java.awt.Color.orange);
        etq_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_titulo.setText("REGISTRARSE");

        etq_cedula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_cedula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_cedula.setText("CÉDULA");

        campo_cedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campo_cedula.setText("1001");
        campo_cedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campo_cedulavalidateEmail(evt);
            }
        });
        campo_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_cedulaActionPerformed(evt);
            }
        });

        etq_nombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_nombre.setText("NOMBRE");

        campo_nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campo_nombre.setText("1001");
        campo_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campo_nombrevalidateEmail(evt);
            }
        });
        campo_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nombreActionPerformed(evt);
            }
        });

        etq_contrasena.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_contrasena.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_contrasena.setText("CONTRASEÑA");

        campo_contrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campo_contrasena.setText("1001");
        campo_contrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campo_contrasenavalidateEmail(evt);
            }
        });
        campo_contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_contrasenaActionPerformed(evt);
            }
        });

        etq_rol.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_rol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_rol.setText("ROL");

        campo_rol.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campo_rol.setText("1001");
        campo_rol.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campo_rolvalidateEmail(evt);
            }
        });
        campo_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_rolActionPerformed(evt);
            }
        });

        btn_registrarse.setBackground(java.awt.Color.orange);
        btn_registrarse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_registrarse.setForeground(new java.awt.Color(255, 255, 255));
        btn_registrarse.setText("REGISTRARSE");
        btn_registrarse.setFocusable(false);
        btn_registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(etq_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(etq_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(etq_cedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_contrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_rol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campo_cedulavalidateEmail(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campo_cedulavalidateEmail
        
    }//GEN-LAST:event_campo_cedulavalidateEmail

    private void campo_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_cedulaActionPerformed

    private void campo_nombrevalidateEmail(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campo_nombrevalidateEmail
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nombrevalidateEmail

    private void campo_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nombreActionPerformed

    private void campo_contrasenavalidateEmail(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campo_contrasenavalidateEmail
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_contrasenavalidateEmail

    private void campo_contrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_contrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_contrasenaActionPerformed

    private void campo_rolvalidateEmail(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campo_rolvalidateEmail
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_rolvalidateEmail

    private void campo_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_rolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_rolActionPerformed

    private void btn_registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarseActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_registrarseActionPerformed

    public void initComponents2(){
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Registrarse");
        setIconImage( getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda2.png")) );
        
        Image img_zelda = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda.png"));
        img_zelda = img_zelda.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        etq_logo.setIcon(new ImageIcon(img_zelda));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_registrarse;
    private javax.swing.JTextField campo_cedula;
    private javax.swing.JTextField campo_contrasena;
    private javax.swing.JTextField campo_nombre;
    private javax.swing.JTextField campo_rol;
    private javax.swing.JLabel etq_cedula;
    private javax.swing.JLabel etq_contrasena;
    private javax.swing.JLabel etq_logo;
    private javax.swing.JLabel etq_nombre;
    private javax.swing.JLabel etq_rol;
    private javax.swing.JLabel etq_titulo;
    // End of variables declaration//GEN-END:variables
}
