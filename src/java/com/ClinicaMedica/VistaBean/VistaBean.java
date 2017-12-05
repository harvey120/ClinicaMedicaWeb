package com.ClinicaMedica.VistaBean;

import com.ClinicaMedica.Modelo.HistorialClinico;
import com.ClinicaMedica.Modelo.Paciente;
import com.ClinicaMedica.Modelo.Persona;
import com.ClinicaMedica.VistaDAO.VistaDAOPaciente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Harvey
 */
@ManagedBean
@ViewScoped
public class VistaBean {

    private Persona persona = new Persona();
    private Paciente paciente = new Paciente();
    private HistorialClinico historial = new HistorialClinico();

    
    public VistaBean() {

    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public HistorialClinico getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialClinico historial) {
        this.historial = historial;
    }

    public void registrar() {
        VistaDAOPaciente dao;
        
        paciente.setIdPaciente(persona.getIdPersona());
        historial.setIdPaciente(paciente.getIdPaciente());
        
        try {
            dao = new VistaDAOPaciente();
            dao.registrar(persona,paciente,historial);
            this.limpiar();
        } catch (Exception e) {
            System.out.println("No se registro en VistaBean " + e);
        }
    }
    
    public void limpiar (){
        persona.setNombre("");
        persona.setApellido("");
        persona.setFechaNacimiento("");
        persona.setTelefono("");
        persona.setCorreoElectronico("");
        persona.setNoDocumento("");
        persona.setIdDocumentoPaciente(0);
        paciente.setIdDomicilio(0);
        paciente.setContactoPersona("");
        paciente.setTelefonoContacto(0);
        paciente.setIdOcupacion(0);
        historial.setDescripcion("");
        historial.setIdReferenciaClinica(0);
        historial.setIdEnfermedad(0);
        historial.setFecha("");
    }
    
   
}
