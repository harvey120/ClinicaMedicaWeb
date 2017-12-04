package com.ClinicaMedica.reportesDAO;

import com.ClinicaMedica.DAO.DAO;
import com.ClinicaMedica.reportesModelo.ReportePacientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
public class ReportesPacienteDAO extends DAO {

    private PreparedStatement st;

    public List<ReportePacientes> listarReporte() throws SQLException {
        List<ReportePacientes> lista = null;
        ReportePacientes rep = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM rptPaciente";
            st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                rep = new ReportePacientes();
                rep.setNombre(rs.getString("nombre"));
                rep.setFecha(rs.getString("fecha"));
                rep.setTelefono(rs.getString("telefono"));
                rep.setCorreo(rs.getString("correo"));
                rep.setSexo(rs.getString("sexo"));
                rep.setCivil(rs.getString("civil"));
                rep.setDocumento(rs.getString("documento"));
                rep.setNoDocumento(rs.getString("noDocumento"));
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
