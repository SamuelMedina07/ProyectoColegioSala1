/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_colegio_paii_sala1;

import animacionesdiseno.login;
import animacionesdiseno.usuarios;
import controlador.LoginControlador;
import controlador.PrincipalControlador;
import controlador.gradoControlador;
import controlador.padreControlador;
import controlador.usuarioControlador;
import modelo.ConsultaGrados;
import modelo.ConsultaPadres;
import modelo.ConsultaUsuarios;
import modelo.Grado;
import modelo.Padre;
import modelo.Usuario;
import vista.frm_Consulta_Grados;
import vista.frm_Consulta_Padres;
import vista.frm_Consulta_Usuarios;
import vista.frm_Grados;
import vista.frm_Inicio;
import vista.frm_Padres;
import vista.frm_Principal;
import vista.frm_Usuarios;
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
        //Animacion&Diseño
        login disenologin = new login(formLogin);
        
        
        //INICIO
        frm_Inicio formInicio = new frm_Inicio(formLogin);
        formInicio.setVisible(true);
        
        //USUARIO MVC
        Usuario usuario2 = new Usuario();
        frm_Usuarios formUsuarios = new frm_Usuarios(frm_pri, true, "");
        frm_Consulta_Usuarios formConsUsuario = new frm_Consulta_Usuarios(formUsuarios, true);
        ConsultaUsuarios consUsuario2 = new ConsultaUsuarios();
        usuarioControlador contUsuario = new usuarioControlador(usuario2, formUsuarios, consUsuario2,formConsUsuario);
        //Animacion&Diseño
        usuarios disenousuario = new usuarios(formUsuarios);
        
        //PADRES MVC
        Padre padre = new Padre();
        frm_Padres formPadre = new frm_Padres(frm_pri, true, "");
        ConsultaPadres consPadres = new ConsultaPadres();
        frm_Consulta_Padres formConsPadres = new frm_Consulta_Padres(formPadre, true);
        padreControlador contPadre = new padreControlador(padre, formPadre, consPadres, formConsPadres);
        
        //GRADOS MVC
        Grado grado = new Grado();
        frm_Grados formGrados = new frm_Grados(frm_pri, true, "");
        ConsultaGrados consGrados = new ConsultaGrados();
        frm_Consulta_Grados formConsultaGrados = new frm_Consulta_Grados(formGrados, true);
        gradoControlador contControlador = new gradoControlador(grado, formGrados, consGrados, formConsultaGrados);
        
        
        //PRINCIPAL
        PrincipalControlador contPrincipal = new PrincipalControlador(frm_pri, formUsuarios,formPadre,formGrados);
        contPrincipal.inciar();
       
    }
    
}
