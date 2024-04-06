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
    public boolean existePadreConCedula(String cedula, int idPadre) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT COUNT(*) AS num_padres FROM tbl_padres WHERE padres_cedula = ? AND padres_id <> ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, cedula);
            ps.setInt(2, idPadre);
            rs = ps.executeQuery();

            if (rs.next()) {
                int numPadres = rs.getInt("num_padres");
                return numPadres > 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar cédula: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return false;
    }

    public boolean existePadreConNombreCompleto(String nombreCompleto, int idPadre) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT COUNT(*) AS num_padres FROM tbl_padres WHERE padres_nombreCompleto = ? AND padres_id <> ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, nombreCompleto);
            ps.setInt(2, idPadre);
            rs = ps.executeQuery();

            if (rs.next()) {
                int numPadres = rs.getInt("num_padres");
                return numPadres > 0; // Si hay algún padre con el mismo nombre completo, devuelve true
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar nombre completo: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return false; // Si no se puede realizar la verificación, devuelve false
    }
    
    
    //***********************************************************
    public int obtenerSiguienteCodigo() {
        Connection con = getConnection();
        sentenciaSQL = "SELECT MAX(padres_id) AS max_codigo FROM tbl_padres";

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

    public Padre obtenerPadreSegunId(int id) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_padres WHERE padres_id=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                padre = new Padre();
                padre.setId(rs.getInt("padres_id"));
                padre.setNombreCompleto(rs.getString("padres_nombreCompleto"));
                padre.setGenero(rs.getString("padres_genero"));
                padre.setCedula(rs.getString("padres_cedula"));
                padre.setTelefono(rs.getString("padres_telefono"));
                padre.setDireccion(rs.getString("padres_direccion"));
                padre.setEstado(rs.getString("padres_estado"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener padre según ID: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return padre;
    }

    public ArrayList<Padre> buscarPadresPorNombre(String nombre) {
        ArrayList<Padre> padresEncontrados = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_padres WHERE padres_nombreCompleto LIKE ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "%" + nombre + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                padre = new Padre();
                padre.setId(rs.getInt("padres_id"));
                padre.setNombreCompleto(rs.getString("padres_nombreCompleto"));
                padre.setGenero(rs.getString("padres_genero"));
                padre.setCedula(rs.getString("padres_cedula"));
                padre.setTelefono(rs.getString("padres_telefono"));
                padre.setDireccion(rs.getString("padres_direccion"));
                padre.setEstado(rs.getString("padres_estado"));
                padresEncontrados.add(padre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar padres por nombre: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return padresEncontrados;
    }

    public ArrayList<Padre> buscarPadresPorCedula(String cedula) {
        ArrayList<Padre> padresEncontrados = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_padres WHERE padres_cedula = ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, cedula);
            rs = ps.executeQuery();

            while (rs.next()) {
                padre = new Padre();
                padre.setId(rs.getInt("padres_id"));
                padre.setNombreCompleto(rs.getString("padres_nombreCompleto"));
                padre.setGenero(rs.getString("padres_genero"));
                padre.setCedula(rs.getString("padres_cedula"));
                padre.setTelefono(rs.getString("padres_telefono"));
                padre.setDireccion(rs.getString("padres_direccion"));
                padre.setEstado(rs.getString("padres_estado"));
                padresEncontrados.add(padre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar padres por cédula: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return padresEncontrados;
    }

    public ArrayList<Padre> buscarPadresPorGenero(String genero) {
        ArrayList<Padre> padresEncontrados = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_padres WHERE padres_genero LIKE ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "%" + genero + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                padre = new Padre();
                padre.setId(rs.getInt("padres_id"));
                padre.setNombreCompleto(rs.getString("padres_nombreCompleto"));
                padre.setGenero(rs.getString("padres_genero"));
                padre.setCedula(rs.getString("padres_cedula"));
                padre.setTelefono(rs.getString("padres_telefono"));
                padre.setDireccion(rs.getString("padres_direccion"));
                padre.setEstado(rs.getString("padres_estado"));
                padresEncontrados.add(padre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar padres por género: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return padresEncontrados;
    }

    public ArrayList<Padre> buscarPadresActivos() {
        ArrayList<Padre> padresActivos = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_padres WHERE padres_estado = 'Activo'";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                padre = new Padre();
                padre.setId(rs.getInt("padres_id"));
                padre.setNombreCompleto(rs.getString("padres_nombreCompleto"));
                padre.setGenero(rs.getString("padres_genero"));
                padre.setCedula(rs.getString("padres_cedula"));
                padre.setTelefono(rs.getString("padres_telefono"));
                padre.setDireccion(rs.getString("padres_direccion"));
                padre.setEstado(rs.getString("padres_estado"));
                padresActivos.add(padre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar padres activos: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return padresActivos;
    }

    public ArrayList<Padre> buscarPadresInactivos() {
        ArrayList<Padre> padresInactivos = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_padres WHERE padres_estado = 'Inactivo'";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                padre = new Padre();
                padre.setId(rs.getInt("padres_id"));
                padre.setNombreCompleto(rs.getString("padres_nombreCompleto"));
                padre.setGenero(rs.getString("padres_genero"));
                padre.setCedula(rs.getString("padres_cedula"));
                padre.setTelefono(rs.getString("padres_telefono"));
                padre.setDireccion(rs.getString("padres_direccion"));
                padre.setEstado(rs.getString("padres_estado"));
                padresInactivos.add(padre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar padres inactivos: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return padresInactivos;
    }

    public int obtenerIdPadreSegunNombre(String nombreCompleto) {
        Connection con = getConnection();
        int idPadre = -1; // Valor predeterminado si no se encuentra el padre

         sentenciaSQL = "SELECT padres_id FROM tbl_padres WHERE padres_nombreCompleto = ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, nombreCompleto);
            rs = ps.executeQuery();

            if (rs.next()) {
                idPadre = rs.getInt("padres_id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener ID del padre: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return idPadre;
    }

}
