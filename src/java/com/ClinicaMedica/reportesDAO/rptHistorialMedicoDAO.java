package com.ClinicaMedica.reportesDAO;

import com.ClinicaMedica.DAO.DAO;
import com.ClinicaMedica.reportesModelo.rptHistorialMedico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
public class rptHistorialMedicoDAO extends DAO {

    private PreparedStatement st;

    public List<rptHistorialMedico> listarReporte(rptHistorialMedico objeto) throws SQLException {
        List<rptHistorialMedico> lista = null;
        rptHistorialMedico rep = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM historialmedico where noDocumento = ?";
            st = this.getCn().prepareStatement(sql);
            st.setString(1, objeto.getNoDocumento());
            rs = st.executeQuery();
            
            lista = new ArrayList();
            while (rs.next()) {
                rep = new rptHistorialMedico();
                rep.setNombrePaciente(rs.getString("nombrePaciente"));
                rep.setFechaNacimiento(rs.getString("fechaNacimiento"));
                rep.setTelefono(rs.getString("telefono"));
                rep.setCorreo(rs.getString("correo"));
                rep.setSexo(rs.getString("sexo"));
                rep.setCivil(rs.getString("civil"));
                rep.setDocumento(rs.getString("documento"));
                rep.setNoDocumento(rs.getString("noDocumento"));
                rep.setReligion(rs.getString("religion"));
                rep.setDireccion(rs.getString("direccion"));
                rep.setDetalleVivienda(rs.getString("detalleVivienda"));
                rep.setPersonaEncargada(rs.getString("personaEncargada"));
                rep.setContactoDeEmergencia(rs.getString("contactoDeEmergencia"));
                rep.setOcupacionPaciente(rs.getString("ocupacionPaciente"));
                rep.setCodigoHistorial(rs.getInt("codigoHistorial"));
                rep.setDescripcionHistorial(rs.getString("descripcionHistorial"));
                rep.setClinicaProveniente(rs.getString("clinicaProveniente"));
                rep.setNombreEnfermedad(rs.getString("nombreEnfermedad"));
                rep.setTipoEnfermedad(rs.getString("tipoEnfermedad"));
                rep.setMotivoConsulta(rs.getString("motivoConsulta"));
                rep.setDescripcion(rs.getString("descripcion"));
                rep.setExamenDiagnositcado(rs.getString("examenDiagnosticado"));
                rep.setTipoExamen(rs.getString("tipoExamen"));
                rep.setFechaCita(rs.getString("fechaCita"));
                rep.setHoraCita(rs.getString("horaCita"));
                rep.setTipoCita(rs.getString("tipoCita"));
                rep.setPresionPaciente(rs.getString("presionPaciente"));
                rep.setTemperaturaPaciente(rs.getString("temperaturaPaciente"));
                rep.setPesoPaciente(rs.getString("pesoPaciente"));
                rep.setEstaturaPaciente(rs.getString("estaturaPaciente"));
                rep.setTallaPaciente(rs.getString("tallaPaciente"));
                rep.setNombreEmpleado(rs.getString("nombreEmpleado"));
                lista.add(rep);
            }

        } catch (Exception e) {
            System.out.println("Revisa rptHistorialMedicoDAO");
            System.out.println("Error al desplegar informacion en rptHistorialMedicoDAO ListarReporte" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

}
