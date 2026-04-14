package com.mycompany.demabitespresentacion;

import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import control.ClientesControl;
import javax.swing.JOptionPane;
import utileria.utilMetodos;

/**
 * Interfaz grafica para la creacion de Clientes Frecuentes.
 * @author Dario
 */
public class FormClientes extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormClientes.class.getName());
    private final ClientesControl control;
    
    /**
     * Contructor del Frame.
     */
    public FormClientes() {
        initComponents();
        this.control = new ClientesControl();
        MenuHeader header = new MenuHeader();
        utilMetodos.insertarPanel(pnlHeader, header);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtAPaterno = new javax.swing.JTextField();
        txtAMaterno = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();

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
        lbl1.setText("Registar cliente frecuente");

        lbl3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl3.setText("Nombres:");

        lbl4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl4.setForeground(new java.awt.Color(52, 59, 27));
        lbl4.setText("Nuevo Cliente");

        lbl5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl5.setText("Apellido Paterno:");

        lbl6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl6.setText("Apellido Materno:");

        lbl7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl7.setText("Email (Opcional):");

        lbl8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        lbl8.setText("Telefono:");

        txtNombres.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        txtAPaterno.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        txtAMaterno.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        btnRegistrar.setBackground(new java.awt.Color(47, 65, 86));
        btnRegistrar.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl8)
                    .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtAPaterno)
                        .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                        .addComponent(txtAMaterno)
                        .addComponent(txtEmail)
                        .addComponent(lbl7)
                        .addComponent(lbl6)
                        .addComponent(lbl5)
                        .addComponent(lbl3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormLayout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(234, 234, 234))
            .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFormLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lbl4)
                    .addContainerGap(469, Short.MAX_VALUE)))
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lbl3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFormLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(lbl4)
                    .addContainerGap(462, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbl1)))
                .addContainerGap(325, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Gestiona el boton de registrar realizando validaciones y llamando metodos.
     * @param evt Evento de accion del boton.
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtNombres.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio");
            txtNombres.requestFocus();
            return;
        }
        if (txtAPaterno.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El apellido paterno es obligatorio");
            txtAPaterno.requestFocus();
            return;
        }
        if (txtAMaterno.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El apellido materno es obligatorio");
            txtAMaterno.requestFocus();
            return;
        }
        if (!txtEmail.getText().isBlank()) {
            if (!txtEmail.getText().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                JOptionPane.showMessageDialog(this, "El formato del correo no es valido");
                txtNombres.requestFocus();
                return;
            }
        }
        if (txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El telefono es obligatorio");
            txtTelefono.requestFocus();
            return;
        }
        if (!txtTelefono.getText().matches("^[0-9]{10}")) {
            JOptionPane.showMessageDialog(this, "El numero solo debe de tener 10 digitos");
            txtNombres.requestFocus();
            return;
        }

        String nombres = txtNombres.getText();
        String aPaterno = txtAPaterno.getText();
        String aMaterno = txtAMaterno.getText();
        String email = txtEmail.getText();
        String telefono = txtTelefono.getText();

        NuevoClienteFrecuenteDTO nuevoCliente = new NuevoClienteFrecuenteDTO(nombres, aPaterno, aMaterno, email, telefono);
        control.registrarCliente(nuevoCliente, this);
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtAMaterno;
    private javax.swing.JTextField txtAPaterno;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
