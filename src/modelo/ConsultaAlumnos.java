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

public class ConsultaAlumnos extends Conexion {

    private PreparedStatement ps;
    private String sentenciaSQL;
    private ResultSet rs;

    public boolean crearAlumno(Alumno alumno) {
        Connection con = getConnection();
        sentenciaSQL = "INSERT INTO tbl_alumnos (alumno_numCuenta, alumno_nombreCompleto, alumno_genero, alumno_fechaNac, "
                + "alumno_direccion, alumno_telefono, alumno_foto, padres_id, grados_id, alumnos_estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, alumno.getNumCuenta());
            ps.setString(2, alumno.getNombreCompleto());
            ps.setString(3, alumno.getGenero());
            ps.setDate(4, new java.sql.Date(alumno.getFechaNac().getTime()));
            ps.setString(5, alumno.getDireccion());
            ps.setString(6, alumno.getTelefono());
            ps.setString(7, alumno.getFoto());
            ps.setInt(8, alumno.getIdPadres());
            ps.setInt(9, alumno.getIdGrado());
            ps.setString(10, alumno.getEstado());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Alumno creado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear alumno");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear alumno: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public ArrayList<Alumno> leerTodosAlumnos() {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_alumnos WHERE alumnos_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setNumCuenta(rs.getString("alumno_numCuenta"));
                alumno.setNombreCompleto(rs.getString("alumno_nombreCompleto"));
                alumno.setGenero(rs.getString("alumno_genero"));
                alumno.setFechaNac(rs.getDate("alumno_fechaNac"));
                alumno.setDireccion(rs.getString("alumno_direccion"));
                alumno.setTelefono(rs.getString("alumno_telefono"));
                alumno.setFoto(rs.getString("alumno_foto"));
                alumno.setIdPadres(rs.getInt("padres_id"));
                alumno.setIdGrado(rs.getInt("grados_id"));
                alumno.setEstado(rs.getString("alumnos_estado"));
                listaAlumnos.add(alumno);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer alumnos: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        return listaAlumnos;
    }

    public boolean buscarAlumno(String numCuenta) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_alumnos WHERE alumno_numCuenta=? AND alumnos_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, numCuenta);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumno: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean modificarAlumno(Alumno alumno) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE tbl_alumnos SET alumno_nombreCompleto=?, alumno_genero=?, "
                + "alumno_fechaNac=?, alumno_direccion=?, alumno_telefono=?, alumno_foto=?, "
                + "padres_id=?, grados_id=? WHERE alumno_numCuenta=? AND alumnos_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, alumno.getNombreCompleto());
            ps.setString(2, alumno.getGenero());
            ps.setDate(3, new java.sql.Date(alumno.getFechaNac().getTime()));
            ps.setString(4, alumno.getDireccion());
            ps.setString(5, alumno.getTelefono());
            ps.setString(6, alumno.getFoto());
            ps.setInt(7, alumno.getIdPadres());
            ps.setInt(8, alumno.getIdGrado());
            ps.setString(9, alumno.getNumCuenta());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Alumno actualizado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se puede actualizar el alumno");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar alumno: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean eliminarAlumno(String numCuenta) {
        Connection con = getConnection();
        sentenciaSQL = "UPDATE  tbl_alumnos SET alumnos_estado='Inactivo' WHERE alumno_numCuenta=? AND alumnos_estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, numCuenta);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar el alumno");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar alumno: " + ex.getMessage());
            return false;
        } finally {
            closeConnection(con);
        }
    }

    //VALIDACIONES//***************************************************
    public boolean existeAlumnoConNombreCompleto(String nombreCompleto, String numCuenta) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT COUNT(*) AS num_alumnos FROM tbl_alumnos WHERE alumno_nombreCompleto = ? AND alumno_numCuenta <> ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, nombreCompleto);
            ps.setString(2, numCuenta);
            rs = ps.executeQuery();

            if (rs.next()) {
                int numAlumnos = rs.getInt("num_alumnos");
                return numAlumnos > 0; // Si hay algún alumno con el mismo nombre completo, devuelve true
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar nombre completo del alumno: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return false; // Si no se puede realizar la verificación, devuelve false
    }

    /**
     * **********************************************************************************
     */
    public int obtenerSiguienteCodigo() {
        Connection con = getConnection();
        sentenciaSQL = "SELECT MAX(alumno_numCuenta) AS max_codigo FROM tbl_alumnos";

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
    public Alumno obtenerAlumnoSegunNumCuenta(String numCuenta) {
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_alumnos WHERE alumno_numCuenta=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, numCuenta);
            rs = ps.executeQuery();

            if (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setNumCuenta(rs.getString("alumno_numCuenta"));
                alumno.setNombreCompleto(rs.getString("alumno_nombreCompleto"));
                alumno.setGenero(rs.getString("alumno_genero"));
                alumno.setFechaNac(rs.getDate("alumno_fechaNac"));
                alumno.setDireccion(rs.getString("alumno_direccion"));
                alumno.setTelefono(rs.getString("alumno_telefono"));
                alumno.setFoto(rs.getString("alumno_foto"));
                alumno.setIdPadres(rs.getInt("padres_id"));
                alumno.setIdGrado(rs.getInt("grados_id"));
                alumno.setEstado(rs.getString("alumnos_estado"));
                return alumno;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener alumno según número de cuenta: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return null;
    }

    public ArrayList<Alumno> buscarAlumnosPorNombre(String nombre) {
        ArrayList<Alumno> alumnosEncontrados = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_alumnos WHERE alumno_nombreCompleto LIKE ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "%" + nombre + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setNumCuenta(rs.getString("alumno_numCuenta"));
                alumno.setNombreCompleto(rs.getString("alumno_nombreCompleto"));
                alumno.setGenero(rs.getString("alumno_genero"));
                alumno.setFechaNac(rs.getDate("alumno_fechaNac"));
                alumno.setDireccion(rs.getString("alumno_direccion"));
                alumno.setTelefono(rs.getString("alumno_telefono"));
                alumno.setFoto(rs.getString("alumno_foto"));
                alumno.setIdPadres(rs.getInt("padres_id"));
                alumno.setIdGrado(rs.getInt("grados_id"));
                alumno.setEstado(rs.getString("alumnos_estado"));
                alumnosEncontrados.add(alumno);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumnos por nombre: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return alumnosEncontrados;
    }

    public ArrayList<Alumno> buscarAlumnosPorGenero(String genero) {
        ArrayList<Alumno> alumnosEncontrados = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_alumnos WHERE alumno_genero LIKE ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "%" + genero + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setNumCuenta(rs.getString("alumno_numCuenta"));
                alumno.setNombreCompleto(rs.getString("alumno_nombreCompleto"));
                alumno.setGenero(rs.getString("alumno_genero"));
                alumno.setFechaNac(rs.getDate("alumno_fechaNac"));
                alumno.setDireccion(rs.getString("alumno_direccion"));
                alumno.setTelefono(rs.getString("alumno_telefono"));
                alumno.setFoto(rs.getString("alumno_foto"));
                alumno.setIdPadres(rs.getInt("padres_id"));
                alumno.setIdGrado(rs.getInt("grados_id"));
                alumno.setEstado(rs.getString("alumnos_estado"));
                alumnosEncontrados.add(alumno);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumnos por género: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return alumnosEncontrados;
    }

    public ArrayList<Alumno> buscarAlumnosActivos() {
        ArrayList<Alumno> alumnosActivos = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_alumnos WHERE alumnos_estado = 'Activo'";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setNumCuenta(rs.getString("alumno_numCuenta"));
                alumno.setNombreCompleto(rs.getString("alumno_nombreCompleto"));
                alumno.setGenero(rs.getString("alumno_genero"));
                alumno.setFechaNac(rs.getDate("alumno_fechaNac"));
                alumno.setDireccion(rs.getString("alumno_direccion"));
                alumno.setTelefono(rs.getString("alumno_telefono"));
                alumno.setFoto(rs.getString("alumno_foto"));
                alumno.setIdPadres(rs.getInt("padres_id"));
                alumno.setIdGrado(rs.getInt("grados_id"));
                alumno.setEstado(rs.getString("alumnos_estado"));
                alumnosActivos.add(alumno);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumnos activos: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return alumnosActivos;
    }

    public ArrayList<Alumno> buscarAlumnosInactivos() {
        ArrayList<Alumno> alumnosInactivos = new ArrayList<>();
        Connection con = getConnection();
        sentenciaSQL = "SELECT * FROM tbl_alumnos WHERE alumnos_estado = 'Inactivo'";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setNumCuenta(rs.getString("alumno_numCuenta"));
                alumno.setNombreCompleto(rs.getString("alumno_nombreCompleto"));
                alumno.setGenero(rs.getString("alumno_genero"));
                alumno.setFechaNac(rs.getDate("alumno_fechaNac"));
                alumno.setDireccion(rs.getString("alumno_direccion"));
                alumno.setTelefono(rs.getString("alumno_telefono"));
                alumno.setFoto(rs.getString("alumno_foto"));
                alumno.setIdPadres(rs.getInt("padres_id"));
                alumno.setIdGrado(rs.getInt("grados_id"));
                alumno.setEstado(rs.getString("alumnos_estado"));
                alumnosInactivos.add(alumno);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar alum: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }

        return alumnosInactivos;
    } 

    
    
    public Date obtenerFechaNacimientoPorNumeroCuenta(String numCuenta) {
        Connection con = getConnection();
        Date fechaNacimiento = null;
        String query = "SELECT alumno_fechaNac FROM tbl_alumnos WHERE alumno_numCuenta = ?";
        
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, numCuenta);
            rs = ps.executeQuery();
            if (rs.next()) {
                fechaNacimiento = rs.getDate("alumno_fechaNac");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la fecha de nacimiento: " + ex.getMessage());
        } finally {
            closeConnection(con);
        }
        
        return fechaNacimiento;
    }
   
}
