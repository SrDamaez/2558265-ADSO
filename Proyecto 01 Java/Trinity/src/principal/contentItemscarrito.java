package principal;

import clases.DataBase;
import clases.Productos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class contentItemscarrito extends javax.swing.JPanel {
    
    Productos producto;
    DataBase basedatos;
    String cedula;
    
    public contentItemscarrito() {
        initComponents();
    }

    public contentItemscarrito(Productos producto, DataBase basedatos, String cedula) {
        this.basedatos = basedatos;
        this.producto = producto;
        this.cedula = cedula;
        initComponents();
        initAlternComponents();
        
        btn_eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarDelCarrito();
            }
        });
    }
    
    private void eliminarDelCarrito() {
        boolean eliminado = basedatos.eliminarDelCarrito(producto);

        if (eliminado) {
            String rol = "";

            ResultSet respuesta = this.basedatos.buscarUsuario(cedula);
        
            try {
                rol = (respuesta.getString("rol"));
                System.out.println(rol);
                System.out.println(cedula);

                if (rol.equalsIgnoreCase("Usuario")) {
                    Menu_usuario ventana = new Menu_usuario(basedatos, cedula);
                    ventana.setVisible(true); // Mostrar la nueva ventana
                    this.getTopLevelAncestor().setVisible(false);
                }else{
                    Menu_vendedor ventana = new Menu_vendedor(basedatos, cedula);
                    ventana.setVisible(true); // Mostrar la nueva ventana
                    this.getTopLevelAncestor().setVisible(false);
                }
            } catch (SQLException ex) {
                System.out.println("Error al procesar el resultado: " + ex.getMessage());
            }
        } else {
            // Manejar el caso en que no se pudo eliminar
        }
    }


    
    public void initAlternComponents(){
        String nombreImagen = producto.getUrl_img();
        ClassLoader classLoader = getClass().getClassLoader();
        java.net.URL imgURL = classLoader.getResource("imagenes/" + nombreImagen);

        if (imgURL != null) {
            java.awt.Image img = new javax.swing.ImageIcon(imgURL).getImage();
            img_item.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH)));
        }
        etq_nombreItem.setText(producto.getNombre());
        etq_precio.setText(String.valueOf(producto.getPrecio()));
        etq_descripcionItem.setText(producto.getDescripcion());
    }
      
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img_item = new javax.swing.JLabel();
        etq_nombreItem = new javax.swing.JLabel();
        etq_descripcionItem = new javax.swing.JLabel();
        etq_precio = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_eliminar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(350, 80));

        etq_nombreItem.setText("name_item");

        etq_descripcionItem.setText("description_item");

        etq_precio.setText("price");

        btn_eliminar.setBackground(java.awt.Color.orange);
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_eliminar.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(img_item, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etq_precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_descripcionItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_nombreItem, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etq_nombreItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_eliminar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etq_descripcionItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etq_precio))))
                    .addComponent(img_item, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JLabel etq_descripcionItem;
    private javax.swing.JLabel etq_nombreItem;
    private javax.swing.JLabel etq_precio;
    private javax.swing.JLabel img_item;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    
}
