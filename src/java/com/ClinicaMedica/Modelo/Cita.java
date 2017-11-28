package com.ClinicaMedica.Modelo;

public class Cita {

    private int idCita;
    private String Fecha;
    private String Horario;
    private int Empleado_idEmpleado;
    private int EstadoCita_idEstadoCita;
    private int Paciente_idPaciente;

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public int getEmpleado_idEmpleado() {
        return Empleado_idEmpleado;
    }

    public void setEmpleado_idEmpleado(int Empleado_idEmpleado) {
        this.Empleado_idEmpleado = Empleado_idEmpleado;
    }

    public int getEstadoCita_idEstadoCita() {
        return EstadoCita_idEstadoCita;
    }

    public void setEstadoCita_idEstadoCita(int EstadoCita_idEstadoCita) {
        this.EstadoCita_idEstadoCita = EstadoCita_idEstadoCita;
    }

    public int getPaciente_idPaciente() {
        return Paciente_idPaciente;
    }

    public void setPaciente_idPaciente(int Paciente_idPaciente) {
        this.Paciente_idPaciente = Paciente_idPaciente;
    }

}
