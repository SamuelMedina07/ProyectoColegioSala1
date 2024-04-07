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
import vista.frm_Consulta_Profesor;
import vista.frm_Profesor;


/**
 *
 * @author Samuel
 */
public class profesores implements ActionListener {
     private  frm_Profesor formProfesor;
     private frm_Consulta_Profesor formConsultaProfesor;
     
     
       public profesores(frm_Profesor formProfesor,frm_Consulta_Profesor formConsultaProfesor) {
        this.formProfesor = formProfesor;
        this.formConsultaProfesor =formConsultaProfesor;
        formProfesor.btnOpciones.addActionListener(this);
        ReajsuteImagen("LogoBosquesSinFondo.png");

    }
     
   
     
       public void ReajsuteImagen(String nombreImagen)
    {
         ImageIcon imagen;
         Icon icono,icono2;
    
           
           
        imagen = new ImageIcon("src/imagenes/"+nombreImagen);
        icono = new ImageIcon(imagen.getImage().getScaledInstance( formProfesor.jlbLogo.getWidth(), formProfesor.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
        icono2 = new ImageIcon(imagen.getImage().getScaledInstance( formConsultaProfesor.jlbLogo.getWidth(), formConsultaProfesor.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
         formProfesor.jlbLogo.setIcon(icono); 
        formConsultaProfesor.jlbLogo.setIcon(icono2); 
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {

        //BOTON 
        if (e.getSource() == formProfesor.btnOpciones) 
        
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
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formProfesor.btnLeer);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formProfesor.btnAgregar);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formProfesor.btnCrear);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formProfesor.btnModificar);
         //Columna 2
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formProfesor.btnEliminar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formProfesor.btnLimpiar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formProfesor.btnCancelar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formProfesor.btnSalir);
         mostrar.jLabelXLeft(290, -250, 10,5, formProfesor.jlbLogo);
         
         
         
   //Ocultando botones con transicion
     AnimationClass ocultar = new AnimationClass();
         //Columna 1
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 , 10, 5,formProfesor.btnLeer);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formProfesor.btnAgregar);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formProfesor.btnCrear);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formProfesor.btnModificar);
         //Columna 2
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formProfesor.btnEliminar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formProfesor.btnLimpiar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formProfesor.btnCancelar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formProfesor.btnSalir);
         ocultar.jLabelXRight(-250, 290, 10,5, formProfesor.jlbLogo);
        
       
    }
    
    
}
