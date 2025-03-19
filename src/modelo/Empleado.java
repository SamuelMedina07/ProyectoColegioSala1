/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author ammcp
 */
public class Empleado {
    private String numEmpleado;
    private int empleadoCargo;
    private String nombreCompleto;
    private String genero;
    private Date fechaNac;
    private String direccion;
    private String telefono;
    private String foto;
    private String estado;
            
    // Constructor
    public Empleado() {
    }

    // Getters y setters
    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmple) {
        this.numEmpleado = numEmple;
    }
    
    public int getEmpleadoCargo(){
        return empleadoCargo;
    }
    
    public void setEmpleadoCargo(int empleCargo){
        this.empleadoCargo = empleCargo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNac() {
        return fechaNac;
    }
    
    public int obtenerEdad() {
        if (fechaNac != null) {
            // Obtener la fecha actual
            Date fechaActual = new Date();
            
            // Calcular la diferencia en milisegundos entre la fecha actual y la fecha de nacimiento
            long diferenciaMillis = fechaActual.getTime() - fechaNac.getTime();
            
            // Calcular la edad en base a la diferencia de milisegundos
            // 1 año = 365 días * 24 horas * 60 minutos * 60 segundos * 1000 milisegundos
            int edad = (int) (diferenciaMillis / (365L * 24 * 60 * 60 * 1000));
            return edad;
        } else {
            return 0; // Si no se ha establecido la fecha de nacimiento, devuelve 0
        }
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
