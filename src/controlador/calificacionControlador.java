/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Calificacion;
import modelo.ConsultaAlumnos;
import modelo.ConsultaCalificaciones;
import modelo.ConsultaGrados;
import modelo.ConsultaMaterias;
import modelo.ConsultaPadres;
import modelo.ConsultaProfesor;
import modelo.ConsultaUsuarios;
import modelo.Grado;
import modelo.ImageProcessor;
import modelo.Materia;
import modelo.Padre;
import modelo.Profesor;
import modelo.Usuario;
import vista.frm_Alumnos;
import vista.frm_Calificaciones;
import vista.frm_Consulta_Alumnos;
import vista.frm_Consulta_Calificaciones;
import vista.frm_Consulta_Grados;
import vista.frm_Consulta_Padres;

public class calificacionControlador implements ActionListener {

    private Calificacion calificacion;
    private frm_Calificaciones formularioCalificaciones;
    private ConsultaCalificaciones consultaCalificaciones;
    private frm_Consulta_Calificaciones formularioConsulta;
    private Object datos[] = new Object[10];
    private frm_Consulta_Alumnos formularioConsultaAlumnos;
    private ConsultaProfesor consultaProfesor = new ConsultaProfesor();
    private ConsultaGrados consGrados = new ConsultaGrados();
    private ConsultaMaterias consMaterias = new ConsultaMaterias();
    private ConsultaAlumnos consultaAlumnos = new ConsultaAlumnos();
    private ConsultaUsuarios consultaUsuarios = new ConsultaUsuarios();
    private DefaultTableModel modelo;

    public calificacionControlador(Calificacion calificacion, frm_Calificaciones formularioCalificaciones, ConsultaCalificaciones consultaCalificaciones, frm_Consulta_Calificaciones formularioConsulta) {
        this.calificacion = calificacion;
        this.formularioCalificaciones = formularioCalificaciones;
        this.consultaCalificaciones = consultaCalificaciones;
        this.formularioConsulta = formularioConsulta;
        this.formularioConsultaAlumnos = new frm_Consulta_Alumnos(formularioCalificaciones, true);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        inicializarBotonesFormulario();
        inicializarBotonedListener();
        habilitarBotones();
    }

    private void inicializarBotonesFormulario() {
        formularioCalificaciones.btnAgregar.addActionListener(this);
        formularioCalificaciones.btnCancelar.addActionListener(this);
        formularioCalificaciones.btnCrear.addActionListener(this);
        formularioCalificaciones.btnBuscar.addActionListener(this);
        formularioCalificaciones.btnModificar.addActionListener(this);
        formularioCalificaciones.btnEliminar.addActionListener(this);
        formularioCalificaciones.btnLimpiar.addActionListener(this);
        formularioCalificaciones.btnSalir.addActionListener(this);

        formularioCalificaciones.btnSeleccionarAlumno.addActionListener(this);
    }

    private void inicializarBotonedListener() {
        formularioConsulta.btn_buscarPor.addActionListener(this);
        formularioConsulta.tbl_consulta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                manejarEventoTablaCalificacion();
            }
        });
        formularioConsultaAlumnos.btn_buscarPor.addActionListener(this);
        formularioConsultaAlumnos.tbl_consulta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                manejarEventoTablaAlumnos();
            }
        });

    }

    private void manejarEventoTablaAlumnos() {
        int filaSeleccionada = formularioConsultaAlumnos.tbl_consulta.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) formularioConsultaAlumnos.tbl_consulta.getModel();
        if (filaSeleccionada >= 0) {
            String numCuenta = String.valueOf(model.getValueAt(filaSeleccionada, 0));
            Alumno alumnoseleccionado = consultaAlumnos.obtenerAlumnoSegunNumCuenta(numCuenta);

            if (alumnoseleccionado.getEstado().equals("Inactivo")) {
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN ALUMNO ACTIVO.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            formularioCalificaciones.txtAlumno.setText(alumnoseleccionado.getNombreCompleto());
            formularioCalificaciones.txtGrado.setText(consGrados.obtenerGradoSegunId(alumnoseleccionado.getIdGrado()).getNombre());
            llenarComboBoxMaterias(alumnoseleccionado.getIdGrado());
            model.setRowCount(0);
            formularioConsultaAlumnos.dispose();
        }
    }

    public void llenarComboBoxMaterias(int idGrado) {
        // Obtén la lista de todos los proveedores desde la base de datos
        ArrayList<Materia> lista = consMaterias.buscarMateriasPorIdGrado(idGrado);

        // Limpia el ComboBox antes de agregar nuevos elementos
        formularioCalificaciones.cbMaterias.removeAllItems();

        // Llena el ComboBox con los nombres de los proveedores
        for (Materia materia : lista) {
            formularioCalificaciones.cbMaterias.addItem(materia);
        }
    }

    public void manejarEventoTablaCalificacion() {
        int filaSeleccionada = formularioConsulta.tbl_consulta.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) formularioConsulta.tbl_consulta.getModel();
        if (filaSeleccionada >= 0) {
            String idCalificacion = String.valueOf(model.getValueAt(filaSeleccionada, 0));
            Calificacion calificacionSeleccionado = consultaCalificaciones.obtenerCalificacionSegunId(Integer.parseInt(idCalificacion));

            if (calificacionSeleccionado.getEstado().equals("CANCELADA")) {
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN CALIFICACION NO CANCELADA.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            String usuarioActual = formularioCalificaciones.lblUsuario.getText();
            Profesor ProfesorSeleccionado = consultaProfesor.obtenerProfesorPorId(calificacionSeleccionado.getIdProfesor());
            Usuario usuarioProfesorSeleccionado = consultaUsuarios.obtenerUusuarioSegunIdUsuario(ProfesorSeleccionado.getCodigoUsuario());

            if (!usuarioProfesorSeleccionado.getNombre().equals(usuarioActual)) {
                JOptionPane.showMessageDialog(null, "ESTA CALLIFICACION NO PERTENECE AL PROFESOR ACTUAL.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            formularioCalificaciones.txtCodigo.setText(String.valueOf(calificacionSeleccionado.getId()));
            formularioCalificaciones.txtAlumno.setText(consultaAlumnos.obtenerAlumnoSegunNumCuenta(String.valueOf(calificacionSeleccionado.getNumCuentaAlumno())).getNombreCompleto());
            formularioCalificaciones.txtGrado.setText(consGrados.obtenerGradoSegunId(calificacionSeleccionado.getIdGrado()).getNombre());
            seleccionarMateria(consMaterias.obtenerMateriaSegunId(calificacionSeleccionado.getIdMateria()));
            formularioCalificaciones.cbParcial.setSelectedItem(calificacionSeleccionado.getParcial());
            formularioCalificaciones.txtNota.setText(String.valueOf(calificacionSeleccionado.getNota()));
            model.setRowCount(0);
            formularioConsulta.dispose();
        }
    }

    public void seleccionarMateria(Materia _materia) {
        formularioCalificaciones.cbMaterias.removeAllItems();
        formularioCalificaciones.cbMaterias.addItem(_materia);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formularioCalificaciones.btnAgregar) {
            limpiar();
            deshabilitarBotones();
        }
        if (e.getSource() == formularioCalificaciones.btnCancelar) {
            habilitarBotones();
            limpiar();
        }
        if (e.getSource() == formularioCalificaciones.btnCrear) {
            guardarAlumno();
        }
        if (e.getSource() == formularioCalificaciones.btnBuscar) {
            formularioConsulta.setVisible(true);
        }
        if (e.getSource() == formularioCalificaciones.btnModificar) {
            modificarAlumno();
        }
        if (e.getSource() == formularioCalificaciones.btnEliminar) {
            eliminarAlumno();
        }
        if (e.getSource() == formularioCalificaciones.btnSeleccionarAlumno) {
            formularioConsultaAlumnos.setVisible(true);
        }
        if (e.getSource() == formularioCalificaciones.btnLimpiar) {
            limpiar();
        }
        if (e.getSource() == formularioCalificaciones.btnSalir) {
            formularioCalificaciones.dispose();
        }
        //-----
    }

    public void guardarAlumno() {
        if (validarYVerificarCalificacion()) {
            if (consultaCalificaciones.crearCalificacion(calificacion)) {
                limpiar();
                habilitarBotones();
            }
        }
    }

    public void modificarAlumno() {
        if (validarYVerificarCalificacion()) {
            if (consultaCalificaciones.modificarCalificacion(calificacion)) {
                limpiar();
            }
        }
    }

    public void eliminarAlumno() {
        if (!formularioCalificaciones.txtCodigo.getText().isEmpty()) {
            String id = formularioCalificaciones.txtCodigo.getText();
            if (consultaCalificaciones.eliminarCalificacion(Integer.parseInt(id))) {
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA CALIFICACION.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean validarYVerificarCalificacion() {
        if (validarCamposNoVacios()) {

            calificacion.setId(Integer.parseInt(formularioCalificaciones.txtCodigo.getText()));
            Alumno alumno = consultaAlumnos.obtenerAlumnoPorNombre(formularioCalificaciones.txtAlumno.getText());
            calificacion.setNumCuentaAlumno(Integer.parseInt(alumno.getNumCuenta()));
            calificacion.setIdGrado(consGrados.obtenerIdGradoSegunNombre(formularioCalificaciones.txtGrado.getText()));
            Materia materia = (Materia) formularioCalificaciones.cbMaterias.getSelectedItem();
            calificacion.setIdMateria(materia.getId());
            calificacion.setParcial((String) formularioCalificaciones.cbParcial.getSelectedItem());

            // Verificar si ya existe una calificación para el alumno en ese grado, materia y parcial
            if (consultaCalificaciones.existeCalificacion(calificacion.getId(),calificacion.getNumCuentaAlumno(), calificacion.getIdGrado(), calificacion.getIdMateria(), calificacion.getParcial())) {
                JOptionPane.showMessageDialog(null, "Ya existe una calificación para este alumno para este parcial.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            calificacion.setNota(Double.parseDouble(formularioCalificaciones.txtNota.getText()));
            calificacion.setIdProfesor(consultaProfesor.obtenerIdProfesorPorNombre(formularioCalificaciones.txtProfesor.getText()));
            
            //   verificar si existe una asignación para ese profesor y esa materia
            if (!consultaCalificaciones.existeAsignacionProfesorMateria(calificacion.getId(),calificacion.getIdProfesor(), calificacion.getIdMateria())) {
                // Si no se encuentra una asignación, mostrar un mensaje y retornar false
                JOptionPane.showMessageDialog(null, "El profesor no tiene asignada la materia para esta calificación.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (calificacion.getNota() >= 70) {
                calificacion.setEstado("Aprobado");
            } else {
                calificacion.setEstado("Reprobado");
            }
            return true;
        }
        return false;
    }

    public boolean validarCamposNoVacios() {
        boolean camposValidos = true;

        if (formularioCalificaciones.txtCodigo.getText().trim().isEmpty()) {
            camposValidos = false;
        }
        if (formularioCalificaciones.txtNota.getText().trim().isEmpty()) {
            resaltarCampoVacio(formularioCalificaciones.txtNota);
            camposValidos = false;
        }
        if (formularioCalificaciones.txtAlumno.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, SELECCIONE UN ALUMNO.", "ERROR", JOptionPane.ERROR_MESSAGE);
            camposValidos = false;
        }
        if (!camposValidos) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, COMPLETE EL FORMULARIO.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return camposValidos;
    }

    public void limpiar() {
        formularioCalificaciones.txtCodigo.setText("");
        formularioCalificaciones.txtAlumno.setText("");
        formularioCalificaciones.txtGrado.setText("");
        formularioCalificaciones.cbMaterias.removeAllItems();
         formularioCalificaciones.cbParcial.setSelectedIndex(0);
        formularioCalificaciones.txtNota.setText("");

    }

    public void resaltarCampoVacio(JTextField campo) {
        Color colorResaltado = new Color(219, 52, 52);
        campo.setBackground(colorResaltado);
    }

    //OBTENER SIGUIENTE CODIGO
    public int obtenerCodigoSiguiente() {
        return consultaCalificaciones.obtenerSiguienteCodigo();
    }

    public void habilitarBotones() {
        formularioCalificaciones.btnCancelar.setEnabled(false);
        formularioCalificaciones.btnCrear.setEnabled(false);

        formularioCalificaciones.btnBuscar.setEnabled(true);
        formularioCalificaciones.btnEliminar.setEnabled(true);
        formularioCalificaciones.btnLeer.setEnabled(true);
        formularioCalificaciones.btnAgregar.setEnabled(true);
        formularioCalificaciones.btnLimpiar.setEnabled(true);
        formularioCalificaciones.btnModificar.setEnabled(true);
        formularioCalificaciones.btnSalir.setEnabled(true);
    }

    public void deshabilitarBotones() {
        formularioCalificaciones.btnCancelar.setEnabled(true);
        formularioCalificaciones.btnCrear.setEnabled(true);
        formularioCalificaciones.txtCodigo.setText(String.valueOf(obtenerCodigoSiguiente()));

        formularioCalificaciones.btnBuscar.setEnabled(false);
        formularioCalificaciones.btnEliminar.setEnabled(false);
        formularioCalificaciones.btnLeer.setEnabled(false);
        formularioCalificaciones.btnAgregar.setEnabled(false);
        formularioCalificaciones.btnLimpiar.setEnabled(false);
        formularioCalificaciones.btnModificar.setEnabled(false);
        formularioCalificaciones.btnSalir.setEnabled(false);
    }

}
