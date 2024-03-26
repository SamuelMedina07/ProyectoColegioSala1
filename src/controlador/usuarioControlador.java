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
import vista.frm_Usuarios;

/**
 *
 * @author ammcp
 */
public class usuarioControlador implements ActionListener {

    private Usuario usuario;
    private frm_Usuarios form;
    private ConsultaUsuarios consUsuario;
    private Object datos[] = new Object[4];
    DefaultTableModel modelo;

    public usuarioControlador(Usuario usuario, frm_Usuarios form, ConsultaUsuarios consUsuario) {
        this.usuario = usuario;
        this.form = form;
        this.consUsuario = consUsuario;
        this.form.btnAgregar.addActionListener(this);
        this.form.btnCancelar.addActionListener(this);
        this.form.btnCrear.addActionListener(this);
        this.form.btnLeer.addActionListener(this);
        this.form.btnBuscar.addActionListener(this);
        this.form.btnModificar.addActionListener(this);
        this.form.btnEliminar.addActionListener(this);
        this.form.btnLimpiar.addActionListener(this);
        this.form.btnSalir.addActionListener(this);

        //Configuraciones
        habilitarBotones();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //BOTON AGREGAR
        if (e.getSource() == form.btnAgregar) {
            deshabilitarBotones();
        }

        if (e.getSource() == form.btnCancelar) {
            habilitarBotones();
            limpiar();
        }

        //BOTON CREAR
        if (e.getSource() == form.btnCrear) {
            guardarUsuario();
        }
        //BOTON LEER TODOS
        if (e.getSource() == form.btnLeer) {
            llenarTabla();
        }

        //BOTON BUSCAR CODIGO
        if (e.getSource() == form.btnBuscar) {

        }
        //BOTON MODIFICAR
        if (e.getSource() == form.btnModificar) {
            modificarUsuario();
        }
        //boton eliminar
        if (e.getSource() == form.btnEliminar) {
            eliminarUsuario();
        }

        if (e.getSource() == form.btnLimpiar) {
            limpiar();
        }

        if (e.getSource() == form.btnSalir) {
            this.form.dispose();
        }
    }

    //METODOS CRUD *************************************************************************
    //GUARDAR
    public void guardarUsuario() {

        if (validarCamposNoVacios()) {

            if (verificarContras()) {
                usuario.setNombre(form.txtNombre1.getText());
                usuario.setContrasena(form.txtContra1.getText());
                usuario.setRol((String) form.cbUsuarios.getSelectedItem());
                usuario.setEstado("Activo");
                if (consUsuario.crearUsuario(usuario)) {
                    limpiar();
                }
            }
        }
    }

    //MODIFICAR
    public void modificarUsuario() {

        if (validarCamposNoVacios()) {

            if (verificarContras()) {
                usuario.setCodigo(Integer.parseInt(form.txtCodigo.getText()));
                usuario.setNombre(form.txtNombre1.getText());
                usuario.setContrasena(form.txtContra1.getText());
                usuario.setRol((String) form.cbUsuarios.getSelectedItem());
                if (consUsuario.modificarUsuario(usuario)) {
                    limpiar();
                }
            }
        }
    }

    //ELIMINAR
    public void eliminarUsuario() {

        if (validarCamposNoVacios()) {

            if (verificarContras()) {
                usuario.setCodigo(Integer.parseInt(form.txtCodigo.getText()));
                if (consUsuario.eliminarUsuario(usuario)) {
                    limpiar();
                }
            }

        }
    }

    //LEER
    public void llenarTabla() {
        modelo = (DefaultTableModel) form.tbl_usuarios.getModel();
        modelo.setRowCount(0);
        ArrayList<Usuario> listaUsuarios = consUsuario.leerTodosUsuarios();
        int registros = listaUsuarios.size();
        for (int i = 0; i < registros; i++) {
            Usuario usuarioTemporal = listaUsuarios.get(i);

            datos[0] = usuarioTemporal.getCodigo();
            datos[1] = usuarioTemporal.getNombre();
            datos[2] = usuarioTemporal.getRol();

            modelo.addRow(datos);
        }
        form.tbl_usuarios.setModel(modelo);
    }

    //VALIDACIONES **************************************************************************
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

    //OTROS METODOS
    //LIMPIAR
    public void limpiar() {
        form.txtCodigo.setText("");
        form.txtNombre1.setText("");
        form.txtContra1.setText("");
        form.txtVerificarContra.setText("");
        form.cbUsuarios.setSelectedIndex(0);
        modelo = (DefaultTableModel) form.tbl_usuarios.getModel();
        modelo.setRowCount(0);
    }

    //RESALTAR CAMPO
    public void resaltarCampoVacio(JTextField campo) {
        Color colorResaltado = new Color(219, 52, 52);
        campo.setBackground(colorResaltado);
    }

    //OBTENER SIGUIENTE CODIGO
    public int devolverCodigoSiguiente() {
        return consUsuario.leerTodosUsuarios().size() + 1;
    }

    //HABILITAR BOTONES
    public void habilitarBotones() {
        form.btnCancelar.setEnabled(false);
        form.btnCrear.setEnabled(false);

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
        form.txtCodigo.setText(String.valueOf(devolverCodigoSiguiente()));

        form.btnBuscar.setEnabled(false);
        form.btnEliminar.setEnabled(false);
        form.btnLeer.setEnabled(false);
        form.btnAgregar.setEnabled(false);
        form.btnLimpiar.setEnabled(false);
        form.btnModificar.setEnabled(false);
        form.btnSalir.setEnabled(false);
    }

}
