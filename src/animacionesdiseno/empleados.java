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
import vista.frm_Empleados;

/**
 *
 * @author Samuel
 */
public class empleados implements ActionListener {
    
     private frm_Alumnos formAlumnos;
     private frm_Consulta_Alumnos formConsultaAlumnos;
     private frm_Empleados formEmpleados;
     
     
       public empleados(frm_Empleados formEmpleados) {
 
        this.formEmpleados = formEmpleados;
        formEmpleados.btnOpciones.addActionListener(this);
        ReajsuteImagen("LogoBosquesSinFondo.png");

    }
     
   
     
       public void ReajsuteImagen(String nombreImagen)
    {
         ImageIcon imagen;
         Icon icono,icono2;
    
           
           
        imagen = new ImageIcon("src/imagenes/"+nombreImagen);
        icono = new ImageIcon(imagen.getImage().getScaledInstance( formEmpleados.jlbLogo.getWidth(), formEmpleados.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
//        icono2 = new ImageIcon(imagen.getImage().getScaledInstance( formConsultaAlumnos.jlbLogo.getWidth(), formConsultaAlumnos.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
         formEmpleados.jlbLogo.setIcon(icono); 
      //  formConsultaAlumnos.jlbLogo.setIcon(icono2); 
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {

        //BOTON 
        if (e.getSource() == formEmpleados.btnOpciones) 
        
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
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formEmpleados.btnAgregar);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formEmpleados.btnCrear);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formEmpleados.btnModificar);
         //Columna 2
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formEmpleados.btnEliminar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formEmpleados.btnLimpiar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formEmpleados.btnCancelar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1 -60  , botonesColumna2Posicionx2 -60, 10, 5,formEmpleados.btnSalir);
         mostrar.jLabelXLeft(290, -250, 10,5, formEmpleados.jlbLogo);
         
         
   //Ocultando botones con transicion
     AnimationClass ocultar = new AnimationClass();
         //Columna 1
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formEmpleados.btnAgregar);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formEmpleados.btnCrear);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formEmpleados.btnModificar);
         //Columna 2
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formEmpleados.btnEliminar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formEmpleados.btnLimpiar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formEmpleados.btnCancelar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2 -60 ,botonesColumna2Posicionx1 -60 , 10, 5,formEmpleados.btnSalir);
         ocultar.jLabelXRight(-250, 290, 10,5, formEmpleados.jlbLogo);
       
    }
    
}
