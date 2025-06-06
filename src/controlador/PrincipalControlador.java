/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Reportes.frm_Reportes;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
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
import vista.frm_login;
import vista.frm_Empleados;
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
    private frm_login formLogin;
    private frm_Reportes formReportes;
    private frm_Empleados formEmpleados;
    

    public PrincipalControlador(frm_Principal formPrin, frm_login formLogin,frm_Usuarios frmUsuarios,frm_Padres formPadres,frm_Grados formGrados,frm_Materias formMaterias,frm_Alumnos formAlumnos,frm_Profesor formProfesor, frm_Asistencias formAsistencias,frm_Calificaciones formCalificaciones, frm_Empleados formEmpleados) {
        this.formPrin = formPrin;
        this.frmUsuarios = frmUsuarios;
        this.formPadres = formPadres;
        this.formGrados = formGrados;
        this.formMaterias = formMaterias;
        this.formAlumnos=formAlumnos;
        this.formProfesor = formProfesor;
        this.formAsistencias=formAsistencias;
        this.formCalificaciones=formCalificaciones;
        this.formLogin=formLogin;
        this.formEmpleados=formEmpleados;
        this.formsConsultas = new frm_Consulta(formPrin, true);
        this.formReportes = new frm_Reportes(formPrin, true);
        
        
        
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
         this.formPrin.btnEmpleados.addActionListener(this);
        
        
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
        formReportes.setLocationRelativeTo(null);
        formEmpleados.setLocationRelativeTo(null);
        this.formPrin.jblManual.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            // Enlace del PowerPoint
            String url = "C://ProyectoColegioSala1//ManualUsuario.pptx"; // Sustituir con el enlace real
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});
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
       //EMPLEADOS
        if(e.getSource()==formPrin.btnEmpleados){
            formEmpleados.setVisible(true);}
       //CALIFICACIONES
       if(e.getSource()==formPrin.btnCalificaciones){
            formCalificaciones.lblUsuario.setText(formPrin.lblUsuario.getText());
            formCalificaciones.txtProfesor.setText(obtenerEncargado(obtenerUsuario()));
            formCalificaciones.setVisible(true);
            
        }
        //REPORTES
       if(e.getSource()==formPrin.btnReportes1){
            formReportes.setVisible(true);
        }
        //ASISTENCIAS
       if(e.getSource()==formPrin.btnConsultas){
            formsConsultas.setVisible(true);
            //FORMULARIO CONSULTAS
        }
        //SALIR
        if(e.getSource()==formPrin.btnSalir){
            formLogin.setVisible(true);
            formPrin.dispose();
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
