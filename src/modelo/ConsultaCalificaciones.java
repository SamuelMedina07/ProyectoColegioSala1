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
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConsultaCalificaciones extends Conexion {

    PreparedStatement ps = null;
    String sentenciaSQL;
    ResultSet rs;

    public boolean crearCalificacion(Calificacion calificacion) {
        Connection con = getConnection();
        sentenciaSQL = "INSERT INTO tbl_calificaciones (calificaciones_parcial, calificaciones_nota, materia_id, alumno_numCuenta, profesor_id, calificaciones_estado, idGrado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, calificacion.getParcial());
            ps.setDouble(2, calificacion.getNota());
            ps.setInt(3, calificacion.getIdMateria());
            ps.setInt(4, calificacion.getNumCuentaAlumno());
            ps.setInt(5, calificacion.getIdProfesor());
            ps.setString(6, calificacion.getEstado());
            ps.setInt(7, calificacion.getIdGrado());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Calificación creada correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear la calificación");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la calificación: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public ArrayList<Calificacion> obtenerCalificacionesPorAlumno(int numCuentaAlumno) {
        ArrayList<Calificacion> calificaciones = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_calificaciones WHERE alumno_numCuenta = ?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, numCuentaAlumno);
            rs = ps.executeQuery();
            while (rs.next()) {
                calificaciones.add(new Calificacion(
                        rs.getInt("calificaciones_id"),
                        rs.getString("calificaciones_parcial"),
                        rs.getDouble("calificaciones_nota"),
                        rs.getInt("materia_id"),
                        rs.getInt("alumno_numCuenta"),
                        rs.getInt("profesor_id"),
                        rs.getString("calificaciones_estado"),
                        rs.getInt("idGrado")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las calificaciones: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return calificaciones;
    }

    public boolean modificarCalificacion(Calificacion calificacion) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE tbl_calificaciones SET calificaciones_parcial=?, calificaciones_nota=?, materia_id=?, alumno_numCuenta=?, profesor_id=?, calificaciones_estado=?, idGrado=? WHERE calificaciones_id=?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, calificacion.getParcial());
            ps.setDouble(2, calificacion.getNota());
            ps.setInt(3, calificacion.getIdMateria());
            ps.setInt(4, calificacion.getNumCuentaAlumno());
            ps.setInt(5, calificacion.getIdProfesor());
            ps.setString(6, calificacion.getEstado());
            ps.setInt(7, calificacion.getIdGrado());
            ps.setInt(8, calificacion.getId());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Calificación modificada correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar la calificación");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la calificación: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean eliminarCalificacion(int idCalificacion) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE  tbl_calificaciones SET calificaciones_estado = ? WHERE calificaciones_id=?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "CANCELADA");
            ps.setInt(2, idCalificacion);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Calificación eliminada correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la calificación");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la calificación: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean buscarCalificacion(Calificacion calificacion) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_calificaciones WHERE calificaciones_id=?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, calificacion.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                calificacion.setParcial(rs.getString("calificaciones_parcial"));
                calificacion.setNota(rs.getDouble("calificaciones_nota"));
                calificacion.setIdMateria(rs.getInt("materia_id"));
                calificacion.setNumCuentaAlumno(rs.getInt("alumno_numCuenta"));
                calificacion.setIdProfesor(rs.getInt("profesor_id"));
                calificacion.setEstado(rs.getString("calificaciones_estado"));
                calificacion.setIdGrado(rs.getInt("idGrado"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la calificación: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

//validaciones
    public boolean existeMateria(String nombreMateria, int idMateria) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT COUNT(*) FROM tbl_materias WHERE materia_nombre = ? AND materia_id != ?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, nombreMateria);
            ps.setInt(2, idMateria);
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Devolverá true si la condición es verdadera
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia de la materia: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return false;
    }

    public int obtenerSiguienteCodigo() {
        Connection con = getConnection();
        sentenciaSQL = "SELECT MAX(calificaciones_id) AS max_codigo FROM tbl_calificaciones";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            if (rs.next()) {
                int ultimoCodigo = rs.getInt("max_codigo");
                return ultimoCodigo + 1; // Devuelve el siguiente código disponible
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el siguiente código: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return 1; // Si no se puede obtener el siguiente código, devuelve 1 como valor predeterminado
    }

    //****************************BUSQUEDA
    public ArrayList<Calificacion> buscarCalificacionesPorGradoMateriaParcial(int idGrado, int idMateria, String parcial) {
        ArrayList<Calificacion> calificacionesEncontradas = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_calificaciones WHERE idGrado=? AND materia_id=? AND calificaciones_parcial=? AND calificaciones_estado !='CANCELADA'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, idGrado);
            ps.setInt(2, idMateria);
            ps.setString(3, parcial);
            rs = ps.executeQuery();
            while (rs.next()) {
                Calificacion calificacion = new Calificacion();
                calificacion.setId(rs.getInt("calificaciones_id"));
                calificacion.setParcial(rs.getString("calificaciones_parcial"));
                calificacion.setNota(rs.getDouble("calificaciones_nota"));
                calificacion.setIdMateria(rs.getInt("materia_id"));
                calificacion.setNumCuentaAlumno(rs.getInt("alumno_numCuenta"));
                calificacion.setIdProfesor(rs.getInt("profesor_id"));
                calificacion.setEstado(rs.getString("calificaciones_estado"));
                calificacion.setIdGrado(rs.getInt("idGrado"));
                calificacionesEncontradas.add(calificacion);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar las calificaciones: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return calificacionesEncontradas;
    }

    public Calificacion obtenerCalificacionSegunId(int id) {
        Calificacion calificacion = null;
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_calificaciones WHERE calificaciones_id=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                calificacion = new Calificacion();
                calificacion.setId(rs.getInt("calificaciones_id"));
                calificacion.setParcial(rs.getString("calificaciones_parcial"));
                calificacion.setNota(rs.getDouble("calificaciones_nota"));
                calificacion.setIdMateria(rs.getInt("materia_id"));
                calificacion.setNumCuentaAlumno(rs.getInt("alumno_numCuenta"));
                calificacion.setIdProfesor(rs.getInt("profesor_id"));
                calificacion.setEstado(rs.getString("calificaciones_estado"));
                calificacion.setIdGrado(rs.getInt("idGrado"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la calificación según ID: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return calificacion;
    }
    
    public int obtenerSiguienteCodigoCalificacion() {
    Connection con = getConnection();
    sentenciaSQL = "SELECT MAX(calificaciones_id) AS max_codigo FROM tbl_calificaciones";

    try {
        ps = con.prepareStatement(sentenciaSQL);
        rs = ps.executeQuery();

        if (rs.next()) {
            int ultimoCodigo = rs.getInt("max_codigo");
            // Incrementar en 1 el último código de calificación y devolverlo
            return ultimoCodigo + 1;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener el siguiente código de calificación: " + ex.getMessage());
    } finally {
        closeConnection(con);
    }

    // Si no se puede obtener el siguiente código, devuelve 1 como valor predeterminado
    return 1;
}

    // VALIDACIONES
    public boolean existeCalificacion(int idCalificacion, int numCuentaAlumno, int idGrado, int idMateria, String parcial) {
        Connection con = getConnection();
        boolean existe = false;

        
        sentenciaSQL = "SELECT COUNT(*) AS count FROM tbl_calificaciones WHERE alumno_numCuenta = ? AND idGrado = ? AND materia_id = ? AND calificaciones_parcial = ? AND calificaciones_estado != 'CANCELADA' AND calificaciones_id != ?";

        try {
            PreparedStatement ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, numCuentaAlumno);
            ps.setInt(2, idGrado);
            ps.setInt(3, idMateria);
            ps.setString(4, parcial);
            ps.setInt(5, idCalificacion); 

            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                existe = (count > 0);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar si existe la calificación: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return existe;
    }

    public boolean existeAsignacionProfesorMateria(int idCalificacion, int idProfesor, int idMateria) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT COUNT(*) AS count FROM tbl_asignacion_profesores_materias WHERE profesor_id = ? AND materia_id = ? AND asignacion_estado != 'Inactivo' ";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, idProfesor);
            ps.setInt(2, idMateria);
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0; 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar la asignación del profesor a la materia: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return false;
    }

}
