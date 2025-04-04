/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Padre;
import modelo.ConsultaPadres;
import vista.frm_Consulta_Padres;
import vista.frm_Padres;

/**
 *
 * @author ammcp
 */
public class padreControlador implements ActionListener {

    private Padre padre;
    private frm_Padres form;
    private ConsultaPadres consPadres;
    private frm_Consulta_Padres formConsPadres;
    private Object datos[] = new Object[10];
    DefaultTableModel modelo;

    public padreControlador(Padre padre, frm_Padres form, ConsultaPadres consPadres, frm_Consulta_Padres formConsPadres) {
        this.padre = padre;
        this.form = form;
        this.consPadres = consPadres;
        this.formConsPadres = formConsPadres;

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        inicializarBotonesFormulario();
        inicializarBotonBuscar();
        habilitarBotones();
    }

    private void inicializarBotonesFormulario() {
        form.btnAgregar.addActionListener(this);
        form.btnCancelar.addActionListener(this);
        form.btnCrear.addActionListener(this);
        form.btnBuscar.addActionListener(this);
        form.btnModificar.addActionListener(this);
        form.btnEliminar.addActionListener(this);
        form.btnLimpiar.addActionListener(this);
        form.btnSalir.addActionListener(this);
    }

    private void inicializarBotonBuscar() {
        formConsPadres.btn_buscarPor.addActionListener(this);
        formConsPadres.tbl_consulta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                manejarEventoTablaPadres();
            }
        });
    }

    private void manejarEventoTablaPadres() {
        int filaSeleccionada = formConsPadres.tbl_consulta.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) formConsPadres.tbl_consulta.getModel();
        if (filaSeleccionada >= 0) {
            String idPadre = String.valueOf(model.getValueAt(filaSeleccionada, 0));
            Padre padreSeleccionado = consPadres.obtenerPadreSegunId(Integer.parseInt(idPadre));

            form.txtCodigo.setText(String.valueOf(padreSeleccionado.getId()));
            form.txtNombres1.setText(String.valueOf(padreSeleccionado.getNombre()));
            form.txtApellidos.setText(String.valueOf(padreSeleccionado.getApellidos()));
            form.txtIdentidad.setText(String.valueOf(padreSeleccionado.getCedula()));
            form.cbGenero.setSelectedItem(padreSeleccionado.getGenero());
            form.txtTelefono.setText(String.valueOf(padreSeleccionado.getTelefono()));
            form.txtDireccion.setText(String.valueOf(padreSeleccionado.getDireccion()));
            model.setRowCount(0);
            formConsPadres.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //BOTON AGREGAR
        if (e.getSource() == form.btnAgregar) {
            limpiar();
            deshabilitarBotones();
        }
        //CANCELAR
        if (e.getSource() == form.btnCancelar) {
            habilitarBotones();
            limpiar();
        }

        //BOTON CREAR
        if (e.getSource() == form.btnCrear) {
            guardarPadre();
        }
        //BOTON LEER TODOS

        //BOTON CONSULTA USUARIO
        if (e.getSource() == form.btnBuscar) {
            formConsPadres.setVisible(true);
        }
        //BOTON BUSCAR USARIO FILATRADO
       
        //BOTON MODIFICAR
        if (e.getSource() == form.btnModificar) {
            modificarPadre();
        }
        //boton eliminar
        if (e.getSource() == form.btnEliminar) {
            eliminarPadre();
        }
        //BOTON LIMPIAR
        if (e.getSource() == form.btnLimpiar) {
            limpiar();
        }
        //BOTON SALIR
        if (e.getSource() == form.btnSalir) {
            this.form.dispose();
        }
    }

    //METODOS CRUD *************************************************************************
    //GUARDAR
    public void guardarPadre() {
        if (validarYVerificarPadre()) {
            if (consPadres.crearPadre(padre)) {
                limpiar();
                habilitarBotones();
            }
        }
    }

    //MODIFICAR
    public void modificarPadre() {
        if (validarYVerificarPadre()) {
            if (consPadres.modificarPadre(padre)) {
                limpiar();
            }
        }
    }

    //ELIMINAR
    public void eliminarPadre() {
        if (!form.txtCodigo.getText().isEmpty()) {
            padre.setId(Integer.parseInt(form.txtCodigo.getText()));
            if (consPadres.eliminarPadre(padre)) {
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN PADRE.", "Informacioin", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //LEER

    //VALIDACIONES **************************************************************************
    //VERIFICAR PADRE
    private boolean validarYVerificarPadre() {
        if (validarCamposNoVacios()) {
            String cedula = form.txtIdentidad.getText();
            String nombreCompleto = form.txtNombres1.getText() + " " + form.txtApellidos.getText();

            // Verificar que no exista otro padre con la misma cédula
            if (consPadres.existePadreConCedula(cedula, Integer.parseInt(form.txtCodigo.getText()))) {
                JOptionPane.showMessageDialog(null, "Ya existe un padre registrado con la misma cédula.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Verificar que no exista otro padre con el mismo nombre completo
            if (consPadres.existePadreConNombreCompleto(nombreCompleto, Integer.parseInt(form.txtCodigo.getText()))) {
                JOptionPane.showMessageDialog(null, "Ya existe un padre registrado con el mismo nombre completo.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Si no hay duplicados, asignar los valores al objeto padre
            padre.setId(Integer.parseInt(form.txtCodigo.getText()));
            padre.setNombreCompleto(nombreCompleto);
            padre.setGenero((String) form.cbGenero.getSelectedItem());
            padre.setCedula(cedula);
            padre.setDireccion(form.txtDireccion.getText());
            padre.setTelefono(form.txtTelefono.getText());
            padre.setEstado("Activo");
            return true; // Los datos del padre son válidos y no hay duplicados
        }

        return false; // No se cumplen todas las condiciones de validación
    }

    //CAMPOS VACIOS
    public boolean validarCamposNoVacios() {
        boolean camposValidos = true;

        if (form.txtCodigo.getText().trim().isEmpty()) {
            camposValidos = false;
        }
        if (form.txtNombres1.getText().trim().isEmpty()) {
            resaltarCampoVacio(form.txtNombres1);
            camposValidos = false;
        }
        if (form.txtApellidos.getText().trim().isEmpty()) {
            resaltarCampoVacio(form.txtApellidos);
            camposValidos = false;
        }
        if (form.txtIdentidad.getText().trim().isEmpty()) {
            resaltarCampoVacio(form.txtIdentidad);
            camposValidos = false;
        }
        if (form.txtDireccion.getText().trim().isEmpty()) {
            resaltarCampoVacio(form.txtDireccion);
            camposValidos = false;
        }
        if (form.txtTelefono.getText().trim().isEmpty()) {
            resaltarCampoVacio(form.txtTelefono);
            camposValidos = false;
        }
        if (!camposValidos) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, COMPLETE EL FORMULARIO.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return camposValidos;
    }

    //METODOS DE CONFIGURACION ********************************************************************************
    //LIMPIAR
    public void limpiar() {
        form.txtCodigo.setText("");
        form.txtNombres1.setText("");
        form.txtApellidos.setText("");
        form.txtTelefono.setText(null);
        form.txtIdentidad.setText("");
        form.txtDireccion.setText("");
        form.cbGenero.setSelectedIndex(0);
    }

    //RESALTAR CAMPO
    public void resaltarCampoVacio(JTextField campo) {
        Color colorResaltado = new Color(219, 52, 52);
        campo.setBackground(colorResaltado);
    }

    //PARA EL TEXT AREA
    private void resaltarCampoVacio(JTextArea txtDireccion) {
        Color colorResaltado = new Color(219, 52, 52);
        txtDireccion.setBackground(colorResaltado);
    }

    //OBTENER SIGUIENTE CODIGO
    public int obtenerCodigoSiguiente() {
        return consPadres.obtenerSiguienteCodigo();
    }

    //HABILITAR BOTONES
    public void habilitarBotones() {
        form.btnCancelar.setEnabled(false);
        form.btnCrear.setEnabled(false);

        form.btnBuscar.setEnabled(true);
        form.btnEliminar.setEnabled(true);
        form.btnAgregar.setEnabled(true);
        form.btnLimpiar.setEnabled(true);
        form.btnModificar.setEnabled(true);
        form.btnSalir.setEnabled(true);
    }

    //DESHABILITAR BOTONES
    public void deshabilitarBotones() {
        form.btnCancelar.setEnabled(true);
        form.btnCrear.setEnabled(true);
        form.txtCodigo.setText(String.valueOf(obtenerCodigoSiguiente()));

        form.btnBuscar.setEnabled(false);
        form.btnEliminar.setEnabled(false);
        form.btnAgregar.setEnabled(false);
        form.btnLimpiar.setEnabled(false);
        form.btnModificar.setEnabled(false);
        form.btnSalir.setEnabled(false);
    }

}
