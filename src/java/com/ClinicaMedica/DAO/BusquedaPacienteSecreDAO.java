package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.BusquedaPacienteSecre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusquedaPacienteSecreDAO extends DAO {

    public BusquedaPacienteSecre leerDoc(BusquedaPacienteSecre bus) throws SQLException {
        BusquedaPacienteSecre nb = null;
        ResultSet nr;
        try {
            this.Conectar();
            PreparedStatement ns = this.getCn().prepareStatement("SELECT persona.Nombre, persona.Apellido, persona.FechaNac, persona.CorreoElectronico, persona.NoDocumento, paciente.contactoEmergencia, paciente.telefonoContacto, historialclinico.Fecha, referenciaclinica.Nombre as Referencia, enfermedad.Nombre AS NombreEnfermedad\n"
                    + "FROM persona INNER JOIN paciente ON (persona.idPersona = paciente.IdPaciente) \n"
                    + "INNER JOIN historialclinico ON (paciente.IdPaciente = historialclinico.Paciente_idPacientee)\n"
                    + "INNER JOIN referenciaclinica ON (historialclinico.IdReferenciaClinica = referenciaclinica.IdReferenciaClinica)\n"
                    + "INNER JOIN enfermedad ON (historialclinico.Enfermedad_idEnfermedadd = enfermedad.CategoriaEnfermedad_IdCategoriaE)\n"
                    + "WHERE persona.NoDocumento = ?");
            ns.setString(1, bus.getNoDocumento());
            nr = ns.executeQuery();
            
            while(nr.next()){
                nb = new BusquedaPacienteSecre();
                nb.setNombre(nr.getString("persona.Nombre"));
                nb.setApellido(nr.getString("persona.Apellido"));
                nb.setFechaNac(nr.getString("persona.FechaNac"));
                nb.setCorreo(nr.getString("persona.CorreoElectronico"));
                nb.setNoDocumento(nr.getString("persona.NoDocumento"));
                nb.setContactoEmergencia(nr.getString("paciente.ContactoEmergencia"));
                nb.setTelefono(nr.getString("paciente.telefonoContacto"));
                nb.setFechaHistorial(nr.getString("historialclinico.Fecha"));
                nb.setReferenciaClinica(nr.getString("Referencia"));
                nb.setEnfermedad(nr.getString("NombreEnfermedad"));
            }
            
        } catch (Exception e) {
            System.out.println("Error en leer IDBusquedaPacienteSecreDao: "+e);
        } finally {
            this.Cerrar();
        } return nb;
    }
}