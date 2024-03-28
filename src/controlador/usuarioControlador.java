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
        if (e.getSource() == form.btnLeer) {
            llenarTabla();
        }

        //BOTON CONSULTA USUARIO
        if (e.getSource() == form.btnBuscar) {
            formConsUsuario.setVisible(true);
        }
        //BOTON BUSCAR USARIO FILATRADO
        if (e.getSource() == formConsUsuario.btn_buscarPor) {
            consultarUsuarios();
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

    //LEER POR FILTRADO
    public void consultarUsuarios() {
        String campoSeleccionado = (String) formConsUsuario.cbBuscarPor.getSelectedItem();
        String campoBuscar = formConsUsuario.txtBuscar.getText();

        switch (campoSeleccionado) {
            case "ID":
                try {
                    int idUsuario = Integer.parseInt(campoBuscar);
                    Usuario usuarioEncontrado = consUsuario.obtenerUusuarioSegunIdUsuario(idUsuario);
                    if (usuarioEncontrado != null) {
                        ArrayList<Usuario> listaUsuariosId = new ArrayList<>();
                        listaUsuariosId.add(usuarioEncontrado);
                        llenarTablaConsulta(listaUsuariosId);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el ID especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor de ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "USUARIO":
                manejarResultadoConsulta(consUsuario.buscarUsuariosPorNombre(campoBuscar), "No se encontró ningún usuario con el nombre especificado.");
                break;
            case "ROL":
                manejarResultadoConsulta(consUsuario.buscarUsuariosPorRol(campoBuscar), "No se encontró ningún usuario con el rol especificado.");
                break;
            case "ACTIVOS":
                manejarResultadoConsulta(consUsuario.buscarUsuariosActivos(), "No se encontró ningún usuario activo.");
                break;
            case "INACTIVOS":
                manejarResultadoConsulta(consUsuario.buscarUsuariosInactivos(), "No se encontró ningún usuario inactivo.");
                break;
        }

    }

    //METODO AUXILIAR PARA LEER POR FILTRADO
    private void manejarResultadoConsulta(ArrayList<Usuario> usuariosEncontrados, String mensajeError) {
        if (!usuariosEncontrados.isEmpty()) {
            llenarTablaConsulta(usuariosEncontrados);
        } else {
            JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
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
        modelo = (DefaultTableModel) form.tbl_usuarios.getModel();
        modelo.setRowCount(0);
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
        form.txtCodigo.setText(String.valueOf(obtenerCodigoSiguiente()));

        form.btnBuscar.setEnabled(false);
        form.btnEliminar.setEnabled(false);
        form.btnLeer.setEnabled(false);
        form.btnAgregar.setEnabled(false);
        form.btnLimpiar.setEnabled(false);
        form.btnModificar.setEnabled(false);
        form.btnSalir.setEnabled(false);
    }

    //LENNAR TABLA DEL FORMULARIO DE CONSULTAS:
    public void llenarTablaConsulta(ArrayList<Usuario> listaUsuarios) {
        modelo = (DefaultTableModel) formConsUsuario.tbl_usuarios.getModel();
        modelo.setRowCount(0);
        int registros = listaUsuarios.size();
        for (int i = 0; i < registros; i++) {
            Usuario usuarioTemporal = listaUsuarios.get(i);

            datos[0] = usuarioTemporal.getCodigo();
            datos[1] = usuarioTemporal.getNombre();
            datos[2] = usuarioTemporal.getRol();
            datos[3] = usuarioTemporal.getEstado();
            modelo.addRow(datos);
        }
        formConsUsuario.tbl_usuarios.setModel(modelo);
    }

}
