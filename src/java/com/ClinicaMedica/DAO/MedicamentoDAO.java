package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Medicamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author medev
 */
public class MedicamentoDAO extends DAO {

    String sql;
    String pt;
    PreparedStatement st;
    
    
    public Medicamento listado(Medicamento topp) throws SQLException{
         ResultSet rs;
        Medicamento topo = new Medicamento();
        
        try {
            System.out.println("ingreso a listar:");
            this.Conectar();
            //sql = "SELECT * FROM Examenesdetalles";
            sql = "SELECT * FROM Medicamento where idMedicamento = ?";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, topp.getIdmedicamento());
            rs = st.executeQuery();            
            while (rs.next()) {
                
                topo.setNombre(rs.getString("Nombre"));
                topo.setDescripcion(rs.getString("Descripcion"));
                topo.setFecha(rs.getString("FechaVencimiento"));
                topo.setProvedor(rs.getInt("Proveedor_idProveedor"));
                topo.setIdInventario(rs.getInt("Inventario_idInventario"));
                topo.setIdmedicamento(rs.getInt("idMedicamento"));
                
            }
        } catch (Exception e) {
            System.out.println("error de lista: " + e);
        } finally {
            this.Cerrar();
        }
        return topo;
    }

}
