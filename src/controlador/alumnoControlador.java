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
import modelo.Grado;
import modelo.ImageProcessor;
import modelo.Padre;
import vista.frm_Alumnos;
import vista.frm_Consulta_Alumnos;
import vista.frm_Consulta_Grados;
import vista.frm_Consulta_Padres;

public class alumnoControlador implements ActionListener {

    private Alumno alumno;
    private frm_Alumnos formularioAlumno;
    private ConsultaAlumnos consultaAlumnos;
    private frm_Consulta_Alumnos formularioConsulta;
    private frm_Consulta_Padres formularioConsultaPadres;
    private frm_Consulta_Grados formularioConsultaFrados;
    private Object datos[] = new Object[10];
    private ConsultaPadres consPadre = new ConsultaPadres();
    private ConsultaGrados consGrados = new ConsultaGrados();
    private DefaultTableModel modelo;
    private String imagenSeleccionada;

    public alumnoControlador(Alumno alumno, frm_Alumnos formularioAlumno, ConsultaAlumnos consultaAlumnos, frm_Consulta_Alumnos formularioConsulta) {
        this.alumno = alumno;
        this.formularioAlumno = formularioAlumno;
        this.consultaAlumnos = consultaAlumnos;
        this.formularioConsulta = formularioConsulta;
        this.imagenSeleccionada = formularioAlumno.urlImagenDefecto;
        this.formularioConsultaFrados = new frm_Consulta_Grados(formularioAlumno, true);
        this.formularioConsultaPadres = new frm_Consulta_Padres(formularioAlumno, true);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        inicializarBotonesFormulario();
        inicializarBotonedListener();
        habilitarBotones();
    }

    private void inicializarBotonesFormulario() {
        formularioAlumno.btnAgregar.addActionListener(this);
        formularioAlumno.btnCancelar.addActionListener(this);
        formularioAlumno.btnCrear.addActionListener(this);
        formularioAlumno.btnLeer.addActionListener(this);
        formularioAlumno.btnBuscar.addActionListener(this);
        formularioAlumno.btnModificar.addActionListener(this);
        formularioAlumno.btnEliminar.addActionListener(this);
        formularioAlumno.btnLimpiar.addActionListener(this);
        formularioAlumno.btnSalir.addActionListener(this);

        formularioAlumno.btnSeleccionarFoto.addActionListener(this);
        formularioAlumno.btnSeleccionarGrado.addActionListener(this);
        formularioAlumno.btnSeleccionarPadre.addActionListener(this);
    }

    private void inicializarBotonedListener() {
        formularioConsulta.btn_buscarPor.addActionListener(this);
        formularioConsulta.tbl_consulta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                manejarEventoTablaAlumnos();
            }
        });
        formularioConsultaPadres.btn_buscarPor.addActionListener(this);
        formularioConsultaPadres.tbl_consulta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                manejarEventoTablaPadres();//
            }
        });

        formularioConsultaFrados.btn_buscarPor.addActionListener(this);
        formularioConsultaFrados.tbl_consulta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                manejarEventoTablaGrados();//
            }
        });
    }

    private void manejarEventoTablaAlumnos() {
        int filaSeleccionada = formularioConsulta.tbl_consulta.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) formularioConsulta.tbl_consulta.getModel();
        if (filaSeleccionada >= 0) {
            String numCuenta = String.valueOf(model.getValueAt(filaSeleccionada, 0));
            Alumno seleccionado = consultaAlumnos.obtenerAlumnoSegunNumCuenta(numCuenta);

            formularioAlumno.txtCodigo.setText(String.valueOf(seleccionado.getNumCuenta()));
            formularioAlumno.txtNombres1.setText(seleccionado.getNombre());
            formularioAlumno.txtApellidos.setText(seleccionado.getApellidos());
            formularioAlumno.cbGenero.setSelectedItem(seleccionado.getGenero());
            formularioAlumno.DateNacimiento.setDate(seleccionado.getFechaNac());
            formularioAlumno.txtDireccion.setText(seleccionado.getDireccion());
            formularioAlumno.txtTelefono.setText(seleccionado.getTelefono());
            formularioAlumno.cargarImagen(seleccionado.getFoto());
            imagenSeleccionada=seleccionado.getFoto();
            formularioAlumno.txtPadre.setText(consPadre.obtenerPadreSegunId(seleccionado.getIdPadres()).getNombreCompleto());
            formularioAlumno.txtGrado.setText(consGrados.obtenerGradoSegunId(seleccionado.getIdGrado()).getNombre());
            formularioConsulta.dispose();
        }
    }

    public void manejarEventoTablaPadres() {
        int filaSeleccionada = formularioConsultaPadres.tbl_consulta.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) formularioConsultaPadres.tbl_consulta.getModel();
        if (filaSeleccionada >= 0) {
            String idPadre = String.valueOf(model.getValueAt(filaSeleccionada, 0));
            Padre padreSeleccionado = consPadre.obtenerPadreSegunId(Integer.parseInt(idPadre));
            if(padreSeleccionado.getEstado().equals("Inactivo")){
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN ENCARGADO ACTIVO.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            formularioAlumno.txtPadre.setText(padreSeleccionado.getNombreCompleto());
            formularioConsultaPadres.dispose();
        }
    }

    public void manejarEventoTablaGrados() {
        int filaSeleccionada = formularioConsultaFrados.tbl_consulta.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) formularioConsultaFrados.tbl_consulta.getModel();
        if (filaSeleccionada >= 0) {
            String id = String.valueOf(model.getValueAt(filaSeleccionada, 0));
            Grado gradoSeleccionado = consGrados.obtenerGradoSegunId(Integer.parseInt(id));
            if(gradoSeleccionado.getEstado().equals("Inactivo")){
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN GRADO no me deja ACTIVO.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            formularioAlumno.txtGrado.setText(gradoSeleccionado.getNombre());
            formularioConsultaFrados.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formularioAlumno.btnAgregar) {
            limpiar();
            deshabilitarBotones();
        }
        if (e.getSource() == formularioAlumno.btnCancelar) {
            habilitarBotones();
            limpiar();
        }
        if (e.getSource() == formularioAlumno.btnCrear) {
            guardarAlumno();
        }
        if (e.getSource() == formularioAlumno.btnLeer) {
            llenarTabla();
        }
        if (e.getSource() == formularioAlumno.btnBuscar) {
            formularioConsulta.setVisible(true);
        }
        if (e.getSource() == formularioAlumno.btnModificar) {
            modificarAlumno();
        }
        if (e.getSource() == formularioAlumno.btnEliminar) {
            eliminarAlumno();
        }
        if (e.getSource() == formularioAlumno.btnSeleccionarGrado) {
            formularioConsultaFrados.setVisible(true);
        }
        if (e.getSource() == formularioAlumno.btnSeleccionarPadre) {
            formularioConsultaPadres.setVisible(true);
        }
        if (e.getSource() == formularioAlumno.btnSeleccionarFoto) {
            guardarForo();
        }
        if (e.getSource() == formularioAlumno.btnLimpiar) {
            limpiar();
        }
        if (e.getSource() == formularioAlumno.btnSalir) {
            formularioAlumno.dispose();
        }
        //-----
    }

    public void guardarForo() {
        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showOpenDialog(formularioAlumno);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = chooser.getSelectedFile();
            imagenSeleccionada = archivoSeleccionado.getAbsolutePath();

            // Guardar la imagen en una ubicación segura (si es necesario)
            String numeroCuentaAlumno = formularioAlumno.txtCodigo.getText(); // Obtener el nombre del alumno
            ImageProcessor imageProcessor = new ImageProcessor();
            imagenSeleccionada = imageProcessor.saveImage(archivoSeleccionado, numeroCuentaAlumno);
            
            // Llamar al método cargarImagen con la ruta de la imagen seleccionada
            formularioAlumno.cargarImagen(imagenSeleccionada);
        }
    }

    public void guardarAlumno() {
        if (validarYVerificarAlumno()) {
            if (consultaAlumnos.crearAlumno(alumno)) {
                limpiar();
                habilitarBotones();
            }
        }
    }

    public void modificarAlumno() {
        if (validarYVerificarAlumno()) {
            if (consultaAlumnos.modificarAlumno(alumno)) {
                limpiar();
            }
        }
    }

    public void eliminarAlumno() {
        if (!formularioAlumno.txtCodigo.getText().isEmpty()) {
            String numCuenta = formularioAlumno.txtCodigo.getText();
            if (consultaAlumnos.eliminarAlumno(numCuenta)) {
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN ALUMNO.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void llenarTabla() {
        modelo = (DefaultTableModel) formularioAlumno.tbl_registros.getModel();
        modelo.setRowCount(0);
        ArrayList<Alumno> listaAlumnos = consultaAlumnos.leerTodosAlumnos();
        for (Alumno alumno : listaAlumnos) {
            // Ajusta el llenado de la tabla según la estructura de la misma
            datos[0] = alumno.getNumCuenta();
            datos[1] = alumno.getNombreCompleto();
            datos[2] = alumno.getGenero();
            datos[3] = alumno.obtenerEdad();
            datos[4] = alumno.getDireccion();
            datos[5] = alumno.getTelefono();
            datos[6] = consPadre.obtenerPadreSegunId(alumno.getIdPadres()).getNombreCompleto();
            datos[7] = consGrados.obtenerGradoSegunId(alumno.getIdGrado()).getNombre();
            modelo.addRow(datos);
        }
        formularioAlumno.tbl_registros.setModel(modelo);
    }

   

    private boolean validarYVerificarAlumno() {
        if (validarCamposNoVacios()) {
            String nombreCompleto = formularioAlumno.txtNombres1.getText() + " " + formularioAlumno.txtApellidos.getText();

            // Verificar si ya existe un alumno con el mismo nombre completo
            if (consultaAlumnos.existeAlumnoConNombreCompleto(nombreCompleto, formularioAlumno.txtCodigo.getText())) {
                JOptionPane.showMessageDialog(null, "Ya existe un alumno con el mismo nombre completo y número de cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            alumno.setNumCuenta(formularioAlumno.txtCodigo.getText());
            alumno.setNombreCompleto(nombreCompleto);
            alumno.setGenero((String) formularioAlumno.cbGenero.getSelectedItem());
            alumno.setFechaNac(formularioAlumno.DateNacimiento.getDate());
            alumno.setDireccion(formularioAlumno.txtDireccion.getText());
            alumno.setTelefono(formularioAlumno.txtTelefono.getText());
            alumno.setIdPadres(consPadre.obtenerIdPadreSegunNombre(formularioAlumno.txtPadre.getText()));
            alumno.setIdGrado(consGrados.obtenerIdGradoSegunNombre(formularioAlumno.txtGrado.getText()));
            alumno.setFoto(imagenSeleccionada);
            alumno.setEstado("Activo");
            return true;
        }
        return false;
    }

    public boolean validarCamposNoVacios() {
        boolean camposValidos = true;

        if (formularioAlumno.txtCodigo.getText().trim().isEmpty()) {
            camposValidos = false;
        }
        if (formularioAlumno.txtNombres1.getText().trim().isEmpty()) {
            resaltarCampoVacio(formularioAlumno.txtNombres1);
            camposValidos = false;
        }
        if (formularioAlumno.DateNacimiento == null) {
            formularioAlumno.DateNacimiento.setBackground(new Color(219, 52, 52));
            camposValidos = false;
        }
        if (formularioAlumno.txtDireccion.getText().trim().isEmpty()) {
            formularioAlumno.txtDireccion.setBackground(new Color(219, 52, 52));
            camposValidos = false;
        }
        if (formularioAlumno.txtTelefono.getText().trim().isEmpty()) {
            resaltarCampoVacio(formularioAlumno.txtTelefono);
            camposValidos = false;
        }
        if (formularioAlumno.txtPadre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, SELECCIONE UN ENCARGADO.", "ERROR", JOptionPane.ERROR_MESSAGE);
            camposValidos = false;
        }
        if (formularioAlumno.txtGrado.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, SELECCIONE UN GRADO.", "ERROR", JOptionPane.ERROR_MESSAGE);
            camposValidos = false;
        }
        if (!camposValidos) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, COMPLETE EL FORMULARIO.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return camposValidos;
    }

    public void limpiar() {
        formularioAlumno.txtCodigo.setText("");
        formularioAlumno.txtNombres1.setText("");
        formularioAlumno.txtApellidos.setText("");
        formularioAlumno.DateNacimiento.setDate(null);
        formularioAlumno.txtTelefono.setText(null);
        formularioAlumno.txtPadre.setText("");
        formularioAlumno.txtGrado.setText("");
        formularioAlumno.txtDireccion.setText("");
        formularioAlumno.cbGenero.setSelectedIndex(0);
        formularioAlumno.cargarImagen(formularioAlumno.urlImagenDefecto);
        imagenSeleccionada = formularioAlumno.urlImagenDefecto;
        modelo = (DefaultTableModel) formularioAlumno.tbl_registros.getModel();
        modelo.setRowCount(0);

    }

    public void resaltarCampoVacio(JTextField campo) {
        Color colorResaltado = new Color(219, 52, 52);
        campo.setBackground(colorResaltado);
    }

    //OBTENER SIGUIENTE CODIGO
    public int obtenerCodigoSiguiente() {
        return consultaAlumnos.obtenerSiguienteCodigo();
    }

    public void habilitarBotones() {
        formularioAlumno.btnCancelar.setEnabled(false);
        formularioAlumno.btnCrear.setEnabled(false);
        formularioAlumno.cargarImagen(formularioAlumno.urlImagenDefecto);
        
        formularioAlumno.btnBuscar.setEnabled(true);
        formularioAlumno.btnEliminar.setEnabled(true);
        formularioAlumno.btnLeer.setEnabled(true);
        formularioAlumno.btnAgregar.setEnabled(true);
        formularioAlumno.btnLimpiar.setEnabled(true);
        formularioAlumno.btnModificar.setEnabled(true);
        formularioAlumno.btnSalir.setEnabled(true);
    }

    public void deshabilitarBotones() {
        formularioAlumno.btnCancelar.setEnabled(true);
        formularioAlumno.btnCrear.setEnabled(true);
        formularioAlumno.txtCodigo.setText(String.valueOf(obtenerCodigoSiguiente()));
        formularioAlumno.cargarImagen(formularioAlumno.urlImagenDefecto);
        
        formularioAlumno.btnBuscar.setEnabled(false);
        formularioAlumno.btnEliminar.setEnabled(false);
        formularioAlumno.btnLeer.setEnabled(false);
        formularioAlumno.btnAgregar.setEnabled(false);
        formularioAlumno.btnLimpiar.setEnabled(false);
        formularioAlumno.btnModificar.setEnabled(false);
        formularioAlumno.btnSalir.setEnabled(false);
    }

    
}
