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

public class ConsultaMaterias extends Conexion {

    PreparedStatement ps = null;
    String sentenciaSQL;
    ResultSet rs;

    public boolean crearMateria(Materia materia) {
        Connection con =getConnection();
        sentenciaSQL = "INSERT INTO tbl_materias (materia_nombre, materia_estado) VALUES (?, ?)";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, materia.getNombre().toUpperCase()); // Guardar en mayúsculas
            ps.setString(2, materia.getEstado());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Materia creada correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear la materia: No se pudo insertar la materia");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la materia: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public ArrayList<Materia> leerTodasMaterias() {
        ArrayList<Materia> listaMaterias = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_materias WHERE materia_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                listaMaterias.add(new Materia(
                        rs.getInt("materia_id"),
                        rs.getString("materia_nombre"),
                        rs.getString("materia_estado")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer las materias: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return listaMaterias;
    }

    public boolean buscarMateria(Materia materia) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_materias WHERE materia_id=? AND materia_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, materia.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                materia.setNombre(rs.getString("materia_nombre"));
                materia.setEstado(rs.getString("materia_estado"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la materia: " + ex.getMessage());
            return false;
        } finally {
           closeConnection(con);
        }
    }

    public boolean modificarMateria(Materia materia) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE tbl_materias SET materia_nombre=? WHERE materia_id=? AND materia_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, materia.getNombre().toUpperCase()); // Guardar en mayúsculas
            ps.setInt(2, materia.getId());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Materia actualizada correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se puede actualizar la materia");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la materia: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean eliminarMateria(Materia materia) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE tbl_materias SET materia_estado =?  WHERE materia_id=? AND materia_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "Inactivo");
            ps.setInt(2, materia.getId());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Materia eliminada correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar la materia");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la materia: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

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
        sentenciaSQL = "SELECT MAX(materia_id) AS max_codigo FROM tbl_materias";

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

    public Materia obtenerMateriaSegunId(int id) {
        Materia materia = null;
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_materias WHERE materia_id=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setId(rs.getInt("materia_id"));
                materia.setNombre(rs.getString("materia_nombre"));
                materia.setEstado(rs.getString("materia_estado"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la materia según ID: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return materia;
    }

    public ArrayList<Materia> buscarMateriasPorNombre(String nombre) {
        ArrayList<Materia> materiasEncontradas = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_materias WHERE materia_nombre LIKE ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "%" + nombre + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia();
                materia.setId(rs.getInt("materia_id"));
                materia.setNombre(rs.getString("materia_nombre"));
                materia.setEstado(rs.getString("materia_estado"));
                materiasEncontradas.add(materia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar materias por nombre: " + ex.getMessage());
        } finally {
           closeConnection(con);
        }

        return materiasEncontradas;
    }

    public ArrayList<Materia> buscarMateriasActivas() {
        ArrayList<Materia> materiasActivas = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_materias WHERE materia_estado = 'Activo'";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia();
                materia.setId(rs.getInt("materia_id"));
                materia.setNombre(rs.getString("materia_nombre"));
                materia.setEstado(rs.getString("materia_estado"));
                materiasActivas.add(materia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar materias activas: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return materiasActivas;
    }

    public ArrayList<Materia> buscarMateriasInactivas() {
        ArrayList<Materia> materiasInactivas = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_materias WHERE materia_estado = 'Inactivo'";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia();
                materia.setId(rs.getInt("materia_id"));
                materia.setNombre(rs.getString("materia_nombre"));
                materia.setEstado(rs.getString("materia_estado"));
                materiasInactivas.add(materia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar materias inactivas: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return materiasInactivas;
    }
}
