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

/**
 *
 * @author ammcp
 */
public class ConsultaUsuarios extends Conexion {

    PreparedStatement ps = null;
    String sentenciaSQL;
    ResultSet rs;
    Usuario usuario;

    public boolean crearUsuario(Usuario usuario) {
        Connection con = getConnection();
        sentenciaSQL = "INSERT INTO tbl_usuarios (usuario_codigo, usuario_nombre, usuario_contrasena, usuario_rol, usuario_estado) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, usuario.getCodigo());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getRol());
            ps.setString(5, usuario.getEstado());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear usuario: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public ArrayList<Usuario> leerTodosUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_usuarios";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                listaUsuarios.add(new Usuario(
                        rs.getInt("usuario_codigo"),
                        rs.getString("usuario_nombre"),
                        rs.getString("usuario_contrasena"),
                        rs.getString("usuario_rol"),
                        rs.getString("usuario_estado")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer usuarios: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return listaUsuarios;
    }

    public boolean buscarUsuario(Usuario usuario) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_usuarios WHERE usuario_codigo=?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, usuario.getCodigo());
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setNombre(rs.getString("usuario_nombre"));
                usuario.setContrasena(rs.getString("usuario_contrasena"));
                usuario.setRol(rs.getString("usuario_rol"));
                usuario.setEstado(rs.getString("usuario_estado"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuario: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean modificarUsuario(Usuario usuario) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE tbl_usuarios SET usuario_nombre=?, usuario_contrasena=?, usuario_rol=?, usuario_estado=? WHERE usuario_codigo=?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContrasena());
            ps.setString(3, usuario.getRol());
            ps.setString(4, usuario.getEstado());
            ps.setInt(5, usuario.getCodigo());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar usuario: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean eliminarUsuario(Usuario usuario) {
        Connection con = getConnection();
        sentenciaSQL = "DELETE FROM tbl_usuarios WHERE usuario_codigo=?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, usuario.getCodigo());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    //**********************************
    public boolean verificarCredenciales(String nombreUsuario, String contrasena) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_usuarios WHERE usuario_nombre = ? AND usuario_contrasena = ? AND usuario_estado = 'Activo' ";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            // Si la consulta devuelve algún resultado, significa que las credenciales son válidas
            return rs.next(); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CREDENCIALES INCORRECTAS, ERROR: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }
}
