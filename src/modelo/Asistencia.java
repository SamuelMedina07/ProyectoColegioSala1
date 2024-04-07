/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Sarah
 */
public class Asistencia {
    private int idAsistencia;
    private int numCuenta;
    private Date asistenciaFecha;
    private String asistenciaEstado;

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Date getAsistenciaFecha() {
        return asistenciaFecha;
    }

    public void setAsistenciaFecha(Date asistenciaFecha) {
        this.asistenciaFecha = asistenciaFecha;
    }

    public String getAsistenciaEstado() {
        return asistenciaEstado;
    }

    public void setAsistenciaEstado(String asistenciaEstado) {
        this.asistenciaEstado = asistenciaEstado;
    }

   
   
    
}
