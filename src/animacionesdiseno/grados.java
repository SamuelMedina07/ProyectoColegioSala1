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
import vista.frm_Consulta_Grados;
import vista.frm_Grados;


/**
 *
 * @author Samuel
 */
public class grados implements ActionListener{
    
     private frm_Grados formGrados;
     private frm_Consulta_Grados formConsultaGrados;
     
     
       public grados(frm_Grados formGrados,frm_Consulta_Grados formConsultaGrados) {
        this.formGrados = formGrados;
        this.formConsultaGrados =formConsultaGrados;
        formGrados.btnOpciones.addActionListener(this);
        ReajsuteImagen("LogoBosquesSinFondo.png");

    }
     
   
     
       public void ReajsuteImagen(String nombreImagen)
    {
         ImageIcon imagen;
         Icon icono,icono2;
    
           
           
        imagen = new ImageIcon("src/imagenes/"+nombreImagen);
        icono = new ImageIcon(imagen.getImage().getScaledInstance( formGrados.jlbLogo.getWidth(), formGrados.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
        icono2 = new ImageIcon(imagen.getImage().getScaledInstance( formConsultaGrados.jlbLogo.getWidth(), formConsultaGrados.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
         formGrados.jlbLogo.setIcon(icono); 
        formConsultaGrados.jlbLogo.setIcon(icono2); 
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {

        //BOTON 
        if (e.getSource() == formGrados.btnOpciones) 
        
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
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formGrados.btnAgregar);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formGrados.btnCrear);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formGrados.btnModificar);
         //Columna 2
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formGrados.btnEliminar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formGrados.btnLimpiar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formGrados.btnCancelar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formGrados.btnSalir);
         mostrar.jLabelYUp(290, 50, 10,5, formGrados.jlbLogo);
         
         
   //Ocultando botones con transicion
     AnimationClass ocultar = new AnimationClass();
         //Columna 1
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formGrados.btnAgregar);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formGrados.btnCrear);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formGrados.btnModificar);
         //Columna 2
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formGrados.btnEliminar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formGrados.btnLimpiar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formGrados.btnCancelar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formGrados.btnSalir);
         ocultar.jLabelYDown(50, 290, 10,5, formGrados.jlbLogo);
       
    }
    
}
