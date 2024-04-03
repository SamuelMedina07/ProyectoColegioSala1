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
import modelo.ConsultaGrados;
import modelo.Padre;
import modelo.ConsultaPadres;
import modelo.Grado;
import vista.frm_Consulta_Grados;
import vista.frm_Consulta_Padres;
import vista.frm_Grados;
import vista.frm_Padres;

/**
 *
 * @author ammcp
 */
public class gradoControlador implements ActionListener {

    private Grado grado;
    private frm_Grados formGrados;
    private frm_Consulta_Grados formConsulta;
    private ConsultaGrados consultaGrados;
    private Object datos[] = new Object[3];
    private DefaultTableModel modelo;

    public gradoControlador(Grado grado, frm_Grados formGrados, ConsultaGrados consultaGrados,frm_Consulta_Grados formConsulta) {
        this.grado = grado;
        this.formGrados = formGrados;
        this.consultaGrados = consultaGrados;
        this.formConsulta = formConsulta;

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        inicializarBotonesFormulario();
        inicializarBotonBuscar();
        habilitarBotones();
    }

    private void inicializarBotonesFormulario() {
        formGrados.btnAgregar.addActionListener(this);
        formGrados.btnCancelar.addActionListener(this);
        formGrados.btnCrear.addActionListener(this);
        formGrados.btnLeer.addActionListener(this);
        formGrados.btnBuscar.addActionListener(this);
        formGrados.btnModificar.addActionListener(this);
        formGrados.btnEliminar.addActionListener(this);
        formGrados.btnLimpiar.addActionListener(this);
        formGrados.btnSalir.addActionListener(this);
    }

    private void inicializarBotonBuscar() {
        formConsulta.btn_buscarPor.addActionListener(this);
        formConsulta.tbl_consulta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                manejarEventoTablaGrados();
            }
        });
    }
     private void manejarEventoTablaGrados() {
        int filaSeleccionada = formConsulta.tbl_consulta.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) formConsulta.tbl_consulta.getModel();
        if (filaSeleccionada >= 0) {
            String id = String.valueOf(model.getValueAt(filaSeleccionada, 0));
            Grado Seleccionado = consultaGrados.obtenerGradoSegunId(Integer.parseInt(id));

            formGrados.txtCodigo.setText(String.valueOf(Seleccionado.getId()));
            formGrados.txtNombre.setText(String.valueOf(Seleccionado.getNombre()));
            model.setRowCount(0);
            formConsulta.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formGrados.btnAgregar) {
            limpiar();
            deshabilitarBotones();
        }
        if (e.getSource() == formGrados.btnCancelar) {
            habilitarBotones();
            limpiar();
        }
        if (e.getSource() == formGrados.btnCrear) {
            guardarGrado();
        }
        if (e.getSource() == formGrados.btnLeer) {
            llenarTabla();
        }
        if (e.getSource() == formGrados.btnBuscar) {
            formGrados.setVisible(true);
        }
        if (e.getSource() == formGrados.btnBuscar) {
            consultarGrados();
        }
        if (e.getSource() == formGrados.btnModificar) {
            modificarGrado();
        }
        if (e.getSource() == formGrados.btnEliminar) {
            eliminarGrado();
        }
        if (e.getSource() == formGrados.btnLimpiar) {
            limpiar();
        }
        if (e.getSource() == formGrados.btnSalir) {
            formGrados.dispose();
        }
    }

    public void guardarGrado() {
        if (validarYVerificarGrado()) {
            if (consultaGrados.crearGrado(grado)) {
                limpiar();
                habilitarBotones();
            }
        }
    }

    public void modificarGrado() {
        if (validarYVerificarGrado()) {
            if (consultaGrados.modificarGrado(grado)) {
                limpiar();
            }
        }
    }

    public void eliminarGrado() {
        if (!formGrados.txtCodigo.getText().isEmpty()) {
            grado.setId(Integer.parseInt(formGrados.txtCodigo.getText()));
            if (consultaGrados.eliminarGrado(grado)) {
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN GRADO.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void llenarTabla() {
        modelo = (DefaultTableModel) formGrados.tbl_registros.getModel();
        modelo.setRowCount(0);
        ArrayList<Grado> listaGrados = consultaGrados.leerTodosGrados();
        for (Grado grado : listaGrados) {
            datos[0] = grado.getId();
            datos[1] = grado.getNombre();
            datos[2] = grado.getEstado();
            modelo.addRow(datos);
        }
        formGrados.tbl_registros.setModel(modelo);
    }

    public void consultarGrados() {
        String campoSeleccionado = (String) formConsulta.cbBuscarPor.getSelectedItem();
        String campoBuscar = formConsulta.txtBuscar.getText();

        switch (campoSeleccionado) {
            case "CÓDIGO":
                try {
                    int idGrado = Integer.parseInt(campoBuscar);
                    Grado gradoEncontrado = consultaGrados.obtenerGradoSegunId(idGrado);
                    if (gradoEncontrado != null) {
                        ArrayList<Grado> listaGrado = new ArrayList<>();
                        listaGrado.add(gradoEncontrado);
                        llenarTablaConsulta(listaGrado);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ningún grado con el ID especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor de ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "NOMBRE":
                manejarResultadoConsulta(consultaGrados.buscarGradosPorNombre(campoBuscar), "No se encontró ningún grado con el nombre especificado.");
                break;
            case "ACTIVOS":
                manejarResultadoConsulta(consultaGrados.buscarGradosActivos(), "No se encontró ningún grado activo.");
                break;
            case "INACTIVOS":
                manejarResultadoConsulta(consultaGrados.buscarGradosInactivos(), "No se encontró ningún grado inactivo.");
                break;
        }
    }

    private void manejarResultadoConsulta(ArrayList<Grado> gradosEncontrados, String mensajeError) {
        if (!gradosEncontrados.isEmpty()) {
            llenarTablaConsulta(gradosEncontrados);
        } else {
            JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarYVerificarGrado() {
        if (validarCamposNoVacios()) {
            grado.setNombre(formGrados.txtNombre.getText());
            grado.setEstado("Activo");
            return true;
        }
        return false;
    }

    public boolean validarCamposNoVacios() {
        boolean camposValidos = true;

        if (formGrados.txtNombre.getText().trim().isEmpty()) {
            resaltarCampoVacio(formGrados.txtNombre);
            camposValidos = false;
        }
        if (!camposValidos) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, COMPLETE EL FORMULARIO.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return camposValidos;
    }

    public void limpiar() {
        formGrados.txtCodigo.setText(String.valueOf(consultaGrados.obtenerSiguienteCodigo()));
        formGrados.txtNombre.setText("");
        modelo = (DefaultTableModel) formGrados.tbl_registros.getModel();
        modelo.setRowCount(0);
    }

    public void resaltarCampoVacio(JTextField campo) {
        Color colorResaltado = new Color(219, 52, 52);
        campo.setBackground(colorResaltado);
    }

    public void habilitarBotones() {
        formGrados.btnCancelar.setEnabled(false);
        formGrados.btnCrear.setEnabled(false);

        formGrados.btnBuscar.setEnabled(true);
        formGrados.btnEliminar.setEnabled(true);
        formGrados.btnLeer.setEnabled(true);
        formGrados.btnAgregar.setEnabled(true);
        formGrados.btnLimpiar.setEnabled(true);
        formGrados.btnModificar.setEnabled(true);
        formGrados.btnSalir.setEnabled(true);
    }

    public void deshabilitarBotones() {
        formGrados.btnCancelar.setEnabled(true);
        formGrados.btnCrear.setEnabled(true);
        formGrados.txtCodigo.setText(String.valueOf(consultaGrados.obtenerSiguienteCodigo()));

        formGrados.btnBuscar.setEnabled(false);
        formGrados.btnEliminar.setEnabled(false);
        formGrados.btnLeer.setEnabled(false);
        formGrados.btnAgregar.setEnabled(false);
        formGrados.btnLimpiar.setEnabled(false);
        formGrados.btnModificar.setEnabled(false);
        formGrados.btnSalir.setEnabled(false);
    }

    public void llenarTablaConsulta(ArrayList<Grado> listaGrados) {
        modelo = (DefaultTableModel) formConsulta.tbl_consulta.getModel();
        modelo.setRowCount(0);
        for (Grado grado : listaGrados) {
            datos[0] = grado.getId();
            datos[1] = grado.getNombre();
            datos[2] = grado.getEstado();
            modelo.addRow(datos);
        }
        formConsulta.tbl_consulta.setModel(modelo);
    }
}
