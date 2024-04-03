/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.frm_Grados;
import vista.frm_Materias;
import vista.frm_Principal;
import vista.frm_Usuarios;
import vista.frm_Padres;

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
 

    public PrincipalControlador(frm_Principal formPrin, frm_Usuarios frmUsuarios,frm_Padres formPadres,frm_Grados formGrados,frm_Materias formMaterias) {
        this.formPrin = formPrin;
        this.frmUsuarios = frmUsuarios;
        this.formPadres = formPadres;
        this.formGrados = formGrados;
        this.formMaterias = formMaterias;
        
        this.formPrin.btnUsuarios.addActionListener(this);
        this.formPrin.btnPadres.addActionListener(this);
        this.formPrin.btnSalir.addActionListener(this);
        this.formPrin.btnGrados.addActionListener(this);
        this.formPrin.btnMaterias.addActionListener(this);
 
    }
    
    public void inciar(){
        formPrin.setLocationRelativeTo(null);
        frmUsuarios.setLocationRelativeTo(null);
        formPadres.setLocationRelativeTo(null);
        formGrados.setLocationRelativeTo(null);
        formMaterias.setLocationRelativeTo(null);
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
       //GRADOS
       if(e.getSource()==formPrin.btnMaterias){
            formMaterias.lblUsuario.setText(formPrin.lblUsuario.getText());
            formMaterias.setVisible(true);
        }
        //SALIR
        if(e.getSource()==formPrin.btnSalir){
            System.exit(0);
        }
        
    }
    
    
    
}
