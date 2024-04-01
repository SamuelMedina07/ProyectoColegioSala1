/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

 

    public PrincipalControlador(frm_Principal formPrin, frm_Usuarios frmUsuarios,frm_Padres formPadres) {
        this.formPrin = formPrin;
        this.frmUsuarios = frmUsuarios;
        this.formPadres = formPadres;
      
        this.formPrin.btnUsuarios.addActionListener(this);
        this.formPrin.btnPadres.addActionListener(this);
        this.formPrin.btnSalir.addActionListener(this);
 
    }
    
    public void inciar(){
        formPrin.setLocationRelativeTo(null);
        frmUsuarios.setLocationRelativeTo(null);
        formPadres.setLocationRelativeTo(null);
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
       
        //SALIR
        if(e.getSource()==formPrin.btnSalir){
            System.exit(0);
        }
        
    }
    
    
    
}
