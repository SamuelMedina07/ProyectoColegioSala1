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
import modelo.ConsultaAlumnos;
import modelo.ConsultaGrados;
import modelo.ConsultaPadres;
import modelo.ConsultaProfesor;
import modelo.ConsultaUsuarios;
import modelo.Grado;
import modelo.ImageProcessor;
import modelo.Padre;
import modelo.Profesor;
import modelo.Usuario;
import vista.frm_Alumnos;
import vista.frm_Consulta_Alumnos;
import vista.frm_Consulta_Grados;
import vista.frm_Consulta_Padres;
import vista.frm_Consulta_Profesor;
import vista.frm_Consulta_Usuarios;
import vista.frm_Profesor;

public class profesorControlador implements ActionListener {

    private Profesor profesor;
    private frm_Profesor formularioProfesor;
    private ConsultaProfesor consultaProfesor;
    private frm_Consulta_Profesor formularioConsulta;
    private frm_Consulta_Usuarios formularioConsultaUsuarios;
    private Object datos[] = new Object[10];
    private ConsultaUsuarios consUsuario = new ConsultaUsuarios();
    private DefaultTableModel modelo;
    private String imagenSeleccionada;

    public profesorControlador(Profesor profesor, frm_Profesor formularioProfesor, ConsultaProfesor consultaProfesor, frm_Consulta_Profesor formularioConsulta) {
        this.profesor = profesor;
        this.formularioProfesor = formularioProfesor;
        this.consultaProfesor = consultaProfesor;
        this.formularioConsulta = formularioConsulta;
        this.imagenSeleccionada = this.formularioProfesor.urlImagenDefecto;
        this.formularioConsultaUsuarios = new frm_Consulta_Usuarios(this.formularioProfesor, true);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        inicializarBotonesFormulario();
        inicializarBotonedListener();
        habilitarBotones();
    }

    private void inicializarBotonesFormulario() {
        formularioProfesor.btnAgregar.addActionListener(this);
        formularioProfesor.btnCancelar.addActionListener(this);
        formularioProfesor.btnCrear.addActionListener(this);
        formularioProfesor.btnLeer.addActionListener(this);
        formularioProfesor.btnBuscar.addActionListener(this);
        formularioProfesor.btnModificar.addActionListener(this);
        formularioProfesor.btnEliminar.addActionListener(this);
        formularioProfesor.btnLimpiar.addActionListener(this);
        formularioProfesor.btnSalir.addActionListener(this);

        formularioProfesor.btnSeleccionarFoto.addActionListener(this);
        formularioProfesor.btnSeleccionarUsuario.addActionListener(this);
    }

    private void inicializarBotonedListener() {
        formularioConsulta.btn_buscarPor.addActionListener(this);
        formularioConsulta.tbl_consulta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                manejarEventoTablaProfesor();
            }
        });
        formularioConsultaUsuarios.btn_buscarPor.addActionListener(this);
        formularioConsultaUsuarios.tbl_usuarios.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                manejarEventoTablaUsuarios();//
            }
        });

    }

    private void manejarEventoTablaProfesor() {
        int filaSeleccionada = formularioConsulta.tbl_consulta.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) formularioConsulta.tbl_consulta.getModel();
        if (filaSeleccionada >= 0) {
            int idProfesor = (int) model.getValueAt(filaSeleccionada, 0);
            Profesor seleccionado = consultaProfesor.obtenerProfesorPorId(idProfesor);

            formularioProfesor.txtCodigo.setText(String.valueOf(seleccionado.getId()));
            formularioProfesor.txtNombres1.setText(seleccionado.getNombre());
            formularioProfesor.txtApellidos.setText(seleccionado.getApellidos());
            formularioProfesor.cbGenero.setSelectedItem(seleccionado.getGenero());
            formularioProfesor.txtIdentidad.setText(seleccionado.getCedula());
            formularioProfesor.txtDireccion.setText(seleccionado.getDireccion());
            formularioProfesor.txtTelefono.setText(seleccionado.getTelefono());
            formularioProfesor.cargarImagen(seleccionado.getFoto());
            imagenSeleccionada = seleccionado.getFoto();
            formularioProfesor.txtUsuario.setText(consUsuario.obtenerUusuarioSegunIdUsuario(seleccionado.getCodigoUsuario()).getNombre());
            model.setRowCount(0);
            formularioConsulta.dispose();
            
        }
    }

    public void manejarEventoTablaUsuarios() {
        int filaSeleccionada = formularioConsultaUsuarios.tbl_usuarios.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) formularioConsultaUsuarios.tbl_usuarios.getModel();
        if (filaSeleccionada >= 0) {
            String idUsuario = String.valueOf(model.getValueAt(filaSeleccionada, 0));
            Usuario usuarioSeleccionado = consUsuario.obtenerUusuarioSegunIdUsuario(Integer.parseInt(idUsuario));
            if (usuarioSeleccionado.getEstado().equals("Inactivo")) {
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN USUARIO ACTIVO.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            formularioProfesor.txtUsuario.setText(usuarioSeleccionado.getNombre());
            formularioConsultaUsuarios.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formularioProfesor.btnAgregar) {
            limpiar();
            deshabilitarBotones();
        }
        if (e.getSource() == formularioProfesor.btnCancelar) {
            habilitarBotones();
            limpiar();
        }
        if (e.getSource() == formularioProfesor.btnCrear) {
            guardarAlumno();
        }
        if (e.getSource() == formularioProfesor.btnLeer) {
            llenarTabla();
        }
        if (e.getSource() == formularioProfesor.btnBuscar) {
            formularioConsulta.setVisible(true);
        }
        if (e.getSource() == formularioProfesor.btnModificar) {
            modificarAlumno();
        }
        if (e.getSource() == formularioProfesor.btnEliminar) {
            eliminarAlumno();
        }
        if (e.getSource() == formularioProfesor.btnSeleccionarUsuario) {
            formularioConsultaUsuarios.setVisible(true);
        }
        if (e.getSource() == formularioProfesor.btnSeleccionarFoto) {
            guardarForo();
        }
        if (e.getSource() == formularioProfesor.btnLimpiar) {
            limpiar();
        }
        if (e.getSource() == formularioProfesor.btnSalir) {
            formularioProfesor.dispose();
        }
        //-----
    }

    public void guardarForo() {
        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showOpenDialog(formularioProfesor);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = chooser.getSelectedFile();
            imagenSeleccionada = archivoSeleccionado.getAbsolutePath();

            // Guardar la imagen en una ubicación segura (si es necesario)
            String numeroCuentaAlumno = formularioProfesor.txtCodigo.getText(); // Obtener el nombre del alumno
            ImageProcessor imageProcessor = new ImageProcessor();
            imagenSeleccionada = imageProcessor.saveImage(archivoSeleccionado, numeroCuentaAlumno);

            // Llamar al método cargarImagen con la ruta de la imagen seleccionada
            formularioProfesor.cargarImagen(imagenSeleccionada);
        }
    }

    public void guardarAlumno() {
        if (validarYVerificarProfesor()) {
            if (consultaProfesor.crearProfesor(profesor)) {
                limpiar();
                habilitarBotones();
            }
        }
    }

    public void modificarAlumno() {
        if (validarYVerificarProfesor()) {
            if (consultaProfesor.modificarProfesor(profesor)) {
                limpiar();
            }
        }
    }

    public void eliminarAlumno() {
        if (!formularioProfesor.txtCodigo.getText().isEmpty()) {
            String id = formularioProfesor.txtCodigo.getText();
            if (consultaProfesor.eliminarProfesor(Integer.parseInt(id))) {
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN PROFESOR.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void llenarTabla() {
        modelo = (DefaultTableModel) formularioProfesor.tbl_registros.getModel();
        modelo.setRowCount(0);
        ArrayList<Profesor> listaProfesores = consultaProfesor.leerTodosProfesores();
        for (Profesor profesor : listaProfesores) {
            datos[0] = profesor.getId();
            datos[1] = profesor.getNombreCompleto();
            datos[2] = profesor.getGenero();
            datos[3] = profesor.getCedula();
            datos[4] = profesor.getTelefono();
            datos[5] = profesor.getDireccion();
            datos[6] = consUsuario.obtenerUusuarioSegunIdUsuario(profesor.getCodigoUsuario()).getNombre();
            modelo.addRow(datos);
        }
        formularioProfesor.tbl_registros.setModel(modelo);
    }

    private boolean validarYVerificarProfesor() {
        if (validarCamposNoVacios()) {
            String nombreCompleto = formularioProfesor.txtNombres1.getText() + " " + formularioProfesor.txtApellidos.getText();

            // Validar si ya existe un profesor con el mismo nombre completo y código de usuario
            if (consultaProfesor.existeProfesorConNombreCompleto(nombreCompleto, Integer.parseInt(formularioProfesor.txtCodigo.getText()))) {
                JOptionPane.showMessageDialog(null, "Ya existe un profesor con el mismo nombre completo.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Validar si ya existe un profesor con la misma cédula
            if (consultaProfesor.existeProfesorConCedula(formularioProfesor.txtIdentidad.getText(), Integer.parseInt(formularioProfesor.txtCodigo.getText()))) {
                JOptionPane.showMessageDialog(null, "Ya existe un profesor con la misma cédula.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Validar si ya existe un profesor con el mismo usuario
            if (consultaProfesor.existeProfesorConMismoUsuario(consUsuario.obtenerUsuarioSegunNombre(formularioProfesor.txtUsuario.getText()).getCodigo(), Integer.parseInt(formularioProfesor.txtCodigo.getText()))) {
                JOptionPane.showMessageDialog(null, "Ya existe un profesor con el mismo usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            profesor = new Profesor();
            profesor.setId(Integer.parseInt(formularioProfesor.txtCodigo.getText()));
            profesor.setNombreCompleto(nombreCompleto);
            profesor.setGenero((String) formularioProfesor.cbGenero.getSelectedItem());
            profesor.setCedula(formularioProfesor.txtIdentidad.getText());
            profesor.setDireccion(formularioProfesor.txtDireccion.getText());
            profesor.setTelefono(formularioProfesor.txtTelefono.getText());
            
            profesor.setCodigoUsuario(consUsuario.obtenerUsuarioSegunNombre(formularioProfesor.txtUsuario.getText()).getCodigo());
            profesor.setFoto(imagenSeleccionada);
            profesor.setEstado("Activo");

            // Guardar el profesor en la base de datos o realizar otra operación necesaria
            // consultaProfesores.guardarProfesor(profesor);
            return true;
        }
        return false;
    }

    public boolean validarCamposNoVacios() {
        boolean camposValidos = true;

        if (formularioProfesor.txtCodigo.getText().trim().isEmpty()) {
            camposValidos = false;
        }
        if (formularioProfesor.txtNombres1.getText().trim().isEmpty()) {
            resaltarCampoVacio(formularioProfesor.txtNombres1);
            camposValidos = false;
        }
        if (formularioProfesor.txtApellidos.getText().trim().isEmpty()) {
            resaltarCampoVacio(formularioProfesor.txtApellidos);
            camposValidos = false;
        }
        if (formularioProfesor.txtIdentidad.getText().trim().isEmpty()) {
            resaltarCampoVacio(formularioProfesor.txtIdentidad);
            camposValidos = false;
        }
        if (formularioProfesor.txtDireccion.getText().trim().isEmpty()) {
            formularioProfesor.txtDireccion.setBackground(new Color(219, 52, 52));
            camposValidos = false;
        }
        if (formularioProfesor.txtTelefono.getText().trim().isEmpty()) {
            resaltarCampoVacio(formularioProfesor.txtTelefono);
            camposValidos = false;
        }
        if (formularioProfesor.txtUsuario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, SELECCIONE UN USUARIO.", "ERROR", JOptionPane.ERROR_MESSAGE);
            camposValidos = false;
        }
        if (!camposValidos) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, COMPLETE EL FORMULARIO.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return camposValidos;
    }

    public void limpiar() {
        formularioProfesor.txtCodigo.setText("");
        formularioProfesor.txtNombres1.setText("");
        formularioProfesor.txtApellidos.setText("");
        formularioProfesor.txtIdentidad.setText("");
        formularioProfesor.txtTelefono.setText(null);
        formularioProfesor.txtUsuario.setText("");
        formularioProfesor.txtDireccion.setText("");
        formularioProfesor.cbGenero.setSelectedIndex(0);
        formularioProfesor.cargarImagen(formularioProfesor.urlImagenDefecto);
        imagenSeleccionada = formularioProfesor.urlImagenDefecto;
        modelo = (DefaultTableModel) formularioProfesor.tbl_registros.getModel();
        modelo.setRowCount(0);

    }

    public void resaltarCampoVacio(JTextField campo) {
        Color colorResaltado = new Color(219, 52, 52);
        campo.setBackground(colorResaltado);
    }

    //OBTENER SIGUIENTE CODIGO
    public int obtenerCodigoSiguiente() {
        return consultaProfesor.obtenerSiguienteCodigo();
    }

    public void habilitarBotones() {
        formularioProfesor.btnCancelar.setEnabled(false);
        formularioProfesor.btnCrear.setEnabled(false);
        formularioProfesor.cargarImagen(formularioProfesor.urlImagenDefecto);

        formularioProfesor.btnBuscar.setEnabled(true);
        formularioProfesor.btnEliminar.setEnabled(true);
        formularioProfesor.btnLeer.setEnabled(true);
        formularioProfesor.btnAgregar.setEnabled(true);
        formularioProfesor.btnLimpiar.setEnabled(true);
        formularioProfesor.btnModificar.setEnabled(true);
        formularioProfesor.btnSalir.setEnabled(true);
    }

    public void deshabilitarBotones() {
        formularioProfesor.btnCancelar.setEnabled(true);
        formularioProfesor.btnCrear.setEnabled(true);
        formularioProfesor.txtCodigo.setText(String.valueOf(obtenerCodigoSiguiente()));
        formularioProfesor.cargarImagen(formularioProfesor.urlImagenDefecto);

        formularioProfesor.btnBuscar.setEnabled(false);
        formularioProfesor.btnEliminar.setEnabled(false);
        formularioProfesor.btnLeer.setEnabled(false);
        formularioProfesor.btnAgregar.setEnabled(false);
        formularioProfesor.btnLimpiar.setEnabled(false);
        formularioProfesor.btnModificar.setEnabled(false);
        formularioProfesor.btnSalir.setEnabled(false);
    }

}
