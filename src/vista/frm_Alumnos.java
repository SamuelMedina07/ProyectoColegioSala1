/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.LabelUI;

public class frm_Alumnos extends javax.swing.JDialog {

    String usuario;
    public String urlImagenDefecto = "src/imagenes/sinPerfil.jpg";

    public frm_Alumnos(java.awt.Frame parent, boolean modal, String user) {
        super(parent, modal);
        initComponents();
        lblUsuario.setText(user);
        cargarImagen(urlImagenDefecto);
    }

    public void cargarImagen(String rutaImagen) {
        // Obtener la URL de la imagen
        File archivoImagen = new File(rutaImagen);
        if (archivoImagen.exists()) {
            // Cargar la imagen en un ImageIcon
            ImageIcon imagenIcono = new ImageIcon(rutaImagen);

            // Escalar la imagen para que se ajuste al tamaño del JLabel
            Image imagenEscalada = imagenIcono.getImage().getScaledInstance(
                    lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);

            // Crear un nuevo ImageIcon con la imagen escalada
            ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada);

            // Establecer el ImageIcon en el JLabel
            lblFoto.setIcon(imagenEscaladaIcono);
        } else {
            System.err.println("Error: No se pudo encontrar la imagen en la ruta especificada: " + rutaImagen);
        }
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
        jLabel7 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtNombres1 = new javax.swing.JTextField();
        txtPadre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        DateNacimiento = new com.toedter.calendar.JDateChooser();
        lblFoto = new javax.swing.JLabel();
        btnSeleccionarFoto = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtGrado = new javax.swing.JTextField();
        btnSeleccionarGrado = new javax.swing.JButton();
        btnSeleccionarPadre = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jlbLogo = new javax.swing.JLabel();
        btnOpciones = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ALUMNOS");

        jPanel1.setBackground(new java.awt.Color(241, 250, 255));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Usuario:");

        lblUsuario.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel6.setBackground(new java.awt.Color(241, 250, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true), "Alumno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(0, 130, 90))); // NOI18N
        jPanel6.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 130, 90));
        jLabel6.setText("NOMBRES");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(20, 110, 61, 14);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 130, 90));
        jLabel7.setText("GENERO");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(20, 200, 50, 20);

        cbGenero.setBackground(new java.awt.Color(241, 250, 255));
        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMENINO" }));
        jPanel6.add(cbGenero);
        cbGenero.setBounds(120, 195, 160, 30);

        btnBuscar.setBackground(new java.awt.Color(241, 250, 255));
        btnBuscar.setForeground(new java.awt.Color(0, 130, 90));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        jPanel6.add(btnBuscar);
        btnBuscar.setBounds(300, 10, 70, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 130, 90));
        jLabel12.setText("NACIMIENTO");
        jPanel6.add(jLabel12);
        jLabel12.setBounds(20, 260, 79, 20);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 130, 90));
        jLabel13.setText("DIRECCION DE VIVIVIENDA ACTUAL");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(50, 330, 220, 20);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 130, 90));
        jLabel9.setText("CODIGO");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(120, 20, 51, 14);

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(241, 250, 255));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel6.add(txtCodigo);
        txtCodigo.setBounds(180, 10, 120, 29);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 130, 90));
        jLabel10.setText("TELEFONO");
        jPanel6.add(jLabel10);
        jLabel10.setBounds(20, 300, 65, 14);

        txtTelefono.setBackground(new java.awt.Color(241, 250, 255));
        txtTelefono.setBorder(null);
        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(504)##-##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefonoMouseClicked(evt);
            }
        });
        jPanel6.add(txtTelefono);
        txtTelefono.setBounds(90, 290, 190, 30);

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
        txtNombres1.setBounds(90, 100, 190, 29);

        txtPadre.setEditable(false);
        txtPadre.setBackground(new java.awt.Color(241, 250, 255));
        txtPadre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPadreMouseClicked(evt);
            }
        });
        txtPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPadreActionPerformed(evt);
            }
        });
        jPanel6.add(txtPadre);
        txtPadre.setBounds(370, 380, 160, 29);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 130, 90));
        jLabel14.setText("ENCARGADO");
        jPanel6.add(jLabel14);
        jLabel14.setBounds(290, 390, 77, 14);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 130, 90));
        jLabel15.setText("FECHA DE  ");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(20, 240, 65, 20);

        DateNacimiento.setBackground(new java.awt.Color(241, 250, 255));
        DateNacimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DateNacimientoMouseClicked(evt);
            }
        });
        jPanel6.add(DateNacimiento);
        DateNacimiento.setBounds(100, 240, 180, 30);

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.add(lblFoto);
        lblFoto.setBounds(300, 230, 120, 130);

        btnSeleccionarFoto.setBackground(new java.awt.Color(241, 250, 255));
        btnSeleccionarFoto.setForeground(new java.awt.Color(0, 130, 90));
        btnSeleccionarFoto.setText("FOTO");
        btnSeleccionarFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        jPanel6.add(btnSeleccionarFoto);
        btnSeleccionarFoto.setBounds(430, 280, 95, 20);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 130, 90));
        jLabel16.setText("APELLIDOS");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(20, 160, 67, 14);

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
        txtApellidos.setBounds(90, 150, 190, 29);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 130, 90));
        jLabel17.setText("GRADO");
        jPanel6.add(jLabel17);
        jLabel17.setBounds(20, 60, 44, 14);

        txtGrado.setEditable(false);
        txtGrado.setBackground(new java.awt.Color(241, 250, 255));
        txtGrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGradoMouseClicked(evt);
            }
        });
        txtGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGradoActionPerformed(evt);
            }
        });
        jPanel6.add(txtGrado);
        txtGrado.setBounds(80, 50, 110, 29);

        btnSeleccionarGrado.setBackground(new java.awt.Color(241, 250, 255));
        btnSeleccionarGrado.setForeground(new java.awt.Color(0, 130, 90));
        btnSeleccionarGrado.setText("SELECCIONAR");
        btnSeleccionarGrado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        jPanel6.add(btnSeleccionarGrado);
        btnSeleccionarGrado.setBounds(195, 55, 92, 20);

        btnSeleccionarPadre.setBackground(new java.awt.Color(241, 250, 255));
        btnSeleccionarPadre.setForeground(new java.awt.Color(0, 130, 90));
        btnSeleccionarPadre.setText("SELECCIONAR");
        btnSeleccionarPadre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        jPanel6.add(btnSeleccionarPadre);
        btnSeleccionarPadre.setBounds(400, 420, 95, 20);

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
        jPanel6.add(jSeparator1);
        jSeparator1.setBounds(20, 130, 230, 0);
        jPanel6.add(jSeparator2);
        jSeparator2.setBounds(20, 130, 260, 20);
        jPanel6.add(jSeparator3);
        jSeparator3.setBounds(20, 180, 260, 20);
        jPanel6.add(jSeparator4);
        jSeparator4.setBounds(20, 320, 260, 30);

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
        jScrollPane1.setBounds(20, 350, 260, 100);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtNombres1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombres1MouseClicked
        // TODO add your handling code here:
        AsignarColorCampo(txtNombres1);
    }//GEN-LAST:event_txtNombres1MouseClicked

    private void txtNombres1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres1ActionPerformed

    private void txtPadreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPadreMouseClicked
        // TODO add your handling code here:
        AsignarColorCampo(txtPadre);
    }//GEN-LAST:event_txtPadreMouseClicked

    private void txtPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPadreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPadreActionPerformed

    private void txtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseClicked
        // TODO add your handling code here:
        AsignarColorCampo(txtTelefono);
    }//GEN-LAST:event_txtTelefonoMouseClicked

    private void txtApellidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosMouseClicked

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtGradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGradoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGradoMouseClicked

    private void txtGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGradoActionPerformed

    private void DateNacimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateNacimientoMouseClicked
        // TODO add your handling code here:
        DateNacimiento.setBackground(Color.WHITE);
    }//GEN-LAST:event_DateNacimientoMouseClicked

    private void btnOpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpcionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcionesMouseClicked

    private void btnOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcionesActionPerformed

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked
        // TODO add your handling code here:
        txtDireccion.setBackground(Color.white);
    }//GEN-LAST:event_txtDireccionMouseClicked

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
            java.util.logging.Logger.getLogger(frm_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                frm_Alumnos dialog = new frm_Alumnos(new javax.swing.JFrame(), true, "AMMC");
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
    public com.toedter.calendar.JDateChooser DateNacimiento;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCrear;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnOpciones;
    public javax.swing.JButton btnSalir;
    public javax.swing.JButton btnSeleccionarFoto;
    public javax.swing.JButton btnSeleccionarGrado;
    public javax.swing.JButton btnSeleccionarPadre;
    public javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    public javax.swing.JLabel jlbLogo;
    public javax.swing.JLabel lblFoto;
    public javax.swing.JLabel lblUsuario;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextArea txtDireccion;
    public javax.swing.JTextField txtGrado;
    public javax.swing.JTextField txtNombres1;
    public javax.swing.JTextField txtPadre;
    public javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
