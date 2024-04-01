/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import AppPackage.AnimationClass;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.plaf.LabelUI;

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
        Color color = Color.white;
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
        jButton1 = new javax.swing.JButton();
        jlbLogo = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLeer = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 250, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 130, 90));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)), "Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_usuarios.setBackground(new java.awt.Color(241, 250, 255));
        tbl_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "USUARIO", "ROL"
            }
        ));
        jScrollPane2.setViewportView(tbl_usuarios);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 460, 150));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 530, 180));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Usuario:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 56, -1));

        lblUsuario.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 73, 14));

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

        btnBuscar.setText("Buscar");
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
        txtVerificarContra.setBounds(110, 140, 140, 40);

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
        txtCodigo.setBounds(180, 10, 80, 29);
        jPanel6.add(jSeparator1);
        jSeparator1.setBounds(20, 80, 230, 10);
        jPanel6.add(jSeparator2);
        jSeparator2.setBounds(20, 130, 230, 10);
        jPanel6.add(jSeparator3);
        jSeparator3.setBounds(20, 178, 230, 10);

        jButton1.setBackground(new java.awt.Color(241, 250, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Selector.png"))); // NOI18N
        jButton1.setText("Opciones");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SelectorOn.png"))); // NOI18N
        jButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SelectorOn.png"))); // NOI18N
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SelectorOn.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1);
        jButton1.setBounds(380, 20, 110, 32);

        jlbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoBosquesSinFondo.png"))); // NOI18N
        jlbLogo.setText("jLabel1");
        jPanel6.add(jlbLogo);
        jlbLogo.setBounds(290, 60, 220, 160);

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 530, 232));

        btnAgregar.setBackground(new java.awt.Color(241, 250, 255));
        btnAgregar.setForeground(new java.awt.Color(0, 130, 90));
        btnAgregar.setText("AGREGAR");
        btnAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 95, -1));

        btnCancelar.setBackground(new java.awt.Color(241, 250, 255));
        btnCancelar.setForeground(new java.awt.Color(0, 130, 90));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 95, -1));

        btnCrear.setBackground(new java.awt.Color(241, 250, 255));
        btnCrear.setForeground(new java.awt.Color(0, 130, 90));
        btnCrear.setText("CREAR");
        btnCrear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 95, -1));

        btnLimpiar.setBackground(new java.awt.Color(241, 250, 255));
        btnLimpiar.setForeground(new java.awt.Color(0, 130, 90));
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 95, -1));

        btnEliminar.setBackground(new java.awt.Color(241, 250, 255));
        btnEliminar.setForeground(new java.awt.Color(0, 130, 90));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 95, -1));

        btnLeer.setBackground(new java.awt.Color(241, 250, 255));
        btnLeer.setForeground(new java.awt.Color(0, 130, 90));
        btnLeer.setText("LEER");
        btnLeer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        jPanel1.add(btnLeer, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 95, -1));

        btnModificar.setBackground(new java.awt.Color(241, 250, 255));
        btnModificar.setForeground(new java.awt.Color(0, 130, 90));
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 95, -1));

        btnSalir.setBackground(new java.awt.Color(241, 250, 255));
        btnSalir.setForeground(new java.awt.Color(0, 130, 90));
        btnSalir.setText("SALIR");
        btnSalir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 95, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
     
           AnimationClass agregar = new AnimationClass();
           AnimationClass agregarr = new AnimationClass();
        //agregar.jButtonXRight(104, 300, 10, 5, btnAgregar);
        agregar.jButtonXLeft(550, 290, 10, 5,btnLeer);
        agregar.jButtonXLeft(670, 410, 10, 5,btnEliminar);
        jlbLogo.setVisible(false);
       // agregarr.jButtonXLeft(90, 30, 10, 5,btnEliminar);
        
     //   AnimationClass agregarr = new AnimationClass();
       // agregarr.jButtonXLeft(300, 104, 10, 5, btnAgregar);
       // agregarr.jLabelXLeft(300, 120, 10, 5,we);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1MouseClicked

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
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cbUsuarios;
    private javax.swing.JButton jButton1;
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
