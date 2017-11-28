package com.ClinicaMedica.Modelo;

public class Especialidad {
    private int idEspecialidad;
    private String nombreEspecialidad;
    
    public Especialidad(){
        this.idEspecialidad=0;
        this.nombreEspecialidad="";
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
    
    
}
