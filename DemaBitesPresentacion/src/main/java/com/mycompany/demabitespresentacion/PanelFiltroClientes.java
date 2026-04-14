package com.mycompany.demabitespresentacion;

/**
 * Panel de filtro para crear reportes de clientes.
 * @author Dario
 */
public class PanelFiltroClientes extends javax.swing.JPanel {

    /**
     * Constructor del panel.
     */
    public PanelFiltroClientes() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl18 = new javax.swing.JLabel();
        lbl19 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtVisitas = new javax.swing.JTextField();

        lbl18.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl18.setText("No. de visitas:");

        lbl19.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl19.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        txtVisitas.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtVisitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVisitasKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl18)
                    .addComponent(lbl19))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl19)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl18)
                    .addComponent(txtVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evita que el usuario pueda escribir caracteres que no sean digitos.
     * @param evt Evento del boton.
     */
    private void txtVisitasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVisitasKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtVisitasKeyTyped

    /**
     * Obtiene el nombre del txt.
     * @return El nombre ingresado.
     */
    public String getNombre() {
        return txtNombre.getText().trim();
    }

    /**
     * Obtiene las visitas del txt.
     * @return El numero de visitas ingresado.
     */
    public Integer getVisitas() {
        String visitas = txtVisitas.getText().trim();
        if (visitas.isEmpty()) {
            return null;
        } else {
            try {
                return Integer.valueOf(visitas);
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl18;
    private javax.swing.JLabel lbl19;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtVisitas;
    // End of variables declaration//GEN-END:variables
}
