package com.ClinicaMedica.Modelo;

/**
 * @author Harvey
 */
public class HistorialClinico {

    private int idHistorialClinico;
    private String descripcion;
    private int idPaciente;
    private int idReferenciaClinica;
    private int idEnfermedad;
    private String fecha;
    private String hora;
    private int idEmpleado;
        
    public HistorialClinico() {
        this.idHistorialClinico = 0;
        this.descripcion = "";
        this.idPaciente = 0;
        this.idReferenciaClinica = 0;
        this.idEnfermedad = 0;
        this.fecha = "";
        this.hora = "";
        this.idEmpleado = 0;
    }

    public int getIdHistorialClinico() {
        return idHistorialClinico;
    }

    public void setIdHistorialClinico(int idHistorialClinico) {
        this.idHistorialClinico = idHistorialClinico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdReferenciaClinica() {
        return idReferenciaClinica;
    }

    public void setIdReferenciaClinica(int idReferenciaClinica) {
        this.idReferenciaClinica = idReferenciaClinica;
    }

    public int getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
}
