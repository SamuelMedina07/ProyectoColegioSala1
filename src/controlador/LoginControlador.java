package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultaUsuarios;
import modelo.Usuario;
import vista.frm_Principal;
import vista.frm_login;

public class LoginControlador implements ActionListener {

    private Usuario usuario;
    private frm_login formUsuario;
    private ConsultaUsuarios consulta;
    private frm_Principal formPrincipal;

    public LoginControlador(Usuario usuario, frm_login form, ConsultaUsuarios consulta, frm_Principal formPrincipal) {
        this.usuario = usuario;
        this.formUsuario = form;
        this.consulta = consulta;
        this.formPrincipal = formPrincipal;
        this.formUsuario.btnIngresar.addActionListener(this);
        this.formUsuario.btnCancelar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formUsuario.btnIngresar) {
            ingresar();
        }
    }

    public void ingresar() {

        String nombreUsuario = formUsuario.txtUsuario.getText();
        String contrasena = String.valueOf(formUsuario.txtContra.getPassword());

        // Verificar las credenciales
        if (consulta.verificarCredenciales(nombreUsuario, contrasena)) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
            // Abre la ventana principal
            formPrincipal.setVisible(true);
            formUsuario.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Inténtalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
