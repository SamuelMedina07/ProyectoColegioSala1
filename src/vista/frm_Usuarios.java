/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import javax.swing.JTextField;

public class frm_Usuarios extends javax.swing.JDialog {

    /**
     * Creates new form frm_Clientes
     */
     
    String usuario;
    
    
    
    public frm_Usuarios(java.awt.Frame parent, boolean modal, String user) {
        super(parent, modal);
        initComponents();
        lblUsuario.setText(user);
    }
    
    public void AsignarColorCampo(JTextField campo){
        //Color colorResaltado = new Color(219, 52, 52);
        Color color = new Color(241,250,255);
        campo.setBackground(color);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_usuarios = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbUsuarios = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        txtVerificarContra = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        txtContra1 = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnOpciones = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLeer = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jlbLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 250, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 130, 90));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(241, 250, 255), 2, true), "Resultado de Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(241, 250, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_usuarios.setBackground(new java.awt.Color(241, 250, 255));
        tbl_usuarios.setForeground(new java.awt.Color(241, 250, 255));
        tbl_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "USUARIO", "ROL"
            }
        ));
        jScrollPane2.setViewportView(tbl_usuarios);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 460, 150));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 530, 180));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 130, 90));
        jLabel8.setText("Usuario en Linea:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 100, -1));

        lblUsuario.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(236, 28, 36));
        lblUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 1, true));
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 80, 14));

        jPanel6.setBackground(new java.awt.Color(241, 250, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true), "Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(0, 130, 90))); // NOI18N
        jPanel6.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 130, 90));
        jLabel6.setText("NOMBRE");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(20, 60, 53, 14);

        txtNombre1.setBackground(new java.awt.Color(241, 250, 255));
        txtNombre1.setBorder(null);
        txtNombre1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombre1MouseClicked(evt);
            }
        });
        txtNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre1ActionPerformed(evt);
            }
        });
        jPanel6.add(txtNombre1);
        txtNombre1.setBounds(80, 50, 170, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 130, 90));
        jLabel7.setText("ROL");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(20, 200, 25, 14);

        cbUsuarios.setBackground(new java.awt.Color(241, 250, 255));
        cbUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "PROFESOR" }));
        cbUsuarios.setBorder(null);
        jPanel6.add(cbUsuarios);
        cbUsuarios.setBounds(90, 190, 160, 30);

        btnBuscar.setBackground(new java.awt.Color(241, 250, 255));
        btnBuscar.setForeground(new java.awt.Color(0, 130, 90));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 1, true));
        jPanel6.add(btnBuscar);
        btnBuscar.setBounds(260, 10, 80, 30);

        txtVerificarContra.setBackground(new java.awt.Color(241, 250, 255));
        txtVerificarContra.setBorder(null);
        txtVerificarContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtVerificarContraMouseClicked(evt);
            }
        });
        jPanel6.add(txtVerificarContra);
        txtVerificarContra.setBounds(110, 140, 140, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 130, 90));
        jLabel11.setText("CONTRASEÑA");
        jPanel6.add(jLabel11);
        jLabel11.setBounds(20, 160, 84, 14);

        txtContra1.setBackground(new java.awt.Color(241, 250, 255));
        txtContra1.setBorder(null);
        txtContra1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtContra1MouseClicked(evt);
            }
        });
        jPanel6.add(txtContra1);
        txtContra1.setBounds(110, 100, 140, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 130, 90));
        jLabel12.setText("CONTRASEÑA");
        jPanel6.add(jLabel12);
        jLabel12.setBounds(20, 110, 84, 14);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 130, 90));
        jLabel13.setText("VERIFICAR");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(20, 150, 63, 10);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 130, 90));
        jLabel9.setText("CODIGO");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(80, 20, 51, 14);

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(241, 250, 255));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel6.add(txtCodigo);
        txtCodigo.setBounds(140, 10, 120, 29);
        jPanel6.add(jSeparator1);
        jSeparator1.setBounds(20, 80, 230, 2);
        jPanel6.add(jSeparator2);
        jSeparator2.setBounds(20, 130, 230, 10);
        jPanel6.add(jSeparator3);
        jSeparator3.setBounds(20, 178, 230, 2);

        btnOpciones.setBackground(new java.awt.Color(241, 250, 255));
        btnOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Selector.png"))); // NOI18N
        btnOpciones.setText("Opciones");
        btnOpciones.setBorder(null);
        btnOpciones.setBorderPainted(false);
        btnOpciones.setFocusPainted(false);
        btnOpciones.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SelectorOn.png"))); // NOI18N
        btnOpciones.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SelectorOn.png"))); // NOI18N
        btnOpciones.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SelectorOn.png"))); // NOI18N
        btnOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOpcionesMouseClicked(evt);
            }
        });
        btnOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionesActionPerformed(evt);
            }
        });
        jPanel6.add(btnOpciones);
        btnOpciones.setBounds(380, 20, 110, 32);

        btnAgregar.setBackground(new java.awt.Color(241, 250, 255));
        btnAgregar.setForeground(new java.awt.Color(0, 130, 90));
        btnAgregar.setText("AGREGAR");
        btnAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel6.add(btnAgregar);
        btnAgregar.setBounds(550, 110, 95, 20);

        btnCancelar.setBackground(new java.awt.Color(241, 250, 255));
        btnCancelar.setForeground(new java.awt.Color(0, 130, 90));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancelar);
        btnCancelar.setBounds(670, 150, 95, 20);

        btnCrear.setBackground(new java.awt.Color(241, 250, 255));
        btnCrear.setForeground(new java.awt.Color(0, 130, 90));
        btnCrear.setText("CREAR");
        btnCrear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        jPanel6.add(btnCrear);
        btnCrear.setBounds(550, 150, 95, 20);

        btnLimpiar.setBackground(new java.awt.Color(241, 250, 255));
        btnLimpiar.setForeground(new java.awt.Color(0, 130, 90));
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel6.add(btnLimpiar);
        btnLimpiar.setBounds(670, 110, 95, 20);

        btnEliminar.setBackground(new java.awt.Color(241, 250, 255));
        btnEliminar.setForeground(new java.awt.Color(0, 130, 90));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel6.add(btnEliminar);
        btnEliminar.setBounds(670, 70, 95, 20);

        btnLeer.setBackground(new java.awt.Color(241, 250, 255));
        btnLeer.setForeground(new java.awt.Color(0, 130, 90));
        btnLeer.setText("LEER");
        btnLeer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btnLeer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel6.add(btnLeer);
        btnLeer.setBounds(550, 70, 95, 20);

        btnModificar.setBackground(new java.awt.Color(241, 250, 255));
        btnModificar.setForeground(new java.awt.Color(0, 130, 90));
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        jPanel6.add(btnModificar);
        btnModificar.setBounds(550, 190, 95, 20);

        btnSalir.setBackground(new java.awt.Color(241, 250, 255));
        btnSalir.setForeground(new java.awt.Color(0, 130, 90));
        btnSalir.setText("SALIR");
        btnSalir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel6.add(btnSalir);
        btnSalir.setBounds(670, 190, 95, 20);

        jlbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoBosquesSinFondo.png"))); // NOI18N
        jlbLogo.setText("jLabel1");
        jPanel6.add(jlbLogo);
        jlbLogo.setBounds(290, 60, 220, 160);

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 770, 232));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombre1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombre1MouseClicked
        // TODO add your handling code here:
        AsignarColorCampo(txtNombre1);
    }//GEN-LAST:event_txtNombre1MouseClicked

    private void txtContra1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContra1MouseClicked
        // TODO add your handling code here:
        AsignarColorCampo(txtContra1);
    }//GEN-LAST:event_txtContra1MouseClicked

    private void txtVerificarContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVerificarContraMouseClicked
        // TODO add your handling code here:
        AsignarColorCampo(txtVerificarContra);
    }//GEN-LAST:event_txtVerificarContraMouseClicked

    private void btnOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionesActionPerformed
        // TODO add your handling code here:
    
        
    }//GEN-LAST:event_btnOpcionesActionPerformed

    private void btnOpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpcionesMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btnOpcionesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_Usuarios dialog = new frm_Usuarios(new javax.swing.JFrame(), true,"AMMC");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCrear;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLeer;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnOpciones;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cbUsuarios;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JLabel jlbLogo;
    public javax.swing.JLabel lblUsuario;
    public javax.swing.JTable tbl_usuarios;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JPasswordField txtContra1;
    public javax.swing.JTextField txtNombre1;
    public javax.swing.JPasswordField txtVerificarContra;
    // End of variables declaration//GEN-END:variables
}
