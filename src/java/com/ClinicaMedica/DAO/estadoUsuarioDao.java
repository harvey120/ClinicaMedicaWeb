package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.EstadoUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erick osoy
 */
public class estadoUsuarioDao extends DAO {

    String sql;
    PreparedStatement st;

    public void registrar(EstadoUsuario doc) throws Exception {
        try {
            this.Conectar();
            sql = "insert into estadousuario(idEstadoUsuario, tipoEstado) value(?,?)";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, doc.getIdEstadoUsuario());
            st.setString(2, doc.getTipoEstado());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Errooooooor EstadoUsuario Dao" + e);
        } finally {
            this.Cerrar();
        }
    }

    public List<EstadoUsuario> listar() throws Exception {
        List<EstadoUsuario> lista = new ArrayList();
        ResultSet rs;
        int i = -1;
        try {
            System.out.println("daolistar");
            this.Conectar();
            sql = "SELECT * FROM estadousuario";
            st = this.getCn().prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                i++;

                EstadoUsuario mar = new EstadoUsuario();
                mar.setIdEstadoUsuario(rs.getInt("IdEstadoUsuario"));
                mar.setTipoEstado(rs.getString("tipoEstado"));
                lista.add(mar);
                //System.out.println(lista.get(i).getCodigo());
            }

        } catch (Exception e) {
            System.out.println("error EstadoUsuario dao" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public void modificar(EstadoUsuario mar) throws SQLException {
        try {
            this.Conectar();
            System.out.println("hola EstadoUsuario Dao**************************");
            sql = "UPDATE estadousuario SET tipoEstado=? WHERE IdEstadoUsuario = ?;";
            st = this.getCn().prepareStatement(sql);
            st.setString(1, mar.getTipoEstado());
            st.setInt(2, mar.getIdEstadoUsuario());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("********* Error EstadoUsuario DAO **************************" + e);
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(EstadoUsuario mar) throws SQLException {

        try {
            this.Conectar();
            sql = ("DELETE FROM estadousuario WHERE IdEstadoUsuario = ?;");
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, mar.getIdEstadoUsuario());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR ELIMINAR EstadoUsuario DAO ***********" + e);
        } finally {
            this.Cerrar();
        }

    }

}
