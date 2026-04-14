package com.mycompany.demabitespresentacion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.demabitesdtos.ReporteClientesDTO;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utileria.utilMetodos;


/**
 * Interfaz grafica para la visualizacion y creacion de pdf de reportes.
 * @author Dario
 */
public class FrameReportesClientes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrameReportesClientes.class.getName());

    /**
     * Contructor del frame.
     */
    public FrameReportesClientes() {
        initComponents();
        MenuHeader header = new MenuHeader();
        utilMetodos.insertarPanel(pnlHeader, header);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        pnlTablaRClientes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRClientes = new javax.swing.JTable();
        lbl4 = new javax.swing.JLabel();
        btnExportarPDF = new javax.swing.JButton();

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
        lbl1.setText("Reportes");

        jScrollPane1.setFont(jScrollPane1.getFont().deriveFont(jScrollPane1.getFont().getSize()+20f));

        tblRClientes.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        tblRClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Numero de Visitas", "Total gastado", "Ultima visita"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRClientes.setRowHeight(30);
        jScrollPane1.setViewportView(tblRClientes);

        javax.swing.GroupLayout pnlTablaRClientesLayout = new javax.swing.GroupLayout(pnlTablaRClientes);
        pnlTablaRClientes.setLayout(pnlTablaRClientesLayout);
        pnlTablaRClientesLayout.setHorizontalGroup(
            pnlTablaRClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
        );
        pnlTablaRClientesLayout.setVerticalGroup(
            pnlTablaRClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaRClientesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbl4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl4.setForeground(new java.awt.Color(52, 59, 27));
        lbl4.setText("Reporte de clientes");

        btnExportarPDF.setBackground(new java.awt.Color(47, 65, 86));
        btnExportarPDF.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        btnExportarPDF.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarPDF.setText("Exportar PDF");
        btnExportarPDF.addActionListener(this::btnExportarPDFActionPerformed);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExportarPDF)
                    .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbl1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlTablaRClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl1)
                .addGap(18, 18, 18)
                .addComponent(lbl4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTablaRClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnExportarPDF)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ejecuta el metodo pdf.
     * @param evt Evento accion del boton.
     */
    private void btnExportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarPDFActionPerformed
        pdf();
    }//GEN-LAST:event_btnExportarPDFActionPerformed

    /**
     * Llena la tabla con la informacion del DTO.
     * @param lista La lista del DTO que llenara la tabla.
     */
    public void cargarDatos(List<ReporteClientesDTO> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tblRClientes.getModel();
        modelo.setRowCount(0);
        for (ReporteClientesDTO dto : lista) {
            modelo.addRow(new Object[]{
                dto.getNombreCliente(),
                dto.getNumeroVisitas(),
                dto.getTotalGastado(),
                dto.getUltimaVisita()
            });
        }
    }
    
    /**
     * Metodo para convertir la tabla de reportes a pdf.
     */
    public void pdf() {
        try {
            String timestamp = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd_HHmm"));
            String rutaPDF = System.getProperty("user.home") + "/Downloads/Reporte_Clientes_" + timestamp + ".pdf";

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(rutaPDF));
            document.open();

            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLACK);
            Paragraph titulo = new Paragraph("REPORTE DE CLIENTES FRECUENTES", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            document.add(new Paragraph("Fecha de generación: " + java.time.LocalDateTime.now()));
            document.add(new Paragraph(" "));

            int columnas = tblRClientes.getColumnCount();
            PdfPTable tablaPDF = new PdfPTable(columnas);
            tablaPDF.setWidthPercentage(100);

            for (int i = 0; i < columnas; i++) {
                PdfPCell header = new PdfPCell(new Phrase(tblRClientes.getColumnName(i)));
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBackgroundColor(new BaseColor(230, 230, 230));
                header.setPadding(5);
                tablaPDF.addCell(header);
            }

            for (int i = 0; i < tblRClientes.getRowCount(); i++) {
                for (int j = 0; j < columnas; j++) {
                    Object valor = tblRClientes.getValueAt(i, j);
                    tablaPDF.addCell(valor != null ? valor.toString() : "");
                }
            }

            document.add(tablaPDF);
            document.close();
            JOptionPane.showMessageDialog(this, "PDF generado con exito en: \n" + rutaPDF);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al crear PDF: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarPDF;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl4;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlTablaRClientes;
    private javax.swing.JTable tblRClientes;
    // End of variables declaration//GEN-END:variables
}
