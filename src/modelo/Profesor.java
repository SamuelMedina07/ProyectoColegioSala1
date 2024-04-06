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
public class Profesor {

    private int id;
    private String nombreCompleto;
    private String cedula;
    private String genero;
    private int codigoUsuario; 
    private String telefono;
    private String direccion;
    private String foto;
    private String estado;

    // Constructor
    public Profesor(int id, String nombreCompleto, String cedula, String genero, int codigoUsuario, String telefono, String direccion, String foto, String estado) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.genero = genero;
        this.codigoUsuario = codigoUsuario;
        this.telefono = telefono;
        this.direccion = direccion;
        this.foto = foto;
        this.estado = estado;
    }
    
    public Profesor(){
        
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    // Método para obtener el nombre
    public String getNombre() {
        // Dividir el nombre completo en partes usando el espacio como delimitador
        String[] partesNombre = nombreCompleto.split(" ");

        // Devolver el primer y segundo nombre, si están disponibles
        if (partesNombre.length >= 2) {
            return partesNombre[0] + " " + partesNombre[1];
        } else if (partesNombre.length == 1) {
            return partesNombre[0]; // Devolver solo el primer nombre si no hay segundo nombre
        } else {
            return ""; // Devolver cadena vacía si no hay nombres
        }
    }

    // Método para obtener los apellidos
    public String getApellidos() {
        // Dividir el nombre completo en partes usando el espacio como delimitador
        String[] partesNombre = nombreCompleto.split(" ");

        // Concatenar los apellidos si hay más de dos partes
        if (partesNombre.length > 2) {
            StringBuilder apellidos = new StringBuilder();
            for (int i = 2; i < partesNombre.length; i++) {
                apellidos.append(partesNombre[i]).append(" ");
            }
            return apellidos.toString().trim();
        } else {
            return ""; // Devolver cadena vacía si no hay apellidos
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCodigoUsuario() { 
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) { // Cambiado a tipo int
        this.codigoUsuario = codigoUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
