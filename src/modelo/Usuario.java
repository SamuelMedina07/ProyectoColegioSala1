/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ammcp
 */
public class Usuario {
    private int codigo;
    private String nombre;
    private String contrasena;
    private String rol;
    private String estado;
    private int id_rol;
    private int id_estado;
    
    

    public Usuario(int codigo, String nombre, String contrasena, String rol, String estado, int id_rol, int id_estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado = estado;
        this.id_rol = id_rol;
        this.id_estado = id_estado;
    }

    public Usuario() {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getIdRol(){
        return id_rol;
    }
    
    public void setIdRol(int id_rol){
        this.id_rol = id_rol;
    }
    
    public int getIdEstado(){
        return id_estado;
}
    
    public void setIdEstado(){
        this.id_estado = id_estado;
    }
}
