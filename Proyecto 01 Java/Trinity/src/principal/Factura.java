
package principal;
import clases.DataBase;
import clases.Productos;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Factura extends javax.swing.JFrame {

    DataBase basedatos;
    private String cedula;
    
    public Factura(DataBase basedatos, String cedula) {
        this.cedula = cedula;
        this.basedatos = basedatos;
        initComponents();
        initComponentAltern();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etq_titulo = new javax.swing.JLabel();
        etq_tituloCantidadProductos = new javax.swing.JLabel();
        etq_cantidadTotal = new javax.swing.JLabel();
        etq_tituloListaproductos = new javax.swing.JLabel();
        etq_tituloCantidad = new javax.swing.JLabel();
        etq_producto = new javax.swing.JLabel();
        etq_cantidadProducto = new javax.swing.JLabel();
        etq_titutloTotal = new javax.swing.JLabel();
        etq_valorTotal = new javax.swing.JLabel();
        btn_menu = new javax.swing.JButton();
        etq_logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(414, 598));
        setPreferredSize(new java.awt.Dimension(414, 598));

        etq_titulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_titulo.setText("GRACIAS POR SU COMPRA");

        etq_tituloCantidadProductos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_tituloCantidadProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_tituloCantidadProductos.setText("Cantidad de Productos:");

        etq_cantidadTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_cantidadTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_cantidadTotal.setText("---");

        etq_tituloListaproductos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_tituloListaproductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_tituloListaproductos.setText("Lista Productos");

        etq_tituloCantidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_tituloCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_tituloCantidad.setText("Cantidad");

        etq_producto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_producto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_producto.setText("---");

        etq_cantidadProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_cantidadProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_cantidadProducto.setText("---");

        etq_titutloTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_titutloTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_titutloTotal.setText("TOTAL PAGADO:");

        etq_valorTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_valorTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_valorTotal.setText("---");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(etq_tituloCantidadProductos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etq_cantidadTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(etq_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etq_tituloListaproductos, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                            .addComponent(etq_titutloTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etq_tituloCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 24, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etq_valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etq_cantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(etq_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etq_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_tituloCantidadProductos)
                    .addComponent(etq_cantidadTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_tituloListaproductos)
                    .addComponent(etq_tituloCantidad))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_producto)
                    .addComponent(etq_cantidadProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_titutloTotal)
                    .addComponent(etq_valorTotal))
                .addContainerGap())
        );

        btn_menu.setBackground(java.awt.Color.orange);
        btn_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_menu.setForeground(new java.awt.Color(255, 255, 255));
        btn_menu.setText("Menu");
        btn_menu.setFocusable(false);
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });

        etq_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(etq_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        String rol = "";

        ResultSet respuesta = this.basedatos.buscarUsuario(cedula);

        try {
            System.out.println("DATOS VÁLIDOS");
            rol = (respuesta.getString("rol"));
            System.out.println(rol);

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
    }//GEN-LAST:event_btn_menuActionPerformed
    
    public void initComponentAltern(){
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Carrito");
        setIconImage( getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda2.png")) );
        
       
        
        Image img_zelda2 = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda.png"));
        img_zelda2 = img_zelda2.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        etq_logo.setIcon(new ImageIcon(img_zelda2));
                
        
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_menu;
    private javax.swing.JLabel etq_cantidadProducto;
    private javax.swing.JLabel etq_cantidadTotal;
    private javax.swing.JLabel etq_logo;
    private javax.swing.JLabel etq_producto;
    private javax.swing.JLabel etq_titulo;
    private javax.swing.JLabel etq_tituloCantidad;
    private javax.swing.JLabel etq_tituloCantidadProductos;
    private javax.swing.JLabel etq_tituloListaproductos;
    private javax.swing.JLabel etq_titutloTotal;
    private javax.swing.JLabel etq_valorTotal;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
