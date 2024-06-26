/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import modelo.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Samuel
 */
public class frm_Reportes extends javax.swing.JDialog {

    String nombre, sentenciaSQL;
    Connection con = null;
    Conexion conecta;
    /**
     * Creates new form frm_reportes
     */
    public frm_Reportes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
          ReajsuteImagen("LogoBosquesSinFondo.png");
    }
    
    public void conectarBD() {
        conecta = new Conexion();
        con = conecta.getConnection();
    }
    
    public void llamarReporteMateriasPorProfesor() {
        nombre = JOptionPane.showInputDialog("INGRESE EL NOMBRE DEL PROFESOR PARA LA BUSQUEDA");
        generarReporte("reporteMateriasPorProfesor.jasper", "nombreProfesor", nombre);
    }

    public void llamarReporteMateriasPorGrado() {
        nombre = JOptionPane.showInputDialog("INGRESE EL NOMBRE DEL GRADO PARA LA BUSQUEDA");
        generarReporte("reporteMateriasPorGrado.jasper", "nombreGrado", nombre);
    }

    public void llamarReporteAlumnoPorNombre() {
        nombre = JOptionPane.showInputDialog("INGRESE EL NOMBRE COMPLETO DEL ALUMNO PARA LA BUSQUEDA");
        generarReporte("reporteNombreAlumno.jasper", "nombreAlumno", nombre);
    }

    public void llamarReporteProfesorPorNombre() {
        nombre = JOptionPane.showInputDialog("INGRESE EL NOMBRE COMPLETO DEL PROFESOR PARA LA BUSQUEDA");
        generarReporte("reporteProfesorPorNombre.jasper", "nombreProfesor", nombre);
    }
    
    public void llamarReporteAsistenciaPorNombreYFecha() {
        nombre = JOptionPane.showInputDialog("INGRESE EL NOMBRE  DEL ALUMNO PARA LA BUSQUEDA");
        Date fecha = mostrarSelectorFecha(); // Llamar al método para obtener la fecha

        if (fecha != null) { // Verificar si se seleccionó una fecha
            generarReporte("reporteAsistencia.jasper", "nombreAlumno", nombre, "fecha", fecha);
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó ninguna fecha.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void llamarReporteCalificacionesPorAlumnoYMateria() {
        String nombreAlumno = JOptionPane.showInputDialog("INGRESE EL NOMBRE COMPLETO DEL ALUMNO PARA LA BUSQUEDA");
        String nombreMateria = JOptionPane.showInputDialog("INGRESE EL NOMBRE DE LA MATERIA PARA LA BUSQUEDA");

        if (nombreAlumno != null && nombreMateria != null) { // Verificar si se ingresaron ambos nombres
            generarReporte("reporteCalificacionesAlumno.jasper", "nombreAlumno", nombreAlumno, "nombreMateria", nombreMateria);
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del alumno y el nombre de la materia.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void generarReporte(String rutaArchivoJasper, String nombreParametro, Object valorParametro) {
        try {
            conectarBD();
            Map<String, Object> parametros = new HashMap<>();
            parametros.put(nombreParametro, valorParametro);

            URL urlMaestro = getClass().getResource(rutaArchivoJasper);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(urlMaestro);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, con);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("REPORTE DE C.E.B BOSQUES DE JUTUCUMA");
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

            con.close();
        } catch (JRException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
     public Date mostrarSelectorFecha() {
        JDateChooser dateChooser = new JDateChooser(); // Crear un nuevo JDateChooser
        dateChooser.setDateFormatString("dd/MM/yyyy"); // Establecer el formato de fecha
        int opcion = JOptionPane.showConfirmDialog(this, dateChooser, "Seleccionar fecha", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (opcion == JOptionPane.OK_OPTION) {
            return dateChooser.getDate(); // Retornar la fecha seleccionada
        } else {
            return null; // Si el usuario cancela, retornar null
        }
    }

    public void generarReporte(String rutaArchivoJasper, String nombreParametro1, Object valorParametro1, String nombreParametro2, Object valorParametro2) {
        try {
            conectarBD();
            Map<String, Object> parametros = new HashMap<>();
            parametros.put(nombreParametro1, valorParametro1);
            parametros.put(nombreParametro2, valorParametro2);

            URL urlMaestro = getClass().getResource(rutaArchivoJasper);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(urlMaestro);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, con);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("REPORTE DE C.E.B BOSQUES DE JUTUCUMA");
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

            con.close();
        } catch (JRException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        jlbLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTES");

        jPanel1.setBackground(new java.awt.Color(241, 250, 255));

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 130, 90));
        jLabel3.setText("reportes");

        jPanel2.setBackground(new java.awt.Color(0, 130, 90));

        btn_1.setBackground(new java.awt.Color(241, 250, 255));
        btn_1.setForeground(new java.awt.Color(0, 130, 90));
        btn_1.setText("Alumnos por Nombre");
        btn_1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btn_1.setBorderPainted(false);
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });

        btn_2.setBackground(new java.awt.Color(241, 250, 255));
        btn_2.setForeground(new java.awt.Color(0, 130, 90));
        btn_2.setText("Profesores por Nombre");
        btn_2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btn_2.setBorderPainted(false);
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });

        btn_3.setBackground(new java.awt.Color(241, 250, 255));
        btn_3.setForeground(new java.awt.Color(0, 130, 90));
        btn_3.setText("Asistencia por Nombre");
        btn_3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btn_3.setBorderPainted(false);
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });

        btn_4.setBackground(new java.awt.Color(241, 250, 255));
        btn_4.setForeground(new java.awt.Color(0, 130, 90));
        btn_4.setText("Materias por Grado");
        btn_4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btn_4.setBorderPainted(false);
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });

        btn_5.setBackground(new java.awt.Color(241, 250, 255));
        btn_5.setForeground(new java.awt.Color(0, 130, 90));
        btn_5.setText("Materias por Profesor");
        btn_5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btn_5.setBorderPainted(false);
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });

        btn_6.setBackground(new java.awt.Color(241, 250, 255));
        btn_6.setForeground(new java.awt.Color(0, 130, 90));
        btn_6.setText("<html>\n<pre>\nCalificaciones por \n      Alumno\n</pre>\n</html>\n");
        btn_6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 90), 2, true));
        btn_6.setBorderPainted(false);
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jlbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoBosquesSinFondo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        // TODO add your handling code here:
       llamarReporteAlumnoPorNombre();

    }//GEN-LAST:event_btn_1ActionPerformed

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
        // TODO add your handling code here:
        llamarReporteProfesorPorNombre();
    }//GEN-LAST:event_btn_2ActionPerformed

    private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
        // TODO add your handling code here:
        llamarReporteAsistenciaPorNombreYFecha();
    }//GEN-LAST:event_btn_3ActionPerformed

    private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
        // TODO add your handling code here:
        llamarReporteMateriasPorGrado();
    }//GEN-LAST:event_btn_4ActionPerformed

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
        // TODO add your handling code here:
        llamarReporteMateriasPorProfesor();
    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        // TODO add your handling code here:
        llamarReporteCalificacionesPorAlumnoYMateria();
    }//GEN-LAST:event_btn_6ActionPerformed
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
            java.util.logging.Logger.getLogger(frm_Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_Reportes dialog = new frm_Reportes(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton btn_1;
    public javax.swing.JButton btn_2;
    public javax.swing.JButton btn_3;
    public javax.swing.JButton btn_4;
    public javax.swing.JButton btn_5;
    public javax.swing.JButton btn_6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel jlbLogo;
    // End of variables declaration//GEN-END:variables
}
