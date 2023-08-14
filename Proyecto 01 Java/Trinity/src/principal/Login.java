package principal;

import clases.DataBase;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Login extends javax.swing.JFrame {

    DataBase basedatos;
    
    public Login() {
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
        etq_password = new javax.swing.JLabel();
        campo_password = new javax.swing.JPasswordField();
        btn_ingresar = new javax.swing.JButton();
        btn_registrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(414, 598));
        setResizable(false);

        etq_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        etq_titulo.setBackground(new java.awt.Color(0, 0, 0));
        etq_titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etq_titulo.setForeground(java.awt.Color.orange);
        etq_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_titulo.setText("INICIAR SESION");

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

        etq_password.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_password.setText("CONTRASEÑA");

        campo_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campo_password.setText("12345");
        campo_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campo_passwordpruebaKey(evt);
            }
        });

        btn_ingresar.setBackground(java.awt.Color.orange);
        btn_ingresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ingresar.setText("INGRESAR");
        btn_ingresar.setFocusable(false);
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
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
                    .addComponent(etq_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campo_password, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(etq_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etq_cedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etq_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        String email = campo_cedula.getText();
        String password = campo_password.getText();

        if (email.equalsIgnoreCase("1001") && password.equalsIgnoreCase("12345")) {
            Menu ventana = new Menu(basedatos);
            dispose();
        }else{
            System.out.println("DATOS INVALIDOS");
        }
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void campo_passwordpruebaKey(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_passwordpruebaKey
        JTextField temporal = (JTextField) evt.getSource();

        if (evt.getKeyCode()<48 || evt.getKeyCode()>57) {
            String texto = temporal.getText();
            String tecla = String.valueOf(evt.getKeyChar());
            temporal.setText( texto.replaceAll(tecla, "") );
        }

        System.out.println("Tecla presionada: "+evt.getKeyChar());
        System.out.println("Texto en input: "+temporal.getText());
        System.out.println("Codigo: "+evt.getKeyCode());
    }//GEN-LAST:event_campo_passwordpruebaKey

    private void campo_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_cedulaActionPerformed

    private void campo_cedulavalidateEmail(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campo_cedulavalidateEmail
        JTextField temporal = (JTextField) evt.getSource();
        String texto = temporal.getText();

        int cont = 0;
        int contPuntos = 0;
        for (int i=0; i<texto.length(); i++) {
            if (texto.charAt(i)=='@') {
                cont++;
            }
            if (cont==1 && texto.charAt(i)=='.') {
                contPuntos++;
            }
        }

        if (cont==1 && contPuntos==2) {
            System.out.println("Correo valido.");

            JTextField referencia = new JTextField();
            temporal.setBorder( referencia.getBorder() );
        }else{
            System.out.println("Correo in-valido.");

            Border borderColor = new LineBorder(Color.RED, 1, true);
            Border borderPadding = new EmptyBorder(2,5,2,5);
            Border borderRojo = new CompoundBorder(borderColor, borderPadding);
            temporal.setBorder(borderRojo);
        }
    }//GEN-LAST:event_campo_cedulavalidateEmail

    private void btn_registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarseActionPerformed
        Registrarse ventana = new Registrarse();
        dispose();

    }//GEN-LAST:event_btn_registrarseActionPerformed

    public void initComponents2(){
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Login");
        setIconImage( getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda2.png")) );
        
        Image img_zelda = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda.png"));
        img_zelda = img_zelda.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        etq_logo.setIcon(new ImageIcon(img_zelda));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_registrarse;
    private javax.swing.JTextField campo_cedula;
    private javax.swing.JTextField campo_password;
    private javax.swing.JLabel etq_cedula;
    private javax.swing.JLabel etq_logo;
    private javax.swing.JLabel etq_password;
    private javax.swing.JLabel etq_titulo;
    // End of variables declaration//GEN-END:variables
}
