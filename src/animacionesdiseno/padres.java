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
import vista.frm_Consulta_Padres;
import vista.frm_Padres;

/**
 *
 * @author Samuel
 */
public class padres implements ActionListener {
    
   private  frm_Padres formPadre;
   private  frm_Consulta_Padres formConsPadres;
     
     
       public padres(frm_Padres formPadre,frm_Consulta_Padres formConsPadres) {
        this.formPadre = formPadre;
        this.formConsPadres =formConsPadres;
        formPadre.btnOpciones.addActionListener(this);
        ReajsuteImagen("LogoBosquesSinFondo.png");

    }
     
   
     
       public void ReajsuteImagen(String nombreImagen)
    {
         ImageIcon imagen;
         Icon icono,icono2;
    
           
           
        imagen = new ImageIcon("src/imagenes/"+nombreImagen);
        icono = new ImageIcon(imagen.getImage().getScaledInstance( formPadre.jlbLogo.getWidth(), formPadre.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
        icono2 = new ImageIcon(imagen.getImage().getScaledInstance( formConsPadres.jlbLogo.getWidth(), formConsPadres.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
         formPadre.jlbLogo.setIcon(icono); 
        formConsPadres.jlbLogo.setIcon(icono2); 
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {

        //BOTON 
        if (e.getSource() == formPadre.btnOpciones) 
        
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
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formPadre.btnAgregar);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formPadre.btnCrear);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formPadre.btnModificar);
         //Columna 2
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formPadre.btnEliminar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formPadre.btnLimpiar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formPadre.btnCancelar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1 -60, botonesColumna2Posicionx2 -60, 10, 5,formPadre.btnSalir);
         mostrar.jLabelXLeft(290, -250, 10,5, formPadre.jlbLogo);
         
         
         
   //Ocultando botones con transicion
     AnimationClass ocultar = new AnimationClass();
         //Columna 1
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formPadre.btnAgregar);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formPadre.btnCrear);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formPadre.btnModificar);
         //Columna 2
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formPadre.btnEliminar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formPadre.btnLimpiar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formPadre.btnCancelar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2 -60,botonesColumna2Posicionx1 -60, 10, 5,formPadre.btnSalir);
         ocultar.jLabelXRight(-250, 290, 10,5, formPadre.jlbLogo);
        
       
    }
    
}
