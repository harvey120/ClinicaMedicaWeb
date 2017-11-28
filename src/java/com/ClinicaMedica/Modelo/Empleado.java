package com.ClinicaMedica.Modelo;

/**
 * @author Harvey
 */
public class Empleado {

    private int idEmpleado;
    private int idEspecialidad;
    private String consultorio;
    private String estado;
    private int idPuesto;

    public Empleado() {
        this.idEmpleado = 0;
        this.idEspecialidad = 0;
        this.consultorio = "";
        this.estado = "";
        this.idPuesto = 0;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

}
