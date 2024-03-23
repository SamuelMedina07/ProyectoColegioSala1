/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_colegio_paii_sala1;

import controlador.LoginControlador;
import modelo.ConsultaUsuarios;
import modelo.Usuario;
import vista.frm_Inicio;
import vista.frm_Principal;
import vista.frm_login;

/**
 *
 * @author ammcp
 */
public class Proyecto_Colegio_PAII_Sala1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       frm_Principal frm_pri = new frm_Principal(("Sala 1"));
        
        //LOGIN MVC
        Usuario usuario = new Usuario();
        frm_login formLogin = new frm_login();
        ConsultaUsuarios consUsuario = new ConsultaUsuarios();
        LoginControlador contLogin = new LoginControlador(usuario, formLogin, consUsuario,frm_pri);
        
        //INICIO
        frm_Inicio formInicio = new frm_Inicio(formLogin);
        formInicio.setVisible(true);
        
        //USUARIO MVC
    }
    
}
