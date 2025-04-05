/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author ammcp
 */
public class frm_Inicio extends javax.swing.JFrame {

    /**
     * Creates new form frm_Inicio
     */
    public frm_Inicio(frm_login frmLogin) {
        initComponents();
        this.setLocationRelativeTo(null);
        iniciarBarra(frmLogin);
 
    }

   public void iniciarBarra(frm_login frmLogin){
       Thread hilo;
       hilo = new Thread(){ 
         public void run(){
             for(int i=1; i<=100; i++){
                 try {
                     Thread.sleep(100);//milisegundos
                     lblTitulo.setText("CARGANDO...");
                     barra.setValue(i);
                     ReajsuteImagen("LogoBosquesSinFondoCorto.png");
                     if(i >=50){
                         barra.setForeground(Color.yellow);
                         ReajsuteImagen("LogoBosquesSinFondoMedio.png");
                     }
                     if(i >=85){
                         barra.setForeground(Color.green);
                         lblTitulo.setText("BIENVENIDO");
                         ReajsuteImagen("LogoBosquesSinFondo.png");
                     }
                 } catch (InterruptedException ex) {
                     Logger.getLogger(frm_Inicio.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             dispose();
             frmLogin.setVisible(true);
         }  
       };
       hilo.start();
   }
   
     public void ReajsuteImagen(String nombreImagen)
    {
         ImageIcon imagen;
    Icon icono;
    
        imagen = new ImageIcon("src/imagenes/"+nombreImagen);
        icono = new ImageIcon(imagen.getImage().getScaledInstance(jlbCarga.getWidth(),jlbCarga.getHeight(),Image.SCALE_DEFAULT));
        jlbCarga.setIcon(icono); 
    
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        barra = new javax.swing.JProgressBar();
        lblTitulo = new javax.swing.JLabel();
        jlbCarga = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CARGANDO");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 250, 255));
        jPanel1.setLayout(null);

        barra.setBackground(new java.awt.Color(241, 250, 255));
        barra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        barra.setForeground(new java.awt.Color(255, 204, 204));
        barra.setBorder(new javax.swing.border.MatteBorder(null));
        barra.setStringPainted(true);
        jPanel1.add(barra);
        barra.setBounds(20, 200, 210, 32);

        lblTitulo.setForeground(new java.awt.Color(0, 130, 90));
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(100, 170, 100, 30);
        jPanel1.add(jlbCarga);
        jlbCarga.setBounds(80, 60, 92, 92);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbCarga;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
