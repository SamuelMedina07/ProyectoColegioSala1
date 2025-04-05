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
import modelo.ImageProcessor;
import modelo.Empleado;
import vista.frm_Empleados;
import modelo.ConsultaEmpleados;

public class EmpleadoControlador implements ActionListener {

    private Empleado empleado;
    private frm_Empleados formularioEmpleado;
    private ConsultaEmpleados ConsultaEmpleados;

 
    private String imagenSeleccionada;

    public EmpleadoControlador(Empleado empleado,frm_Empleados formularioEmpleado, ConsultaEmpleados ConsultaEmpleados ) {
        this.empleado = empleado;
        this.formularioEmpleado = formularioEmpleado;
        this.ConsultaEmpleados = ConsultaEmpleados;
        this.imagenSeleccionada = formularioEmpleado.urlImagenDefecto;

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        inicializarBotonesFormulario();
        habilitarBotones();
    }

    private void inicializarBotonesFormulario() {
        formularioEmpleado.btnAgregar.addActionListener(this);
        formularioEmpleado.btnCancelar.addActionListener(this);
        formularioEmpleado.btnCrear.addActionListener(this);
        formularioEmpleado.btnBuscar.addActionListener(this);
        formularioEmpleado.btnModificar.addActionListener(this);
        formularioEmpleado.btnEliminar.addActionListener(this);
        formularioEmpleado.btnLimpiar.addActionListener(this);
        formularioEmpleado.btnSalir.addActionListener(this);

        formularioEmpleado.btnSeleccionarFoto.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formularioEmpleado.btnAgregar) {
//            limpiar();
           deshabilitarBotones();
        }
        if (e.getSource() == formularioEmpleado.btnCancelar) {
            habilitarBotones();
            limpiar();
        }
        if (e.getSource() == formularioEmpleado.btnCrear) {
            guardarAlumno();
            System.out.print("hola");
        }
//       // if (e.getSource() == formularioEmpleado.btnBuscar) {
//       //     formularioConsulta.setVisible(true);
//       // }
//        if (e.getSource() == formularioEmpleado.btnModificar) {
//            modificarAlumno();
//        }
//        if (e.getSource() == formularioEmpleado.btnEliminar) {
//            eliminarAlumno();
//        }
        if (e.getSource() == formularioEmpleado.btnSeleccionarFoto) {
            guardarForo();
        }
        if (e.getSource() == formularioEmpleado.btnLimpiar) {
            limpiar();
        }
        if (e.getSource() == formularioEmpleado.btnSalir) {
            formularioEmpleado.dispose();
        }
        //-----
    }

    public void guardarForo() {
        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showOpenDialog(formularioEmpleado);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = chooser.getSelectedFile();
            imagenSeleccionada = archivoSeleccionado.getAbsolutePath();

            // Guardar la imagen en una ubicación segura (si es necesario)
            String numeroCuentaAlumno = formularioEmpleado.txtCodigo.getText(); // Obtener el nombre del alumno
            ImageProcessor imageProcessor = new ImageProcessor();
            imagenSeleccionada = imageProcessor.saveImage(archivoSeleccionado, numeroCuentaAlumno);
            
            // Llamar al método cargarImagen con la ruta de la imagen seleccionada
            formularioEmpleado.cargarImagen(imagenSeleccionada);
        }
    }

    public void guardarAlumno() {
            if(validarYVerificarAlumno()){
            if (ConsultaEmpleados.crearEmpleado(empleado)) {
                limpiar();
                habilitarBotones();
            }
        }
    }
//
//    public void modificarAlumno() {
//        if (validarYVerificarAlumno()) {
//            if (consultaAlumnos.modificarAlumno(alumno)) {
//                limpiar();
//            }
//        }
//    }
//
//    public void eliminarAlumno() {
//        if (!formularioEmpleado.txtCodigo.getText().isEmpty()) {
//            String numCuenta = formularioEmpleado.txtCodigo.getText();
//            if (consultaAlumnos.eliminarAlumno(numCuenta)) {
//                limpiar();
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN ALUMNO.", "Información", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }


   

    private boolean validarYVerificarAlumno() {
        if (validarCamposNoVacios()) {
            String nombreCompleto = formularioEmpleado.txtNombres1.getText() + " " + formularioEmpleado.txtApellidos.getText();

//            // Verificar si ya existe un alumno con el mismo nombre completo
//            if (consultaAlumnos.existeAlumnoConNombreCompleto(nombreCompleto, formularioEmpleado.txtCodigo.getText())) {
//                JOptionPane.showMessageDialog(null, "Ya existe un alumno con el mismo nombre completo y número de cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
//                return false;
//            }

            empleado.setNumEmpleado(formularioEmpleado.txtCodigo.getText());
            empleado.setNombreCompleto(nombreCompleto);
            empleado.setEmpleadoCargo(formularioEmpleado.cbUsuarios.getSelectedIndex());
            empleado.setGenero((String) formularioEmpleado.cbGenero.getSelectedItem());
            empleado.setFechaNac(formularioEmpleado.DateNacimiento.getDate());
            empleado.setDireccion(formularioEmpleado.txtDireccion.getText());
            empleado.setTelefono(formularioEmpleado.txtTelefono.getText());
            empleado.setFoto(imagenSeleccionada);
            empleado.setEstado(""+1);
            return true;
        }
        return false;
    }

    public boolean validarCamposNoVacios() {
        boolean camposValidos = true;

        if (formularioEmpleado.txtCodigo.getText().trim().isEmpty()) {
            camposValidos = false;
        }
        if (formularioEmpleado.txtNombres1.getText().trim().isEmpty()) {
            resaltarCampoVacio(formularioEmpleado.txtNombres1);
            camposValidos = false;
        }
        if (formularioEmpleado.txtApellidos.getText().trim().isEmpty()) {
            resaltarCampoVacio(formularioEmpleado.txtApellidos);
            camposValidos = false;
        }
        if (formularioEmpleado.DateNacimiento == null) {
            formularioEmpleado.DateNacimiento.setBackground(new Color(219, 52, 52));
            camposValidos = false;
        }
        if (formularioEmpleado.txtDireccion.getText().trim().isEmpty()) {
            formularioEmpleado.txtDireccion.setBackground(new Color(219, 52, 52));
            camposValidos = false;
        }
        if (formularioEmpleado.txtTelefono.getText().trim().isEmpty()) {
            resaltarCampoVacio(formularioEmpleado.txtTelefono);
            camposValidos = false;
        }
       
        if (!camposValidos) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, COMPLETE EL FORMULARIO.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return camposValidos;
    }

    public void limpiar() {
        formularioEmpleado.txtCodigo.setText("");
        formularioEmpleado.txtNombres1.setText("");
        formularioEmpleado.txtApellidos.setText("");
        formularioEmpleado.DateNacimiento.setDate(null);
        formularioEmpleado.txtTelefono.setText(null);
        formularioEmpleado.txtDireccion.setText("");
        formularioEmpleado.cbGenero.setSelectedIndex(0);
        formularioEmpleado.cargarImagen(formularioEmpleado.urlImagenDefecto);
        imagenSeleccionada = formularioEmpleado.urlImagenDefecto;

    }

    public void resaltarCampoVacio(JTextField campo) {
        Color colorResaltado = new Color(219, 52, 52);
        campo.setBackground(colorResaltado);
    }

    //OBTENER SIGUIENTE CODIGO
    public int obtenerCodigoSiguiente() {
        return ConsultaEmpleados.obtenerSiguienteCodigo();
    }

    public void habilitarBotones() {
        formularioEmpleado.btnCancelar.setEnabled(false);
        formularioEmpleado.btnCrear.setEnabled(false);
        formularioEmpleado.cargarImagen(formularioEmpleado.urlImagenDefecto);
        
        formularioEmpleado.btnBuscar.setEnabled(true);
        formularioEmpleado.btnEliminar.setEnabled(true);
        formularioEmpleado.btnAgregar.setEnabled(true);
        formularioEmpleado.btnLimpiar.setEnabled(true);
        formularioEmpleado.btnModificar.setEnabled(true);
        formularioEmpleado.btnSalir.setEnabled(true);
    }

    public void deshabilitarBotones() {
        formularioEmpleado.btnCancelar.setEnabled(true);
        formularioEmpleado.btnCrear.setEnabled(true);
       formularioEmpleado.txtCodigo.setText(String.valueOf(obtenerCodigoSiguiente()));
        formularioEmpleado.cargarImagen(formularioEmpleado.urlImagenDefecto);
        
        formularioEmpleado.btnBuscar.setEnabled(false);
        formularioEmpleado.btnEliminar.setEnabled(false);
        formularioEmpleado.btnAgregar.setEnabled(false);
        formularioEmpleado.btnLimpiar.setEnabled(false);
        formularioEmpleado.btnModificar.setEnabled(false);
        formularioEmpleado.btnSalir.setEnabled(false);
    }

    
}
