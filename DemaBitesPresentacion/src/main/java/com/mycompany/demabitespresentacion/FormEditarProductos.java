package com.mycompany.demabitespresentacion;

import Enums.Tipo;
import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesdtos.IngredienteProductoDTO;
import com.mycompany.demabitesdtos.NuevoProductoActualizadoDTO;
import control.Navegacion;
import control.ProductosControl;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utileria.BusquedaIngredientes;
import utileria.utilMetodos;

/**
 * Interfaz grafica para la creacion de productos y su relacion con ingredientes.
 * @author Dario
 */
public class FormEditarProductos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormEditarProductos.class.getName());
    private byte[] imagenBytes;
    private final ProductosControl control;
    
    /**
     * Contructor del frame.
     */
    public FormEditarProductos(){
        initComponents();
        this.control = new ProductosControl();
        MenuHeader header = new MenuHeader();
        utilMetodos.insertarPanel(pnlHeader, header);
        llenarCombo();
        cargarDatos();
        ocultarColumnaID();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlForm = new javax.swing.JPanel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnAgregarIngrediente = new javax.swing.JButton();
        cmbMedida = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblIngredientes = new javax.swing.JTable();
        lbl8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaDescripcion = new javax.swing.JTextArea();
        lbl9 = new javax.swing.JLabel();
        btnAgregarImagen = new javax.swing.JButton();
        pnlImagen = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBackground(new java.awt.Color(254, 255, 234));

        pnlHeader.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );

        lbl1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 32)); // NOI18N
        lbl1.setForeground(new java.awt.Color(52, 59, 27));
        lbl1.setText("Editar Producto");

        lbl3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl3.setText("Nombre:");

        lbl4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl4.setForeground(new java.awt.Color(52, 59, 27));
        lbl4.setText("Editar Producto");

        lbl5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl5.setText("Precio:");

        lbl6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl6.setText("Tipo:");

        lbl7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl7.setText("Agregar Ingredientes:");

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        txtPrecio.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(47, 65, 86));
        btnActualizar.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnAgregarIngrediente.setBackground(new java.awt.Color(47, 65, 86));
        btnAgregarIngrediente.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        btnAgregarIngrediente.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarIngrediente.setText("Agregar Ingrediente");
        btnAgregarIngrediente.addActionListener(this::btnAgregarIngredienteActionPerformed);

        cmbMedida.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        cmbMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMedida.setEnabled(false);

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        tblIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Unidad de Medida", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIngredientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblIngredientes);

        lbl8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl8.setText("Descripcion:");

        txtaDescripcion.setColumns(20);
        txtaDescripcion.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        txtaDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtaDescripcion);

        lbl9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl9.setText("Imagen:");

        btnAgregarImagen.setBackground(new java.awt.Color(47, 65, 86));
        btnAgregarImagen.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        btnAgregarImagen.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarImagen.setText("Agregar Imagen");
        btnAgregarImagen.addActionListener(this::btnAgregarImagenActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl9)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarImagen)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl9)
                    .addComponent(btnAgregarImagen))
                .addGap(5, 5, 5))
        );

        pnlImagen.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlImagenLayout = new javax.swing.GroupLayout(pnlImagen);
        pnlImagen.setLayout(pnlImagenLayout);
        pnlImagenLayout.setHorizontalGroup(
            pnlImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );
        pnlImagenLayout.setVerticalGroup(
            pnlImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(251, 251, 251))
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPrecio)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                        .addGroup(pnlFormLayout.createSequentialGroup()
                            .addComponent(lbl7)
                            .addGap(18, 18, 18)
                            .addComponent(btnAgregarIngrediente))
                        .addGroup(pnlFormLayout.createSequentialGroup()
                            .addComponent(lbl6)
                            .addGap(18, 18, 18)
                            .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbl5)
                        .addComponent(lbl3)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFormLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lbl4)
                    .addContainerGap(474, Short.MAX_VALUE)))
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lbl3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl6)
                    .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl7)
                    .addComponent(btnAgregarIngrediente))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnActualizar)
                .addContainerGap())
            .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFormLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(lbl4)
                    .addContainerGap(794, Short.MAX_VALUE)))
        );

        jScrollPane2.setViewportView(pnlForm);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbl1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
        }
        if (c == '.' && txtPrecio.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    /**
     * Ejecuta el metodo actualizar.
     * @param evt Evento accion del boton.
     */
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    /**
     * Ejecuta el metodo agregarIngrediente.
     * @param evt Evento accion del boton.
     */
    private void btnAgregarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIngredienteActionPerformed
        agregarIngrediente();
    }//GEN-LAST:event_btnAgregarIngredienteActionPerformed

    /**
     * Ejecuta el metodo agregarImagen.
     * @param evt Evento accion del boton.
     */
    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed
        agregarImagen();
    }//GEN-LAST:event_btnAgregarImagenActionPerformed

    /**
     * Me equivoque de evento aqui no va nada.
     * @param evt .
     */
    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane3MouseClicked

    /**
     * Ejecuta el metodo eliminar ingrediente al clickear dos veces una fila.
     * @param evt Evento de accion del boton.
     */
    private void tblIngredientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIngredientesMouseClicked
        if (evt.getClickCount() == 2) {
            eliminarIngredienteSeleccionado();
        }
    }//GEN-LAST:event_tblIngredientesMouseClicked

    /**
    * Oculta la columna del ID para que no sea visible al usuario pero siga existiendo en el modelo.
    */
    public void ocultarColumnaID() {
         if (tblIngredientes.getColumnCount() > 0) {
             tblIngredientes.getColumnModel().getColumn(0).setMinWidth(0);
             tblIngredientes.getColumnModel().getColumn(0).setMaxWidth(0);
             tblIngredientes.getColumnModel().getColumn(0).setPreferredWidth(0);
         }
    }
    
    /**
     * Se encarga de llenar el combo con los tipos del enumerador.
     */
    private void llenarCombo(){
        cmbMedida.removeAllItems();
        for (Tipo t : Tipo.values()) {
            cmbMedida.addItem(t.name());;
        }
    }
    
    /**
     * Logica para agregar una imagen al panel de imagen y al producto.
     */
    public void agregarImagen(){
        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imagenes (jpg, png, gif)", "jpg", "png", "gif"));
        int resultado = selector.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo = selector.getSelectedFile();
                imagenBytes = java.nio.file.Files.readAllBytes(archivo.toPath());
                ImageIcon iconoOriginal = new ImageIcon(imagenBytes);
                Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                        pnlImagen.getWidth(), pnlImagen.getHeight(), Image.SCALE_SMOOTH);
                JLabel lblPrevia = new JLabel(new ImageIcon(imagenEscalada));
                lblPrevia.setSize(pnlImagen.getWidth(), pnlImagen.getHeight());
                pnlImagen.removeAll();
                pnlImagen.add(lblPrevia);
                pnlImagen.revalidate();
                pnlImagen.repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al cargar la imagen: " + ex.getMessage());
            }
        }
    }
    
    /**
     * Logica para agregar un ingrediente a la tabla de receta del producto.
     */
    public void agregarIngrediente(){
        BuscadorDialog buscador = new BuscadorDialog(null, true, new BusquedaIngredientes());
        buscador.setLocationRelativeTo(this);
        buscador.setVisible(true);
        Object seleccionado = buscador.getObjetoSeleccionado();
        if (seleccionado != null) {
            Ingrediente ing = (Ingrediente) seleccionado;
            DefaultTableModel modeloReceta = (DefaultTableModel) tblIngredientes.getModel();
            for (int i = 0; i < tblIngredientes.getRowCount(); i++) {
                if (tblIngredientes.getValueAt(i, 0).equals(ing.getId())) {
                    JOptionPane.showMessageDialog(this, "El ingrediente " + ing.getNombre() + " ya esta en la lista.");
                    return;
                }
            }
            modeloReceta.addRow(new Object[]{
                ing.getId(),
                ing.getNombre(),
                ing.getUnidad(),
                0.0
            });
        }
    }
    
    /**
     * Carga los datos del producto seleccionado para su visualizacion y su posterior actualizacion.
     */
    private void cargarDatos(){
        Long id = Navegacion.getControlNavegacion().getIdSeleccionado();
        if (id != null) {
            try {
                NuevoProductoActualizadoDTO producto = control.consultarParaEditar(id, this);
                if (producto != null) {
                    txtNombre.setText(producto.getNombre());
                    txtPrecio.setText(String.valueOf(producto.getPrecio()));
                    txtaDescripcion.setText(producto.getDescripcion());
                    if (producto.getTipoProducto() != null) {
                        cmbMedida.setSelectedItem(producto.getTipoProducto().name());
                    }
                    cmbMedida.setEnabled(false);
                    DefaultTableModel modelo = (DefaultTableModel) tblIngredientes.getModel();
                    modelo.setRowCount(0);
                    for (IngredienteProductoDTO ing : producto.getIngredientes()) {
                        modelo.addRow(new Object[]{
                            ing.getIdIngrediente(),
                            ing.getNombre(),
                            ing.getUnidad(),
                            ing.getCantidadRequerida()
                        });
                    }
                    tblIngredientes.revalidate();
                    tblIngredientes.repaint();
                    //Logica para imagen
                    if (producto.getImagenProducto() != null && producto.getImagenProducto().length > 0) {
                        this.imagenBytes = producto.getImagenProducto();
                        ImageIcon iconoOriginal = new ImageIcon(this.imagenBytes);
                        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                                pnlImagen.getWidth(), pnlImagen.getHeight(), Image.SCALE_SMOOTH);
                        JLabel lblPrevia = new JLabel(new ImageIcon(imagenEscalada));
                        lblPrevia.setSize(pnlImagen.getWidth(), pnlImagen.getHeight());
                        pnlImagen.removeAll();
                        pnlImagen.add(lblPrevia);
                        pnlImagen.revalidate();
                        pnlImagen.repaint();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
            }
        }
    }
    
    /**
     * Metodo para actualizar los productos con la llamada al metodo que se conecta con la base de datos,
     * la validacion y organizacion de los datos para realizarlo.
     */
    public void actualizar() {
        if (tblIngredientes.isEditing()) {
            tblIngredientes.getCellEditor().stopCellEditing();
        }
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre del producto es obligatorio.");
            txtNombre.requestFocus();
            return;
        }
        if (txtPrecio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El precio es obligatorio.");
            txtPrecio.requestFocus();
            return;
        }
        if (txtaDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La descripcion es obligatoria.");
            txtaDescripcion.requestFocus();
            return;
        }try {
            Double precio = Double.valueOf(txtPrecio.getText().trim());
            if (precio <= 0) {
                JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0.");
                return;
            }
            if (cmbMedida.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de producto.");
                return;
            }
            String seleccionCombo = cmbMedida.getSelectedItem().toString().toUpperCase();
            Tipo tipoProducto = Tipo.valueOf(seleccionCombo);
            DefaultTableModel modelo = (DefaultTableModel) tblIngredientes.getModel();
            List<IngredienteProductoDTO> receta = new java.util.ArrayList<>();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                Long idIng = (Long) modelo.getValueAt(i, 0);
                Double cant;
                try {
                    cant = Double.valueOf(modelo.getValueAt(i, 3).toString());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Formato invalido: ingresa solo numeros en las cantidades.");
                    return; 
                }
                if (cant <= 0) {
                    JOptionPane.showMessageDialog(this, "La cantidad del ingrediente debe ser mayor a 0.");
                    return;
                }
                receta.add(new IngredienteProductoDTO(idIng, cant));
            }
            NuevoProductoActualizadoDTO productoEditado = new NuevoProductoActualizadoDTO();
            Long idActual = Navegacion.getControlNavegacion().getIdSeleccionado();
            productoEditado.setId(idActual); 
            productoEditado.setNombre(txtNombre.getText().trim());
            productoEditado.setPrecio(precio);
            productoEditado.setDescripcion(txtaDescripcion.getText().trim());
            productoEditado.setImagenProducto(imagenBytes);
            productoEditado.setIngredientes(receta);
            productoEditado.setTipoProducto(tipoProducto);
            control.actualizarProducto(productoEditado, this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en los datos: " + e.getMessage());
        }
    }
    
    /**
     * Elimina un ingrediente que se encuentre en la tabla de ingredientes.
     */
    private void eliminarIngredienteSeleccionado() {
        int fila = tblIngredientes.getSelectedRow();
        if (fila != -1) {
            String nombreIng = tblIngredientes.getValueAt(fila, 1).toString();
            int respuesta = JOptionPane.showConfirmDialog(
                this, 
                "¿Estas seguro de que deseas eliminar el ingrediente '" + nombreIng + "' de la receta?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                DefaultTableModel modelo = (DefaultTableModel) tblIngredientes.getModel();
                modelo.removeRow(fila);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JButton btnAgregarIngrediente;
    private javax.swing.JComboBox<String> cmbMedida;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlImagen;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTable tblIngredientes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextArea txtaDescripcion;
    // End of variables declaration//GEN-END:variables
}
