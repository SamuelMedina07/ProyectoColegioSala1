/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ammcp
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ConsultaProfesor extends Conexion {

    private PreparedStatement ps;
    private String sentenciaSQL;
    private ResultSet rs;

    public boolean crearProfesor(Profesor profesor) {
        Connection con = getConnection();
        sentenciaSQL = "INSERT INTO tbl_profesor (profesor_nombreCompleto, profesor_cedula, profesor_genero, usuario_codigo, profesor_telefono, profesor_direccion, profesor_foto, profesor_estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, profesor.getNombreCompleto());
            ps.setString(2, profesor.getCedula());
            ps.setString(3, profesor.getGenero());
            ps.setInt(4, profesor.getCodigoUsuario());
            ps.setString(5, profesor.getTelefono());
            ps.setString(6, profesor.getDireccion());
            ps.setString(7, profesor.getFoto());
            ps.setString(8, profesor.getEstado());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Profesor creado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear profesor");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear profesor: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public ArrayList<Profesor> leerTodosProfesores() {
        ArrayList<Profesor> listaProfesores = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_profesor WHERE profesor_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getInt("profesor_id"));
                profesor.setNombreCompleto(rs.getString("profesor_nombreCompleto"));
                profesor.setCedula(rs.getString("profesor_cedula"));
                profesor.setGenero(rs.getString("profesor_genero"));
                profesor.setCodigoUsuario(rs.getInt("usuario_codigo"));
                profesor.setTelefono(rs.getString("profesor_telefono"));
                profesor.setDireccion(rs.getString("profesor_direccion"));
                profesor.setFoto(rs.getString("profesor_foto"));
                profesor.setEstado(rs.getString("profesor_estado"));
                listaProfesores.add(profesor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer profesores: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return listaProfesores;
    }

    public boolean buscarProfesor(int idProfesor) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_profesor WHERE profesor_id = ?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, idProfesor);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar profesor: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean modificarProfesor(Profesor profesor) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE tbl_profesor SET profesor_nombreCompleto=?, profesor_cedula=?, "
                + "profesor_genero=?, usuario_codigo=?, profesor_telefono=?, profesor_direccion=?, "
                + "profesor_foto=? WHERE profesor_id=?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, profesor.getNombreCompleto());
            ps.setString(2, profesor.getCedula());
            ps.setString(3, profesor.getGenero());
            ps.setInt(4, profesor.getCodigoUsuario());
            ps.setString(5, profesor.getTelefono());
            ps.setString(6, profesor.getDireccion());
            ps.setString(7, profesor.getFoto());
            ps.setInt(8, profesor.getId());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Profesor actualizado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el profesor");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar profesor: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean eliminarProfesor(int idProfesor) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE tbl_profesor SET profesor_estado='Inactivo' WHERE profesor_id=? AND profesor_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, idProfesor);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Profesor eliminado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el profesor");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar profesor  " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    //VALIDACIONES//***************************************************
    public boolean existeProfesorConNombreCompleto(String nombreCompleto, int codigo) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT COUNT(*) AS num_profesores FROM tbl_profesor WHERE profesor_nombreCompleto = ? AND profesor_id <> ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, nombreCompleto);
            ps.setInt(2, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                int numProfesores = rs.getInt("num_profesores");
                return numProfesores > 0; // Si hay algún profesor con el mismo nombre completo, devuelve true
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar nombre completo del profesor: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return false;
    }

    public boolean existeProfesorConCedula(String cedula, int idProfesor) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT COUNT(*) AS num_profesores FROM tbl_profesor WHERE profesor_cedula = ? AND profesor_id <> ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, cedula);
            ps.setInt(2, idProfesor);
            rs = ps.executeQuery();

            if (rs.next()) {
                int numProfesores = rs.getInt("num_profesores");
                return numProfesores > 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar cédula del profesor: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return false;
    }

    public boolean existeProfesorConMismoUsuario(int codigo, int idProfesor) {
    Connection con = getConnection();
    sentenciaSQL = "SELECT COUNT(*) AS num_profesores FROM tbl_profesor WHERE usuario_codigo = ? AND profesor_id <> ?";

    try {
        ps = con.prepareStatement(sentenciaSQL);
        ps.setInt(1, codigo);
        ps.setInt(2, idProfesor);
        rs = ps.executeQuery();

        if (rs.next()) {
            int numProfesores = rs.getInt("num_profesores");
            return numProfesores > 0;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al verificar nombre de usuario del profesor: " + ex.getMessage());
    } finally {
        closeConnection(con);
    }

    return false;
}

    /**
     * **********************************************************************************
     */
    public int obtenerSiguienteCodigo() {
        Connection con = getConnection();
        sentenciaSQL = "SELECT MAX(profesor_id) AS max_codigo FROM tbl_profesor";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            if (rs.next()) {
                String ultimoCodigo = rs.getString("max_codigo");
                if (ultimoCodigo != null) {
                    // Si hay un código máximo existente, incrementarlo en 1 y devolverlo
                    return Integer.parseInt(ultimoCodigo) + 1;
                } else {
                    // Si no hay ningún código en la base de datos, devuelve 1 como valor predeterminado
                    return 1;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el siguiente código: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        // Si no se puede obtener el siguiente código, devuelve 1 como valor predeterminado
        return 1;
    }

    //CONSULTAS DE BUSQUEDA*******************************************************
    public Profesor obtenerProfesorPorId(int idProfesor) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_profesor WHERE profesor_id = ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, idProfesor);
            rs = ps.executeQuery();

            if (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getInt("profesor_id"));
                profesor.setNombreCompleto(rs.getString("profesor_nombreCompleto"));
                profesor.setCedula(rs.getString("profesor_cedula"));
                profesor.setGenero(rs.getString("profesor_genero"));
                profesor.setCodigoUsuario(rs.getInt("usuario_codigo"));
                profesor.setTelefono(rs.getString("profesor_telefono"));
                profesor.setDireccion(rs.getString("profesor_direccion"));
                profesor.setFoto(rs.getString("profesor_foto"));
                profesor.setEstado(rs.getString("profesor_estado"));
                return profesor;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener profesor por ID: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return null;
    }

    public Profesor obtenerProfesorSegunCedula(String cedula) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_profesor WHERE profesor_cedula = ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, cedula);
            rs = ps.executeQuery();

            if (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getInt("profesor_id"));
                profesor.setNombreCompleto(rs.getString("profesor_nombreCompleto"));
                profesor.setCedula(rs.getString("profesor_cedula"));
                profesor.setGenero(rs.getString("profesor_genero"));
                profesor.setCodigoUsuario(rs.getInt("usuario_codigo"));
                profesor.setTelefono(rs.getString("profesor_telefono"));
                profesor.setDireccion(rs.getString("profesor_direccion"));
                profesor.setFoto(rs.getString("profesor_foto"));
                profesor.setEstado(rs.getString("profesor_estado"));
                return profesor;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener profesor según cédula: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return null;
    }

    public ArrayList<Profesor> buscarProfesoresPorCedula(String cedula) {
        ArrayList<Profesor> profesoresEncontrados = new ArrayList<>();
        Connection con = getConnection();
         sentenciaSQL = "SELECT * FROM tbl_profesor WHERE profesor_cedula = ?";

        try {
             ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, cedula);
             rs = ps.executeQuery();

            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getInt("profesor_id"));
                profesor.setNombreCompleto(rs.getString("profesor_nombreCompleto"));
                profesor.setGenero(rs.getString("profesor_genero"));
                profesor.setCedula(rs.getString("profesor_cedula"));
                profesor.setCodigoUsuario(rs.getInt("usuario_codigo"));
                profesor.setTelefono(rs.getString("profesor_telefono"));
                profesor.setDireccion(rs.getString("profesor_direccion"));
                profesor.setEstado(rs.getString("profesor_estado"));
                profesoresEncontrados.add(profesor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar profesores por cédula: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return profesoresEncontrados;
    }

    public ArrayList<Profesor> buscarProfesoresPorNombre(String nombre) {
        ArrayList<Profesor> profesoresEncontrados = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_profesor WHERE profesor_nombreCompleto LIKE ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "%" + nombre + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getInt("profesor_id"));
                profesor.setNombreCompleto(rs.getString("profesor_nombreCompleto"));
                profesor.setCedula(rs.getString("profesor_cedula"));
                profesor.setGenero(rs.getString("profesor_genero"));
                profesor.setCodigoUsuario(rs.getInt("usuario_codigo"));
                profesor.setTelefono(rs.getString("profesor_telefono"));
                profesor.setDireccion(rs.getString("profesor_direccion"));
                profesor.setFoto(rs.getString("profesor_foto"));
                profesor.setEstado(rs.getString("profesor_estado"));
                profesoresEncontrados.add(profesor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar profesores por nombre: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return profesoresEncontrados;
    }

    public ArrayList<Profesor> buscarProfesoresPorGenero(String genero) {
        ArrayList<Profesor> profesoresEncontrados = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_profesor WHERE profesor_genero LIKE ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "%" + genero + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getInt("profesor_id"));
                profesor.setNombreCompleto(rs.getString("profesor_nombreCompleto"));
                profesor.setCedula(rs.getString("profesor_cedula"));
                profesor.setGenero(rs.getString("profesor_genero"));
                profesor.setCodigoUsuario(rs.getInt("usuario_codigo"));
                profesor.setTelefono(rs.getString("profesor_telefono"));
                profesor.setDireccion(rs.getString("profesor_direccion"));
                profesor.setFoto(rs.getString("profesor_foto"));
                profesor.setEstado(rs.getString("profesor_estado"));
                profesoresEncontrados.add(profesor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar profesores por género: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return profesoresEncontrados;
    }

    public ArrayList<Profesor> buscarProfesoresActivos() {
        ArrayList<Profesor> profesoresActivos = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_profesor WHERE profesor_estado = 'Activo'";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getInt("profesor_id"));
                profesor.setNombreCompleto(rs.getString("profesor_nombreCompleto"));
                profesor.setCedula(rs.getString("profesor_cedula"));
                profesor.setGenero(rs.getString("profesor_genero"));
                profesor.setCodigoUsuario(rs.getInt("usuario_codigo"));
                profesor.setTelefono(rs.getString("profesor_telefono"));
                profesor.setDireccion(rs.getString("profesor_direccion"));
                profesor.setFoto(rs.getString("profesor_foto"));
                profesor.setEstado(rs.getString("profesor_estado"));
                profesoresActivos.add(profesor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar profesores activos: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return profesoresActivos;
    }

    public ArrayList<Profesor> buscarProfesoresInactivos() {
        ArrayList<Profesor> profesoresInactivos = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_profesor WHERE profesor_estado = 'Inactivo'";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getInt("profesor_id"));
                profesor.setNombreCompleto(rs.getString("profesor_nombreCompleto"));
                profesor.setCedula(rs.getString("profesor_cedula"));
                profesor.setGenero(rs.getString("profesor_genero"));
                profesor.setCodigoUsuario(rs.getInt("usuario_codigo"));
                profesor.setTelefono(rs.getString("profesor_telefono"));
                profesor.setDireccion(rs.getString("profesor_direccion"));
                profesor.setFoto(rs.getString("profesor_foto"));
                profesor.setEstado(rs.getString("profesor_estado"));
                profesoresInactivos.add(profesor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar profesores inactivos: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return profesoresInactivos;
    }

}
