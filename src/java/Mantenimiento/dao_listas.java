package Mantenimiento;

import com.ClinicaMedica.DAO.DAO;
import com.ClinicaMedica.Modelo.Provedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dao_listas extends DAO {
 
   private PreparedStatement pre;
    String sql;
    ResultSet rs;
    
     public ArrayList<Provedor> listarunico() throws SQLException {
        
        List<Provedor> me = new ArrayList();
        try {
            this.Conectar();
            sql = "SELECT * FROM proveedor";
            pre = this.getCn().prepareCall(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Provedor men = new Provedor();
                men.setNombre(rs.getString("Nombre"));
                men.setIdprovedor(rs.getInt("idProveedor"));
                me.add(men);
            }
        } catch (SQLException ex) {
            System.out.println("no inserta ocupacion: " + ex);
        } finally {
            this.Cerrar();
        }
        return (ArrayList<Provedor>) me;
    }
  
}
