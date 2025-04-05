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
import vista.frm_Consulta_Materias;
import vista.frm_Materias;

/**
 *
 * @author Samuel
 */
public class materias implements ActionListener {
    
    private frm_Materias formMaterias;
    private frm_Consulta_Materias formConsultaMaterias;
    
    
    public materias(frm_Materias formMaterias,frm_Consulta_Materias formConsultaMaterias)
    {
    this.formMaterias = formMaterias;
    this.formConsultaMaterias = formConsultaMaterias; 
    formMaterias.btnOpciones.addActionListener(this);
    ReajsuteImagen("LogoBosquesSinFondo.png");
    }
    
    
    
    public void ReajsuteImagen(String nombreImagen)
    {
         ImageIcon imagen;
         Icon icono,icono2;
    
           
           
        imagen = new ImageIcon("src/imagenes/"+nombreImagen);
        icono = new ImageIcon(imagen.getImage().getScaledInstance( formMaterias.jlbLogo.getWidth(), formMaterias.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
        icono2 = new ImageIcon(imagen.getImage().getScaledInstance( formConsultaMaterias.jlbLogo.getWidth(), formConsultaMaterias.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
         formMaterias.jlbLogo.setIcon(icono); 
        formConsultaMaterias.jlbLogo.setIcon(icono2); 
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {

        //BOTON 
        if (e.getSource() == formMaterias.btnOpciones) 
        
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
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formMaterias.btnAgregar);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formMaterias.btnCrear);
         mostrar.jButtonXLeft(botonesColumna1Posicionx1, botonesColumna1Posicionx2, 10, 5,formMaterias.btnModificar);
         //Columna 2
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formMaterias.btnEliminar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formMaterias.btnLimpiar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formMaterias.btnCancelar);
         mostrar.jButtonXLeft(botonesColumna2Posicionx1, botonesColumna2Posicionx2, 10, 5,formMaterias.btnSalir);
         mostrar.jLabelYUp(290, 50, 10,5, formMaterias.jlbLogo);
         
         
   //Ocultando botones con transicion
     AnimationClass ocultar = new AnimationClass();
         //Columna 1
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formMaterias.btnAgregar);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formMaterias.btnCrear);
         ocultar.jButtonXRight( botonesColumna1Posicionx2,botonesColumna1Posicionx1 ,10, 5,formMaterias.btnModificar);
         //Columna 2
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formMaterias.btnEliminar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formMaterias.btnLimpiar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formMaterias.btnCancelar);
         ocultar.jButtonXRight(botonesColumna2Posicionx2,botonesColumna2Posicionx1, 10, 5,formMaterias.btnSalir);
         ocultar.jLabelYDown(50, 290, 10,5, formMaterias.jlbLogo);
       
    }
   
    
    
    
    
    
    
}
