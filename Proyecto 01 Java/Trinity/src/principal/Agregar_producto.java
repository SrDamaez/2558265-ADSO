
package principal;

import java.awt.Image;
import javax.swing.ImageIcon;
import clases.DataBase;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;

public class Agregar_producto extends javax.swing.JFrame {

    DataBase basedatos;
    private String cedula;
    ImageIcon imagenTemporal;
    
    public Agregar_producto(DataBase basedatos, String cedula) {
        this.basedatos = new DataBase();
        this.cedula = cedula;
        initComponents();
        initComponents2();
        imagenTemporal = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etq_titulo = new javax.swing.JLabel();
        etq_nombre = new javax.swing.JLabel();
        campo_nombre = new javax.swing.JTextField();
        etq_descripcion = new javax.swing.JLabel();
        campo_descripcion = new javax.swing.JTextField();
        etq_cantidad = new javax.swing.JLabel();
        etq_precio = new javax.swing.JLabel();
        campo_precio = new javax.swing.JTextField();
        etq_nombreArchivo = new javax.swing.JLabel();
        campo_archivo = new javax.swing.JTextField();
        btnLoadImage = new javax.swing.JButton();
        panelPreview = new javax.swing.JScrollPane();
        imagenLabel = new javax.swing.JLabel();
        btn_volver = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        campo_cantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etq_titulo.setBackground(new java.awt.Color(0, 0, 0));
        etq_titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etq_titulo.setForeground(java.awt.Color.orange);
        etq_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_titulo.setText("NUEVO PRODUCTO");

        etq_nombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_nombre.setText("NOMBRE");

        campo_nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campo_nombre.setText("---");
        campo_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nombreActionPerformed(evt);
            }
        });
        campo_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campo_nombreKeyReleased(evt);
            }
        });

        etq_descripcion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_descripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_descripcion.setText("DESCRIPCIÒN");

        campo_descripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campo_descripcion.setText("---");
        campo_descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campo_descripcionKeyReleased(evt);
            }
        });

        etq_cantidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_cantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_cantidad.setText("CANTIDAD");

        etq_precio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_precio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_precio.setText("PRECIO");

        campo_precio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campo_precio.setText("---");
        campo_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campo_precioKeyReleased(evt);
            }
        });

        etq_nombreArchivo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_nombreArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_nombreArchivo.setText("NOMBRE ARCHIVO");

        campo_archivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campo_archivo.setText("---");
        campo_archivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campo_archivoKeyReleased(evt);
            }
        });

        btnLoadImage.setBackground(java.awt.Color.orange);
        btnLoadImage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoadImage.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadImage.setText("BUSCAR IMAGEN");
        btnLoadImage.setFocusable(false);
        btnLoadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadImageActionPerformed(evt);
            }
        });

        imagenLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelPreview.setViewportView(imagenLabel);

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

        btn_guardar.setBackground(java.awt.Color.orange);
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_guardar.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardar.setText("GUARDAR");
        btn_guardar.setFocusable(false);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        campo_cantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campo_cantidad.setText("---");
        campo_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campo_cantidadKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(campo_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLoadImage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campo_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(etq_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_nombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(etq_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_descripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etq_cantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_precio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_nombreArchivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLoadImage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String descripcion = campo_descripcion.getText();
        String precio = campo_precio.getText();
        String nombre = campo_nombre.getText();
        String cantidad = campo_cantidad.getText();
        String img_archivo = campo_archivo.getText();
       
        boolean respuesta = this.basedatos.insertarProducto(nombre, descripcion, precio, cantidad, img_archivo);

        System.out.println("Registro exitoso!");
        
        try {
            BufferedImage image;
            image = createBufferedImage(imagenTemporal);
            if (image != null) {
                String outputFilePath = "src/imagenes/"+img_archivo;
                ImageIO.write(image, "png", new File(outputFilePath));
                
                System.out.println("La imagen se ha cargado correctamente y se ha guardado en " + outputFilePath);
            } else {
                System.out.println("No se pudo cargar la imagen.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Menu_vendedor ventana = new Menu_vendedor(basedatos, cedula);
        dispose();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        Menu_vendedor ventana = new Menu_vendedor(basedatos, cedula);
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_volverActionPerformed

    private void campo_precioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_precioKeyReleased
        
    }//GEN-LAST:event_campo_precioKeyReleased

    private void campo_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_nombreKeyReleased
        
    }//GEN-LAST:event_campo_nombreKeyReleased

    private void btnLoadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadImageActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Imagen", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int seleccion = fileChooser.showOpenDialog(panelPreview);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String rutaImagen = fileChooser.getSelectedFile().getAbsolutePath();
            imagenTemporal = new ImageIcon(rutaImagen);
            Image imagen = imagenTemporal.getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH);
            imagenTemporal = new ImageIcon(imagen);

            imagenLabel.setIcon(imagenTemporal);
        }
    }//GEN-LAST:event_btnLoadImageActionPerformed
     private BufferedImage createBufferedImage(ImageIcon temporal){
        Image imagen = temporal.getImage();
        
        BufferedImage bufferedImage = new BufferedImage(
            imagen.getWidth(null),
            imagen.getHeight(null),
            BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D bGr = bufferedImage.createGraphics();
        bGr.drawImage(imagen, 0, 0, null);
        bGr.dispose();
        
        return bufferedImage;
     }
    private void campo_descripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_descripcionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_descripcionKeyReleased

    private void campo_archivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_archivoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_archivoKeyReleased

    private void campo_cantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_cantidadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_cantidadKeyReleased

    private void campo_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nombreActionPerformed

    
    public void initComponents2(){
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Nuevo Producto");
        setIconImage( getToolkit().createImage(ClassLoader.getSystemResource("imagenes/zelda2.png")) );
       
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadImage;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JTextField campo_archivo;
    private javax.swing.JTextField campo_cantidad;
    private javax.swing.JTextField campo_descripcion;
    private javax.swing.JTextField campo_nombre;
    private javax.swing.JTextField campo_precio;
    private javax.swing.JLabel etq_cantidad;
    private javax.swing.JLabel etq_descripcion;
    private javax.swing.JLabel etq_nombre;
    private javax.swing.JLabel etq_nombreArchivo;
    private javax.swing.JLabel etq_precio;
    private javax.swing.JLabel etq_titulo;
    private javax.swing.JLabel imagenLabel;
    private javax.swing.JScrollPane panelPreview;
    // End of variables declaration//GEN-END:variables

}
