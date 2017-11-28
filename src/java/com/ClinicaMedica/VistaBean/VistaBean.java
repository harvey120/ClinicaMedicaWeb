package com.ClinicaMedica.VistaBean;

import com.ClinicaMedica.Modelo.HistorialClinico;
import com.ClinicaMedica.Modelo.Paciente;
import com.ClinicaMedica.Modelo.Persona;
import com.ClinicaMedica.VistaDAO.VistaDAO;
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
        VistaDAO dao;
        
        paciente.setIdPaciente(persona.getIdPersona());
        historial.setIdPaciente(paciente.getIdPaciente());
        
        // modificar la base de datos y recordar que la tabla historial clinico es autonumerica
        
        try {
            dao = new VistaDAO();
            dao.registrar(persona,paciente,historial);

        } catch (Exception e) {
            System.out.println("No se registro en VistaBean " + e);
        }
    }
}
