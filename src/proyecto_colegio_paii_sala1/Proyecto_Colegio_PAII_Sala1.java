/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_colegio_paii_sala1;

import animacionesdiseno.alumnos;
import animacionesdiseno.grados;
import animacionesdiseno.login;
import animacionesdiseno.materias;
import animacionesdiseno.padres;
import animacionesdiseno.profesores;
import animacionesdiseno.usuarios;
import controlador.AsistenciaControlador;
import controlador.LoginControlador;
import controlador.PrincipalControlador;
import controlador.alumnoControlador;
import controlador.gradoControlador;
import controlador.materiaControlador;
import controlador.padreControlador;
import controlador.profesorControlador;
import controlador.usuarioControlador;
import modelo.Alumno;
import modelo.Asistencia;
import modelo.ConsultaAlumnos;
import modelo.ConsultaGrados;
import modelo.ConsultaMaterias;
import modelo.ConsultaPadres;
import modelo.ConsultaProfesor;
import modelo.ConsultaUsuarios;
import modelo.ConsultasAsistencia;
import modelo.Grado;
import modelo.Materia;
import modelo.Padre;
import modelo.Profesor;
import modelo.Usuario;
import vista.frm_Alumnos;
import vista.frm_Asistencias;
import vista.frm_Consulta_Alumnos;
import vista.frm_Consulta_Grados;
import vista.frm_Consulta_Materias;
import vista.frm_Consulta_Padres;
import vista.frm_Consulta_Profesor;
import vista.frm_Consulta_Usuarios;
import vista.frm_Grados;
import vista.frm_Inicio;
import vista.frm_Materias;
import vista.frm_Padres;
import vista.frm_Principal;
import vista.frm_Profesor;
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
        LoginControlador contLogin = new LoginControlador(usuario, formLogin, consUsuario, frm_pri);
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
        usuarioControlador contUsuario = new usuarioControlador(usuario2, formUsuarios, consUsuario2, formConsUsuario);
        //Animacion&Diseño
        usuarios disenousuario = new usuarios(formUsuarios, formConsUsuario);

        //PADRES MVC
        Padre padre = new Padre();
        frm_Padres formPadre = new frm_Padres(frm_pri, true, "");
        ConsultaPadres consPadres = new ConsultaPadres();
        frm_Consulta_Padres formConsPadres = new frm_Consulta_Padres(formPadre, true);
        padreControlador contPadre = new padreControlador(padre, formPadre, consPadres, formConsPadres);
        //Animacion&Diseño
        padres disenopadre = new padres(formPadre, formConsPadres);
        
        //GRADOS MVC
        Grado grado = new Grado();
        frm_Grados formGrados = new frm_Grados(frm_pri, true, "");
        ConsultaGrados consGrados = new ConsultaGrados();
        frm_Consulta_Grados formConsultaGrados = new frm_Consulta_Grados(formGrados, true);
        gradoControlador contControlador = new gradoControlador(grado, formGrados, consGrados, formConsultaGrados);
        //Animacion&Diseño
        grados disenogrados = new grados(formGrados,formConsultaGrados);
        
        //MATERIAS MVC
        Materia materia = new Materia();
        frm_Materias formMaterias = new frm_Materias(frm_pri, true, "");
        ConsultaMaterias consMaterias = new ConsultaMaterias();
        frm_Consulta_Materias formConsultaMaterias = new frm_Consulta_Materias(formMaterias, true);
        materiaControlador contMateria = new materiaControlador(materia, formMaterias, consMaterias, formConsultaMaterias);
        //Animacion&Diseño
         materias disenomateria = new materias(formMaterias,formConsultaMaterias);
         
        //ALUMNOS MVC
        Alumno alumno = new Alumno();
        frm_Alumnos formAlumnos = new frm_Alumnos(frm_pri, true, "");
        ConsultaAlumnos consAlumnos = new ConsultaAlumnos();
        frm_Consulta_Alumnos formConsultaAlumnos = new frm_Consulta_Alumnos(formAlumnos, true);
        alumnoControlador contAlumno = new alumnoControlador(alumno, formAlumnos, consAlumnos, formConsultaAlumnos);
        //Animacion&Diseño
        alumnos disenoalumnos = new alumnos(formAlumnos,formConsultaAlumnos);

        //PROFESOR MVC
        Profesor profesor = new Profesor();
        frm_Profesor formProfesor = new frm_Profesor(frm_pri, true, "");
        ConsultaProfesor consProfesor = new ConsultaProfesor();
        frm_Consulta_Profesor formConsultaProfesor = new frm_Consulta_Profesor(formProfesor, true);
        profesorControlador contProfesor = new profesorControlador(profesor, formProfesor, consProfesor, formConsultaProfesor);

        //ASISTENCIA
        Asistencia asistencia = new Asistencia();
        frm_Asistencias formAsistencias = new frm_Asistencias(frm_pri,true);
        ConsultasAsistencia consAsistencia = new ConsultasAsistencia();
        AsistenciaControlador contAsistencia = new AsistenciaControlador(asistencia,formAsistencias,consAsistencia,formConsultaAlumnos);
        //Animacion&Diseño
        profesores disenoprofesor = new profesores(formProfesor,formConsultaProfesor);
        //PRINCIPAL
        PrincipalControlador contPrincipal = new PrincipalControlador(frm_pri, formUsuarios, formPadre, formGrados, formMaterias, formAlumnos,formProfesor,formAsistencias);
        contPrincipal.inciar();

    }

}
