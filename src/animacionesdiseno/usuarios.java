/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionesdiseno;

import AppPackage.AnimationClass;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import vista.frm_Consulta_Usuarios;
import vista.frm_Usuarios;

/**
 *
 * @author Samuel
 */
public class usuarios implements ActionListener{
    
     private frm_Usuarios formUsuarios;
     private frm_Consulta_Usuarios formConsUsuario;
     
     
       public usuarios(frm_Usuarios formUsuarios,frm_Consulta_Usuarios formConsUsuario) {
        this.formUsuarios = formUsuarios;
        this.formConsUsuario =formConsUsuario;
        formUsuarios.btnOpciones.addActionListener(this);
        ReajsuteImagen("LogoBosquesSinFondo.png");

    }
     
   
     
       public void ReajsuteImagen(String nombreImagen)
    {
         ImageIcon imagen;
         Icon icono,icono2;
    
           
           
        imagen = new ImageIcon("src/imagenes/"+nombreImagen);
        icono = new ImageIcon(imagen.getImage().getScaledInstance( formUsuarios.jlbLogo.getWidth(), formUsuarios.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
        icono2 = new ImageIcon(imagen.getImage().getScaledInstance( formConsUsuario.jlbLogo.getWidth(), formConsUsuario.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
       formUsuarios.jlbLogo.setIcon(icono); 
    formConsUsuario.jlbLogo.setIcon(icono2); 
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {

        //BOTON 
        if (e.getSource() == formUsuarios.btnOpciones) 
        
            animacion();
 
    }
    
    public void animacion(){
        
        int botonesColumna1Posicionx1= 550;
         int botonesColumna2Posicionx1= 670;
         
         int margenseparaciondeposicioninicial = 260;
         
         int botonesColumna1Posicionx2= botonesColumna1Posicionx1-margenseparaciondeposicioninicial;
         int botonesColumna2Posicionx2= botonesColumna2Posicionx1-margenseparaciondeposicioninicial;
         
         
        
    //Mostando botones ocultos con transicion
     AnimationClass mostrar = new AnimationClass();
         //Columna 1
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formUsuarios.btnLeer);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formUsuarios.btnAgregar);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formUsuarios.btnCrear);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formUsuarios.btnModificar);
         //Columna 2
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formUsuarios.btnEliminar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formUsuarios.btnLimpiar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formUsuarios.btnCancelar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formUsuarios.btnSalir);
         mostrar.jLabelYUp(240, 60, 10,5, formUsuarios.jlbLogo);
         
         
   //Ocultando botones con transicion
     AnimationClass ocultar = new AnimationClass();
         //Columna 1
         ocultar.jButtonXLeft( botonesColumna1Posicionx2,botonesColumna1Posicionx1 , 10, 5,formUsuarios.btnLeer);
         ocultar.jButtonXLeft( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formUsuarios.btnAgregar);
         ocultar.jButtonXLeft( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formUsuarios.btnCrear);
         ocultar.jButtonXLeft( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formUsuarios.btnModificar);
         //Columna 2
         ocultar.jButtonXLeft(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formUsuarios.btnEliminar);
         ocultar.jButtonXLeft(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formUsuarios.btnLimpiar);
         ocultar.jButtonXLeft(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formUsuarios.btnCancelar);
         ocultar.jButtonXLeft(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formUsuarios.btnSalir);
         ocultar.jLabelYDown(60, 240, 10,5, formUsuarios.jlbLogo);
       
    }
    
    
}
