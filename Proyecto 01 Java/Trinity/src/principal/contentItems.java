package principal;

import principal.Carrito;
import clases.DataBase;
import clases.Productos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class contentItems extends javax.swing.JPanel {
    
    Productos producto;
    DataBase basedatos;
    String cedula;
    
    public contentItems() {
        initComponents();
    }

    public contentItems(Productos producto, DataBase basedatos, String cedula) {
        this.basedatos = basedatos;
        this.producto = producto;
        this.cedula = cedula;
        initComponents();
        initAlternComponents();
        
        btn_añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAlCarrito();
            }
        });
    }
    
    private void agregarAlCarrito() {
        basedatos.agregarAlCarrito(producto);
        
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
        etq_descripcionItem.setText(producto.getDescripcion());
        etq_precio.setText(producto.getPrecio());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img_item = new javax.swing.JLabel();
        etq_nombreItem = new javax.swing.JLabel();
        etq_descripcionItem = new javax.swing.JLabel();
        etq_precio = new javax.swing.JLabel();
        btn_añadir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setMinimumSize(new java.awt.Dimension(350, 80));

        etq_nombreItem.setText("name_item");

        etq_descripcionItem.setText("description_item");

        etq_precio.setText("price");

        btn_añadir.setBackground(java.awt.Color.orange);
        btn_añadir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_añadir.setText("Añadir");
        btn_añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(img_item, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etq_descripcionItem, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(etq_nombreItem, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(etq_precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_añadir)
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etq_nombreItem)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_descripcionItem)
                            .addComponent(btn_añadir))
                        .addGap(3, 3, 3)
                        .addComponent(etq_precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(img_item, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirActionPerformed
        // Encuentra el JFrame contenedor de este JPanel
        java.awt.Container container = this;
        while (!(container instanceof javax.swing.JFrame) && container.getParent() != null) {
            container = container.getParent();
        }

        if (container instanceof javax.swing.JFrame) {
            javax.swing.JFrame frame = (javax.swing.JFrame) container;
            frame.dispose(); // Cierra el JFrame
        }

        Carrito ventana = new Carrito(basedatos, cedula);
    }//GEN-LAST:event_btn_añadirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadir;
    private javax.swing.JLabel etq_descripcionItem;
    private javax.swing.JLabel etq_nombreItem;
    private javax.swing.JLabel etq_precio;
    private javax.swing.JLabel img_item;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
