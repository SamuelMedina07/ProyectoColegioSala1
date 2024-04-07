/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Calificacion;
import modelo.ConsultaAlumnos;
import modelo.ConsultaCalificaciones;
import modelo.ConsultaGrados;
import modelo.ConsultaMaterias;
import modelo.ConsultaPadres;
import modelo.ConsultaProfesor;
import modelo.Grado;
import modelo.Materia;

/**
 *
 * @author ammcp
 */
public class frm_Consulta_Calificaciones extends javax.swing.JDialog {

    private Object datos[] = new Object[10];
    private DefaultTableModel modelo;
    private ConsultaProfesor consultaProfesor= new ConsultaProfesor();
    private ConsultaAlumnos consultaAlumn= new ConsultaAlumnos();
    private ConsultaCalificaciones consultaCalifs= new ConsultaCalificaciones();
    private ConsultaMaterias consMaterias = new ConsultaMaterias();
    private ConsultaGrados consGrados = new ConsultaGrados();
    /**
     * Creates new form frm_Consulta_Producto
     */
    public frm_Consulta_Calificaciones(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        ReajsuteImagen("LogoBosquesSinFondo.png");
        actualizarCombobox();
    }
    
    //Llenar Combobox con los proveedores
    public void llenarComboBoxGrados() {
        // Obtén la lista de todos los proveedores desde la base de datos
        ArrayList<Grado> lista = consGrados.leerTodosGrados();

        // Limpia el ComboBox antes de agregar nuevos elementos
        cbGrado.removeAllItems();

        // Llena el ComboBox con los nombres de los proveedores
        for (Grado grado : lista) {
            cbGrado.addItem(grado);
        }
    }
    
    public void llenarComboBoxMaterias() {
        // Obtén la lista de todos los proveedores desde la base de datos
        ArrayList<Materia> lista = consMaterias.leerTodasMaterias();

        // Limpia el ComboBox antes de agregar nuevos elementos
        cbMaterias.removeAllItems();

        // Llena el ComboBox con los nombres de los proveedores
        for (Materia materia : lista) {
            cbMaterias.addItem(materia);
        }
    }

    //Metodo para ejecutar la accion de llenar el combobox
    public void actualizarCombobox() {
        llenarComboBoxGrados();
        llenarComboBoxMaterias();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlbLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_consulta = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbMaterias = new javax.swing.JComboBox<>();
        btn_buscarPor = new javax.swing.JButton();
        cbGrado = new javax.swing.JComboBox<>();
        cbParcial = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(241, 250, 255));

        jPanel2.setBackground(new java.awt.Color(241, 250, 255));

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 130, 90));
        jLabel3.setText("consulta calificaciones");

        jlbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoBosquesSinFondo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(62, 62, 62)
                .addComponent(jlbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(0, 130, 90));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(241, 250, 255), 2, true), "CALIFICACIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(241, 250, 255))); // NOI18N

        tbl_consulta.setBackground(new java.awt.Color(241, 250, 255));
        tbl_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "ALUMNO", "NOTA", "PROFESOR", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(tbl_consulta);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GRADO");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MATERIA");

        cbMaterias.setBackground(new java.awt.Color(241, 250, 255));

        btn_buscarPor.setBackground(new java.awt.Color(241, 250, 255));
        btn_buscarPor.setForeground(new java.awt.Color(0, 130, 90));
        btn_buscarPor.setText("Buscar");
        btn_buscarPor.setBorder(null);
        btn_buscarPor.setBorderPainted(false);
        btn_buscarPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarPorActionPerformed(evt);
            }
        });

        cbGrado.setBackground(new java.awt.Color(241, 250, 255));

        cbParcial.setBackground(new java.awt.Color(241, 250, 255));
        cbParcial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRIMER PARCIAL", "SEGUNDO PARCIAL", "TERCER PARCIAL", "CUARTO PARCIAL" }));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PARCIAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(btn_buscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarPorActionPerformed
        // TODO add your handling code here:
        consultarCalificaciones();
        
    }//GEN-LAST:event_btn_buscarPorActionPerformed

    public void consultarCalificaciones() {
        Materia materiaSeleccionado = (Materia) cbMaterias.getSelectedItem();
        Grado gradoSeleccionado = (Grado) cbGrado.getSelectedItem();
        String parcial = (String) cbParcial.getSelectedItem();

        manejarResultadoConsulta(consultaCalifs.buscarCalificacionesPorGradoMateriaParcial(gradoSeleccionado.getId(), materiaSeleccionado.getId(),parcial), "No se encontró ningúna calificacion con los parametros especificados.");
    }

    private void manejarResultadoConsulta(ArrayList<Calificacion> calificacionesEncontrados, String mensajeError) {
        if (!calificacionesEncontrados.isEmpty()) {
            llenarTablaConsulta(calificacionesEncontrados);
        } else {
            JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenarTablaConsulta(ArrayList<Calificacion> listaCalifs) {
        modelo = (DefaultTableModel) tbl_consulta.getModel();
        modelo.setRowCount(0);
        for (Calificacion calificaion : listaCalifs) {
            datos[0] = calificaion.getId();
            datos[1] = consultaAlumn.obtenerAlumnoSegunNumCuenta(String.valueOf(calificaion.getNumCuentaAlumno())).getNombreCompleto();
            datos[2] = calificaion.getNota();
            datos[3] = consultaProfesor.obtenerProfesorPorId(calificaion.getIdProfesor()).getNombreCompleto();
            datos[4] = calificaion.getEstado();
            modelo.addRow(datos);
        }
        tbl_consulta.setModel(modelo);
    }
      public void ReajsuteImagen(String nombreImagen)
    {
         ImageIcon imagen;
         Icon icono2;
    
           
           
        imagen = new ImageIcon("src/imagenes/"+nombreImagen);
        icono2 = new ImageIcon(imagen.getImage().getScaledInstance( jlbLogo.getWidth(), jlbLogo.getHeight(),Image.SCALE_DEFAULT));
        jlbLogo.setIcon(icono2); 
        
    }
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
            java.util.logging.Logger.getLogger(frm_Consulta_Calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Consulta_Calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Consulta_Calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Consulta_Calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                frm_Consulta_Calificaciones dialog = new frm_Consulta_Calificaciones(new javax.swing.JDialog(), true);
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
    public javax.swing.JButton btn_buscarPor;
    public javax.swing.JComboBox<Grado> cbGrado;
    public javax.swing.JComboBox<Materia> cbMaterias;
    public javax.swing.JComboBox<String> cbParcial;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel jlbLogo;
    public javax.swing.JTable tbl_consulta;
    // End of variables declaration//GEN-END:variables
}