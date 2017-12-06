package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Examen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author javam
 */
public class VistaExamenDAO extends DAO {

    String sql;
    PreparedStatement st;

    public Examen listado(Examen topp) throws SQLException {
        ResultSet rs;
        //clase con los 4 atributos
        Examen topo = new Examen();

        try {
            System.out.println("ingreso a listar Examenes:");
            this.Conectar();
            //sql = "SELECT * FROM Examenesdetalles";
            sql = "SELECT * FROM Examen where idExamen = ?";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, topp.getIdExamen());
            rs = st.executeQuery();
            while (rs.next()) {

                topo.setNombre(rs.getString("Nombre"));
                topo.setIdCategoriaExamen(rs.getInt("idCategoriaExamen"));
                topo.setIdExamen(rs.getInt("idExamen"));
            }
        } catch (Exception e) {
            System.out.println("error de listar Examenes Dao: " + e);
        } finally {
            this.Cerrar();
        }
        return topo;
    }
}
