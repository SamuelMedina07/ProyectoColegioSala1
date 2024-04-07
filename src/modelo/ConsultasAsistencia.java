/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author Sarah
 */
public class ConsultasAsistencia extends Conexion{
    private PreparedStatement ps;
    private String sentenciaSQL;
    private ResultSet rs;
    
    public boolean crearAsistencia(Asistencia asistencia){
         Connection con = getConnection();
         sentenciaSQL="INSERT INTO tbl_asistencias(asistencia_id,alumnos_numCuenta,asistencia_fecha,asistencia_estado) VALUES(?,?,?,?)";
         try {
             ps = con.prepareStatement(sentenciaSQL);
             ps.setInt(1, asistencia.getIdAsistencia());
             ps.setInt(2, asistencia.getNumCuenta());
             ps.setDate(3, new java.sql.Date(asistencia.getAsistenciaFecha().getTime()));
             ps.setString(10, asistencia.getAsistenciaEstado());
             
             int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Asistencia guardada correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar la asistencia");
                return false;
            }
         }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar asistencia: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
             
    }
    //VALIDACIONES//***************************************************
    public boolean existeAlumnoconAsistencia(String nombreCompleto, int codigo) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT COUNT(*) AS num_asistencias FROM tbl_asistencias WHERE asistencias_estado = ? AND asistencias_id <> ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, nombreCompleto);
            ps.setInt(2, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                int numAsistencias = rs.getInt("num_asistencias");
                return numAsistencias > 0; // Si hay algún alumno con asistencia, devuelve true
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar los datos: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return false;
    }
    
}
