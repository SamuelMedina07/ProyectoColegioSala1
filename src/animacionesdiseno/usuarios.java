/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionesdiseno;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import vista.frm_Usuarios;

/**
 *
 * @author Samuel
 */
public class usuarios {
    
     private frm_Usuarios formUsuarios;
     
     
       public usuarios(frm_Usuarios formUsuarios) {
        this.formUsuarios = formUsuarios;
        ReajsuteImagen("LogoBosquesSinFondo.png");

    }
     

     
     
     
       public void ReajsuteImagen(String nombreImagen)
    {
         ImageIcon imagen;
    Icon icono;
    
        imagen = new ImageIcon("src/imagenes/"+nombreImagen);
        icono = new ImageIcon(imagen.getImage().getScaledInstance(formUsuarios.jlbLogo.getWidth(),formUsuarios.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
        formUsuarios.jlbLogo.setIcon(icono); 
    
    }
    
 
    
}
