package com.ClinicaMedica.reportesDAO;

import com.ClinicaMedica.DAO.DAO;
import com.ClinicaMedica.reportesModelo.rptBusquedaPaciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
public class ReportesBusquedaPacienteDAO extends DAO {

    private PreparedStatement st;

    public List<rptBusquedaPaciente> listarReporte(rptBusquedaPaciente objeto) throws SQLException {

        List<rptBusquedaPaciente> lista = null;
        rptBusquedaPaciente rep = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM rptbusquedapaciente where noDocumento=?";
            st = this.getCn().prepareCall(sql);
            st.setString(1, objeto.getNoDocumento());
            rs = st.executeQuery();

            lista = new ArrayList();

            while (rs.next()) {
                rep = new rptBusquedaPaciente();
                rep.setNombrePaciente(rs.getString("nombrePaciente"));
                rep.setFechaNacimiento(rs.getString("fechaNacimiento"));
                rep.setTelefono(rs.getString("telefono"));
                rep.setCorreo(rs.getString("correo"));
                rep.setGenero(rs.getString("genero"));
                rep.setCivil(rs.getString("civil"));
                rep.setDocumento(rs.getString("documento"));
                rep.setNoDocumento(rs.getString("noDocumento"));
                rep.setReligion(rs.getString("religion"));
                rep.setDireccion(rs.getString("direccion"));
                rep.setDetalleVivienda(rs.getString("detalleVivienda"));
                rep.setOcupacion(rs.getString("ocupacion"));
                rep.setCodigoHistorial(rs.getInt("codigoHistorial"));
                rep.setDescripcion(rs.getString("descripcion"));
                rep.setFechaIngreso(rs.getString("fechaIngreso"));
                rep.setReferenciaClinica(rs.getString("referenciaClinica"));
                lista.add(rep);

            }

        } catch (Exception e) {
            System.out.println("Revisa ReportesBusquedaPacienteDAO");
            System.out.println("Error al desplegar informacion en ReportesBusquedaPacienteDAO ListarPaciente" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

}
