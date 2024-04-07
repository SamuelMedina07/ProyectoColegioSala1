/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Asistencia;
import modelo.ConsultaAlumnos;
import modelo.ConsultasAsistencia;
import vista.frm_Asistencias;
import vista.frm_Consulta_Alumnos;

/**
 *
 * @author Sarah
 */
public class AsistenciaControlador implements ActionListener {

    private Asistencia asistencia;
    private frm_Asistencias frmAsistencias;
    private ConsultasAsistencia consultaAs;
    private frm_Consulta_Alumnos formConsultaA;
    private ConsultaAlumnos consAlumnos = new ConsultaAlumnos();

    public AsistenciaControlador(Asistencia asistencia, frm_Asistencias frmAsistencias, ConsultasAsistencia consultaAs, frm_Consulta_Alumnos formConsultaA) {
        this.asistencia = asistencia;
        this.frmAsistencias = frmAsistencias;
        this.consultaAs = consultaAs;
        this.formConsultaA = formConsultaA;
        this.formConsultaA = new frm_Consulta_Alumnos(this.frmAsistencias, true);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        inicializarBotonesFormulario();
        inicializarBotonedListener();
    }

    private void inicializarBotonesFormulario() {
        frmAsistencias.btGuardar.addActionListener(this);
        frmAsistencias.btnLimpiar.addActionListener(this);
        frmAsistencias.btnSalir.addActionListener(this);

        frmAsistencias.btnSeleccionarAlumno.addActionListener(this);
    }

    private void inicializarBotonedListener() {
        formConsultaA.btn_buscarPor.addActionListener(this);
        formConsultaA.tbl_consulta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                manejarEventoTablaAlumnos();//
            }
        });
    }

    private void manejarEventoTablaAlumnos() {
        int filaSeleccionada = formConsultaA.tbl_consulta.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) formConsultaA.tbl_consulta.getModel();
        if (filaSeleccionada >= 0) {
            String numCuenta = String.valueOf(model.getValueAt(filaSeleccionada, 0));
            Alumno seleccionado = consAlumnos.obtenerAlumnoSegunNumCuenta(numCuenta);
            if (seleccionado.getEstado().equals("Inactivo")) {
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN ALUMNO ACTIVO.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            frmAsistencias.jtNombre.setText(seleccionado.getNombre());
            formConsultaA.dispose();
        }
    }

    public void guardarAsistencia() {
        if (validarYVerificarAsistencia()) {
            if (consultaAs.crearAsistencia(asistencia)) {
                
                limpiar();

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmAsistencias.btGuardar) {
            guardarAsistencia();
        }
        if (e.getSource() == frmAsistencias.btnLimpiar) {
            limpiar();
        }
        if (e.getSource() == frmAsistencias.btnSeleccionarAlumno) {
            formConsultaA.setVisible(true);
        }
        if (e.getSource() == frmAsistencias.btnSalir) {
            frmAsistencias.dispose();

        }
    }

    private boolean validarYVerificarAsistencia() {
        if (validarCamposNoVacios()) {
            Alumno alumno = consAlumnos.obtenerAlumnoPorNombre(frmAsistencias.jtNombre.getText());
            
            // Validar si al alumno ya se le coloco asistencia.
            if (consultaAs.validarAsistenciaExistente(Integer.parseInt(alumno.getNumCuenta()),frmAsistencias.DateFecha.getDate() )) {
                JOptionPane.showMessageDialog(null, "ya se paso asistencia a este alumno.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            asistencia = new Asistencia();
            asistencia.setNumCuenta(Integer.parseInt(consAlumnos.obtenerAlumnoPorNombre(frmAsistencias.jtNombre.getText()).getNumCuenta()));
            asistencia.setAsistenciaFecha(frmAsistencias.DateFecha.getDate());
            asistencia.setAsistenciaEstado((String) frmAsistencias.jcbasistencia.getSelectedItem());

            // Guardar asistencia en la base de datos o realizar otra operación necesaria
            return true;
        }
        return false;
    }

    private boolean validarCamposNoVacios() {
        boolean camposValidos = true;

        if (frmAsistencias.jtNombre.getText().trim().isEmpty()) {
            resaltarCampoVacio(frmAsistencias.jtNombre);
            camposValidos = false;
        }
        if (frmAsistencias.DateFecha == null) {
            frmAsistencias.DateFecha.setBackground(new Color(219, 52, 52));
            camposValidos = false;
        }
        return camposValidos;
    }

    private void limpiar() {
        frmAsistencias.jtNombre.setText("");
        frmAsistencias.jcbasistencia.setSelectedIndex(0);
        frmAsistencias.DateFecha.setDate(null);
    }

    private void resaltarCampoVacio(JTextField campo) {
       Color colorResaltado = new Color(219, 52, 52);
        campo.setBackground(colorResaltado);
    }

}
