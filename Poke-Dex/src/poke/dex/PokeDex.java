package poke.dex;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PokeDex extends javax.swing.JFrame {
    
    ConsumoApi consumo = new ConsumoApi();
    JButton botonPokemon;
    private String paginaActual = "https://pokeapi.co/api/v2/pokemon";
    private String paginaAnterior = null;

    public PokeDex() {
        setTitle("PokeDex");
        setResizable(false);
        
        initComponents();
        
        obtenerNombresPokemon(paginaActual);
        getContentPane().setBackground(new Color(0x4E4747));
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etq_tittle = new javax.swing.JLabel();
        scrollBotones = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        Name_pokemon = new javax.swing.JLabel();
        nombre_pokemon = new javax.swing.JLabel();
        label_img = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        label_img2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        etq_tittle.setFont(new java.awt.Font("Bitstream Charter", 2, 36)); // NOI18N
        etq_tittle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/titulo.png"))); // NOI18N

        scrollBotones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollBotones.setForeground(new java.awt.Color(255, 102, 102));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N

        tabla.setBackground(new java.awt.Color(0, 0, 0));
        tabla.setFont(new java.awt.Font("Tlwg Typo", 1, 14)); // NOI18N
        tabla.setForeground(new java.awt.Color(255, 255, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setGridColor(new java.awt.Color(255, 255, 255));
        tabla.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tabla.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabla);

        nombre_pokemon.setBackground(new java.awt.Color(51, 51, 255));
        nombre_pokemon.setFont(new java.awt.Font("Timmana", 2, 36));
        nombre_pokemon.setForeground(new java.awt.Color(255, 255, 255));

        btn_back.setFont(new java.awt.Font("Z003", 1, 18)); // NOI18N
        btn_back.setForeground(new java.awt.Color(0, 0, 0));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_next.setFont(new java.awt.Font("Z003", 1, 18)); // NOI18N
        btn_next.setForeground(new java.awt.Color(0, 0, 0));
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/next.png"))); // NOI18N
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Name_pokemon))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44)
                                                .addComponent(label_img2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49)
                                                .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label_img, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                            .addComponent(nombre_pokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(133, 133, 133)))))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(etq_tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(etq_tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Name_pokemon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombre_pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_img, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_img2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_next, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scrollBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        scrollBotones.getAccessibleContext().setAccessibleParent(scrollBotones);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void obtenerNombresPokemon(String endpoint) {
        // Llamada a la API de PokeAPI para obtener los nombres de los Pokémon
        String response = consumo.consumoGET(endpoint, new HashMap<>());

        if (response != null) {
            // Procesar la respuesta JSON
            JsonElement element = JsonParser.parseString(response);
            if (element.isJsonObject()) {
                JsonObject jsonObject = element.getAsJsonObject();
                JsonArray results = jsonObject.getAsJsonArray("results");

                // Crea un JPanel para organizar los botones verticalmente
                JPanel panelBotones = new JPanel();
                panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS)); // Disposición vertical
                
                JsonElement nextElement = jsonObject.get("next");
                JsonElement previousElement = jsonObject.get("previous");
                if (nextElement != null && !nextElement.isJsonNull()) {
                    paginaActual = nextElement.getAsString();
                }
                if (previousElement != null && !previousElement.isJsonNull()) {
                    paginaAnterior = previousElement.getAsString();
                } else {
                    paginaAnterior = null; // Si no hay página anterior, la establecemos como null
                }
                
                for (JsonElement result : results) {

                    JsonObject pokemon = result.getAsJsonObject();
                    String name = pokemon.get("name").getAsString();
                    String url = pokemon.get("url").getAsString();
                    
                    // Crea un botón con el nombre del Pokémon
                    botonPokemon = new JButton(name);
                    botonPokemon.setBackground(new Color(0xFFFFFF));
                    botonPokemon.setForeground(new Color ( 0x000000));
                    botonPokemon.setFont(new Font("Timmana", Font.LAYOUT_LEFT_TO_RIGHT, 16));
                    botonPokemon.setBorderPainted(false);
                    botonPokemon.setFocusPainted(false);
                    
                    
                    // Establece el ancho fijo del botón
                    botonPokemon.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinea el botón al centro
                    botonPokemon.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonPokemon.getMinimumSize().height));                    
                    // Agrega un ActionListener para mostrar la imagen al presionar el botón
                    botonPokemon.addActionListener((ActionEvent e) -> {
                        mostrarImagenPokemon(url,name);
                        mostrarHabilidades(url);
                    });

                    // Agrega el botón al JPanel
                    panelBotones.add(botonPokemon);
                    
                }
                                          
                // Añade el JScrollPane al ScrollPane original
                scrollBotones.add(panelBotones);
                
                JsonObject firstPokemon = results.get(0).getAsJsonObject();
                String firstPokemonUrl = firstPokemon.get("url").getAsString();
                String firstName = firstPokemon.get("name").getAsString();
                mostrarImagenPokemon(firstPokemonUrl, firstName);
                mostrarHabilidades(firstPokemonUrl);
            }
        }
    }
    
    private void mostrarHabilidades(String url) {
        String response = consumo.consumoGET(url, new HashMap<>());
        if (response != null) {
            JsonElement element = JsonParser.parseString(response);

            if (element.isJsonObject()) {
                JsonObject jsonObject = element.getAsJsonObject();
                JsonArray abilitiesArray = jsonObject.getAsJsonArray("abilities");
                int i = 1;
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("N"); // Agrega columna de número
                model.addColumn("Habilidad"); // Agrega columna de nombre
                model.addColumn("URL"); // Agrega columna de URL
                for (JsonElement abilityElement : abilitiesArray) {

                    JsonObject abilityObject = abilityElement.getAsJsonObject();
                    String habilidadName = abilityObject.getAsJsonObject("ability").get("name").getAsString();
                    String habilidadUrl = abilityObject.getAsJsonObject("ability").get("url").getAsString();
                    model.addRow(new Object[]{i, habilidadName, habilidadUrl});
                    i++;
                }

                tabla.setModel(model);
            }
        }
    }

    
    private void mostrarImagenPokemon(String url, String name) {
        // Llamada a la API de PokeAPI para obtener los detalles del Pokémon
        String response = consumo.consumoGET(url, new HashMap<>());

        if (response != null) {
            // Procesar la respuesta JSON
            JsonElement element = JsonParser.parseString(response);
            if (element.isJsonObject()) {
                JsonObject jsonObject = element.getAsJsonObject();
                
                String imageUrl = jsonObject.getAsJsonObject("sprites").getAsJsonObject("other").getAsJsonObject("home").get("front_default").getAsString();
                String imageUrl2= jsonObject.getAsJsonObject("sprites").getAsJsonObject("other").getAsJsonObject("official-artwork").get("front_shiny").getAsString();

                // Cargar y mostrar la imagen del Pokémon
                try {
                    URL imgUrl = new URL(imageUrl);
                    Image img = ImageIO.read(imgUrl);
                    ImageIcon icon = new ImageIcon(img);
                    
                    URL imgUrl2 = new URL(imageUrl2);
                    Image img2 = ImageIO.read(imgUrl2);
                    ImageIcon icon2 = new ImageIcon(img2);
                    
                    Image newImg = icon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
                    Image newImg2 = icon2.getImage().getScaledInstance(140, 160, Image.SCALE_DEFAULT);
                    
                    label_img.setIcon(new ImageIcon(newImg));
                    label_img2.setIcon(new ImageIcon(newImg2));
                    
                    String nombre_poke = name;
                    nombre_pokemon.setText(nombre_poke);
                    nombre_pokemon.setHorizontalAlignment(SwingConstants.CENTER);
                    
                } catch (IOException e) {
                }
            }
        }
    }
    
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
         if (paginaAnterior != null) {
            obtenerNombresPokemon(paginaAnterior);
        }     
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        obtenerNombresPokemon(paginaActual);
    }//GEN-LAST:event_btn_nextActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new PokeDex().setVisible(true);
        });
    }
    
    
    


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Name_pokemon;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_next;
    public javax.swing.JLabel etq_tittle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_img;
    private javax.swing.JLabel label_img2;
    private javax.swing.JLabel nombre_pokemon;
    private java.awt.ScrollPane scrollBotones;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
