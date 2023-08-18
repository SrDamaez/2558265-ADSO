package principal;

import clases.DataBase;
import clases.Productos;

public class contentItems extends javax.swing.JPanel {
    
    Productos producto;
    
    public contentItems() {
        initComponents();
    }

    public contentItems(Productos producto, DataBase basedatos) {
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
        btn_añadir = new javax.swing.JButton();
        etq_precio = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(350, 80));

        img_item.setText("img_item");

        etq_nombreItem.setText("name_item");

        etq_descripcionItem.setText("description_item");

        btn_añadir.setBackground(java.awt.Color.orange);
        btn_añadir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_añadir.setText("Añadir");

        etq_precio.setText("price");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img_item, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etq_precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_descripcionItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_nombreItem, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_añadir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(img_item, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etq_nombreItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etq_descripcionItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etq_precio))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(btn_añadir)
                                .addGap(14, 14, 14))))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadir;
    private javax.swing.JLabel etq_descripcionItem;
    private javax.swing.JLabel etq_nombreItem;
    private javax.swing.JLabel etq_precio;
    private javax.swing.JLabel img_item;
    // End of variables declaration//GEN-END:variables
}
