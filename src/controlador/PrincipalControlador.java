/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.frm_Alumnos;
import vista.frm_Asistencias;
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
    private frm_Principal formPrin;
    private frm_Usuarios frmUsuarios;
    private frm_Padres formPadres;
    private frm_Grados formGrados;
    private frm_Materias formMaterias;
    private frm_Alumnos formAlumnos;
    private frm_Profesor formProfesor;
    private frm_Asistencias formAsistencias;
    

    public PrincipalControlador(frm_Principal formPrin, frm_Usuarios frmUsuarios,frm_Padres formPadres,frm_Grados formGrados,frm_Materias formMaterias,frm_Alumnos formAlumnos,frm_Profesor formProfesor, frm_Asistencias formAsistencias) {
        this.formPrin = formPrin;
        this.frmUsuarios = frmUsuarios;
        this.formPadres = formPadres;
        this.formGrados = formGrados;
        this.formMaterias = formMaterias;
        this.formAlumnos=formAlumnos;
        this.formProfesor = formProfesor;
        this.formAsistencias=formAsistencias;
        
        
        this.formPrin.btnUsuarios.addActionListener(this);
        this.formPrin.btnPadres.addActionListener(this);
        this.formPrin.btnSalir.addActionListener(this);
        this.formPrin.btnGrados.addActionListener(this);
        this.formPrin.btnMaterias.addActionListener(this);
        this.formPrin.btnAlumnos.addActionListener(this);
        this.formPrin.btnProfesores.addActionListener(this);
        this.formPrin.btnAsistencias.addActionListener(this);
        
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
       //PROFESORES
       if(e.getSource()==formPrin.btnAsistencias){
            formAsistencias.setVisible(true);
        }
        //SALIR
        if(e.getSource()==formPrin.btnSalir){
            System.exit(0);
        }
        
    }
    
    
    
}
