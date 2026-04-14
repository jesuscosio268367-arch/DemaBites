package com.mycompany.demabitespresentacion;

import com.mycompany.demabitesdtos.ReporteClientesDTO;
import control.ReportesControl;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utileria.utilMetodos;

/**
 * Interfaz grafica para generar y añadir paramatres de filtrado a los reportes.
 * @author Dario
 */
public class FrameReportes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrameReportes.class.getName());
    
    private final ReportesControl control;
    private PanelFiltroClientes pnlClientes;
    private PanelFiltroComandas pnlComandas;

    /**
     * Contructor del frame.
     */
    public FrameReportes() {
        initComponents();
        this.control = new ReportesControl();
        MenuHeader header = new MenuHeader();
        utilMetodos.insertarPanel(pnlHeader2, header);
        pnlDinamico.setLayout(new BorderLayout());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal2 = new javax.swing.JPanel();
        pnlHeader2 = new javax.swing.JPanel();
        lbl15 = new javax.swing.JLabel();
        pnlReportes = new javax.swing.JPanel();
        lbl16 = new javax.swing.JLabel();
        lbl17 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        cbxOpcion = new javax.swing.JComboBox<>();
        pnlDinamico = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal2.setBackground(new java.awt.Color(254, 255, 234));

        pnlHeader2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlHeader2Layout = new javax.swing.GroupLayout(pnlHeader2);
        pnlHeader2.setLayout(pnlHeader2Layout);
        pnlHeader2Layout.setHorizontalGroup(
            pnlHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1219, Short.MAX_VALUE)
        );
        pnlHeader2Layout.setVerticalGroup(
            pnlHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );

        lbl15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 32)); // NOI18N
        lbl15.setForeground(new java.awt.Color(52, 59, 27));
        lbl15.setText("Reportes");

        lbl16.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl16.setText("Elija una opción:");

        lbl17.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl17.setForeground(new java.awt.Color(52, 59, 27));
        lbl17.setText("Generar Reporte");

        btnGenerar.setBackground(new java.awt.Color(47, 65, 86));
        btnGenerar.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(this::btnGenerarActionPerformed);

        cbxOpcion.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cbxOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "Comandas", "Clientes" }));
        cbxOpcion.addActionListener(this::cbxOpcionActionPerformed);

        javax.swing.GroupLayout pnlDinamicoLayout = new javax.swing.GroupLayout(pnlDinamico);
        pnlDinamico.setLayout(pnlDinamicoLayout);
        pnlDinamicoLayout.setHorizontalGroup(
            pnlDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlDinamicoLayout.setVerticalGroup(
            pnlDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlReportesLayout = new javax.swing.GroupLayout(pnlReportes);
        pnlReportes.setLayout(pnlReportesLayout);
        pnlReportesLayout.setHorizontalGroup(
            pnlReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReportesLayout.createSequentialGroup()
                .addGroup(pnlReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReportesLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lbl16)
                        .addGap(18, 18, 18)
                        .addComponent(cbxOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlReportesLayout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(btnGenerar)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addComponent(pnlDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlReportesLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lbl17)
                    .addContainerGap(470, Short.MAX_VALUE)))
        );
        pnlReportesLayout.setVerticalGroup(
            pnlReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReportesLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(pnlReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl16)
                    .addComponent(cbxOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerar)
                .addGap(22, 22, 22))
            .addGroup(pnlReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlReportesLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(lbl17)
                    .addContainerGap(293, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlPrincipal2Layout = new javax.swing.GroupLayout(pnlPrincipal2);
        pnlPrincipal2.setLayout(pnlPrincipal2Layout);
        pnlPrincipal2Layout.setHorizontalGroup(
            pnlPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipal2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlPrincipal2Layout.createSequentialGroup()
                .addGroup(pnlPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipal2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbl15))
                    .addGroup(pnlPrincipal2Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(pnlReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipal2Layout.setVerticalGroup(
            pnlPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipal2Layout.createSequentialGroup()
                .addComponent(pnlHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ejecuta el metodo de generacion de reportes
     * @param evt 
     */
    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        generar();
    }//GEN-LAST:event_btnGenerarActionPerformed

    /**
     * Logica para cambiar el panel al seleccionar algo en el combobox.
     * @param evt El evento.
     */
    private void cbxOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOpcionActionPerformed
        String seleccion = cbxOpcion.getSelectedItem().toString();
        pnlDinamico.removeAll();
    
        if (seleccion.equals("Comandas")) {
           pnlComandas = new PanelFiltroComandas();
           cambiarPanelFiltro(pnlComandas);
        } else if (seleccion.equals("Clientes")) {
            pnlClientes = new PanelFiltroClientes();
            cambiarPanelFiltro(pnlClientes);
        }
            pnlDinamico.revalidate();
            pnlDinamico.repaint();
    }//GEN-LAST:event_cbxOpcionActionPerformed

    /**
     * Logica para rellenar el panel.
     * @param panelNuevo El panel que se rellenara.
     */
    private void cambiarPanelFiltro(JPanel panelNuevo) {
        pnlDinamico.removeAll(); 
        pnlDinamico.add(panelNuevo, BorderLayout.CENTER);
        pnlDinamico.revalidate();
        pnlDinamico.repaint();
    }
    
    /**
     * Metodo para generar y filtrar reportes.
     */
    private void generar() {
        String seleccion = cbxOpcion.getSelectedItem().toString();
        if (seleccion.equals("Clientes") && pnlClientes != null) {
            String nombre = pnlClientes.getNombre();
            Integer visitas = pnlClientes.getVisitas();
            try {
                List<ReporteClientesDTO> lista = control.consultarReporte(nombre, visitas, this);
                FrameReportesClientes tablaFrame = new FrameReportesClientes();
                tablaFrame.cargarDatos(lista);
                tablaFrame.setVisible(true);
                tablaFrame.setLocationRelativeTo(null);
                this.dispose(); 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al generar reporte: " + e.getMessage());
            }
        } 
        else if (seleccion.equals("Comandas")) {
            JOptionPane.showMessageDialog(this, "Reporte de comandas no implementado.");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JComboBox<String> cbxOpcion;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl13;
    private javax.swing.JLabel lbl14;
    private javax.swing.JLabel lbl15;
    private javax.swing.JLabel lbl16;
    private javax.swing.JLabel lbl17;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JPanel pnlDinamico;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlForm1;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlHeader1;
    private javax.swing.JPanel pnlHeader2;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlPrincipal1;
    private javax.swing.JPanel pnlPrincipal2;
    private javax.swing.JPanel pnlReportes;
    private javax.swing.JTextField txtAMaterno;
    private javax.swing.JTextField txtAMaterno1;
    private javax.swing.JTextField txtAPaterno;
    private javax.swing.JTextField txtAPaterno1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNombres1;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefono1;
    // End of variables declaration//GEN-END:variables
}
