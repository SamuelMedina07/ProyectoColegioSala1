/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    Connection c = null;
   
    private String db = "bd_colegio_sala1";
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost:3306/"+db;

    public Connection getConnection(){
        try {
            // Cargar el controlador de la base de datos MySQL
            Class.forName("com.mysql.jdbc.Driver");
            // Establecer la conexión utilizando DriverManager
            c = (Connection)DriverManager.getConnection(this.url, this.user,this.pass);
            System.out.print("Conexion Realizada Correctamente");//investigar porque con cada dato son 5 conexiones re...
        } catch (ClassNotFoundException ex) {
            System.out.print("Error no se puso realizar conexion" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.print("Error no se puso realizar conexion" + ex.getMessage());
        }
        return c;
    }
    
    public void closeConnection(Connection con) {
        
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexion Cerrada: " );
            }else{
             System.out.println("Conexion ya estaba Cerrada: " );
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion con = new Conexion();
        con.getConnection();
    }
    
}
