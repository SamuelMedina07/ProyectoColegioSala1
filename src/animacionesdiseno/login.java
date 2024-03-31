/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionesdiseno;


import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import vista.frm_login;

/**
 *
 * @author Samuel
 */
public class login{
    
  private frm_login formUsuario;
     
     
       public login(frm_login form) {
        this.formUsuario = form;
        ReajsuteImagen("LogoBosquesSinFondo.png");

    }
     

     
     
     
       public void ReajsuteImagen(String nombreImagen)
    {
         ImageIcon imagen;
    Icon icono;
    
        imagen = new ImageIcon("src/imagenes/"+nombreImagen);
        icono = new ImageIcon(imagen.getImage().getScaledInstance(formUsuario.jlbLogo.getWidth(),formUsuario.jlbLogo.getHeight(),Image.SCALE_DEFAULT));
        formUsuario.jlbLogo.setIcon(icono); 
    
    }
    
    
}
