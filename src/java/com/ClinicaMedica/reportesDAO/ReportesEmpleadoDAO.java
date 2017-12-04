package com.ClinicaMedica.reportesDAO;

import com.ClinicaMedica.DAO.DAO;
import com.ClinicaMedica.reportesModelo.ReporteEmpleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
public class ReportesEmpleadoDAO extends DAO{
    
    private PreparedStatement st;
    
    public List<ReporteEmpleado> listarReporte() throws SQLException {
        List<ReporteEmpleado> lista = null;
        ReporteEmpleado rep = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM rptEmpleado";
            st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                rep = new ReporteEmpleado();
                rep.setNombre(rs.getString("nombre"));
                rep.setTelefono(rs.getString("telefono"));
                rep.setCorreo(rs.getString("correo"));
                rep.setDocumento(rs.getString("documento"));
                rep.setNoDocumento(rs.getString("noDocumento"));
                rep.setEspecialidad(rs.getString("especialidad"));
                rep.setConsultorio(rs.getString("consultorio"));
                rep.setPuesto(rs.getString("puesto"));
                lista.add(rep);
            }

        } catch (Exception e) {
            System.out.println("Revisa ReportesEmpleadoDAO");
            System.out.println("Error al desplegar informacion en ReportesEmpleadoDAO ListarEmpleado" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
}
