package com.ClinicaMedica.VistaDAO;

import com.ClinicaMedica.DAO.DAO;
import com.ClinicaMedica.Modelo.HistorialClinico;
import com.ClinicaMedica.Modelo.Paciente;
import com.ClinicaMedica.Modelo.Persona;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Harvey
 */
public class VistaDAO extends DAO {

    private PreparedStatement st;

    public void registrar(Persona per, Paciente pac, HistorialClinico histo) throws SQLException {
        
        try {
            this.Conectar();
            String sql = "INSERT INTO persona(idPersona, Nombre, Apellido, FechaNac, Telefono, CorreoElectronico,"
                    + " Genero_idSexo, EstadoCivil_idEstCivil, IdDocumentoPaciente, NoDocumento,"
                    + " Religion_IdReligion) value(?,?,?,?,?,?,?,?,?,?,?)";
            this.st = this.getCn().prepareStatement(sql);
            st.setInt(1, per.getIdPersona());
            st.setString(2, per.getNombre());
            st.setString(3, per.getApellido());
            st.setString(4, per.getFechaNacimiento());
            st.setString(5, per.getTelefono());
            st.setString(6, per.getCorreoElectronico());
            st.setInt(7, per.getIdGenero());
            st.setInt(8, per.getIdEstadoCivil());
            st.setInt(9, per.getIdDocumentoPaciente());
            st.setString(10, per.getNoDocumento());
            st.setInt(11, per.getIdReligion());

            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Revisa personaDAO");
            System.out.println("No se pudo Insertar en PersonaDAO" + e);
        } finally {
            this.Cerrar();
        }

        try {
            this.Conectar();
            String sql = "INSERT INTO paciente(IdPaciente, Domicilio_IdDomicilio, contactoEmergencia, telefonoContacto, ocupacion_idOcupacion)"
                    + " value(?,?,?,?,?)";
            this.st = this.getCn().prepareStatement(sql);
            st.setInt(1, pac.getIdPaciente());
            st.setInt(2, pac.getIdDomicilio());
            st.setString(3, pac.getContactoPersona());
            st.setInt(4, pac.getTelefonoContacto());
            st.setInt(5, pac.getIdOcupacion());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Revisa pacienteDAO");
            System.out.println("No se pudo Insertar en PacienteDAO" + e);
        } finally {
            this.Cerrar();
        }

        try {
            this.Conectar();
            String sql = "INSERT INTO historialclinico(Descripcion, Paciente_idPacientee, IdReferenciaClinica, Enfermedad_idEnfermedadd, FechaHora, IdEmpleado)"
                    + " value(?,?,?,?,?,?,?)";
            this.st = this.getCn().prepareStatement(sql);
            st.setString(1, histo.getDescripcion());
            st.setInt(2, histo.getIdPaciente());
            st.setInt(3, histo.getIdReferenciaClinica());
            st.setInt(4, histo.getIdEnfermedad());
            st.setString(5, histo.getFecha());
            st.setInt(6, histo.getIdEmpleado());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Revisa HistorialClinicoDAO");
            System.out.println("No se pudo Insertar en HistorialClinicoDAO" + e);
        } finally {
            this.Cerrar();
        }
    }
}
