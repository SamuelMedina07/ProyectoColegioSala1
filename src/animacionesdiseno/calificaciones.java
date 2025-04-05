/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionesdiseno;

import AppPackage.AnimationClass;
import controlador.calificacionControlador;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import vista.frm_Calificaciones;
import vista.frm_Consulta_Calificaciones;

/**
 *
 * @author Samuel
 */
public class calificaciones implements ActionListener{
    
    
     private frm_Calificaciones formCalificaciones;
    private frm_Consulta_Calificaciones formConsultaCalificaciones;
    
    
    public calificaciones(frm_Calificaciones formCalificaciones,frm_Consulta_Calificaciones formConsultaCalificaciones)
    {
    this.formCalificaciones = formCalificaciones;
    this.formConsultaCalificaciones = formConsultaCalificaciones; 
    formCalificaciones.btnOpciones.addActionListener(this);
    ReajsuteImagen("LogoBosquesSinFondo.png");
    }
    
    
    
    public void ReajsuteImagen(String nombreImagen)
    {
         ImageIcon imagen;
         Icon icono,icono2;
    
           
           
        imagen = new ImageIcon("src/imagenes/"+nombreImagen);
        icono = new ImageIcon(imagen.getImage().getScaledInstance( formCalificaciones.jlbLogo.getWidth(), formCalificaciones.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
        icono2 = new ImageIcon(imagen.getImage().getScaledInstance( formConsultaCalificaciones.jlbLogo.getWidth(), formConsultaCalificaciones.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
         formCalificaciones.jlbLogo.setIcon(icono); 
        formConsultaCalificaciones.jlbLogo.setIcon(icono2); 
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {

        //BOTON 
        if (e.getSource() == formCalificaciones.btnOpciones) 
        
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
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formCalificaciones.btnAgregar);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formCalificaciones.btnCrear);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formCalificaciones.btnModificar);
         //Columna 2
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formCalificaciones.btnEliminar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formCalificaciones.btnLimpiar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formCalificaciones.btnCancelar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formCalificaciones.btnSalir);
         mostrar.jLabelYUp(290, 50, 10,5, formCalificaciones.jlbLogo);
         
         
   //Ocultando botones con transicion
     AnimationClass ocultar = new AnimationClass();
         //Columna 1
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formCalificaciones.btnAgregar);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formCalificaciones.btnCrear);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formCalificaciones.btnModificar);
         //Columna 2
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formCalificaciones.btnEliminar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formCalificaciones.btnLimpiar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formCalificaciones.btnCancelar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formCalificaciones.btnSalir);
         ocultar.jLabelYDown(50, 290, 10,5, formCalificaciones.jlbLogo);
       
    }
    
}
