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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import modelo.ConsultaUsuarios;
import vista.frm_Consulta_Usuarios;
import vista.frm_Usuarios;

/**
 *
 * @author ammcp
 */
public class usuarioControlador implements ActionListener {

    private Usuario usuario;
    private frm_Usuarios form;
    private ConsultaUsuarios consUsuario;
    private frm_Consulta_Usuarios formConsUsuario;
    private Object datos[] = new Object[4];
    DefaultTableModel modelo;

    public usuarioControlador(Usuario usuario, frm_Usuarios form, ConsultaUsuarios consUsuario, frm_Consulta_Usuarios formConsUsuarios) {
        this.usuario = usuario;
        this.form = form;
        this.consUsuario = consUsuario;
        this.formConsUsuario = formConsUsuarios;

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
        form.btnLeer.addActionListener(this);
        form.btnBuscar.addActionListener(this);
        form.btnModificar.addActionListener(this);
        form.btnEliminar.addActionListener(this);
        form.btnLimpiar.addActionListener(this);
        form.btnSalir.addActionListener(this);
    }

    private void inicializarBotonBuscar() {
        formConsUsuario.btn_buscarPor.addActionListener(this);
        formConsUsuario.tbl_usuarios.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                manejarEventoTablaUsuarios();
            }
        });
    }

    private void manejarEventoTablaUsuarios() {
        int filaSeleccionada = formConsUsuario.tbl_usuarios.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) formConsUsuario.tbl_usuarios.getModel();
        if (filaSeleccionada >= 0) {
            String idUsuario = String.valueOf(model.getValueAt(filaSeleccionada, 0));
            Usuario usuarioSeleccionado = consUsuario.obtenerUusuarioSegunIdUsuario(Integer.parseInt(idUsuario));

            form.txtCodigo.setText(String.valueOf(usuarioSeleccionado.getCodigo()));
            form.txtNombre1.setText(String.valueOf(usuarioSeleccionado.getNombre()));
            form.txtContra1.setText(String.valueOf(usuarioSeleccionado.getContrasena()));
            form.txtVerificarContra.setText(String.valueOf(usuarioSeleccionado.getContrasena()));
            form.cbUsuarios.setSelectedItem(usuarioSeleccionado.getRol());
            form.cbUsuarios.setSelectedIndex(usuarioSeleccionado.getIdRol());
          //  form.cbUsuarios.setSelectedIndex(usuarioSeleccionado.getIdRol());
            model.setRowCount(0);
            formConsUsuario.dispose();
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
            guardarUsuario();
        }
        //BOTON LEER TODOS
        

        //BOTON CONSULTA USUARIO
        if (e.getSource() == form.btnBuscar) {
            formConsUsuario.setVisible(true);
        }
        //BOTON MODIFICAR
        if (e.getSource() == form.btnModificar) {
            modificarUsuario();
        }
        //boton eliminar
        if (e.getSource() == form.btnEliminar) {
            eliminarUsuario();
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
    public void guardarUsuario() {
        if (validarYVerificarUsuario()) {
            if (consUsuario.crearUsuario(usuario)) {
                limpiar();
                habilitarBotones();
            }
        }
    }

    //MODIFICAR
    public void modificarUsuario() {
        if (validarYVerificarUsuario()) {
            if (consUsuario.modificarUsuario(usuario)) {
                limpiar();
            }
        }
    }

    //ELIMINAR
    public void eliminarUsuario() {
        if (!form.txtCodigo.getText().isEmpty()) {
            usuario.setCodigo(Integer.parseInt(form.txtCodigo.getText()));
            if (consUsuario.eliminarUsuario(usuario)) {
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN USUARIO.", "Informacioin", JOptionPane.INFORMATION_MESSAGE);
        }
    }


 

   
    

    //VALIDACIONES **************************************************************************
    //VERIFICAR USUARIO
    private boolean validarYVerificarUsuario() {
        if (validarCamposNoVacios() && verificarContras()) {
            String nombreUsuario = form.txtNombre1.getText();
            if (consUsuario.existeUsuario(nombreUsuario, Integer.parseInt(form.txtCodigo.getText()))) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya está en uso. Por favor, elija otro.", "Error", JOptionPane.ERROR_MESSAGE);
                return false; // No se puede guardar o modificar porque el nombre de usuario ya existe
            } else {
                usuario.setCodigo(Integer.parseInt(form.txtCodigo.getText()));
                usuario.setNombre(nombreUsuario);
                usuario.setContrasena(form.txtContra1.getText());
                usuario.setRol((String) form.cbUsuarios.getSelectedItem());
                usuario.setEstado("Activo");
                usuario.setIdRol(form.cbUsuarios.getSelectedIndex());
                usuario.setIdEstado(1);
                return true; // El usuario es válido y no existe otro con el mismo nombre
            }
        }
        return false; // No se cumplen todas las condiciones de validación
    }

    //CAMPOS VACIOS
    public boolean validarCamposNoVacios() {
        boolean camposValidos = true;

        if (form.txtCodigo.getText().trim().isEmpty()) {
            camposValidos = false;
        }
        if (form.txtNombre1.getText().trim().isEmpty()) {
            resaltarCampoVacio(form.txtNombre1);
            camposValidos = false;
        }
        if (form.txtContra1.getText().trim().isEmpty()) {
            resaltarCampoVacio(form.txtContra1);
            camposValidos = false;
        }
        if (form.txtVerificarContra.getText().trim().isEmpty()) {
            resaltarCampoVacio(form.txtVerificarContra);
            camposValidos = false;
        }
        if (!camposValidos) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, COMPLETE EL FORMULARIO.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return camposValidos;
    }

    public boolean verificarContras() {
        if (!form.txtContra1.getText().equals(form.txtVerificarContra.getText())) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    //METODOS DE CONFIGURACION ********************************************************************************
    //LIMPIAR
    public void limpiar() {
        form.txtCodigo.setText("");
        form.txtNombre1.setText("");
        form.txtContra1.setText("");
        form.txtVerificarContra.setText("");
        form.cbUsuarios.setSelectedIndex(0);
    }

    //RESALTAR CAMPO
    public void resaltarCampoVacio(JTextField campo) {
        Color colorResaltado = new Color(219, 52, 52);
        campo.setBackground(colorResaltado);
    }

    //OBTENER SIGUIENTE CODIGO
    public int obtenerCodigoSiguiente() {
        return consUsuario.obtenerSiguienteCodigo();
    }

    //HABILITAR BOTONES
    public void habilitarBotones() {
        form.btnCancelar.setEnabled(true);
        form.btnCrear.setEnabled(true);

        form.btnBuscar.setEnabled(true);
        form.btnEliminar.setEnabled(true);
        form.btnLeer.setEnabled(true);
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
        form.btnLeer.setEnabled(false);
        form.btnAgregar.setEnabled(false);
        form.btnLimpiar.setEnabled(false);
        form.btnModificar.setEnabled(false);
        form.btnSalir.setEnabled(false);
    }

    

}
