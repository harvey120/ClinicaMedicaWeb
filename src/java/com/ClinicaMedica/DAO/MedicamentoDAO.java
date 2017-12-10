package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Medicamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author medev
 */
public class MedicamentoDAO extends DAO {

    String sql;
    String pt;
    PreparedStatement st;

    public List<Medicamento> listado(Medicamento topp) throws SQLException {
        ResultSet rs;
        List<Medicamento> lista = new ArrayList<>();
        Medicamento topo = null;

        try {
            System.out.println("ingreso a listar:");
            this.Conectar();
            sql = "SELECT * FROM rptmedicamento where idMedicamento = ?";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, topp.getIdmedicamento());
            rs = st.executeQuery();
            while (rs.next()) {
                topo = new Medicamento();
                topo.setIdmedicamento(rs.getInt("idMedicamento"));
                topo.setNombre(rs.getString("Nombre"));
                topo.setDescripcion(rs.getString("Descripcion"));
                topo.setFecha(rs.getString("FechaVencimiento"));
                topo.setProvedor(rs.getString("proveedor"));

                lista.add(topo);

            }
        } catch (Exception e) {
            System.out.println("error de lista: " + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<Medicamento> listarMedicamento(Medicamento objeto) throws SQLException {
        List<Medicamento> lista = null;
        Medicamento rep = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM rptmedicamento where Nombre = ? ";
            st = this.getCn().prepareCall(sql);
            st.setString(1, objeto.getNombre());
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                rep = new Medicamento();
                rep.setIdmedicamento(rs.getInt("idMedicamento"));

                rep.setDescripcion(rs.getString("Descripcion"));
                rep.setFecha(rs.getString("fecha"));
                rep.setProvedor(rs.getString("proveedor"));
                rep.setNombre(rs.getString("Nombre"));

                lista.add(rep);
                System.out.println("Si en listo los datos");
            }

        } catch (Exception e) {
            System.out.println("Revisa ReportesPacienteDAO");
            System.out.println("Error al desplegar informacion en ReportesPacienteDAO ListarReporte" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

}
