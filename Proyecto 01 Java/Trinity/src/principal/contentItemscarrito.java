package principal;

import clases.DataBase;
import clases.Productos;

public class contentItemscarrito extends javax.swing.JPanel {
    
    Productos producto;
    
    public contentItemscarrito() {
        initComponents();
    }

    public contentItemscarrito(Productos producto, DataBase basedatos) {
        this.producto = producto;
        initComponents();
        initAlternComponents();
    }
    
    public void initAlternComponents(){
        img_item.setText( this.producto.getUrl_img() );
        etq_nombreItem.setText( this.producto.getNombre() );
        etq_precio.setText( this.producto.getPrecio() );
        etq_descripcionItem.setText( this.producto.getDescripcion());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img_item = new javax.swing.JLabel();
        etq_nombreItem = new javax.swing.JLabel();
        etq_descripcionItem = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JButton();
        etq_precio = new javax.swing.JLabel();
        spinn_cantidad = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();

        setMinimumSize(new java.awt.Dimension(350, 80));

        img_item.setText("img_item");

        etq_nombreItem.setText("name_item");

        etq_descripcionItem.setText("description_item");

        btn_eliminar.setBackground(java.awt.Color.orange);
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_eliminar.setText("Añadir");

        etq_precio.setText("price");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spinn_cantidad))
                .addGap(0, 0, 0))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(spinn_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(etq_nombreItem)
                                .addGap(27, 27, 27)
                                .addComponent(etq_precio))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(img_item, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(etq_descripcionItem)))
                        .addGap(0, 0, 0)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JLabel etq_descripcionItem;
    private javax.swing.JLabel etq_nombreItem;
    private javax.swing.JLabel etq_precio;
    private javax.swing.JLabel img_item;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner spinn_cantidad;
    // End of variables declaration//GEN-END:variables
}
