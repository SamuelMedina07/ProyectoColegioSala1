/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Calificacion {

    private int id;
    private String parcial;
    private double nota;
    private int idMateria;
    private int numCuentaAlumno;
    private int idProfesor;
    private String estado;
    private int idGrado;

    public Calificacion(int id, String parcial, double nota, int idMateria, int numCuentaAlumno, int idProfesor, String estado, int idGrado) {
        this.id = id;
        this.parcial = parcial;
        this.nota = nota;
        this.idMateria = idMateria;
        this.numCuentaAlumno = numCuentaAlumno;
        this.idProfesor = idProfesor;
        this.estado = estado;
        this.idGrado = idGrado;
    }
    
    public Calificacion(){
        
    }

    // Métodos getter y setter para acceder a los campos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParcial() {
        return parcial;
    }

    public void setParcial(String parcial) {
        this.parcial = parcial;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int getNumCuentaAlumno() {
        return numCuentaAlumno;
    }

    public void setNumCuentaAlumno(int numCuentaAlumno) {
        this.numCuentaAlumno = numCuentaAlumno;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }
}
