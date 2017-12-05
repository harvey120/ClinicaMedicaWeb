package com.ClinicaMedica.reportesDAO;

import com.ClinicaMedica.DAO.DAO;
import com.ClinicaMedica.reportesModelo.rptBusquedaEmpleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
public class ReportesBusquedaEmpleadoDAO extends DAO {

    private PreparedStatement st;

    public List<rptBusquedaEmpleado> listarReporte(rptBusquedaEmpleado objeto) throws SQLException {
        
        List<rptBusquedaEmpleado> lista = null;
        rptBusquedaEmpleado rep = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM rptbusquedaempleado where noDocumento=?";
            st = this.getCn().prepareCall(sql);
            st.setString(1, objeto.getNoDocumento());
            rs = st.executeQuery();
            
            lista = new ArrayList();
            
            while (rs.next()) {
                rep = new rptBusquedaEmpleado();
                rep.setNombreCompleto(rs.getString("nombreCompleto"));
                rep.setFechaNacimiento(rs.getString("fechaNacimiento"));
                rep.setTelefonoDeContacto(rs.getString("telefonoDeContacto"));
                rep.setCorreo(rs.getString("correo"));
                rep.setSexo(rs.getString("sexo"));
                rep.setCivil(rs.getString("civil"));
                rep.setDocumentoIdentificacion(rs.getString("documentoIdentificacion"));
                rep.setNoDocumento(rs.getString("noDocumento"));
                rep.setEspecialidad(rs.getString("especialidad"));
                rep.setConsultorio(rs.getString("consultorio"));
                rep.setEstadoCita(rs.getString("estadoCita"));
                rep.setPuesto(rs.getString("puesto"));
                rep.setUsuario(rs.getString("usuario"));
                rep.setContrasena(rs.getString("contrasena"));
                rep.setEstado(rs.getString("estado"));
                lista.add(rep);
                
            }

        } catch (Exception e) {
            System.out.println("Revisa ReportesBusquedaEmpleadoDAO");
            System.out.println("Error al desplegar informacion en ReportesBusquedaEmpleadoDAO ListarEmpleado" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

}
