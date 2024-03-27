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

public class ConsultaPadres extends Conexion {

    PreparedStatement ps = null;
    String sentenciaSQL;
    ResultSet rs;
    Padre padre;

    public boolean crearPadre(Padre padre) {
        Connection con = getConnection();
        sentenciaSQL = "INSERT INTO tbl_padres (padres_nombreCompleto, padres_genero, padres_cedula, padres_telefono, padres_direccion, padres_estado) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, padre.getNombreCompleto());
            ps.setString(2, padre.getGenero());
            ps.setString(3, padre.getCedula());
            ps.setString(4, padre.getTelefono());
            ps.setString(5, padre.getDireccion());
            ps.setString(6, padre.getEstado());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Padre creado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear padre: No se pudo insertar el padre");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear padre: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public ArrayList<Padre> leerTodosPadres() {
        ArrayList<Padre> listaPadres = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_padres WHERE padres_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                listaPadres.add(new Padre(
                        rs.getInt("padres_id"),
                        rs.getString("padres_nombreCompleto"),
                        rs.getString("padres_genero"),
                        rs.getString("padres_cedula"),
                        rs.getString("padres_telefono"),
                        rs.getString("padres_direccion"),
                        rs.getString("padres_estado")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer padres: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return listaPadres;
    }

    public boolean buscarPadre(Padre padre) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_padres WHERE padres_id=? AND padres_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, padre.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                padre.setNombreCompleto(rs.getString("padres_nombreCompleto"));
                padre.setGenero(rs.getString("padres_genero"));
                padre.setCedula(rs.getString("padres_cedula"));
                padre.setTelefono(rs.getString("padres_telefono"));
                padre.setDireccion(rs.getString("padres_direccion"));
                padre.setEstado(rs.getString("padres_estado"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar padre: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean modificarPadre(Padre padre) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE tbl_padres SET padres_nombreCompleto=?, padres_genero=?, padres_cedula=?, padres_telefono=?, padres_direccion=? WHERE padres_id=? AND padres_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, padre.getNombreCompleto());
            ps.setString(2, padre.getGenero());
            ps.setString(3, padre.getCedula());
            ps.setString(4, padre.getTelefono());
            ps.setString(5, padre.getDireccion());
            ps.setInt(6, padre.getId());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Padre actualizado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE ACTUALIZAR EL PADRE");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar padre: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean eliminarPadre(Padre padre) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE tbl_padres SET padres_estado =?  WHERE padres_id=? AND padres_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "Inactivo");
            ps.setInt(2, padre.getId());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Padre eliminado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR EL PADRE");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar padre: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    //**********************************************************************************************
    public boolean existePadreConCedula(String cedula) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT COUNT(*) FROM tbl_padres WHERE padres_cedula = ?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Devuelve true si hay al menos un padre con la misma cédula
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar la cédula del padre: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return false; // Retorna false si no se pudo realizar la consulta correctamente
    }

    public boolean existePadreConNombreCompleto(String nombreCompleto) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT COUNT(*) FROM tbl_padres WHERE padres_nombreCompleto = ?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, nombreCompleto);
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Devuelve true si hay al menos un padre con el mismo nombre completo
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar el nombre completo del padre: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return false; // Retorna false si no se pudo realizar la consulta correctamente
    }

}
