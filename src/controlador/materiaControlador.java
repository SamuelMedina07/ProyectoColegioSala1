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
import modelo.ConsultaMaterias;
import modelo.Padre;
import modelo.ConsultaPadres;
import modelo.Grado;
import modelo.Materia;
import vista.frm_Consulta_Grados;
import vista.frm_Consulta_Materias;
import vista.frm_Consulta_Padres;
import vista.frm_Grados;
import vista.frm_Materias;
import vista.frm_Padres;

/**
 *
 * @author ammcp
 */
public class materiaControlador implements ActionListener {

    private Materia materia;
    private frm_Materias formMateria;
    private frm_Consulta_Materias formConsulta;
    private ConsultaMaterias consultaMaterias;
    private Object datos[] = new Object[3];
    private DefaultTableModel modelo;

    public materiaControlador(Materia materia, frm_Materias formMateria, ConsultaMaterias consultaMaterias, frm_Consulta_Materias formConsulta) {
        this.materia = materia;
        this.formMateria = formMateria;
        this.consultaMaterias = consultaMaterias;
        this.formConsulta = formConsulta;

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        inicializarBotonesFormulario();
        inicializarBotonBuscar();
        habilitarBotones();
    }

    private void inicializarBotonesFormulario() {
        formMateria.btnAgregar.addActionListener(this);
        formMateria.btnCancelar.addActionListener(this);
        formMateria.btnCrear.addActionListener(this);
        formMateria.btnLeer.addActionListener(this);
        formMateria.btnBuscar.addActionListener(this);
        formMateria.btnModificar.addActionListener(this);
        formMateria.btnEliminar.addActionListener(this);
        formMateria.btnLimpiar.addActionListener(this);
        formMateria.btnSalir.addActionListener(this);
    }

    private void inicializarBotonBuscar() {
        formConsulta.btn_buscarPor.addActionListener(this);
        formConsulta.tbl_consulta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                manejarEventoTablaMaterias();
            }
        });
    }

    private void manejarEventoTablaMaterias() {
        int filaSeleccionada = formConsulta.tbl_consulta.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) formConsulta.tbl_consulta.getModel();
        if (filaSeleccionada >= 0) {
            String id = String.valueOf(model.getValueAt(filaSeleccionada, 0));
            Materia seleccionada = consultaMaterias.obtenerMateriaSegunId(Integer.parseInt(id));

            formMateria.txtCodigo.setText(String.valueOf(seleccionada.getId()));
            formMateria.txtNombre.setText(String.valueOf(seleccionada.getNombre()));
            model.setRowCount(0);
            formConsulta.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formMateria.btnAgregar) {
            limpiar();
            deshabilitarBotones();
        }
        if (e.getSource() == formMateria.btnCancelar) {
            habilitarBotones();
            limpiar();
        }
        if (e.getSource() == formMateria.btnCrear) {
            guardarMateria();
        }
        if (e.getSource() == formMateria.btnLeer) {
            llenarTabla();
        }
        if (e.getSource() == formMateria.btnBuscar) {
            formConsulta.setVisible(true);
        }
        if (e.getSource() == formConsulta.btn_buscarPor) {
            consultarMaterias();
        }
        if (e.getSource() == formMateria.btnModificar) {
            modificarMateria();
        }
        if (e.getSource() == formMateria.btnEliminar) {
            eliminarMateria();
        }
        if (e.getSource() == formMateria.btnLimpiar) {
            limpiar();
        }
        if (e.getSource() == formMateria.btnSalir) {
            formMateria.dispose();
        }
    }

    public void guardarMateria() {
        if (validarYVerificarMateria()) {
            if (consultaMaterias.crearMateria(materia)) {
                limpiar();
                habilitarBotones();
            }
        }
    }

    public void modificarMateria() {
        if (validarYVerificarMateria()) {
            if (consultaMaterias.modificarMateria(materia)) {
                limpiar();
            }
        }
    }

    public void eliminarMateria() {
        if (!formMateria.txtCodigo.getText().isEmpty()) {
            materia.setId(Integer.parseInt(formMateria.txtCodigo.getText()));
            if (consultaMaterias.eliminarMateria(materia)) {
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA MATERIA.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void llenarTabla() {
        modelo = (DefaultTableModel) formMateria.tbl_registros.getModel();
        modelo.setRowCount(0);
        ArrayList<Materia> listaMaterias = consultaMaterias.leerTodasMaterias();
        for (Materia materia : listaMaterias) {
            datos[0] = materia.getId();
            datos[1] = materia.getNombre();
            datos[2] = materia.getEstado();
            modelo.addRow(datos);
        }
        formMateria.tbl_registros.setModel(modelo);
    }

    public void consultarMaterias() {
        String campoSeleccionado = (String) formConsulta.cbBuscarPor.getSelectedItem();
        String campoBuscar = formConsulta.txtBuscar.getText();

        switch (campoSeleccionado) {
            case "ID":
                try {
                    int idMateria = Integer.parseInt(campoBuscar);
                    Materia materiaEncontrada = consultaMaterias.obtenerMateriaSegunId(idMateria);
                    if (materiaEncontrada != null) {
                        ArrayList<Materia> listaMateria = new ArrayList<>();
                        listaMateria.add(materiaEncontrada);
                        llenarTablaConsulta(listaMateria);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna materia con el ID especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor de ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "NOMBRE":
                manejarResultadoConsulta(consultaMaterias.buscarMateriasPorNombre(campoBuscar), "No se encontró ninguna materia con el nombre especificado.");
                break;
            case "ACTIVAS":
                manejarResultadoConsulta(consultaMaterias.buscarMateriasActivas(), "No se encontró ninguna materia activa.");
                break;
            case "INACTIVAS":
                manejarResultadoConsulta(consultaMaterias.buscarMateriasInactivas(), "No se encontró ninguna materia inactiva.");
                break;
        }
    }

    private void manejarResultadoConsulta(ArrayList<Materia> materiasEncontradas, String mensajeError) {
        if (!materiasEncontradas.isEmpty()) {
            llenarTablaConsulta(materiasEncontradas);
        } else {
            JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarYVerificarMateria() {
        if (validarCamposNoVacios()) {
            materia.setId(Integer.parseInt(formMateria.txtCodigo.getText()));
            String nombreMateria = formMateria.txtNombre.getText().toUpperCase(); // Convertir el nombre de la materia a mayúsculas
            materia.setNombre(nombreMateria);
            materia.setEstado("Activo");

            // Verificar si la materia ya existe en la base de datos
            if (consultaMaterias.existeMateria(nombreMateria, materia.getId())) {
                JOptionPane.showMessageDialog(null, "Ya existe una materia con el mismo nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            return true;
        }
        return false;
    }

    public boolean validarCamposNoVacios() {
        boolean camposValidos = true;

        if (formMateria.txtNombre.getText().trim().isEmpty()) {
            resaltarCampoVacio(formMateria.txtNombre);
            camposValidos = false;
        }
        if (!camposValidos) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, COMPLETE EL FORMULARIO.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return camposValidos;
    }

    public void limpiar() {
        formMateria.txtCodigo.setText("");
        formMateria.txtNombre.setText("");
        modelo = (DefaultTableModel) formMateria.tbl_registros.getModel();
        modelo.setRowCount(0);
    }

    public void resaltarCampoVacio(JTextField campo) {
        Color colorResaltado = new Color(219, 52, 52);
        campo.setBackground(colorResaltado);
    }

    public void habilitarBotones() {
        formMateria.btnCancelar.setEnabled(false);
        formMateria.btnCrear.setEnabled(false);

        formMateria.btnBuscar.setEnabled(true);
        formMateria.btnEliminar.setEnabled(true);
        formMateria.btnLeer.setEnabled(true);
        formMateria.btnAgregar.setEnabled(true);
        formMateria.btnLimpiar.setEnabled(true);
        formMateria.btnModificar.setEnabled(true);
        formMateria.btnSalir.setEnabled(true);
    }

    public void deshabilitarBotones() {
        formMateria.btnCancelar.setEnabled(true);
        formMateria.btnCrear.setEnabled(true);
        formMateria.txtCodigo.setText(String.valueOf(consultaMaterias.obtenerSiguienteCodigo()));

        formMateria.btnBuscar.setEnabled(false);
        formMateria.btnEliminar.setEnabled(false);
        formMateria.btnLeer.setEnabled(false);
        formMateria.btnAgregar.setEnabled(false);
        formMateria.btnLimpiar.setEnabled(false);
        formMateria.btnModificar.setEnabled(false);
        formMateria.btnSalir.setEnabled(false);
    }

    public void llenarTablaConsulta(ArrayList<Materia> listaMaterias) {
        modelo = (DefaultTableModel) formConsulta.tbl_consulta.getModel();
        modelo.setRowCount(0);
        for (Materia materia : listaMaterias) {
            datos[0] = materia.getId();
            datos[1] = materia.getNombre();
            datos[2] = materia.getEstado();
            modelo.addRow(datos);
        }
        formConsulta.tbl_consulta.setModel(modelo);
    }
}