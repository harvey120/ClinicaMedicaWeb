package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erick osoy
 */
public class usuarioDao extends DAO {

    String sql;
    PreparedStatement st;

    public void registrarUsuarios(Usuarios doc) throws Exception {
        try {
            this.Conectar();
            sql = "insert into usuario( idUsuario,Usuario, Contrasenia, EstadoUsuario_idEstadoUsuario) value(?,?,?,?)";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, doc.getIdUsuario());
            st.setString(2, doc.getUsuario());
            st.setString(3, doc.getContrasenia());
            st.setInt(4, doc.getIdEstadoUsuario());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("***************ERROR Insertar UsuarioDao************" + e);
        } finally {
            this.Cerrar();
        }

    }

    public List<Usuarios> listar() throws Exception {
        List<Usuarios> lista = new ArrayList();
        ResultSet rs;
        int i = -1;
        try {
            System.out.println("daolistar");
            this.Conectar();
            sql = "SELECT * FROM usuario";
            st = this.getCn().prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                i++;

                Usuarios mar = new Usuarios();
                mar.setIdUsuario(rs.getInt("IdUsuario"));
                mar.setUsuario(rs.getString("Usuario"));
                mar.setContrasenia(rs.getString("Contrasenia"));
                mar.setIdEstadoUsuario(rs.getInt("EstadoUsuario_idEstadoUsuario"));
                lista.add(mar);
                //System.out.println(lista.get(i).getCodigo());
            }

        } catch (Exception e) {
            System.out.println("***************ERROR Listar UsuarioDao************" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public void modificarUsuarios(Usuarios mar) throws SQLException {
        try {
            this.Conectar();
            System.out.println("hola Usuarios Dao**************************");
            sql = "UPDATE usuario SET Usuario=?, contrasenia=?, EstadoUsuario_idEstadoUsuario=? WHERE idUsuario=?;";
            st = this.getCn().prepareStatement(sql);
            st.setString(1, mar.getUsuario());
            st.setString(2, mar.getContrasenia());
            st.setInt(3, mar.getIdEstadoUsuario());
            st.setInt(4, mar.getIdUsuario());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("***************ERROR Modificar UsuarioDao************" + e);
        } finally {
            this.Cerrar();
        }
    }

    public void eliminarUsuarios(Usuarios mar) throws SQLException {

        try {
            this.Conectar();
            sql = ("DELETE FROM usuario WHERE IdUsuario = ?;");
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, mar.getIdUsuario());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("***************ERROR Eliminar UsuarioDao************" + e);
        } finally {
            this.Cerrar();
        }

    }

    public Usuarios leerID(Usuarios vi) throws Exception {
        Usuarios pers = null;
        ResultSet rs;

        try {
            System.out.println("****************daoLEER*********************");
            this.Conectar();
            sql = "SELECT * from usuario WHERE IdUsuario = ?";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, vi.getIdUsuario());
            rs = st.executeQuery();
            while (rs.next()) {
                pers = new Usuarios();
                pers.setIdUsuario(rs.getInt("IdUsuario"));
                pers.setUsuario(rs.getString("Usuario"));
                pers.setContrasenia(rs.getString("contrasenia"));
                pers.setIdEstadoUsuario(rs.getInt("EstadoUsuario_idEstadoUsuario"));
            }

        } catch (Exception e) {
            System.out.println("***************ERROR LEER ID UsuarioDao************" + e);
        } finally {
            this.Cerrar();
        }
        return pers;
    }

}
