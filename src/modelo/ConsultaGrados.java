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
import modelo.Padre;

public class ConsultaGrados extends Conexion {

    PreparedStatement ps = null;
    String sentenciaSQL;
    ResultSet rs;

    public boolean crearGrado(Grado grado) {
        Connection con = getConnection();
        sentenciaSQL = "INSERT INTO tbl_grados (grados_nombre, grados_estado) VALUES (?, ?)";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, grado.getNombre());
            ps.setString(2, grado.getEstado());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Grado creado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear grado: No se pudo insertar el grado");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear grado: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public ArrayList<Grado> leerTodosGrados() {
        ArrayList<Grado> listaGrados = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_grados WHERE grados_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                listaGrados.add(new Grado(
                        rs.getInt("grados_id"),
                        rs.getString("grados_nombre"),
                        rs.getString("grados_estado")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer grados: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return listaGrados;
    }

    public boolean buscarGrado(Grado grado) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_grados WHERE grados_id=? AND grados_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, grado.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                grado.setNombre(rs.getString("grados_nombre"));
                grado.setEstado(rs.getString("grados_estado"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar grado: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean modificarGrado(Grado grado) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE tbl_grados SET grados_nombre=? WHERE grados_id=? AND grados_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, grado.getNombre());
            ps.setInt(2, grado.getId());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Grado actualizado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se puede actualizar el grado");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar grado: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean eliminarGrado(Grado grado) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE tbl_grados SET grados_estado =?  WHERE grados_id=? AND grados_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "Inactivo");
            ps.setInt(2, grado.getId());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Grado eliminado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar el grado");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar grado: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

//**********************************************************************************************
    public boolean existeGrado(String nombreGrado, int idGrado) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT COUNT(*) FROM tbl_grados WHERE grados_nombre = ? AND grados_id != ?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, nombreGrado);
            ps.setInt(2, idGrado);
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Devolverá true si la condición es verdadera
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del grado: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return false;
    }

    //***********************************************************
    public int obtenerSiguienteCodigo() {
        Connection con = getConnection();
        sentenciaSQL = "SELECT MAX(grados_id) AS max_codigo FROM tbl_grados";

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

    public Grado obtenerGradoSegunId(int id) {
        Grado grado = null;
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_grados WHERE grados_id=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                grado = new Grado();
                grado.setId(rs.getInt("grados_id"));
                grado.setNombre(rs.getString("grados_nombre"));
                grado.setEstado(rs.getString("grados_estado"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener grado según ID: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return grado;
    }

    public ArrayList<Grado> buscarGradosPorNombre(String nombre) {
        ArrayList<Grado> gradosEncontrados = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_grados WHERE grados_nombre LIKE ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "%" + nombre + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Grado grado = new Grado();
                grado.setId(rs.getInt("grados_id"));
                grado.setNombre(rs.getString("grados_nombre"));
                grado.setEstado(rs.getString("grados_estado"));
                gradosEncontrados.add(grado);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar grados por nombre: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return gradosEncontrados;
    }

    public ArrayList<Grado> buscarGradosActivos() {
        ArrayList<Grado> gradosActivos = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_grados WHERE grados_estado = 'Activo'";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Grado grado = new Grado();
                grado.setId(rs.getInt("grados_id"));
                grado.setNombre(rs.getString("grados_nombre"));
                grado.setEstado(rs.getString("grados_estado"));
                gradosActivos.add(grado);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar grados activos: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return gradosActivos;
    }

    public ArrayList<Grado> buscarGradosInactivos() {
        ArrayList<Grado> gradosInactivos = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_grados WHERE grados_estado = 'Inactivo'";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Grado grado = new Grado();
                grado.setId(rs.getInt("grados_id"));
                grado.setNombre(rs.getString("grados_nombre"));
                grado.setEstado(rs.getString("grados_estado"));
                gradosInactivos.add(grado);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar grados inactivos: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return gradosInactivos;
    }

}
