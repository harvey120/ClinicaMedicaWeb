package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.CategoriaExamen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javam
 */
public class CategoriaExamenDao extends DAO{
    
    public List<CategoriaExamen> listar() throws SQLException {
        List<CategoriaExamen> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM categoriaexamen";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                CategoriaExamen exa = new CategoriaExamen();
                exa.setIdCategoriaExamen(rs.getInt("idCategoriaExamen"));
                exa.setNombreCategoria(rs.getString("NombreCategoria"));
                lista.add(exa);
            }
        } catch (SQLException e) {
            System.out.println("Error al desplegar informacion en CategoriaExamenDao Listar" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }
}
