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
import vista.frm_Alumnos;
import vista.frm_Consulta_Alumnos;
import vista.frm_Consulta_Grados;
import vista.frm_Grados;

/**
 *
 * @author Samuel
 */
public class alumnos implements ActionListener {
    
     private frm_Alumnos formAlumnos;
     private frm_Consulta_Alumnos formConsultaAlumnos;
     
     
       public alumnos(frm_Alumnos formAlumnos,frm_Consulta_Alumnos formConsultaAlumnos) {
        this.formAlumnos = formAlumnos;
        this.formConsultaAlumnos =formConsultaAlumnos;
        formAlumnos.btnOpciones.addActionListener(this);
        ReajsuteImagen("LogoBosquesSinFondo.png");

    }
     
   
     
       public void ReajsuteImagen(String nombreImagen)
    {
         ImageIcon imagen;
         Icon icono,icono2;
    
           
           
        imagen = new ImageIcon("src/imagenes/"+nombreImagen);
        icono = new ImageIcon(imagen.getImage().getScaledInstance( formAlumnos.jlbLogo.getWidth(), formAlumnos.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
        icono2 = new ImageIcon(imagen.getImage().getScaledInstance( formConsultaAlumnos.jlbLogo.getWidth(), formConsultaAlumnos.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
         formAlumnos.jlbLogo.setIcon(icono); 
        formConsultaAlumnos.jlbLogo.setIcon(icono2); 
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {

        //BOTON 
        if (e.getSource() == formAlumnos.btnOpciones) 
        
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
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formAlumnos.btnAgregar);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formAlumnos.btnCrear);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formAlumnos.btnModificar);
         //Columna 2
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formAlumnos.btnEliminar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formAlumnos.btnLimpiar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formAlumnos.btnCancelar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formAlumnos.btnSalir);
         mostrar.jLabelXLeft(290, -250, 10,5, formAlumnos.jlbLogo);
         
         
   //Ocultando botones con transicion
     AnimationClass ocultar = new AnimationClass();
         //Columna 1
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formAlumnos.btnAgregar);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formAlumnos.btnCrear);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formAlumnos.btnModificar);
         //Columna 2
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formAlumnos.btnEliminar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formAlumnos.btnLimpiar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formAlumnos.btnCancelar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formAlumnos.btnSalir);
         ocultar.jLabelXRight(-250, 290, 10,5, formAlumnos.jlbLogo);
       
    }
    
}
