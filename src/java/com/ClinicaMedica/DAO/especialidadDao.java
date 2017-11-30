package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Especialidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class especialidadDao extends DAO {

    String sql;
    PreparedStatement st;
    
    public void registrar(Especialidad doc) throws Exception {
        try {
            this.Conectar();
            sql = "insert into especialidad(idEspecialidad, nombreEspecialidad) value(?,?)";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, doc.getIdEspecialidad());
            st.setString(2, doc.getNombreEspecialidad());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Errooooooor" + e);
        } finally {
            this.Cerrar();
        }
    }
    
    public List<Especialidad> listar() throws Exception {
        List<Especialidad> lista = new ArrayList();
        ResultSet rs;
        int i = -1;
        try {
            System.out.println("daolistar");
            this.Conectar();
            sql = "SELECT * FROM especialidad";
            st = this.getCn().prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                i++;

                Especialidad mar = new Especialidad();
                mar.setIdEspecialidad(rs.getInt("IdEspecialidad"));
                mar.setNombreEspecialidad(rs.getString("nombreEspecialidad"));
                lista.add(mar);
                //System.out.println(lista.get(i).getCodigo());
            }

        } catch (Exception e) {
            System.out.println("error Pacienete dao" + e);
        } finally {
            this.Cerrar();

        }
        return lista;
    }
    
    
    public void modificar(Especialidad mar) throws SQLException {
        try {
            this.Conectar();
            System.out.println("hola Documento_Identificacion Dao**************************");
            sql = "UPDATE especialidad SET nombreEspecialidad=? WHERE IdEspecialidad = ?;";
            st = this.getCn().prepareStatement(sql);
            st.setString(1, mar.getNombreEspecialidad());
            st.setInt(2, mar.getIdEspecialidad());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("*********error DocumentoIdentificacion DAO **************************" + e);
        } finally {
            this.Cerrar();
        }
    }
    
    
    public void eliminar(Especialidad mar) throws SQLException {

        try {
            this.Conectar();
            sql = ("DELETE FROM especialidad WHERE IdEspecialidad = ?;");
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, mar.getIdEspecialidad());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR ELIMINAR Documento_Identificacion DAO ***********" + e);
        } finally {
            this.Cerrar();
        }

    }

}
