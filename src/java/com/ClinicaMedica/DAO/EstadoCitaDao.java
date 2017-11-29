
package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.EstadoCita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoCitaDao extends DAO{
     public List<EstadoCita> listar() throws SQLException {
        List<EstadoCita> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM estadocita";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EstadoCita cit = new EstadoCita();
                cit.setIdEstadoCita(rs.getInt("IdEstadoCita"));
                cit.setTipo(rs.getString("Tipo"));
               
                
                lista.add(cit);
            }
        } catch (SQLException e) {
            System.out.println("Error al desplegar informacion en EstadoCitaDao Listar" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }
}
