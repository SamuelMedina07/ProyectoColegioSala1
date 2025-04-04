/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.LabelUI;

public class frm_Padres extends javax.swing.JDialog {

    /**
     * Creates new form frm_Clientes
     */
    String usuario;

    public frm_Padres(java.awt.Frame parent, boolean modal, String user) {
        super(parent, modal);
        initComponents();
        lblUsuario.setText(user);
    }

    public void AsignarColorCampo(JTextField campo) {
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
        jLabel8 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtIdentidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtNombres1 = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jlbLogo = new javax.swing.JLabel();
        btnOpciones = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PADRES");

        jPanel1.setBackground(new java.awt.Color(241, 250, 255));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 130, 90));
        jLabel8.setText("Usuario en Linea:");

        lblUsuario.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(236, 28, 36));
        lblUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));

        jPanel6.setBackground(new java.awt.Color(241, 250, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true), "Padres", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(0, 130, 90))); // NOI18N
        jPanel6.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 130, 90));
        jLabel6.setText("NOMBRES");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(20, 70, 61, 14);

        txtIdentidad.setBackground(new java.awt.Color(241, 250, 255));
        txtIdentidad.setBorder(null);
        txtIdentidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdentidadMouseClicked(evt);
            }
        });
        txtIdentidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentidadActionPerformed(evt);
            }
        });
        jPanel6.add(txtIdentidad);
        txtIdentidad.setBounds(120, 210, 160, 29);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 130, 90));
        jLabel7.setText("GENERO");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(20, 170, 70, 14);

        cbGenero.setBackground(new java.awt.Color(241, 250, 255));
        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMENINO" }));
        jPanel6.add(cbGenero);
        cbGenero.setBounds(120, 160, 160, 30);

        btnBuscar.setBackground(new java.awt.Color(241, 250, 255));
        btnBuscar.setForeground(new java.awt.Color(0, 130, 90));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        jPanel6.add(btnBuscar);
        btnBuscar.setBounds(270, 10, 80, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 130, 90));
        jLabel11.setText("# IDENTIDAD");
        jPanel6.add(jLabel11);
        jLabel11.setBounds(20, 220, 76, 14);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 130, 90));
        jLabel12.setText("APELLIDOS");
        jPanel6.add(jLabel12);
        jLabel12.setBounds(20, 120, 67, 14);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 130, 90));
        jLabel13.setText("DIRECCION DE VIVIENDA ACTUAL");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(310, 230, 199, 20);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 130, 90));
        jLabel9.setText("CODIGO");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(90, 20, 51, 14);

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(241, 250, 255));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel6.add(txtCodigo);
        txtCodigo.setBounds(150, 10, 120, 29);

        txtDireccion.setBackground(new java.awt.Color(241, 250, 255));
        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDireccionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txtDireccion);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(310, 260, 200, 100);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 130, 90));
        jLabel10.setText("TELEFONO");
        jPanel6.add(jLabel10);
        jLabel10.setBounds(20, 280, 70, 14);

        txtTelefono.setBackground(new java.awt.Color(241, 250, 255));
        txtTelefono.setBorder(null);
        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(504)####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefonoMouseClicked(evt);
            }
        });
        jPanel6.add(txtTelefono);
        txtTelefono.setBounds(90, 270, 190, 30);

        txtNombres1.setBackground(new java.awt.Color(241, 250, 255));
        txtNombres1.setBorder(null);
        txtNombres1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombres1MouseClicked(evt);
            }
        });
        txtNombres1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombres1ActionPerformed(evt);
            }
        });
        jPanel6.add(txtNombres1);
        txtNombres1.setBounds(90, 60, 180, 30);

        txtApellidos.setBackground(new java.awt.Color(241, 250, 255));
        txtApellidos.setBorder(null);
        txtApellidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApellidosMouseClicked(evt);
            }
        });
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel6.add(txtApellidos);
        txtApellidos.setBounds(90, 110, 180, 29);

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
        btnCrear.setBounds(550, 70, 95, 20);

        btnModificar.setBackground(new java.awt.Color(241, 250, 255));
        btnModificar.setForeground(new java.awt.Color(0, 130, 90));
        btnModificar.setText("ACTUALIZAR");
        btnModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        jPanel6.add(btnModificar);
        btnModificar.setBounds(550, 150, 95, 20);

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
        btnSalir.setBounds(610, 190, 95, 20);

        jlbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoBosquesSinFondo.png"))); // NOI18N
        jPanel6.add(jlbLogo);
        jlbLogo.setBounds(290, 50, 220, 160);

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
        btnOpciones.setBounds(390, 10, 90, 32);
        jPanel6.add(jSeparator2);
        jSeparator2.setBounds(20, 140, 250, 2);
        jPanel6.add(jSeparator3);
        jSeparator3.setBounds(20, 240, 260, 20);
        jPanel6.add(jSeparator4);
        jSeparator4.setBounds(20, 300, 260, 10);
        jPanel6.add(jSeparator5);
        jSeparator5.setBounds(20, 90, 250, 10);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator1);
        jSeparator1.setBounds(300, 220, 20, 140);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentidadActionPerformed

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

    private void txtIdentidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdentidadMouseClicked
        // TODO add your handling code here:
        AsignarColorCampo(txtIdentidad);
    }//GEN-LAST:event_txtIdentidadMouseClicked

    private void txtNombres1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombres1MouseClicked
        // TODO add your handling code here:
        AsignarColorCampo(txtNombres1);
    }//GEN-LAST:event_txtNombres1MouseClicked

    private void txtNombres1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres1ActionPerformed

    private void txtApellidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosMouseClicked
        // TODO add your handling code here:
        AsignarColorCampo(txtApellidos);
    }//GEN-LAST:event_txtApellidosMouseClicked

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked
        // TODO add your handling code here:
        txtDireccion.setBackground(Color.white);
    }//GEN-LAST:event_txtDireccionMouseClicked

    private void txtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseClicked
        // TODO add your handling code here:
        AsignarColorCampo(txtTelefono);
    }//GEN-LAST:event_txtTelefonoMouseClicked

    private void btnOpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpcionesMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnOpcionesMouseClicked

    private void btnOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionesActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnOpcionesActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Padres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Padres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Padres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Padres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_Padres dialog = new frm_Padres(new javax.swing.JFrame(), true, "AMMC");
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
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnOpciones;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public javax.swing.JLabel jlbLogo;
    public javax.swing.JLabel lblUsuario;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextArea txtDireccion;
    public javax.swing.JTextField txtIdentidad;
    public javax.swing.JTextField txtNombres1;
    public javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
