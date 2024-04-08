/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConsultaProfesor;
import modelo.ConsultaUsuarios;
import modelo.Profesor;
import modelo.Usuario;
import vista.frm_Alumnos;
import vista.frm_Asistencias;
import vista.frm_Calificaciones;
import vista.frm_Consulta;
import vista.frm_Grados;
import vista.frm_Materias;
import vista.frm_Principal;
import vista.frm_Usuarios;
import vista.frm_Padres;
import vista.frm_Profesor;

/**
 *
 * @author ammcp
 */
public class PrincipalControlador implements ActionListener{
    //USUARIO
    ConsultaUsuarios consUsuarios = new ConsultaUsuarios();
    ConsultaProfesor consProfesor = new ConsultaProfesor();
    //
    private frm_Principal formPrin;
    private frm_Usuarios frmUsuarios;
    private frm_Padres formPadres;
    private frm_Grados formGrados;
    private frm_Materias formMaterias;
    private frm_Alumnos formAlumnos;
    private frm_Profesor formProfesor;
    private frm_Asistencias formAsistencias;
    private frm_Calificaciones formCalificaciones;
    private frm_Consulta formsConsultas;
    

    public PrincipalControlador(frm_Principal formPrin, frm_Usuarios frmUsuarios,frm_Padres formPadres,frm_Grados formGrados,frm_Materias formMaterias,frm_Alumnos formAlumnos,frm_Profesor formProfesor, frm_Asistencias formAsistencias,frm_Calificaciones formCalificaciones) {
        this.formPrin = formPrin;
        this.frmUsuarios = frmUsuarios;
        this.formPadres = formPadres;
        this.formGrados = formGrados;
        this.formMaterias = formMaterias;
        this.formAlumnos=formAlumnos;
        this.formProfesor = formProfesor;
        this.formAsistencias=formAsistencias;
        this.formCalificaciones=formCalificaciones;
        this.formsConsultas = new frm_Consulta(formPrin, true);
        
        
        this.formPrin.btnUsuarios.addActionListener(this);
        this.formPrin.btnPadres.addActionListener(this);
        this.formPrin.btnSalir.addActionListener(this);
        this.formPrin.btnGrados.addActionListener(this);
        this.formPrin.btnMaterias.addActionListener(this);
        this.formPrin.btnAlumnos.addActionListener(this);
        this.formPrin.btnProfesores.addActionListener(this);
        this.formPrin.btnAsistencias.addActionListener(this);
        this.formPrin.btnCalificaciones.addActionListener(this);
        this.formPrin.btnConsultas.addActionListener(this);
        this.formPrin.btnReportes1.addActionListener(this);
        
    }
    
    public void inciar(){
        formPrin.setLocationRelativeTo(null);
        frmUsuarios.setLocationRelativeTo(null);
        formPadres.setLocationRelativeTo(null);
        formGrados.setLocationRelativeTo(null);
        formMaterias.setLocationRelativeTo(null);
        formAlumnos.setLocationRelativeTo(null);
        formProfesor.setLocationRelativeTo(null);
        formAsistencias.setLocationRelativeTo(null);
        formCalificaciones.setLocationRelativeTo(null);
        formsConsultas.setLocationRelativeTo(null);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //USUARIOS
        if(e.getSource()==formPrin.btnUsuarios){
            frmUsuarios.lblUsuario.setText(formPrin.lblUsuario.getText());
            frmUsuarios.setVisible(true);
        }
        //PADRES
        if(e.getSource()==formPrin.btnPadres){
            formPadres.lblUsuario.setText(formPrin.lblUsuario.getText());
            formPadres.setVisible(true);
        }
       //GRADOS
       if(e.getSource()==formPrin.btnGrados){
            formPadres.lblUsuario.setText(formPrin.lblUsuario.getText());
            formGrados.setVisible(true);
        }
       //MATERIAS
       if(e.getSource()==formPrin.btnMaterias){
            formMaterias.lblUsuario.setText(formPrin.lblUsuario.getText());
            formMaterias.setVisible(true);
        }
       //ALUMNOS
       if(e.getSource()==formPrin.btnAlumnos){
            formAlumnos.lblUsuario.setText(formPrin.lblUsuario.getText());
            formAlumnos.setVisible(true);
        }
       //PROFESORES
       if(e.getSource()==formPrin.btnProfesores){
            formProfesor.lblUsuario.setText(formPrin.lblUsuario.getText());
            formProfesor.setVisible(true);
        }
       //ASISTENCIAS
       if(e.getSource()==formPrin.btnAsistencias){
            formAsistencias.setVisible(true);
        }
       //CALIFICACIONES
       if(e.getSource()==formPrin.btnCalificaciones){
            formCalificaciones.lblUsuario.setText(formPrin.lblUsuario.getText());
            formCalificaciones.txtProfesor.setText(obtenerEncargado(obtenerUsuario()));
            formCalificaciones.setVisible(true);
            
        }
        //REPORTES
       if(e.getSource()==formPrin.btnReportes1){
            //FORMULARIO REPORTES
        }
        //ASISTENCIAS
       if(e.getSource()==formPrin.btnConsultas){
            formsConsultas.setVisible(true);
            //FORMULARIO CONSULTAS
        }
        //SALIR
        if(e.getSource()==formPrin.btnSalir){
            System.exit(0);
        }
        
    }
    
    public Usuario obtenerUsuario(){
        Usuario user = consUsuarios.obtenerUsuarioSegunNombre(formPrin.lblUsuario.getText());
        return user;
    }
    
    public String obtenerEncargado(Usuario user){
        String nombreEncargado = "NO CONECTADO";
        if(user.getRol().equals("PROFESOR")){
            Profesor profesor = consProfesor.obtenerProfesorPorCodigoUsuario(user.getCodigo());
            nombreEncargado = profesor.getNombreCompleto();
        }
        if(user.getRol().equals("ADMIN")){
            nombreEncargado = user.getNombre();
        }
        
       return nombreEncargado;
    }
    
}
