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
        sentenciaSQL = "INSERT INTO tbl_usuarios (usuario_nombre, usuario_contrasena, usuario_rol, usuario_estado) VALUES (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContrasena());
            ps.setString(3, usuario.getRol());
            ps.setString(4, usuario.getEstado());
            int filasAfectadas = ps.executeUpdate(); // Usamos executeUpdate en lugar de execute
            if (filasAfectadas > 0) { // Verificamos si se insertaron filas en la base de datos
                JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear usuario: No se pudo insertar el usuario");
                return false;
            }
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
        sentenciaSQL = "SELECT * FROM tbl_usuarios WHERE usuario_estado = 'Activo'";
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
        sentenciaSQL = "UPDATE tbl_usuarios SET usuario_nombre=?, usuario_contrasena=?, usuario_rol=? WHERE usuario_codigo=? AND usuario_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContrasena());
            ps.setString(3, usuario.getRol());
            ps.setInt(4, usuario.getCodigo());
            int filasAfectadas = ps.executeUpdate(); // Usamos executeUpdate en lugar de execute
            if (filasAfectadas > 0) { // Verificamos si se actualizaron filas en la base de datos
                JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE ACTUALIZAR EL USUARIO");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar usuario: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean eliminarUsuario(Usuario usuario) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE tbl_usuarios SET usuario_estado =?  WHERE usuario_codigo=? AND usuario_estado = 'Activo' ";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "Inactivo");
            ps.setInt(2, usuario.getCodigo());
            int filasAfectadas = ps.executeUpdate(); // Usamos executeUpdate en lugar de execute
            if (filasAfectadas > 0) { // Verificamos si se actualizaron filas en la base de datos
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR EL USUARIO");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    //**********************************VERIFICACIONES
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

    public boolean existeUsuario(String nombreUsuario, int codigoUsuario) {
    Connection con = getConnection();
    sentenciaSQL = "SELECT COUNT(*) FROM tbl_usuarios WHERE usuario_nombre = ? AND usuario_codigo != ?";
    try {
        ps = con.prepareStatement(sentenciaSQL);
        ps.setString(1, nombreUsuario);
        ps.setInt(2, codigoUsuario);
        rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; // Devolverá true si la condición es verdadera
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al verificar usuario: " + ex.getMessage());
    } finally {
        closeConnection(con);
    }
    return false;
}

    //***********************************BUSQUEDAS
    public int obtenerSiguienteCodigo() {
        Connection con = getConnection();
        sentenciaSQL = "SELECT MAX(usuario_codigo) AS max_codigo FROM tbl_usuarios";
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
    
    public Usuario obtenerUusuarioSegunIdUsuario(int id){
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_usuarios WHERE usuario_codigo=?";
        
        try{
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setCodigo(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setContrasena(rs.getString(3));
                usuario.setRol(rs.getString(4));
                usuario.setEstado(rs.getString(5));
                return usuario;
            }
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo leer datos " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return null;
    }
    
     public ArrayList<Usuario> buscarUsuariosPorNombre(String nombreUsuario) {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_usuarios WHERE usuario_nombre LIKE ? AND usuario_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "%" + nombreUsuario + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("usuario_codigo"),
                        rs.getString("usuario_nombre"),
                        rs.getString("usuario_contrasena"),
                        rs.getString("usuario_rol"),
                        rs.getString("usuario_estado")
                );
                listaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuarios por nombre: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return listaUsuarios;
    }
     
     public ArrayList<Usuario> buscarUsuariosPorRol(String rol) {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_usuarios WHERE usuario_rol = ? AND usuario_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, rol);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("usuario_codigo"),
                        rs.getString("usuario_nombre"),
                        rs.getString("usuario_contrasena"),
                        rs.getString("usuario_rol"),
                        rs.getString("usuario_estado")
                );
                listaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuarios por rol: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return listaUsuarios;
    }

    public ArrayList<Usuario> buscarUsuariosActivos() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_usuarios WHERE usuario_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("usuario_codigo"),
                        rs.getString("usuario_nombre"),
                        rs.getString("usuario_contrasena"),
                        rs.getString("usuario_rol"),
                        rs.getString("usuario_estado")
                );
                listaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuarios activos: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return listaUsuarios;
    }

    public ArrayList<Usuario> buscarUsuariosInactivos() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_usuarios WHERE usuario_estado = 'Inactivo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("usuario_codigo"),
                        rs.getString("usuario_nombre"),
                        rs.getString("usuario_contrasena"),
                        rs.getString("usuario_rol"),
                        rs.getString("usuario_estado")
                );
                listaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuarios inactivos: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return listaUsuarios;
    }

}
