package principal;

import clases.DataBase;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Menu extends javax.swing.JFrame {

    DataBase basedatos;
    
    public Menu( DataBase basedatos) {
        this.basedatos = basedatos;
        initComponents();
        initComponentAltern();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        etq_carrito = new javax.swing.JLabel();
        etq_logo = new javax.swing.JLabel();
        etq_usuario = new javax.swing.JLabel();
        contentPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etq_carrito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        etq_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        etq_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        contentPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etq_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etq_carrito, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etq_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void initComponentAltern(){
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Menú");
        setIconImage( getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda2.png")) );
        
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
    private javax.swing.JPanel contentPrincipal;
    private javax.swing.JLabel etq_carrito;
    private javax.swing.JLabel etq_logo;
    private javax.swing.JLabel etq_usuario;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
